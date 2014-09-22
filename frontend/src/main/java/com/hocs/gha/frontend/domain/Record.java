/*
 * Copyright (c) 2014. Colocar el texto de propiedad
 */

package com.hocs.gha.frontend.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by NelsonAlfonso on 05-09-2014.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "record", namespace = "http://www.example.org/schema3", propOrder = {
        "firstName",
        "lastName",
        "password"
})
public class Record {

    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected String firstName;

    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected String lastName;

    @XmlElement(namespace = "http://www.example.org/schema3", required = true)
    protected String password;


    public Record() {
    }

    public Record(String firstName) {
        this.firstName = firstName;
    }

    public Record(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
