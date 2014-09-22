/**
 * Created by nelson on 30/07/14.
 */

/**
 * El objeto GhaServiceError indica que se genero un error despues de consumir un servicio REST del proyecto GHA
 *
 * @param errorJson [Opcional]
 * El objeto error que devuelve como respuesta un servicio REST de GHA. Permite que GhaServiceError muestre mas detalles
 * en su atributo "message" tales como: Tipo de Error, Mensaje devuelto por el servicio, Descripcion del error y el StackTrace
 * @param message [Opcional]
 * Un mensaje que se desee mostrar para completar la informacion del error
 * @constructor
 */
function GhaServiceError(errorJson, message) {
    "use strict";
    var errorType;
    message = message || "Error al consumir servicio GHA...";

    if (errorJson !== undefined) {
        switch (errorJson.code) {
            case 1:
                errorType = "Error en el Servidor";
                break;
            case 2:
                errorType = "Error en el Servicio REST";
                break;
        }

        message = message +
            "\n ERROR_TYPE: " + errorType +
            "\n MESSAGE: " + errorJson.message +
            "\n DESCRIPTION: " + errorJson.description +
            "\n STACK_TRACE: " + errorJson.stackTrace;
    }

    this.name = "GhaServiceError";
    this.message = message;
}
GhaServiceError.prototype = new Error();
GhaServiceError.prototype.constructor = GhaServiceError;