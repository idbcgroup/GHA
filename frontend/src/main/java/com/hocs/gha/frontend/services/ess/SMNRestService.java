package com.hocs.gha.frontend.services.ess;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hocs.gha.frontend.domain.CodeRequest;
import com.hocs.gha.frontend.domain.ErrorInfo;
import com.hocs.gha.frontend.domain.GhaResponse;
import com.hocs.gha.frontend.domain.SmnAlarm;
import com.hocs.gha.frontend.domain.SmnMessage;
import com.hocs.gha.frontend.domain.SmnNotification;
import com.hocs.gha.frontend.domain.SmnResponse;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

/**
 * @author naramirez
 */
@Stateless
@Path(GhaServerBaseApplication.ESS_SERVICE_PATH)
public class SMNRestService {

	/**
	 * @param request
	 *            objeto JSON con esta forma: { code: "bpuId" }
	 * @return objeto JSON con esta forma:
	 * 
	 *         <pre>
	 * { valid: true o false,
	 *   messages: [{...}],
	 *   notifications:[{...}],
	 *   alarms: [{...}],
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
	@Path("/getMsgNotifAndAlarms")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public GhaResponse getMsgsNotifsAndAlarms(CodeRequest request) {

		SmnResponse response = new SmnResponse();
		ErrorInfo error = new ErrorInfo();

		try {
			if (!request.getCode().equals("user"))
				throw new Exception();

			response.setValid(true);

			SmnAlarm alarm = null;
			alarm = new SmnAlarm();
			alarm.setDescription("descrip");
			alarm.setLevel("SOFT");
			response.getAlarms().add(alarm);

			alarm = new SmnAlarm();
			alarm.setDescription("descrip");
			alarm.setLevel("SEVERE");
			response.getAlarms().add(alarm);

			SmnMessage msg = new SmnMessage();
			msg.setMessage("mensaje");
			msg.setTitle("titulo");
			response.getMessages().add(msg);

			SmnNotification notif = new SmnNotification();
			notif.setDescription("descrip");
			response.getNotifications().add(notif);

			error = new ErrorInfo();
			error.setCode(0);
			error.setDescription("Sin Error");
			error.setMessage("Sin Error");
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
