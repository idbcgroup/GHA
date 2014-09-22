/**
 * MODULO DE UTILIDADES
 */

var CORE_NAMESPACE = CORE_NAMESPACE || {};

CORE_NAMESPACE.UtilModule = (function () {
    'use strict';

    var hostAndDomainStr = '', serviceStr = '', idleTime = 0;

    // Este FunctionPack va a ir dentro de la estructura global GHA
    var functionPack = {
        longCad: {
            source: "if(args.value === null) return true; var valueLength = args.value.toString().length; return (valueLength < args.longCad);",
            isCreated: true,
            owner: "global", // global: nunca se elimina, "nombreOwner" para ser eliminado cuando el Owner se elimine
            funcObj: null
        },
        clickValidate: "var aux = 'los parametros son: '; window.alert(aux + args.param1 +' y ' + args.param2); args.form.validate();"
    };



    var suscriptionLists = {
        resizedLayout: [],
        pacienteDiab: []
    };

    var csofModes = {
        FORM: 0, // Un formulario (HME, MLM, etc)
        FORM_INSTANCE: 1, // Instancia de un formulario (Paciente1, Paciente2, etc. en HME)
        VPU_ICT: 2,
        VPU_SEARCH: 3,
        PACKS: 4, // Catalog, Param, InfoPack, BpoPack deseado (Ej: BpuPack o SexCatalog)
        GHA_EMPTY: 5, // Estructura base de GlaGlobal vacia
        PAA: 6 // Carga de componentes del portal (logo de inst, botones del header, menu, etc)
    };

    /**
     * Ejecuta una funcion que viene del servidor y opcionalmente devuelve un valor si la funcion deseada lo hace
     * @param funcId
     * El id de la funcion que se desea ejecutar (el codigo de esa funcion viene de la BD)
     * @param params
     * Objeto con los parametros que va a recibir la funcion que se desea llamar
     * @param context
     * El contexto donde se va a ejecutar la funcion. Si no se le pasa por parametros se ejecuta en el contexto global
     *
     * @returns {*} El resultado de la funcion deseada si esta devuelve algun valor. undefined en caso contrario
     */
    var funcMng = function (funcId, params, context) {
        //noinspection JSHint
        if(!functionPack[funcId].isCreated){
            var funcTemp = new Function("args", functionPack[funcId.def].source);
            functionPack[funcId].funcObj = funcTemp;
            functionPack[funcId].isCreated = true;
        }

        return functionPack[funcId].funcObj.call(context, params);
    };

    /**
     * Se trae el infoPack del servidor y le asigna el dato deseado
     *
     * @param name
     * El nombre que identifica el InfoPack
     * @param index
     * El indice de la instancia deseada del infoPack. Si se omite este parametro se devolverá la primera
     * instancia del infoPack en caso de que maneje multiples instancias
     * @param newElem
     * El nuevo elemento a agregan en el infoPack
     * @param data
     * Los datos del nuevo elemento
     */
    var setInfoPackDataFromServer = function (name, index, newElem, data) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        // se consulta el servicio
        var requestData = JSON.stringify({ code: name });
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: getNewServiceUrl("ess", "getInfoPack"),
            data: requestData,
            dataType: "json"
        }).done(function (dataResp) {
            // si el servicio se ejecuto correctamente le saco el infoPack, sino creo un objeto vacio
            var newInfoPack = (dataResp.valid) ? dataResp.infoPack : {isUnique: true, data: []};

            // Actualizo GHAGlobal y la cookie donde se almacena
            var ghaGlobal = $.cookie("GHAGlobal");

            ghaGlobal.infoPacks[name] = newInfoPack;
            if (newInfoPack.isUnique) {
                index = 0;
            }

            if (ghaGlobal.infoPacks[name].data.length === 0) {
                ghaGlobal.infoPacks[name].data.push({});
            }

            var instance = ghaGlobal.infoPacks[name].data[index];
            instance[newElem] = data;
            $.cookie("GHAGlobal", ghaGlobal);
        });
    };

    /**
     * Busca en el servidor el infoPack deseado y lo asigna a la estructura global
     *
     * @param name
     * El nombre que identifica el InfoPack
     * @param index
     * El indice de la instancia deseada del infoPack. Si se omite este parametro se devolverá la primera instancia
     * del infoPack en caso de que maneje multiples instancias
     * @param funcHandler
     * Funcion para manejar el resultado devuelto por el servidor.
     * Puede recibir el objeto con los datos de la instancia del InfoPack desado o undefined
     */
    var getInfoPackFromServer = function (name, index, funcHandler) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        var requestData = JSON.stringify({ code: name });

        // se consulta el servicio
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: getNewServiceUrl("ess", "getInfoPack"),
            data: requestData,
            dataType: "json"
        }).done(function (dataResp) {
            // si el servicio se ejecuto correctamente
            if (dataResp.valid) {
                // Actualizo GHAGlobal y la cookie donde se almacena
                var ghaGlobal = $.cookie("GHAGlobal");

                ghaGlobal.infoPacks[name] = dataResp.infoPack;
                $.cookie("GHAGlobal", ghaGlobal);

                // devuelvo la informacion deseada
                var newInfoPack = ghaGlobal.infoPacks[name];
                if (newInfoPack.isUnique) {
                    index = 0;
                }

                var instance = newInfoPack.data[index];
                funcHandler(instance);
            } else {
                throw new GhaServiceError(dataResp.error);
            }
        }).fail(function () {
            funcHandler(undefined);
        });
    };

    /**
     * Busca en el servidor el parametro deseado y lo asigna a la estructura global
     *
     * @param name
     * El nombre que identifica el Parameter
     * @param funcHandler
     * Funcion para manejar el resultado devuelto por el servidor.
     * Puede recibir el el objeto con los datos del Parameter desado o undefined
     */
    var getParameterFromServer = function (name, funcHandler) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        // se consulta el servicio
        var requestData = JSON.stringify({ code: name });
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: getNewServiceUrl("ess", "getParameter"),
            data: requestData,
            dataType: "json"
        }).done(function (dataResp) {
            // si el servicio se ejecuto correctamente
            if (dataResp.valid) {
                // Actualizo GHAGlobal y la cookie donde se almacena
                var ghaGlobal = $.cookie("GHAGlobal");

                //noinspection JSUnresolvedVariable
                ghaGlobal.parameters[name] = dataResp.parameter;
                $.cookie("GHAGlobal", ghaGlobal);

                // devuelvo la informacion deseada
                var newParameter = ghaGlobal.parameters[name];
                funcHandler(newParameter);
            } else {
                throw new GhaServiceError(dataResp.error);
            }
        }).fail(function () {
            funcHandler(undefined);
        });

    };

    /**
     * Busca en el servidor el catalogo deseado y lo asigna a la estructura global
     *
     * @param name
     *            El nombre que identifica el Catalog
     * @param funcHandler
     *            Funcion para manejar el resultado devuelto por el servidor.
     *            Puede recibir el el objeto con los datos del Catalog desado o
     *            undefined
     */
    var getCatalogFromServer = function (name, funcHandler) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        var requestData = JSON.stringify({
            catalogCode: name
        });

        // se consulta el servicio
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: getNewServiceUrl("ess", "getCatalog"),
            data: requestData,
            dataType: "json"
        }).done(function (dataResp) {
            // si el servicio se ejecuto correctamente
            if (dataResp.valid) {
                // Actualizo GHAGlobal y la cookie donde se almacena
                var ghaGlobal = $.cookie("GHAGlobal");

                //noinspection JSUnresolvedVariable
                ghaGlobal.catalogs[name] = dataResp.catalog;
                $.cookie("GHAGlobal", ghaGlobal);

                // devuelvo la informacion desada
                var newCatalog = ghaGlobal.catalogs[name];
                funcHandler(newCatalog);
            } else {
                throw new GhaServiceError(dataResp.error);
            }
        }).fail(function () {
            funcHandler(undefined);
        });
    };

    /**
     * Devuelve una URL con el dominio de la aplicacion y la pagina deseada.<br/>
     * Ej: "http://localhost:8080/frontend/init.html"<br/> donde "init.html" es
     * la pagina deseada
     *
     * @param htmlPage
     *            la pagina html o jsp
     * @returns string: La URL deseada
     */
    var getNewUrl = function (htmlPage) {
        htmlPage = htmlPage || '';
        var isEmpty = (hostAndDomainStr.length === 0);

        if (isEmpty) {
            var hrefStr = window.location.href;
            var index = hrefStr.lastIndexOf("/");
            hostAndDomainStr = hrefStr.slice(0, index);
        }

        return hostAndDomainStr + "/" + htmlPage;
    };

    /**
     * Devuelve la URL del servicio deseado.
     *
     * Ej: "http://localhost:8080/frontend/services/auth/validarCredenciales"
     * donde "auth" es el nombre del modulo y "validarCredenciales" es el nombre del servicio
     *
     * @param moduleName
     * el nombre del modulo al que pertenece el servicio
     * @param serviceName
     * el nombre del servicio
     * @returns string La URL deseada
     */
    var getNewServiceUrl = function (moduleName, serviceName) {
        serviceName = serviceName || '';
        var isEmpty = (serviceStr.length === 0);

        if (isEmpty) {
            var urlStr = getNewUrl('');
            var index = urlStr.indexOf("/");
            urlStr = urlStr.slice(index, -1);
            serviceStr = urlStr + "/" + "services";
        }
        return serviceStr + "/" + moduleName + "/" + serviceName;
    };

    /**
     * asigna un nuevo elemento al infoPack deseado
     *
     * @param infoPackParams
     *            objeto de la forma: { name (String), index (Integer, opcional) }
     * @param newElem
     *            el nuevo elemento a agregan en el infoPack
     * @param data
     *            los datos del nuevo elemento
     */
    var setInfoPackData = function (infoPackParams, newElem, data) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        var infoPackName = infoPackParams.name;
        var instanceIndex = infoPackParams.index || 0;
        var ghaGlobal = $.cookie("GHAGlobal") || {};

        var noInfoPackName = (infoPackName === undefined);
        var noGhaGlobal = (ghaGlobal === undefined);

        if (noInfoPackName || noGhaGlobal) {
            throw "Debe indicar el nombre del infoPack";
        } else {
            var infoPack = ghaGlobal.infoPacks[infoPackName];
            var isInCache = (infoPack !== undefined);
            if (isInCache) {
                window.console.log("infoPackManager isInCache");
                if (infoPack.isUnique) {
                    instanceIndex = 0;
                }

                infoPack.data[instanceIndex][newElem] = data;
                $.cookie("GHAGlobal", ghaGlobal);
            } else {
                setInfoPackDataFromServer(infoPackName, instanceIndex, newElem, data);
            }
        }
    };

    /**
     * busca y devuelve los datos del infoPack deseado
     *
     * @param infoPackParams
     *            objeto de la forma: <br>{ name (String), index (Integer,
     *            opcional) }
     * @param funcHandler
     *            funcion que se encarga de recibir el resultado de esta
     *            operacion. Puede recibir undefined o el InfoPack deseado
     */
    var getInfoPack = function (infoPackParams, funcHandler) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        var infoPackName = infoPackParams.name;
        var instanceIndex = infoPackParams.index || 0;
        var ghaGlobal = $.cookie("GHAGlobal");

        var noInfoPackName = (infoPackName === undefined);
        var noGhaGlobal = (ghaGlobal === undefined);

        if (noInfoPackName) {
            throw "No existe en atributo 'name' de 'infoPackParams'";
        }
        if (noGhaGlobal) {
            throw "No esta definidio el objeto GHAGlobal";
        }

        var infoPack = ghaGlobal.infoPacks[infoPackName];
        var isInCache = (infoPack !== undefined);
        if (isInCache) {
            window.console.log("infoPackManager isInCache");
            if (infoPack.isUnique) {
                instanceIndex = 0;
            }

            var infoPackInstnace = infoPack.data[instanceIndex];
            funcHandler(infoPackInstnace);
        } else {
            getInfoPackFromServer(infoPackName, instanceIndex, funcHandler);
        }

    };

    /**
     * busca y devuelve los datos del Parameter deseado
     *
     * @param name
     *            el nombre que identifica el Parameter
     * @param funcHandler
     *            funcion que se encarga de recibir el resultado de esta
     *            operacion. Puede recibir undefined o el Parameter deseado
     */
    var getParameter = function (name, funcHandler) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        var ghaGlobal = $.cookie("GHAGlobal");
        var noName = (name === undefined);
        var noGhaGlobal = (ghaGlobal === undefined);

        if (noName) {
            throw "No existe en atributo 'name' de 'infoPackParams'";
        }
        if (noGhaGlobal) {
            throw "No esta definidio el objeto GHAGlobal";
        }

        var parameter = ghaGlobal.parameters[name];
        var isInCache = (parameter !== undefined);
        if (isInCache) {
            funcHandler(parameter);
        } else {
            getParameterFromServer(name, funcHandler);
        }
    };

    /**
     * busca y devuelve los datos del Catalog deseado
     *
     * @param name
     *            el nombre que identifica el Catalog
     * @param funcHandler
     *            funcion que se encarga de recibir el resultado de esta
     *            operacion. Puede recibir undefined o el Catalog deseado
     */
    var getCatalog = function (name, funcHandler) {
        if (!$.cookie.json) {
            $.cookie.json = true;
        }

        var ghaGlobal = $.cookie("GHAGlobal");
        var noName = (name === undefined);
        var noGhaGlobal = (ghaGlobal === undefined);

        if (noName) {
            throw "No existe en atributo 'name' de 'infoPackParams'";
        }
        if (noGhaGlobal) {
            throw "No esta definidio el objeto GHAGlobal";
        }
        var catalog = ghaGlobal.catalogs[name];
        var isInCache = (catalog !== undefined);
        if (isInCache) {
            funcHandler(catalog);
        } else {
            getCatalogFromServer(name, funcHandler);
        }

    };

    /**
     * Funcion para borrar las estructuras globales de las cookies
     */
    var borrarEstructuraGlobal = function () {
        $.removeCookie("GHAGlobal");
    };

    /**
     * Asigna el tiempo en que puede estar inactiva la pagina donde se ejecuta
     * este metodo. Pasado este tiempo la pagina mustra un mensaje y redirige a
     * una pagina deseada
     *
     * @param config
     *      Objeto JSON de Configuración con los siguientes atributos:
     * <pre>
     *      seconds: la cantidad de segundos en la que la pagina puede estar inactiva
     *      pageToGo: string con el nombre de la pagina a donde se desea redirigir. Ej: "init.html"
     *      message: (Opcional) string con el mensaje que se mostrara cando se vensa el tiempo de inactividad
     * </pre>
     */
    var setInactivityTime = function (config) {
        //noinspection JSUnresolvedVariable
        if (config.pageToGo === undefined) {
            throw "Se debe Indicar por parametro la página a la cual se desea Redirigir";
        }

        //noinspection JSUnresolvedVariable
        if (config.seconds === undefined) {
            throw  "Se debe Indicar por parametro los segundos de Inactividad de la pagina para Redirigir";
        }

        $(document).ready(function () {
            setInterval(function () {
                // alert("el timer es: " +idleTime);
                idleTime = idleTime + 1;
                // seconds antes eran 30 segundos para expirar la session

                //noinspection JSUnresolvedVariable
                if (idleTime === config.seconds) {
                    if (config.message !== undefined) {
                        window.alert(config.message);
                    }

                    //noinspection JSUnresolvedVariable
                    var url = getNewUrl(config.pageToGo);
                    location.replace(url);
                    // cierro sesion y se redirige la pagina al inicio
                }
            }, 1000); // el intervalo ejecuta cada 1 segundo

            $(this).mousemove(function () {
                idleTime = 0;
            });

            $(this).keypress(function () {
                idleTime = 0;
            });
        });
    };

    /**
     * Muestra un dialogo con los datos del error que devuelve una llamada a los
     * servicios REST de GHA
     *
     * @param error
     *            el objeto error que devuelve el servicio REST
     */
    var showServiceErrorDialog = function (error) {
        if (error === undefined) {
            throw "Debe pasar por parametros el json con los datos del error";
        }

        var errorType = "";
        if (error.code === 1) {
            errorType = "Error en el Servidor";
        } else if (error.code === 2) {
            errorType = "Error en el Servicio REST";
        }

        //noinspection JSUnresolvedVariable
        isc.warn("<b>ERROR_TYPE:</b> " + errorType +
            "<br><b>MESSAGE:</b> " + error.message +
            "<br><b>DESCRIPTION:</b> " + error.description +
            "<br><b>STACK_TRACE:</b> " + error.stackTrace);
    };

    /**
     * Devuelve un de la forma: {"key1":"val1", "key2":"val2", ...}
     * en base a una lista de la forma: [{id:"key1", value:"value1"}, {id:"key2", value:"value2"}, ...]
     *
     * @param list
     * La lista con los objetos
     * @returns {object} el valueMap
     */
    var getAsValueMap = function (list) {
        if (list === undefined) {
            throw "Debe pasar por parametros la lista que desea convertir en valueMap";
        }

        var valueMap = {};
        for (var i = 0; i < list.length; i++) {
            var key = (list[i].id === undefined) ? list[i].code : list[i].id;
            valueMap[key] = list[i].name;
        }

        return valueMap;
    };



    /**
     * Dispara un broadcast de un evento deseado para notificar a los listeners que esten escuchandolo
     * @param eventToFire
     * Nombre del evento al que se le desea ejecutar el broadcast
     */
    var fireBroadcast = function (eventToFire) {
        var listOfHandlers = suscriptionLists[eventToFire];
        for (var i = 0; i < listOfHandlers.length; i++) {
            var listenerFunc = listOfHandlers[i];
            listenerFunc();
        }
    };

    /**
     * Suscribe una funcion que se van a encarga de "escuchar" al avento deseado
     * @param eventToSuscribe
     * Nombre del evento al que se le desea suscribir
     * @param listenerFunc la funcion que se va a suscribir
     */
    var suscribeToBrodcast = function (eventToSuscribe, listenerFunc) {
        suscriptionLists[eventToSuscribe].push(listenerFunc);
    };

    /**
     * CMD: Carga Modelo de Datos
     * @param jsonResp
     * El JSON con la data a cargar en el Modelo de Datos GHA
     */
    var cmd = function (jsonResp) {
        // TODO codigo que se encarga de cargar el JSON en la estructura global e ir generando el formulario con la data de ese JSON
    };

    /**
     * CSOF: Cliente - Solicitud Objetos y Funciones
     * @param params
     * Objetos con los parametros del objeto o funcion que se desea solicitar.
     * {elemABuscar, Modo}
     */
    var csof = function (params) {
        cbsc("FSOF", params, function (resp) {
            if (resp !== null) {
                cmd(resp);
            }
        });
    };

    /**
     * CBSC: Cliente - Back Service Call. Se encarga de manejar las llamadas desde el cliente
     * a funciones que se encuentran en el servidor (backend o frontend) y manejarar los posibles errores
     * que sucedan durante la llamada (mostrarlos en el PME, registrarlos en un LOG, etc)
     * @param funcName
     * El nombre de la funcion que se desea llamar del servidor
     * @param funcParams
     * El nombre de la funcion que se desea ejecutar
     * @param funcListener
     * funcion callback que se ejecuta cuando CBSC resive respuesta del servidor
     */
    var cbsc = function (funcName, funcParams, funcListener) {
        var requestData = JSON.stringify({ funcName: funcName, funcParams: funcParams });
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: getNewServiceUrl("ess", "fbsc"),
            data: requestData,
            dataType: "json"
        }).done(function (dataResp) {
            if (dataResp.valid) {
                funcListener(dataResp);
            } else {
                // TODO logica para el manejo de los errores (mostrar mensajes, LOG, etc)
                funcListener(null);
            }
        }).fail(function () {
            // TODO logica para el manejo de los errores (mostrar mensajes, LOG, etc)
            funcListener(null);
        });
    };

    return {
        getNewUrl: getNewUrl,
        getNewServiceUrl: getNewServiceUrl,
        setInfoPackData: setInfoPackData,
        getInfoPack: getInfoPack,
        getParameter: getParameter,
        getCatalog: getCatalog,
        setInactivityTime: setInactivityTime,
        borrarEstructuraGlobal: borrarEstructuraGlobal,
        showServiceErrorDialog: showServiceErrorDialog,
        getAsValueMap: getAsValueMap,
        funcMng: funcMng,
        fireBroadcast: fireBroadcast,
        suscribeToBrodcast: suscribeToBrodcast,
        csof: csof,
        cbsc: cbsc
    };
})();