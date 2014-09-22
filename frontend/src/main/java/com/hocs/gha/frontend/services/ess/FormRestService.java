package com.hocs.gha.frontend.services.ess;

import com.hocs.gha.frontend.domain.*;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;
import org.apache.commons.io.IOUtils;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author naramirez
 */
@Stateless
@Path(GhaServerBaseApplication.ESS_SERVICE_PATH)
public class FormRestService {

    /**
     * @param request objeto JSON con esta forma: { code: "formCode" }
     * @return objeto JSON con esta forma:
     * <p/>
     * <pre>
     * { valid: true o false,
     *   jsonString:"String con el codigo del formulario"
     *   errorInfo: {
     *       code: 0,
     *       message: "msj",
     *       description: "desc",
     *       stackTrace: "stack trace"
     *   }
     * }
     * </pre>
     */
    @POST
    @Path("/getForm")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GhaResponse getForm(CodeRequest request) {

        FormResponse response = new FormResponse();
        ErrorInfo error = new ErrorInfo();
        String stringResponse;
        StringWriter writer = new StringWriter();

        try {
            String formCode = request.getCode();
            InputStream in;

            switch (formCode) {
                case "BPU_EDT":
                    stringResponse = "{ width: '100%', height: '100%', members: [ isc.Label.create({ contents: 'Navigation', align: 'center', overflow: 'hidden', width: '30%', showResizeBar: true, border: '1px solid blue'}), isc.VLayout.create({ width: '70%', members: [ isc.Label.create({ contents: 'Listing', align: 'center', overflow: 'hidden',height: '30%', showResizeBar: true, border: '1px solid blue' }), isc.Label.create({ contents: 'Details', align: 'center', overflow: 'hidden', height: '70%', border: '1px solid blue' })]})]}";
                    break;
                case "INITIAL_FORM":
                    in = getClass().getResourceAsStream("/formPrueba01.txt");
                    IOUtils.copy(in, writer, "UTF-8");
                    stringResponse = writer.toString();
                    break;
                case "DATASOURCE":
                    in = getClass().getResourceAsStream("/DsPrueba01.txt");
                    IOUtils.copy(in, writer, "UTF-8");

                    writer.append(',');

                    in = getClass().getResourceAsStream("/DsPrueba02.txt");
                    IOUtils.copy(in, writer, "UTF-8");

                    stringResponse = "{ds:[" + writer.toString() + "]}";
                    break;
                default:
                    throw new Exception();
            }


            error = new ErrorInfo();
            error.setCode(0);
            error.setDescription("Sin Error");
            error.setMessage("Sin Error");

            response.setValid(true);
            response.setJsonString(stringResponse);
            response.setError(error);
        } catch (Exception e) {
            e.printStackTrace();

            error.setCode(1);
            error.setMessage(e.getMessage());
            error.setDescription("Error en servicio SOA");
            error.setStackTrace(e.getStackTrace()[0].toString());

            response.setValid(false);
            response.setError(error);
        }

        return response;
    }

    @POST
    @Path("/servicePruebaFetch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object servicePruebaFetch(Object request) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> Entro en servicePruebaFetch <<<<<<<<<<<<<<<<<<<<<<<<<");

        Map mapRequest = (Map) request;
        System.out.println("sessionId = " + mapRequest.get("sessionId"));
        System.out.println("token = " + mapRequest.get("token"));

        ArrayList<Map> list = new ArrayList<>();
        HashMap<String, Object> response = new HashMap<>();
        response.put("firstName", "nelson");
        response.put("lastName", "perez");
        response.put("password", "1234");
        list.add(response);

        response = new HashMap<>();
        response.put("firstName", "Carlos");
        response.put("lastName", "Inguanzo");
        response.put("password", "12345");
        list.add(response);

        return list;
    }

    @POST
    @Path("/servicePrueba")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object servicePrueba(Object request) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> Entro en servicePrueba <<<<<<<<<<<<<<<<<<<<<<<<<");
        Map mapRequest = (Map) request;
        String operationType = (String) mapRequest.get("operationType");
        String txCode = (String) mapRequest.get("txCode");
        String token = (String) mapRequest.get("token");
        int sessionId = (int) mapRequest.get("sessionId");
        LinkedHashMap data = (LinkedHashMap) mapRequest.get("data");

        System.out.println("operationType: " + operationType);
        System.out.println("txCode: " + txCode);
        System.out.println("token: " + token);
        System.out.println("sessionId: " + sessionId);

        LinkedHashMap<String, Object> responseMap = new LinkedHashMap<>();
        ArrayList<Map> list = new ArrayList<>();

        HashMap<String, Object> record = new HashMap<>();
        TestResponse response = new TestResponse(0, 0, 1, 1);

        if (txCode.equals("txToDs1")) {
            String firstName = "firstName", password = "password", lastName = "lastName";
            if (!operationType.equals("fetch")) {
                firstName = (String) data.get("firstName");
                password = (String) data.get("password");
                lastName = (String) data.get("lastName");

                record.put("firstName", firstName);
                record.put("password", password);
                record.put("lastName", lastName);
                list.add(record);
            } else {
                for (int i = 0; i < 50; i++) {
                    record = new HashMap<>();
                    record.put("firstName", firstName + i);
                    record.put("password", password + i);
                    record.put("lastName", lastName + i);
                    list.add(record);
                }
            }
        } else {
            String col1 = "col1", col2 = "col2", col3 = "col3", col4 = "col4";
            if (!operationType.equals("fetch")) {
                col1 = (String) data.get("col1");
                col2 = (String) data.get("col2");
                col3 = (String) data.get("col3");
                col4 = (String) data.get("col4");

                record.put("col1", col1);
                record.put("col2", col2);
                record.put("col3", col3);
                record.put("col4", col4);
                list.add(record);
            } else {
                for (int i = 0; i < 20; i++) {
                    record = new HashMap<>();
                    record.put("col1", col1 + i);
                    record.put("col2", col2 + i);
                    record.put("col3", col3 + i);
                    record.put("col4", col4 + i);
                    list.add(record);
                }
            }
        }
        responseMap.put("data", list);
        responseMap.put("errorCode", 0);

        return responseMap;
    }


    @POST
    @Path("/servicePruebaAdd")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedHashMap servicePruebaAdd(TestRequest request) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> Entro en servicePruebaAdd <<<<<<<<<<<<<<<<<<<<<<<<<");
        LinkedHashMap data = (LinkedHashMap) request.getData();
        String firstName = (String) data.get("firstName");
        String password = (String) data.get("password");
        String lastName = (String) data.get("lastName");

        TestResponse response = new TestResponse(0, 0, 1, 1);

        Record record = new Record(firstName, lastName, password);
        response.setData(record);

        LinkedHashMap<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("response", response);
        return responseMap;
    }

    @POST
    @Path("/servicePruebaUpdate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedHashMap servicePruebaUpdate(TestRequest request) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> Entro en servicePruebaUpdate <<<<<<<<<<<<<<<<<<<<<<<<<");

        LinkedHashMap data = (LinkedHashMap) request.getData();
        String firstName = (String) data.get("firstName");
        String password = (String) data.get("password");
        String lastName = (String) data.get("lastName");
        Record record = new Record(firstName, lastName, password);

        TestResponse response = new TestResponse(0, 0, 1, 1);
        response.setData(record);

        LinkedHashMap<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("response", response);
        return responseMap;
    }

    @POST
    @Path("/servicePruebaDelete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LinkedHashMap servicePruebaDelete(TestRequest request) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> Entro en servicePruebaDelete <<<<<<<<<<<<<<<<<<<<<<<<<");

        LinkedHashMap data = (LinkedHashMap) request.getData();
        String firstName = (String) data.get("firstName");
        Record record = new Record(firstName);

        TestResponse response = new TestResponse(0, 0, 1, 1);
        response.setData(record);

        LinkedHashMap<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("response", response);
        return responseMap;
    }


}
