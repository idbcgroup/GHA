/*
 * Copyright (c) 2014. Colocar el texto de propiedad
 */

package com.hocs.gha.frontend.services.ess;

import com.hocs.gha.backend.facade.auth.LoginServiceRemote;
import com.hocs.gha.frontend.domain.GhaGenObj;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * FBSC: Frontend Back Service Call
 *
 * @author naramirez
 */
@Stateless
@Path(GhaServerBaseApplication.ESS_SERVICE_PATH)
public class FbscRestService {

    @EJB(lookup = LoginServiceRemote.JNDI_NAME)
    private LoginServiceRemote loginService;


    @POST
    @Path("/fbsc")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map fbsc(Map request) {
        Map response = null;

        try {
            GhaGenObj genObj = toeSC(request);

            // Se opera con el objeto gha...

            response = tosSC(genObj);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Transformar Objeto json Entrada de Smart Client
     */
    public GhaGenObj toeSC(Map requestObj) {
        GhaGenObj genObj = new GhaGenObj();
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();

        Map dataSC = (Map) requestObj.get("data");
        Set keySet = dataSC.keySet();
        for (Object key : keySet) {
            String keyStr = (String) key;

            if (keyStr.equals("bpiCode")) {
                genObj.setBpiCode((String) dataSC.get("bpiCode"));
            } else if (keyStr.equals("operationType")) {
                genObj.setOperationType((String) dataSC.get("operationType"));
            } else if (keyStr.equals("sessionId")) {
                genObj.setSessionId((int) dataSC.get("sessionId"));
            } else if (keyStr.equals("terminalCode")) {
                genObj.setTerminalCode((String) dataSC.get("terminalCode"));
            } else if (keyStr.equals("token")) {
                genObj.setToken((String) dataSC.get("token"));
            } else if (keyStr.equals("txCode")) {
                genObj.setTxCode((String) dataSC.get("txCode"));
            } else if (keyStr.equals("txOrigin")) {
                genObj.setTxOrigin((String) dataSC.get("txOrigin"));
            } else if (keyStr.equals("userName")) {
                genObj.setUserName((String) dataSC.get("userName"));
            } else {
                data.put(keyStr, dataSC.get(keyStr));
            }
        }

        genObj.setData(data);

        return genObj;
    }

    /**
     * Transformar a Objeto json Salida de Smart Client
     */
    public Map tosSC(GhaGenObj exitObj) {
        LinkedHashMap<String, Object> mapObj = new LinkedHashMap<>();
        LinkedHashMap<String, Object> data = new LinkedHashMap<>();

        data.put("bpiCode", exitObj.getBpiCode());
        data.put("operationType", exitObj.getOperationType());
        data.put("sessionId", exitObj.getSessionId());
        data.put("terminalCode", exitObj.getTerminalCode());
        data.put("token", exitObj.getToken());
        data.put("txCode", exitObj.getTxCode());
        data.put("txOrigin", exitObj.getTxOrigin());
        data.put("userName", exitObj.getUserName());

        Map dataExitObj = exitObj.getData();
        if (dataExitObj != null) {
            Set keySet = dataExitObj.keySet();
            for (Object key : keySet) {
                String keyStr = (String) key;
                data.put(keyStr, dataExitObj.get(keyStr));
            }
        }

        mapObj.put("status", 0);
        mapObj.put("startRow", 0);
        mapObj.put("endRow", 0);
        mapObj.put("totalRows", 0);
        mapObj.put("data", data);

        return mapObj;
    }
}
