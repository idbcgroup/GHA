var CORE_NAMESPACE = CORE_NAMESPACE || {};

CORE_NAMESPACE.DropdownMenuModule = (function () {
    "use strict";

    var util_module = CORE_NAMESPACE.UtilModule;
    var layoutBase_module = CORE_NAMESPACE.LayoutBaseModule;

    var nameContainer = null;
    var userDataContiner = null;
    var buttonsContiner = null;

    /**
     * Muestra el perfil del usurio
     */
    var showPerfil = function () {
        // TODO
        window.alert("showPerfil()");
    };

    /**
     * Desloguea al usuario de la aplicacion
     */
    var logoutUser = function () {
        var url = util_module.getNewUrl("login.html");
        location.replace(url);
    };

    // COMPONENTES DE LA VISTA
    /**
     * Genera el layout que contiene la informacion del nombre de usuario
     */
    var generateUserNameContainer = function () {
        var userNameLabel = isc.Label.create({
            width: "100%",
            height: "100%",
            contents: "Usuario: Nelson Ramirez",
            styleName: "gha-top-label-dropdown-menu"
        });

        var nameContainer = isc.HLayout.create({
            height: 40,
            backgroundColor: "#99C9F3",
            members: [userNameLabel]
        });

        userNameLabel.setBackgroundColor(nameContainer.backgroundColor);
        return nameContainer;
    };

    /**
     * Genera el layout que contiene la informacion sobre la data de usuario
     */
    var generateUserDataContainer = function () {
        return isc.VLayout.create({
            backgroundColor: "#D2E8FF"
        });
    };

    /**
     * Genera el layout que contiene los botones del menu
     */
    var generateButtonsContainer = function () {
        var perfilButton = isc.IButton.create({
            title: "Perfil",
            click: showPerfil
        });
        var logoutButton = isc.IButton.create({
            title: "Cerrar sesión",
            click: logoutUser
        });
        var spacerConf = {
            width: 20
        };
        var buttonsContiner = isc.HLayout.create({
            height: 40,
            backgroundColor: "#99C9F3",
            defaultLayoutAlign: "center",
            members: [
                isc.LayoutSpacer.create(spacerConf),
                perfilButton,
                isc.LayoutSpacer.create(),
                logoutButton,
                isc.LayoutSpacer.create(spacerConf)
            ]
        });
        return buttonsContiner;
    };

    var init = function () {
        var headerLayout = layoutBase_module.headerLayout;

        nameContainer = generateUserNameContainer();
        userDataContiner = generateUserDataContainer();
        buttonsContiner = generateButtonsContainer();

        var pico = isc.Img.create({
            src: "../img/pico.png",
            width: 27,
            height: 15,
            left: layoutBase_module.getLayoutBaseWidth() - 60,
            top: headerLayout.getHeight() - 15,
            position: "absolute",
            autoDraw: false
        });

        var dropdownMenu = isc.VLayout.create({
            width: 280,
            height: 270,
            top: headerLayout.getHeight(),
            left: (layoutBase_module.getLayoutBaseWidth() - 20) - 280,
            backgroundColor: "#FFFFFF",
            border: "1px solid #E0E0E0",
            position: "absolute",
            visibility: "hidden",
            canFocus: true,
            showShadow: true,
            shadowDepth: 6,
            members: [nameContainer, userDataContiner, buttonsContiner]
        });

        // Dando funcionalidad al boton User:
        var userInfoImgButton = layoutBase_module.userInfoImgButton;
        userInfoImgButton.click = function () {
            var isVisible = dropdownMenu.isVisible();
            if (isVisible) {
                dropdownMenu.hide();
                pico.hide();
            } else {
                dropdownMenu.show();
                pico.show();
            }
        };

        // ajustando la ubicacion del menu segun el tamaño de la ventana
        util_module.suscribeToBrodcast("resizedLayout", function () {
            var layoutBaseWidth = layoutBase_module.getLayoutBaseWidth();
            var dropdownMenuNewLeft = (layoutBaseWidth - 20) - 280;
            var picoNewLeft = layoutBaseWidth - 60;

            dropdownMenu.setLeft(dropdownMenuNewLeft);
            pico.setLeft(picoNewLeft);
        });
    };

    init();

    // OBJETO CON LOS ELEMENTOS PUBLICOS DEL MODULO
    return {
        nameContainer: nameContainer,
        userDataContiner: userDataContiner,
        buttonsContiner: buttonsContiner
    };
})();
