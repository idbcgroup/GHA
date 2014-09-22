package com.hocs.gha.frontend.services.gom;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hocs.gha.backend.facade.auth.LoginServiceRemote;
import com.hocs.gha.frontend.domain.BpiPackData;
import com.hocs.gha.frontend.domain.BpiParameter;
import com.hocs.gha.frontend.domain.BpuAccessPack;
import com.hocs.gha.frontend.domain.BpuPack;
import com.hocs.gha.frontend.domain.ComboBoxElement;
import com.hocs.gha.frontend.domain.DataGlobalInfoPacks;
import com.hocs.gha.frontend.domain.DataGlobalParameters;
import com.hocs.gha.frontend.domain.DataGlobalRequest;
import com.hocs.gha.frontend.domain.DataGlobalResponse;
import com.hocs.gha.frontend.domain.ErrorInfo;
import com.hocs.gha.frontend.domain.InfoPack;
import com.hocs.gha.frontend.domain.Institutions;
import com.hocs.gha.frontend.domain.MessageParameter;
import com.hocs.gha.frontend.domain.OperationParameter;
import com.hocs.gha.frontend.services.application.GhaServerBaseApplication;

/**
 * @author naramirez
 */
@Stateless
@Path(GhaServerBaseApplication.GOM_SERVICE_PATH)
public class DataGlobalRestService {

    /**
     * Se encarga de verificar que el usaurio y el password sean validos
     *
     * @param request objeto json con esta forma:
     * <pre> { institutionid: id de la institucion,
     *         workingareaid: id del area de trabajo }
     * </pre>
     * @return objeto JSON con esta forma:
     * <pre>
     * {@code
     *  {
     *      valid: true o false,
     *      infoPacks: {
     *          BpiPack: { },
     *          AccessPack: { },
     *          TerminalPack: { },
     *          PeripheralPack: { }
     *      },
     *      parameters: {
     *          BpiParameter: { }
     *          OperationParameter: { }
     *          MessageParameter: { }
     *      },
     *      bpuData:{ },
     *      error: {
     *          code: 0,
     *          message: "msj",
     *          description: "desc",
     *          stackTrace: "stack trace"
     *      }
     *  }
     * }
     *
     * </pre>
     */
    @POST
    @Path("/getDataGlobal")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DataGlobalResponse getDataGlobal(DataGlobalRequest request) {

        DataGlobalResponse response = new DataGlobalResponse();
        ErrorInfo error = new ErrorInfo();

        // TODO armar objeto fachada para consultar el servicio SOA
        try {
            BpuPack bpuPack = new BpuPack();
            bpuPack.setBpuHoraryRestricted(false);
            bpuPack.setBpuWaRestricted(true);
            bpuPack.setBpuPkiRequired("ELEC_CERT_NOT-REQUIRED");
            
            BpuAccessPack bpuAccessPack = new BpuAccessPack();
            for (int i = 0; i < 3; i++) {
                ComboBoxElement element = new ComboBoxElement();
                element.setId(i);
                element.setName(i + "Hospital");
                bpuAccessPack.getBpuWaAllowed().add(element);
            }
            
            ComboBoxElement WorkingAreaPrimary = new ComboBoxElement();
            WorkingAreaPrimary.setId(200);
            WorkingAreaPrimary.setName("Area de Trabajo Primaria");
            
            bpuPack.setBpuPrimaryWaIo(WorkingAreaPrimary);
            
            DataGlobalInfoPacks infoPacks = new DataGlobalInfoPacks();
            InfoPack bpiPack = new InfoPack();
            infoPacks.setAccessPack(new InfoPack());
            infoPacks.setPeripherialPack(new InfoPack());
            infoPacks.setTerminalPack(new InfoPack());
            infoPacks.setBpiPack(bpiPack);
            infoPacks.setBpuPack(bpuPack);
            infoPacks.setBpuAccessPack(bpuAccessPack);

            bpiPack.setIsUnique(false);
            bpiPack.getData().add(new BpiPackData());
            bpiPack.getData().add(new BpiPackData());

            DataGlobalParameters parameters = new DataGlobalParameters();
            parameters.setBpiParameter(new BpiParameter());
            parameters.setOperationParameter(new OperationParameter());
            parameters.setMessageParameter(new MessageParameter());

            error.setCode(0);
            error.setMessage("Exito");
            error.setDescription("Exito");

            response.setValid(true);
            response.setInfoPacks(infoPacks);
            response.setParameters(parameters);
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
