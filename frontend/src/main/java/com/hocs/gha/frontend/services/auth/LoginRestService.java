package com.hocs.gha.frontend.services.auth;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hocs.gha.backend.facade.auth.LoginServiceRemote;
import com.hocs.gha.frontend.domain.*;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

/**
 * @author naramirez
 */
@Stateless
@Path(GhaServerBaseApplication.AUTH_SERVICE_PATH)
public class LoginRestService {

    @EJB(lookup = LoginServiceRemote.JNDI_NAME)
    private LoginServiceRemote loginService;

    /**
     * Se encarga de verificar que el usaurio y el password sean validos
     *
     * @param request objeto JSON con esta forma: <br>
     *                { <b>login</b>: nombre de usaurio,<br>
     *                <b>password</b>: password en md5,<br>
     *                }
     * @return objeto JSON con esta forma: <br>
     * <p/>
     * <pre>
     *       { valid: true o false
     *         blocked: true o false          // Indica si el usuario es bloqueado por numero de intentos
     *         invalidPassword:true o false   // Indica si la clave es Invalida
     *         accountInactivate:true o false // Indica si la cuenta se encuentra activa
     *         userNotExists:true o false     // Indica si el usuario existe en la base de datos
     *         numAttemps: 3                  // Indica el numero de intentos restantes a la base de datos
     *         bpiDefault: id                 // Institución BPI por defecto en la que puede conectarse el usuario
     *         bpuData: {
     *             institutions = [           // Lista de instituciones con id, nombre y URL para redirigir
     *                 {id, name, url},
     *                 {id, name, url}
     *             ]
     *             workingAreas = [           // Lista de areas de trabajo con id y nombre para redirigir
     *                 {id, name},
     *                 {id, name}
     *             ]
     *         }
     *         error: {
     *             code:errorId,
     *             description:description,
     *             message:message,
     *             stackTrace:stackTrace
     *         }
     *       }
     * </pre>
     */
    @POST
    @Path("/validarCredenciales")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginResponse verificarLogin(LoginRequest request) {

        LoginResponse response = new LoginResponse();
        ErrorInfo error = new ErrorInfo();
        // armar el objeto credenciales de la fachada:

        try {
            // TODO consumir servicio SOA para llenar los jax-b
            error.setCode(1);
            error.setDescription("Sin Error");
            error.setMessage("Sin Error");
            error.setStackTrace("Sin trackTrace");

            response.setValid(true);
            response.setError(error);
            response.setInvalidPassword(false);
            response.setAccountInactivate(false);
            response.setUserNotExists(false);
            response.setNumAttemps(3);

            if (request.getLogin().equals("xxxx"))
                response.setBpiDefault(200);
            else
                response.setBpiDefault(0);

            BpuData bpuData = new BpuData();

            for (int i = 0; i < 3; i++) {
                ComboBoxElement element = new ComboBoxElement();
                element.setId(i);
                element.setName(i + "EGU");
                bpuData.getWorkingAreas().add(element);

                Institutions institutions = new Institutions();
                institutions.setId(i);
                institutions.setName(i + " El Marquez");
                institutions.setUrl("http://www.google.com.ve");
                bpuData.getInstitutions().add(institutions);

            }

            response.setBpuData(bpuData);
        } catch (Exception e) {
            error.setCode(1);
            error.setDescription("Sin Error");
            error.setMessage("Sin Error");
            error.setStackTrace("Sin trackTrace");

            response.setError(error);
            response.setValid(false);

            e.printStackTrace();
        }

        return response;
    }
}
