var CORE_NAMESPACE = CORE_NAMESPACE || {};

CORE_NAMESPACE.LayoutBaseModule = (function () {
    "use strict";
    var util_module = CORE_NAMESPACE.UtilModule;

    var logoImg = null;
    var msgImgButton = null, userInfoImgButton = null;
    var userNameAndWALayout = null, menuBarLayout = null, formLayout = null, statusBarLayout = null;
    var contentLayout = null, headerLayout = null;

    var getLayoutBaseWidth = function () {
        return contentLayout.getWidth();
    };

    var getLayoutBaseHeight = function () {
        return contentLayout.getHeight();
    };

    var init = function () {
        var spacerConfig = {
            width: 20
        };

        logoImg = isc.Img.create({
            imageType: "stretch",
            src: "../img/logo.png",
            title: "Usuario",
            width: 130,
            margin: 10,
            visibility: "hidden"
        });

        msgImgButton = isc.ImgButton.create({
            imageType: "center",
            src: "../img/msgBoton.png",
            title: "Mensajes",
            width: 50,
            visibility: "hidden"
        });

        userInfoImgButton = isc.ImgButton.create({
            imageType: "center",
            src: "../img/userBoton.png",
            title: "Usuario",
            width: 50,
            visibility: "hidden"
        });

        userNameAndWALayout = isc.VLayout.create({
            align: "center",
            width: 400
        });

        headerLayout = isc.HLayout.create({
            height: 70,
            members: [isc.LayoutSpacer.create(spacerConfig),
                logoImg,
                isc.LayoutSpacer.create(),
                userNameAndWALayout,
                msgImgButton,
                userInfoImgButton,
                isc.LayoutSpacer.create(spacerConfig)
            ],
            backgroundColor: "#F0F0F0"
        });

        menuBarLayout = isc.HLayout.create({
            height: 40,
            backgroundColor: "#003B80"
        });

        formLayout = isc.VLayout.create();

        var principalContiner = isc.VLayout.create({
            height: "100%",
            members: [menuBarLayout, formLayout]
        });

        var footLogo = isc.Img.create({
            width: 50,
            height: 20,
            imageType: "center",
            src: "../img/footLogo.jpg"
        });

        statusBarLayout = isc.HLayout.create({
            height: 20,
            backgroundColor: "#484848",
            members: [isc.LayoutSpacer.create(), footLogo]
        });

        contentLayout = isc.VLayout.create({
            width: "100%",
            height: "100%",
            minMemberSize: "18",
            overflow: "hidden",
            members: [headerLayout, principalContiner, statusBarLayout]
        });

        // cuando el contentLayout cambia de tamaño se ejecutan todas las
        // funciones
        // que estan escuchando este evento
        contentLayout.resized = function () {
            util_module.fireBroadcast("resizedLayout");
        };

        contentLayout.show();
    };

    init();
    return {
        logoImg: logoImg,
        formLayout: formLayout,
        menuBarLayout: menuBarLayout,
        statusBarLayout: statusBarLayout,
        userNameAndWALayout: userNameAndWALayout,
        msgImgButton: msgImgButton,
        userInfoImgButton: userInfoImgButton,
        getLayoutBaseWidth: getLayoutBaseWidth,
        getLayoutBaseHeight: getLayoutBaseHeight,
        headerLayout: headerLayout
    };
})();