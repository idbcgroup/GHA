var CORE_NAMESPACE = CORE_NAMESPACE || {};

CORE_NAMESPACE.InitFormModule = (function () {
    var layoutBase_module = CORE_NAMESPACE.LayoutBaseModule;
    var util_module = CORE_NAMESPACE.UtilModule;

    var labelUsersGHA;
    var labelAppNetwork;
    var labelUsersHCloud;
    var labelAppHCloud;
    var hLayoutSessionNetwork;
    var hLayoutSessionHCloud;
    var vLayoutInit;
    var hLayoutExitButton;
    var hCloudButton;
    var exitButton;
    var networkButton;

    var paramFromUrl = function (name) {
        var regExp = new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)');
        var result = regExp.exec(location.search);
        return (result !== null) ? decodeURIComponent(result[1]) : null;
    };

    var parseGhaBpiXml = function () {
        var ghabpiParam = paramFromUrl("ghabpi");
        if (ghabpiParam === null)
            return null;

        // JSON
        var pack = JSON.parse(ghabpiParam);
        return pack;
    };

    var parseGhaTermXml = function () {
        var ghatermParam = paramFromUrl("ghaterm");
        if (ghatermParam === null)
            return null;

        // JSON
        var pack = JSON.parse(ghatermParam);
        return pack;
    };

    var redirigirVistaConexionUsuario = function () {
        var url = util_module.getNewUrl("login.html");

        $.get(url, function () {
            window.open(url, '_blank', 'location=no,menubar=no,status=no,titlebar=no,toolbar=no');
        }).fail(function () {
            var msj_VCF_006 = "No ha sido posible obtener acceso a la aplicación gha. No se desplegó la vista de conexión a usuario (VCU) ";
            isc.warn(msj_VCF_006);
        });
    };

    var loadFormComponents = function () {
        var createSpacer = function (alto) {
            return isc.LayoutSpacer.create({
                height: alto
            });
        };

        // COMPONENTES DE LA VISTA
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

        labelUsersGHA = isc.Label.create({
            height: 40,
            align: "center",
            valign: "top",
            contents: "----<b>Usuarios</b> gha----"
        });

        labelAppNetwork = isc.Label.create({
            width: 300,
            align: "right",
            valign: "center",
            contents: "Acceso a la aplicación gha en modo red o autónomo"
        });

        networkButton = isc.IButton.create({
            width: 120,
            title: "gha",
            disabled: true,
            click: redirigirVistaConexionUsuario
        });

        hLayoutSessionNetwork = isc.HLayout.create({
            width: "100%",
            height: 20,
            align: "center",
            layoutAlign: "center",
            members: [labelAppNetwork, isc.LayoutSpacer.create({
                width: 20
            }), networkButton]
        });

        labelUsersHCloud = isc.Label.create({
            height: 40,
            align: "center",
            valign: "top",
            contents: "----<b>Usuarios</b> h-cloud----"
        });

        labelAppHCloud = isc.Label.create({
            width: 300,
            align: "right",
            valign: "center",
            contents: "Acceso a la aplicación gha vía h-cloud"
        });

        hCloudButton = isc.IButton.create({
            width: 120,
            title: "h-cloud",
            disabled: true,
            click: function () {
                // TODO
            }
        });

        hLayoutSessionHCloud = isc.HLayout.create({
            width: "100%",
            height: 30,
            align: "center",
            layoutAlign: "center",
            members: [labelAppHCloud, isc.LayoutSpacer.create({
                width: 20
            }), hCloudButton]
        });

        exitButton = isc.IButton.create({
            width: 120,
            title: "SALIR",
            click: function () {
                util_module.borrarEstructuraGlobal();
                window.close();
            }
        });

        hLayoutExitButton = isc.HLayout.create({
            width: "100%",
            height: 30,
            align: "center",
            members: [isc.LayoutSpacer.create({
                align: "right",
                width: labelAppHCloud.getWidth() + 20
            }), exitButton]
        });

        vLayoutInit = isc.VLayout.create({
            align: "top",
            members: [createSpacer(20),
                logoGhaLayout,
                createSpacer(30),
                labelUsersGHA,
                hLayoutSessionNetwork,
                createSpacer(30),
                labelUsersHCloud,
                hLayoutSessionHCloud,
                createSpacer(10),
                hLayoutExitButton]
        });

        var formLayout = layoutBase_module.formLayout;
        formLayout.addMember(vLayoutInit);
    };

    var showForm = function () {
        vLayoutInit.show();
    };
    var hideForm = function () {
        vLayoutInit.hide();
    };

    var init = function () {
        loadFormComponents();

        var ghaGlobal = {
            infoPacks: {},
            parameters: {},
            catalogs: {},
            infoMeds: {}
        };
        var infoPacks = ghaGlobal.infoPacks;

        var bpiPack = parseGhaBpiXml();
        var terminalPack = parseGhaTermXml();

        // Si el archivo ghabpi.xml NO es ubicado
        if (bpiPack === null) {
            hCloudButton.setDisabled(false);
            networkButton.setDisabled(true);
        } else {
            infoPacks.bpiPack = {
                isUnique: false,
                data: [bpiPack]
            };
        }

        // el archivo ghaterm.xml NO existe
        if (terminalPack === null) {
            var msj_VCF_003 = "No ha sido posible obtener acceso a la aplicación gha. No se ha podido ubicar el archivo de definición del Terminal. Contacte al personal Técnico";
            isc.warn(msj_VCF_003, function (value) {
                util_module.borrarEstructuraGlobal();
                window.close();
            });
            return;
        }

        // el archivo ghaterm.xml SI existe
        infoPacks.terminalPack = {
            isUnique: true,
            data: [terminalPack]
        };

        var installType = bpiPack.instalationType;
        if (installType === "MIXTO") {
            var termType = terminalPack.terminalType;
            if (termType === "MOVIL")
                hCloudButton.setDisabled(false);

            networkButton.setDisabled(false);
        } else {
            networkButton.setDisabled(false);
        }

        // agrego la estructura global a las cookies
        $.cookie("GHAGlobal", ghaGlobal);
    };

    // Inicializando el modulo
    init();

    // OBJETO CON LOS ELEMENTOS PUBLICOS DEL MODULO
    return {
        showForm: showForm,
        hideForm: hideForm
    };
})();

CORE_NAMESPACE.InitFormModule.showForm();
