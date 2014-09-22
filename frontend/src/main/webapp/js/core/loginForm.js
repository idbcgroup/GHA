var CORE_NAMESPACE = CORE_NAMESPACE || {};

CORE_NAMESPACE.LoginFormModule = (function () {
    'use strict';
    var layoutBase_module = CORE_NAMESPACE.LayoutBaseModule;
    var util_module = CORE_NAMESPACE.UtilModule;

    var loginForm = null, nameUserTextItem = null, passwordItem = null, instSelectItem = null, waSelecteItem = null,
        forgetPasswordLabel = null, cancelarButton = null, verifDataButton = null, initSesionButton = null;
    var localInstCode = null, remoteWAKey = "remoteArea";

    var verifyLogin = function () {

        function validateSpaceWhite(campo) {
            return !/^\s+|\s+$/.test(campo.getValue());
        }

        if (validateSpaceWhite(nameUserTextItem) && (nameUserTextItem.getValue() !== null) && (nameUserTextItem.getValue() !== undefined)) {
            if (!(validateSpaceWhite(passwordItem) && (passwordItem.getValue() !== null) && (passwordItem.getValue() !== undefined))) {
                isc.say("Debe de Introducir una cadena de texto en el password");
                return false;
            }
        } else {
            isc.say("Debe de Introducir una cadena de texto en el nombre de usuario");
            return false;
        }

        var passwordValue = passwordItem.getValue();
        var nameValue = nameUserTextItem.getValue();

        if (passwordValue === undefined) {
            isc.warn("Debe ingresar una Contraseña");
            return;
        }

        var windowsWait = isc.Dialog.create({
            message: "Se están verificando sus datos",
            icon: "[SKIN]ask.png",
            showTitle: false
        });

        var requestDataStr = JSON.stringify({
            login: nameValue,
            password: $.md5(passwordValue)
        });

        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: util_module.getNewServiceUrl("auth", "validarCredenciales"),
            data: requestDataStr,
            dataType: "json",
            error: function (jqXHR, textStatus, errorThrown) {
                window.alert("EL estatus es: " + textStatus + " y el error es: " + errorThrown);
            }
        }).done(function (response) {
            var errorInService, msj, msj_RWA_005, msj_RWA_006, msj_RWA_007;
            var institutions, workingAreas, atributeData, valueMap;

            errorInService = (response.valid === false);
            if (errorInService) {
                util_module.showServiceErrorDialog(response.error);
                return;
            }

            if (response.accountInactivate) {
                msj = "La cuenta del usuario está Inactiva.";
                isc.say(msj);
                windowsWait.hide();
                cancelarButton.click();

            } else if (response.blocked) {
                msj_RWA_005 = "La cuenta del usuario está Bloqueada por exceso de intentos fallidos de conexión. " + "Contacte al administrador";
                isc.say(msj_RWA_005);
                windowsWait.hide();
                cancelarButton.click();

            } else if (response.userNotExists) {
                msj_RWA_006 = "No existe una cuenta registrada para el usuario. Contacte al administrador";
                isc.say(msj_RWA_006);
                windowsWait.hide();
                cancelarButton.click();

            } else if (response.invalidPassword) {
                msj_RWA_007 = "Los datos suministrados no coinciden con la información registrada para el usuario. " +
                    "Después de " + response.numAttemps + " intentos de conexión fallidos se Bloqueará su cuenta";
                isc.say(msj_RWA_007);
                windowsWait.hide();
                cancelarButton.click();

            } else {
                // se complementa el BpuPack con la info de las ubicaciones
                institutions = response.bpuData.institutions;
                workingAreas = response.bpuData.workingAreas;
                atributeData = { institutions: institutions, workingAreas: workingAreas };
                util_module.setInfoPackData({ name: "bpuPack" }, "bpuLocations", atributeData);

                // cargar las instituciones y areas de trabajo en los selectItems
                util_module.getInfoPack({name: "bpiPack"}, function (bpiPack) {
                    var institution = bpiPack.institution;
                    localInstCode = institution.code;

                    // cargar instituciones en instSelectItem
                    if (bpiPack.instalationType === "GHA_INDEPENDIENTE") {
                        valueMap = {};
                        valueMap[institution.code] = institution.name;

                        instSelectItem.setValueMap(valueMap);
                        instSelectItem.setValue(localInstCode);
                        instSelectItem.setDisabled(true);
                    } else {
                        valueMap = util_module.getAsValueMap(institutions);
                        valueMap[institution.code] = institution.name;

                        instSelectItem.setValueMap(valueMap);
                        instSelectItem.setValue(response.bpiDefault);
                        instSelectItem.setDisabled(false);
                    }

                    // cargar areas de trabajo en waSelecteItem
                    util_module.getInfoPack({name: "terminalPack"}, function (terminalPack) {

                        var estaEnInstLocal = (localInstCode === response.bpiDefault);
                        var disableIfNotMovil = (terminalPack.terminalType !== "MOVIL");
                        var workingArea = terminalPack.workingArea;

                        if (estaEnInstLocal) {
                            valueMap = util_module.getAsValueMap(workingAreas);
                            valueMap[workingArea.code] = workingArea.name;

                            waSelecteItem.setValueMap(valueMap);
                            waSelecteItem.setValue(workingArea.code);
                            waSelecteItem.setDisabled(disableIfNotMovil);
                        } else {
                            valueMap = {};
                            valueMap[workingArea.code] = workingArea.value;
                            valueMap[remoteWAKey] = "Area Remota";

                            waSelecteItem.setValueMap(valueMap);
                            waSelecteItem.setValue(remoteWAKey);
                            waSelecteItem.setDisabled(true);
                        }

                        initSesionButton.setDisabled(false);
                    });
                });

                windowsWait.hide();
            }
        });
    };

    var passwordOlvidado = function () {
        isc.warn("Este manejador se encargara de redirigir al usuario a la URL que se encuentra en el atributo INIT_URL del archivo de configuración");
    };

    var limpiarCampos = function () {
        passwordItem.clearValue();
        nameUserTextItem.clearValue();
        instSelectItem.clearValue();
        waSelecteItem.clearValue();

        passwordItem.setDisabled(true);
        instSelectItem.setDisabled(true);
        waSelecteItem.setDisabled(true);
        forgetPasswordLabel.setDisabled(true);
        initSesionButton.setDisabled(true);
        verifDataButton.setDisabled(true);
    };

    var logonLog = function () {

        var instDest, login, pass, instOrigen = null;

        instDest = instSelectItem.getValue();
        login = nameUserTextItem.getValue();
        pass = passwordItem.getValue();

        if (instDest === undefined) {
            isc.warn("Debe seleccionar una institucion de destino");
            return;
        }

        // alert(JSON.stringify($.cookie("GHAGlobal")));

        var windowsWait = isc.Dialog.create({
            message: "Se están procesando sus datos",
            icon: "[SKIN]confirm.png",
            showTitle: false
        });

        util_module.getInfoPack({name: "bpiPack"}, function (bpiPackData) {

            if (bpiPackData === undefined) {
                isc.warn("no se pudo obtener el bpiPack");
                return;
            }

            var institution = bpiPackData.institution;
            instOrigen = institution.code;
        });

        var requestDataStr = JSON.stringify({
            password: pass, // Password
            login: login,// nombre de usuario
            instOrigen: instOrigen, // Institucion de Origen
            instDest: instDest    // Institucion de Destino
        });

        //alert("Antes de hacer setInlogonLog --> "+requestDataStr);

        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: util_module.getNewServiceUrl("auth", "setInLogonLog"),
            data: requestDataStr,
            dataType: "json",
            error: function (jqXHR, textStatus, errorThrown) {
                isc.warn("EL estatus es: " + textStatus + " y el error es: " + errorThrown);
            }
        }).done(function (dataResp) {
            var errorInService = (dataResp.valid === false);
            if (errorInService) {
                // Registrar la situación de falla en las tablas de bitácora de resultados
                // de las conexiones en la base de dato local LogonLog, InstanceLogon  y SingleSignOnUser
                isc.warn("No ha sido posible obtener acceso a la aplicación gha.  Conexión remota no está disponible ahora, intente mas tarde, gracias");
                cancelarButton.click();
                util_module.showServiceErrorDialog(dataResp.error);
                return;
            }

            if (dataResp.valid) {
                // Registrar la situación de exito en las tablas de bitácora de resultados de las conexiones
                // en la base de dato local LogonLog, InstanceLogon  y SingleSignOnUser
                var workingAreaId = waSelecteItem.getValue();

                if (workingAreaId === undefined) {
                    isc.warn("Debe seleccionar un Area de Trabajo");
                    return;
                }

                var requestDataStr = JSON.stringify({
                    institutionId: instDest,    // Institucion de Destino
                    workingAreaId: workingAreaId
                });

                //alert("Antes de hacer getDataGlobal --> "+requestDataStr);

                $.ajax({
                    type: "POST",
                    contentType: "application/json;charset=utf-8",
                    url: util_module.getNewServiceUrl("gom", "getDataGlobal"),
                    data: requestDataStr,
                    dataType: "json",
                    error: function (jqXHR, textStatus, errorThrown) {
                        window.alert("EL estatus es: " + textStatus + " y el error es: " + errorThrown);
                    }
                }).done(function (dataResp) {

                    var errorInService = (dataResp.valid === false);
                    if (errorInService) {
                        util_module.showServiceErrorDialog(dataResp.error);
                        cancelarButton.click();
                        return;
                    }

                    var infoPacks = dataResp.infoPacks;
                    var parameters = dataResp.parameters;
                    var bpuPack = infoPacks.bpuPack;

                    $.cookie.json = true;
                    var ghaGlobal = $.cookie("GHAGlobal");

                    ghaGlobal.infoPacks.accessPack = infoPacks.accessPack;
                    ghaGlobal.infoPacks.peripherialPack = infoPacks.peripherialPack;
                    ghaGlobal.infoPacks.bpuAccessPack = infoPacks.bpuAccessPack;
                    ghaGlobal.parameters.bpiParameter = parameters.bpiParameter;
                    ghaGlobal.parameters.operationParameter = parameters.operationParameter;
                    ghaGlobal.parameters.messageParameter = parameters.messageParameter;

                    ghaGlobal.infoPacks.bpuPack.data[0].bpuPrimaryWaIo = bpuPack.bpuPrimaryWaIo;
                    ghaGlobal.infoPacks.bpuPack.data[0].bpuHoraryRestricted = bpuPack.bpuHoraryRestricted;
                    ghaGlobal.infoPacks.bpuPack.data[0].bpuWaRestricted = bpuPack.bpuWaRestricted;
                    ghaGlobal.infoPacks.bpuPack.data[0].bpuPkiRequired = bpuPack.bpuPkiRequired;
                    ghaGlobal.infoPacks.bpuPack.data[0].initialActionOnLogon = bpuPack.initialActionOnLogon;
                    ghaGlobal.infoPacks.bpuPack.data[0].initialForm = bpuPack.initialForm;

                    $.cookie("GHAGlobal", ghaGlobal);

                    ghaGlobal = $.cookie("GHAGlobal");
                    //alert(JSON.stringify($.cookie("GHAGlobal")));
                    if (bpuPack.bpuHoraryRestricted === true) {
                        var msj_RWA_010 = "El usuario no está autorizado para conectarse al sistema fuera de su horario laboral. La conexión será cancelada. Intente mas tarde dentro de su horario regular de trabajo, gracias";
                        isc.say(msj_RWA_010);
                        windowsWait.hide();
                        cancelarButton.click();
                    }
                    else if (bpuPack.bpuHoraryRestricted === false) {
                        if (bpuPack.bpuWaRestricted === false) {

                            // Area de Trabajo Primaria ubicada en:
                            // ghaGlobal["infoPacks"]["bpuPack"]["data"][0]["bpuPrimaryWaIo"]
                            // si el tipo de terminal es movil, se puede cambiar de area de trabajo siempre
                            // y cuando el area de trabajo donde se encuentra el terminal "terminalPack":{
                            //"isUnique":true,"data":[{"terminalName":"Terminal 1","terminalType":"FIJO","workingArea":{"code":1,"name":"Enfermeria"}}]
                            //y la seleccionada por el usuario esten dentro de las areas de trabajo permitidas en [BpuAccessPack]  el atributo [BpuWaAllowed]
                            // usuario
                            // [BpuAccessPack]  el atributo [BpuWaAllowed]
                            var bandera = false;
                            // duda debo buscar ambos es decir el area de trabajo donde se encuentra el terminal
                            // y el workingArea Seleccionado?? solo busco el seleccionado
                            if (ghaGlobal.infoPacks.terminalPack.data[0].terminalType === "MOVIL") {
                                // Leo los WorkingAreaPermitodos.
                                var bpuWaAllowed = ghaGlobal.infoPacks.bpuAccessPack.bpuWaAllowed;
                                for (var c = 0; c < bpuWaAllowed.length; c++) {
                                    //alert(" EL id es : "+bpuWaAllowed[c].id+" y el nombre es: "+fruits[c].name);
                                    if (bpuWaAllowed[c].id === workingAreaId) {
                                        bandera = true;
                                        break;
                                    }
                                }

//                                if (!bandera) {
//                                    // en caso de no estar entre los seleccionados
//                                    // se supone que debo realizar algo
//                                }

                            }

                        } else if (bpuPack.bpuWaRestricted === true) {
                            var terminalWaCode = ghaGlobal.infoPacks.terminalPack.data[0].workingArea.code;
                            var bpuPrimaryWaId = ghaGlobal.infoPacks.bpuPack.data[0].bpuPrimaryWaIo.id;
                            var url = null;

                            //alert("el codigo del terminal es "+terminalWaCode+" el bpuPrimary es "+bpuPrimaryWaId);

                            // Si el area de trabajo en que se encuentra el terminal es igual al area de trabajo Primaria
                            if (terminalWaCode === bpuPrimaryWaId) {
                                windowsWait.hide();
                                // si son iguales se continua con el flujo de trabajo FN014. Asumo que encendido es 0 y apagado es 1
                                if (ghaGlobal.parameters.operationParameter.pkiOn === 0) {
                                    if (ghaGlobal.infoPacks.bpuPack.data[0].bpuPkiRequired === "ELEC_CERT_NOT-REQUIRED") {
                                        isc.say("no se necesitan firmas electronicas");
                                        url = util_module.getNewUrl("portal.html");
                                        location.replace(url);
                                    } else if (ghaGlobal.infoPacks.bpuPack.data[0].bpuPkiRequired === "ELEC_CERT_ACTIVE") {
                                        isc.say("se usan las firmas electronicas");
//                    					 1)	En este punto se debe proceder a invocar la Vista de Solicitud de Pin de Certificado Electrónico (SPC).
//                    					 Se  Pasa a caso de uso ( CU-91RWA.003  Obtener PIN para Autorización Firmas Electrónicas)
//        								 2)	Obtenido el PIN de autorización, se verifica con la base de datos y se obtienen las llaves electrónicas para
//        								 firmar documentos. Ambas informaciones son resguardadas en la estructura [BpuPack] y serán utilizadas cuando el 
//        								 sistema requiera firmar por él, un documento electrónico
                                    }
                                }
                            }
                            else {
                                // Si no coinciden el area de trabajo en que esta la terminal y la primaria definida
                                // se prosegui al caso de uso alternativo FA011
                                var msj_RWA_011 = "El usuario no está autorizado para conectarse al sistema en esta área de trabajo. Intente su conexión desde su área de trabajo asignada, gracias.";
                                isc.warn(msj_RWA_011);
                                windowsWait.hide();
                                cancelarButton.click();
                                util_module.borrarEstructuraGlobal();
                                // Preguntar si va index o init
                                url = util_module.getNewUrl("index.html");
                                location.replace(url);
                            }
                        }
                    }
                });

            }

        });

    };

    var init = function () {
        function createSpacer(alto) {
            return isc.LayoutSpacer.create({ height: alto });
        }

        loginForm = isc.DynamicForm.create({
            width: 305,
            position: "relative",
            layoutAlign: "center",
            titleOrientation: "top",
            numCols: 3,
            fields: [
                { type: "header", defaultValue: "Iniciar Sesión", align: "center", colSpan: 3 },
                {
                    name: "nameUser",
                    width: 180,
                    title: "Nombre de Usuario",
                    startRow: false,
                    type: "text",
                    keyUp: function (item) {
                        var params = { value: item.getValue(), longCad: 4 };
                        var desabilitar = util_module.funcMng('longCad', params);

                        passwordItem.setDisabled(desabilitar);
                        forgetPasswordLabel.setDisabled(desabilitar);
                        verifDataButton.setDisabled(desabilitar);
                    }
                },
                { type: "spacer" },
                {
                    name: "verifDataButton",
                    title: "Verificar Datos",
                    type: "button",
                    width: 100,
                    endRow: true,
                    startRow: false,
                    disabled: true,
                    click: verifyLogin
                },
                {
                    name: "password",
                    type: "password",
                    title: "clave de Acceso",
                    width: 180,
                    disabled: true
                },
                { type: "spacer" },
                {
                    name: "cancelarButton",
                    title: "Cancelar",
                    type: "button",
                    endRow: true,
                    startRow: false,
                    width: 100,
                    click: limpiarCampos
                },
                {
                    name: "forgetPassword",
                    type: "staticText",
                    showTitle: false,
                    disabled: true,
                    defaultValue: "¿Olvido su Clave de Acceso?",
                    align: "center",
                    colSpan: 3,
                    height: 30,
                    click: passwordOlvidado
                },
                { type: "header", defaultValue: "-------------------------------------", align: "center", colspan: 3 },
                {
                    name: "institution",
                    title: "Institución",
                    type: "select",
                    disabled: true,
                    width: 180,
                    changed: function (form, item, value) {
                        util_module.getInfoPack({ name: "terminalPack" }, function (terminalPack) {
                            util_module.getInfoPack({name: "bpuPack"}, function (bpuPack) {

                                var workingAreas = bpuPack.bpuLocations.workingAreas;
                                var workingArea = terminalPack.workingArea;
                                var estaEnInstLocal = (localInstCode.toString() === value);
                                var terminalIsNotMovil = (terminalPack.terminalType !== "MOVIL");
                                var valueMap;

                                if (estaEnInstLocal) {
                                    valueMap = util_module.getAsValueMap(workingAreas);
                                    valueMap[workingArea.code] = workingArea.name;

                                    waSelecteItem.setValueMap(valueMap);
                                    waSelecteItem.setValue(workingArea.code);
                                    waSelecteItem.setDisabled(terminalIsNotMovil);
                                } else {
                                    valueMap = {};
                                    valueMap[workingArea.code] = workingArea.value;
                                    valueMap[remoteWAKey] = "Area Remota";

                                    waSelecteItem.setValueMap(valueMap);
                                    waSelecteItem.setValue(remoteWAKey);
                                    waSelecteItem.setDisabled(true);
                                }
                            });
                        });
                    }
                },
                { type: "spacer" },
                {
                    name: "initSesionButton",
                    title: "Iniciar Sesión",
                    type: "button",
                    width: 100,
                    startRow: false,
                    click: logonLog
                },
                {
                    name: "workingArea",
                    title: "workingArea",
                    type: "select",
                    width: 180,
                    disabled: true
                },
                { type: "spacer" },
                {
                    title: "Salir",
                    type: "button",
                    startRow: false,
                    width: 100,
                    click: function () {
                        util_module.borrarEstructuraGlobal();
                        window.close();
                    }
                }
            ]
        });

        nameUserTextItem = loginForm.getItem("nameUser");
        passwordItem = loginForm.getItem("password");
        instSelectItem = loginForm.getItem("institution");
        waSelecteItem = loginForm.getItem("workingArea");
        forgetPasswordLabel = loginForm.getItem("forgetPassword");
        initSesionButton = loginForm.getItem("initSesionButton");
        cancelarButton = loginForm.getItem("cancelarButton");
        verifDataButton = loginForm.getItem("verifDataButton");

        var logoGhaLayout = isc.HLayout.create({
            align: "center",
            height: 75,
            members: [isc.Img.create({
                imageType: "stretch",
                src: "../img/logo.png",
                title: "Usuario",
                width: 150,
                height: 75
            })]
        });

        layoutBase_module.formLayout.addMembers([createSpacer(20), logoGhaLayout, createSpacer(10), loginForm]);
        layoutBase_module.msgImgButton.hide();
        layoutBase_module.userInfoImgButton.hide();

        // util_module.setinactivitytime( { //message:"su sesion a expirado",
        // seconds:30,
        // pagetogo:"init.html"
        // });
    };

    init();
    return {
        nameUser: nameUserTextItem,
        passwordItem: passwordItem,
        institutionSelectItem: instSelectItem,
        workingAreaSelectItem: waSelecteItem
    };
})();
