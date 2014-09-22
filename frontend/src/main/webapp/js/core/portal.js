var CORE_NAMESPACE = CORE_NAMESPACE || {};

(function () {
    "use strict";
    var util_module = CORE_NAMESPACE.UtilModule;
    var layoutBase_module = CORE_NAMESPACE.LayoutBaseModule;

    /**
     * Carga y muestra el logo de la institucion
     */
    var loadInstitutionLogo = function () {
        var params = {};
        params.name = "bpiPack";
        util_module.getInfoPack(params, function (infoPack) {
            var isDefined = (infoPack !== undefined);
            var imgSrc = isDefined ? infoPack.bpiLogoNameRoute : "../img/logo.png";

            layoutBase_module.logoImg.setSrc(imgSrc);
        });
    };

    /**
     * muestra el nombre de usuario que inicio sesion y el nombre del area de
     * trabajo donde se esta conectando
     */
    var showUserNameAndWorkingArea = function () {

        // creo los labels para User y WA
        var userNameLabel = isc.Label.create({
            width: "100%",
            height: 20,
            align: "right",
            contents: "Usuario: Nelson Ramirez",
            styleName: "gha-top-label-dropdown-menu"
        });

        var workingAreaLabel = isc.Label.create({
            width: "100%",
            height: 20,
            align: "right",
            contents: "Area Actual",
            styleName: "gha-top-label-dropdown-menu"
        });

        var layout = layoutBase_module.userNameAndWALayout;
        layout.addMembers([userNameLabel, workingAreaLabel]);

        // busco el nombre del usuario y se lo asigno al label
        var params = {};
        params.name = "bpuPack";
        util_module.getInfoPack(params, function (infoPack) {
            var isDefined = (infoPack !== undefined);
            var texto = isDefined ? infoPack.bpuUserName : "User Name";

            userNameLabel.setContents(texto);
        });

        // busco el nombre del WA y se lo asigno al label
        params.name = "terminalPack";
        util_module.getInfoPack(params, function (infoPack) {
            var isDefined = (infoPack !== undefined);
            var texto = isDefined ? infoPack.workingAreaName : "Working Area";

            workingAreaLabel.setContents(texto);
        });
    };

    /**
     * carga las opciones del menú que quedarán disponibles para el usuario.
     * Estas opciones se encuentran en el BpuAccessPack
     */
    var loadEnabledMenuOptions = function () {

    };

    /**
     * Carga y muestra el formulario inicial que se debe mostrar al usuario
     */
    var loadInitialForm = function () {
        var params = {};
        params.name = "bpuPack";
        util_module.getInfoPack(params, function (infoPack) {
            var isDefined = (infoPack !== undefined);
            var codigo = isDefined ? infoPack.initialActionOnLogon : "BPU_EDT";

            var requestData = JSON.stringify({
                code: codigo
            });

            $.ajax({
                type: "POST",
                contentType: "application/json;charset=utf-8",
                url: util_module.getNewServiceUrl("ess", "getForm"),
                data: requestData,
                dataType: "json"
            }).done(function (dataResp) {
                if (dataResp.valid) {
                    // cargando un json con los datos de un formulario
                    var jsonParse = isc.JSON.decode(dataResp.jsonString);
                    window.console.log(jsonParse);

                    // generar los componentes con los datos obtenidos
                    var aux = isc.HLayout.create(jsonParse);
                    window.console.log(aux);

                    var formLayout = layoutBase_module.formLayout;
                    formLayout.addMember(aux);
                }
            });
        });
    };

    var showMsgsNotifsAndAlarms = function () {
        var params = {};
        params.name = "bpuPack";
        util_module.getInfoPack(params, function (infoPack) {
            var isDefined = (infoPack !== undefined);
            var codigo = isDefined ? infoPack.bpuId : "user";

            var requestData = JSON.stringify({
                code: codigo
            });

            var msg = "Estimado usuario, tiene Mensaje y/o Notificaciones pendientes por Atender. " +
                "Seleccione el indicador de mensajes y Notificaciones ubicado en la parte superior derecha del PORTAL, Gracias";

            $.ajax({
                type: "POST",
                contentType: "application/json;charset=utf-8",
                url: util_module.getNewServiceUrl("ess", "getMsgNotifAndAlarms"),
                data: requestData,
                dataType: "json"
            }).done(function (dataResp) {
                if (dataResp.valid) {
                    var haveMsgs = (dataResp.messages.length !== 0);
                    var haveNotifs = (dataResp.notifications.length !== 0);
                    if (haveMsgs || haveNotifs) {
                        // TODO activar indicador de msg y notif de
                        // ser necesario
                        isc.say(msg);
                    }

                }
            });
        });

    };

    loadInstitutionLogo();
    loadEnabledMenuOptions();
    loadInitialForm();
    showUserNameAndWorkingArea();
    showMsgsNotifsAndAlarms();
    layoutBase_module.logoImg.show();
    layoutBase_module.msgImgButton.show();
    layoutBase_module.userInfoImgButton.show();
})();
