package com.hocs.gha.frontend.services.gom;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hocs.gha.backend.facade.auth.LoginServiceRemote;
import com.hocs.gha.frontend.domain.CatalogResponse;
import com.hocs.gha.frontend.domain.CodeRequest;
import com.hocs.gha.frontend.domain.ComboBoxElement;
import com.hocs.gha.frontend.domain.ErrorInfo;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

/**
 * @author naramirez
 */
@Stateless
@Path(GhaServerBaseApplication.GOM_SERVICE_PATH)
public class CatalogRestService {

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
	 * { valid: true o false,
	 *   catalog:[ { id: 1, name: "AAA" }, 
	 *             { id: 2, name: "YYY" }, ...]
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
	@Path("/getCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CatalogResponse getCatalog(CodeRequest request) {

		CatalogResponse response = new CatalogResponse();
		ErrorInfo error = new ErrorInfo();

		// TODO armar objeto fachada para consultar el servicio SOA
		try {
			// TODO ejecutar el Web Service para obtene el catalogo
			ArrayList<ComboBoxElement> list = new ArrayList<ComboBoxElement>();

			for (int i = 0; i < 3; i++) {
				ComboBoxElement element = new ComboBoxElement();
				element.setId(i);
				element.setName(i + "XXX");
				list.add(element);
			}

			error.setCode(0);
			error.setMessage("Exito");
			error.setDescription("Exito");

			response.setValid(true);
			response.getCatalog().addAll(list);
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
}
