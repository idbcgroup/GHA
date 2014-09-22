package com.hocs.gha.frontend.services.gom;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hocs.gha.backend.facade.auth.LoginServiceRemote;
import com.hocs.gha.frontend.domain.CodeRequest;
import com.hocs.gha.frontend.domain.ErrorInfo;
import com.hocs.gha.frontend.domain.ParameterResponse;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

/**
 * @author naramirez
 */
@Stateless
@Path(GhaServerBaseApplication.GOM_SERVICE_PATH)
public class ParameterRestService {

	@EJB(lookup = LoginServiceRemote.JNDI_NAME)
	private LoginServiceRemote loginService;

	/**
	 * Se encarga de verificar que el usaurio y el password sean validos
	 * 
	 * @param request
	 *            objeto JSON con esta forma: <br>
	 *            { <b>catalogCode</b>: nombre del catalogo }
	 * @return objeto JSON con esta forma:
	 * 
	 *         <pre>
	 * Servicio: services/gom/getParameter
	 * 	Recibe: 
	 * 	        { String ManagerRequest }
	 * 	Devuelve: 
	 * 	        {   valid: true o false
	 * 	            Parameter:{ param1: XXX, param2: XXX }
	 * 	            errorInfo: { int errorId, String message, String descripcion, String stackTrace }
	 * 	        }
	 * </pre>
	 */
	@POST
	@Path("/getParameter")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ParameterResponse getParameter(CodeRequest request) {

		ParameterResponse response = new ParameterResponse();
		ErrorInfo error = new ErrorInfo();

		try {

			error.setCode(0);
			error.setMessage("Exito");
			error.setDescription("Exito");
			response.setValid(true);
			response.setError(error);
			response.setParameter(null);

		} catch (Exception e) {

		}

		error.setCode(1);
		error.setMessage("Exception");
		error.setDescription("Error en servicio SOA");
		error.setStackTrace(" trackTrace");

		response.setValid(false);
		response.setError(error);

		return response;
	}
}
