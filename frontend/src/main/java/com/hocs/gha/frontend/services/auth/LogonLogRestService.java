package com.hocs.gha.frontend.services.auth;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hocs.gha.frontend.domain.ErrorInfo;
import com.hocs.gha.frontend.domain.LogonLogRequest;
import com.hocs.gha.frontend.domain.LogonLogResponse;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

/**
 * @author caparicio
 */
@Stateless
@Path(GhaServerBaseApplication.AUTH_SERVICE_PATH)
public class LogonLogRestService {
    /**
     * Registra la conexión realizada en la tabla <b>LogonLog</b> que representa
     * la bitácora de Conexiones de la Aplicación, indicando toda la información
     * capturada en el proceso de conexión
     *
     * @param request Objeto JSON con esta forma:
     * <pre>
     * {    login: nombre de usaurio,
     *      password: password,
     *      bpiCodeFrom: id de la institucion desde donde se conecta el usuario,
     *      bpiCodeTo: id de la institucion donde se va a conectar el usuario
     * }
     * </pre>
     * @return objeto JSON con esta forma:
     * <pre>
     * {
     *      valid: true o false,
     *      error: {
     *          code: codigo del error,
     *          message: "mensaje del error",
     *          description: "descripcion del error",
     *          stackTrace: "stack trace del error (puede ser null)"
     *      }
     * }
     * </pre>
     */
    @POST
    @Path("/setInLogonLog")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LogonLogResponse LogonLogConection(LogonLogRequest request) {
        LogonLogResponse response = new LogonLogResponse();

        try {
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setCode(0);
            errorInfo.setDescription("Sin Error");
            errorInfo.setMessage("Sin Error");
            errorInfo.setStackTrace("StackTrace sin error");

            response.setError(errorInfo);
            response.setValid(true);
        } catch (Exception e) {
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setCode(1);
            errorInfo.setDescription("Error de ejecucion");
            errorInfo.setMessage("Error al ejecutar el servicio EJB");
            errorInfo.setStackTrace("StackTrace con error");

            response.setError(errorInfo);
            response.setValid(false);
        }
        return response;
    }
}