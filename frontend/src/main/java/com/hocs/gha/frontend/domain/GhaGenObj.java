/*
 * Copyright (c) 2014. Colocar el texto de propiedad
 */

package com.hocs.gha.frontend.domain;

import java.util.Map;

/**
 * Created by NelsonAlfonso on 18-09-2014.
 */
public class GhaGenObj {
    // El id de la trasaccion a ejecutar ("GuardarItem", "DesapachoProveedor", etc...)
    String TxCode;
    // Origen de la transaccion: GHA, SC, ExtJS, etc..
    String txOrigin;
    // Tipo de operacion (ADD, REMOVE, UPDATE, FETCH, etc...)
    String operationType;

    // id de la sesion del usaurio
    int sessionId;
    // el  token identificador del usuario
    String token;
    // Nombre del usuario
    String userName;
    // el codigo de la institucion donde se esta solicitando la transaccion
    String bpiCode;
    // el codigo del terminal dentro de la institucion
    String terminalCode;

    // La data en si con la que se quiere operar en la transaccion
    private Map data;

    public GhaGenObj() {
    }

    public String getTxCode() {
        return TxCode;
    }

    public void setTxCode(String txCode) {
        TxCode = txCode;
    }

    public String getTxOrigin() {
        return txOrigin;
    }

    public void setTxOrigin(String txOrigin) {
        this.txOrigin = txOrigin;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBpiCode() {
        return bpiCode;
    }

    public void setBpiCode(String bpiCode) {
        this.bpiCode = bpiCode;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
