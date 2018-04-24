/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.freshmarket.webapp.cedis;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author EmmanuelSantana
 */
@ManagedBean
@SessionScoped
public class ApplicationProperties implements Serializable {

    private String applicationName = "Bilanx";
    private String applicationVersion = "1.0";
    private String supportEmail = "contacto@isasistemas.com";

    private String infoDefaultTitle = "Muy bien";
    private String warnDefaultTitle = "Atencion";
    private String errorDefaultTitle = "Lo sentimos";
    private String fatalDefaultTitle = "De verdad lo sentimos";

    //Permissions
    private String notAllowedDefaultMessage = "*(No tienes permisos suficientes para ver esto, contacta a tu administrador.)";

    // Getters & Setters
    public void setNotAllowedDefaultMessage(String notAllowedDefaultMessage) {
        this.notAllowedDefaultMessage = notAllowedDefaultMessage;
    }

    public String getNotAllowedDefaultMessage() {
        return notAllowedDefaultMessage;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(String supportEmail) {
        this.supportEmail = supportEmail;
    }

    public String getInfoDefaultTitle() {
        return infoDefaultTitle;
    }

    public void setInfoDefaultTitle(String infoDefaultTitle) {
        this.infoDefaultTitle = infoDefaultTitle;
    }

    public String getWarnDefaultTitle() {
        return warnDefaultTitle;
    }

    public void setWarnDefaultTitle(String warnDefaultTitle) {
        this.warnDefaultTitle = warnDefaultTitle;
    }

    public String getErrorDefaultTitle() {
        return errorDefaultTitle;
    }

    public void setErrorDefaultTitle(String errorDefaultTitle) {
        this.errorDefaultTitle = errorDefaultTitle;
    }

    public String getFatalDefaultTitle() {
        return fatalDefaultTitle;
    }

    public void setFatalDefaultTitle(String fatalDefaultTitle) {
        this.fatalDefaultTitle = fatalDefaultTitle;
    }

}
