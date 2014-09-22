package com.hocs.gha.frontend.services.ess;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hocs.gha.frontend.domain.*;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

import java.util.Arrays;

/**
 * @author caparicio
 */
@Stateless
@Path(GhaServerBaseApplication.ESS_SERVICE_PATH)
public class InfoPackRestService {
    @POST
    @Path("/getInfoPack")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public InfoPackResponse getInfoPack(CodeRequest request) {
        InfoPackResponse response = new InfoPackResponse();
        InfoPackData packData;

        String code = request.getCode();
        try {
            switch (code) {
                case "bpiPack":
                    packData = new BpiPackData();
                    break;
                case "bpuPack":
                    packData = new BpuPack();
                    break;
                default:
                    throw new Exception("No se consiguio el infoPack");
            }

            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setCode(0);
            errorInfo.setDescription("Sin Error");
            errorInfo.setMessage("Sin Error");
            errorInfo.setStackTrace("StackTrace sin error");

            InfoPack infoPack = new InfoPack();
            infoPack.setIsUnique(true);
            infoPack.getData().add(packData);

            response.setError(errorInfo);
            response.setValid(true);
            response.setInfoPack(infoPack);

        } catch (Exception e) {
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setCode(1);
            errorInfo.setDescription(e.getMessage());
            errorInfo.setMessage("Error en servicio EJB");
            errorInfo.setStackTrace(Arrays.toString(e.getStackTrace()));

            InfoPack infoPack = new InfoPack();
            infoPack.setIsUnique(false);

            response.setError(errorInfo);
            response.setValid(false);
            response.setInfoPack(infoPack);
        }
        return response;
    }
}
