var CORE_NAMESPACE = CORE_NAMESPACE || {};

CORE_NAMESPACE.BotonPruebaModule = (function () {
    "use strict";

    var util_module = CORE_NAMESPACE.UtilModule;
    var layoutBase_module = CORE_NAMESPACE.LayoutBaseModule;
    var testButton = null;

    var getJsonString = function (code, funcHandler) {
        var requestData = JSON.stringify({
            code: code
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

                funcHandler(jsonParse);
            } else {
                isc.warn("No se encontro el formulario");
                funcHandler(null);
            }
        });
    };

    var arrDS = [];
    var pepe = 1;

    var init = function () {
        testButton = isc.IButton.create({
            title: "boton prueba",
            autoDraw: false,
            click: function () {

                getJsonString("DATASOURCE", function (jsonDS) {
                    if (jsonDS === null) {
                        return;
                    }

                    arrDS.push(isc.RestDataSource.create({
                        ID: "DSTest1",
                        dataFormat: "json",
                        operationBindings: [
                            {operationType: "fetch", dataProtocol: "clientCustom"},
                            {operationType: "add", dataProtocol: "clientCustom"},
                            {operationType: "remove", dataProtocol: "clientCustom"},
                            {operationType: "update", dataProtocol: "clientCustom"}
                        ],
                        fields: [
                            {name: "firstName", title: "First Name", type: "text", required: true, length: 50, primaryKey: true},
                            {name: "lastName", title: "Last Name1", type: "text", length: 50},
                            {name: "password", title: "Password", type: "password", required: true, length: 20}
                        ],
                        transformRequest: function (dsRequest) {
                            dsRequest.dataFormat = "json";

                            var requestData = JSON.stringify({
                                sessionId: 1,
                                txCode: "txToDs1",
                                token: "XXX1",
                                userName: "",
                                bpiCode: "",
                                terminalCode: "",
                                operationType: dsRequest.operationType,
                                data: dsRequest.data
                            });

                            $.ajax({
                                type: "POST",
                                contentType: "application/json;charset=utf-8",
                                url: "services/ess/servicePrueba",
                                data: requestData,
                                dataType: "json"
                            }).done(function (dataResp) {
                                var data = dataResp.data;
                                var aux = {status: 0, startRow: 0, endRow: data.length - 1, totalRows: data.length, data: data};
                                DSTest1.processResponse(dsRequest.requestId, aux);
                            });
                        }
                    }));

                    arrDS.push(isc.RestDataSource.create({
                        ID: "DSTest2",
                        dataFormat: "json",
                        operationBindings: [
                            {operationType: "fetch", dataProtocol: "clientCustom"},
                            {operationType: "add", dataProtocol: "clientCustom"},
                            {operationType: "remove", dataProtocol: "clientCustom"},
                            {operationType: "update", dataProtocol: "clientCustom"}
                        ],
                        fields: [
                            {name: "col1", title: "col1", type: "text", length: 50, primaryKey: true},
                            {name: "col2", title: "col2", type: "text", length: 50},
                            {name: "col3", title: "col3", type: "select"},
                            {name: "col4", title: "col4", type: "password", length: 20}
                        ],
                        transformRequest: function (dsRequest) {
                            dsRequest.dataFormat = "json";

                            var requestData = JSON.stringify({
                                sessionId: 1,
                                txCode: "txToDs2",
                                token: "XXX1",
                                userName: "",
                                bpiCode: "",
                                terminalCode: "",
                                operationType: dsRequest.operationType,
                                data: dsRequest.data
                            });

                            $.ajax({
                                type: "POST",
                                contentType: "application/json;charset=utf-8",
                                url: "services/ess/servicePrueba",
                                data: requestData,
                                dataType: "json"
                            }).done(function (dataResp) {
                                var data = dataResp.data;
                                var aux = {status: 0, startRow: 0, endRow: data.length - 1, totalRows: data.length, data: data};
                                DSTest2.processResponse(dsRequest.requestId, aux);
                            });
                        }
                    }));

                    getJsonString("INITIAL_FORM", function (jsonForm) {
                        if (jsonDS === null) {
                            return;
                        }

                        var form = isc.VLayout.create({
                            width: '100%',
                            height: '100%',
                            members: [
                                isc.ListGrid.create({
                                    ID: 'countryList',
                                    width: 500,
                                    height: 150,
                                    alternateRecordStyles: true,
                                    emptyCellValue: '--',
                                    dataSource: arrDS[pepe],
                                    useAllDataSourceFields: true,
                                    autoFetchData: true,
                                    dataPageSize: 20
                                }),

                                isc.DynamicForm.create({
                                    ID: 'boundForm',
                                    colWidths: [100, 200],
                                    autoFetchData: true,
                                    fields: [
                                        {type: 'header', defaultValue: 'Registration Form'},
                                        {name: 'password'},
                                        {name: 'password2', title: 'Password Again', type: 'password', required: true,
                                            length: 20, validators: [
                                                {   type: 'matchesField',
                                                    otherField: 'password',
                                                    errorMessage: 'Passwords do not match'
                                                }
                                            ]
                                        },
                                        {name: 'acceptTerms', title: 'I accept the terms of use.', type: 'checkbox', width: 150,
                                            defaultValue: false,
                                            validators: [
                                                {
                                                    type: 'custom',
                                                    condition: 'return value == true',
                                                    errorMessage: 'You must accept the terms of use to continue'
                                                }
                                            ]
                                        },
                                        {name: 'fetchBtn', title: 'fetchBtn', type: 'button',
                                            click: function () {
                                                boundForm.fetchData();
                                            }
                                        },
                                        {name: 'addBtn', title: 'addBtn', type: 'button',
                                            click: function () {
                                                boundForm.addData(
                                                    {
                                                        firstName: 'US',
                                                        lastName: 'Edited Value',
                                                        password: 'Edited Value'
                                                    });
                                            }
                                        },
                                        {name: 'updateBtn', title: 'updateBtn', type: 'button',
                                            click: function () {
                                                boundForm.updateData({
                                                        firstName: 'US',
                                                        lastName: 'Edited Value',
                                                        password: 'Edited Value'
                                                    },
                                                    function (dsResponse, data, dsRequest) {
                                                        myForm.setValues(data);
                                                    });
                                            }
                                        },
                                        {name: 'deleteBtn', title: 'deleteBtn', type: 'button',
                                            click: function () {
                                                boundForm.removeData({ firstName: 'US' });
                                            }
                                        },
                                        {name: 'saveDataBtn', title: 'saveDataBtn', type: 'button',
                                            click: function () {
                                                boundForm.saveData();
                                            }
                                        },
                                        {name: 'switchDS', title: 'switchDS', type: 'button',
                                            click: function () {
                                                pepe = 1-pepe;
                                                countryList.setDataSource(arrDS[pepe]);
                                                boundForm.setDataSource(arrDS[pepe], boundForm.getFields());

                                                countryList.fetchData();
                                                boundForm.fetchData();
                                            }
                                        },
                                        {name: 'selectRecord', title: 'selectRecord', type: 'button',
                                            click: function () {
                                                boundForm.fetchData();
                                            }
                                        }
                                    ],
                                    dataSource: arrDS[pepe],
                                    useAllDataSourceFields: true
                                })
                            ]
                        });
                        var formLayout = layoutBase_module.formLayout;
                        formLayout.addMember(form);
                    });
                });
            }
        });

        var menuBarLayout = layoutBase_module.menuBarLayout;
        menuBarLayout.addMember(testButton);
    };

    init();
    return {
        testButton: testButton
    };
})();