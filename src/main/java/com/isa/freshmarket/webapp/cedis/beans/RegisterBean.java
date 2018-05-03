/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template cerFile, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.freshmarket.webapp.cedis.beans;

import com.isa.facturacion.api.client.Facturas;
import com.isa.facturacion.api.model.RegisterDTO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ServiceUnavailableException;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author imjesr
 */
@ManagedBean
@ViewScoped
public class RegisterBean implements Serializable {

    private String rfc;
    private String razonSocial;
    private String passAccount;
    private String passCsd;
    private String email;
    private String phone;
    private UploadedFile cerFile;
    private UploadedFile keyFile;
    private Boolean acceptedTerms = false;
    RegisterDTO newRegister = new RegisterDTO();

    @PostConstruct
    public void init() {

    }

    public void onRegisterUserEvent() {
        if (cerFile.getSize() == 0 || keyFile.getSize() == 0) {
            MessageUtil.showMessage("Atencion", "Los archivos del certificado son obligatorios.", FacesMessage.SEVERITY_ERROR);
            return;
        }
        newRegister.setCer(cerFile.getContents());
        newRegister.setKey(keyFile.getContents());

        try {
            new Facturas().registrarUsuario(newRegister);
            RequestContext.getCurrentInstance().execute("PF('success-dlg-var').show()");
            newRegister = new RegisterDTO();
        } catch (InternalServerErrorException | ServiceUnavailableException e) {
            MessageUtil.showMessage("Error", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }

    public RegisterDTO getNewRegister() {
        return newRegister;
    }

    public void setNewRegister(RegisterDTO newRegister) {
        this.newRegister = newRegister;
    }

    public Boolean getAcceptedTerms() {
        return acceptedTerms;
    }

    public void setAcceptedTerms(Boolean acceptedTerms) {
        this.acceptedTerms = acceptedTerms;
    }

    public UploadedFile getCerFile() {
        return cerFile;
    }

    public void setCerFile(UploadedFile cerFile) {
        this.cerFile = cerFile;
    }

    public UploadedFile getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(UploadedFile keyFile) {
        this.keyFile = keyFile;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getPassAccount() {
        return passAccount;
    }

    public void setPassAccount(String passAccount) {
        this.passAccount = passAccount;
    }

    public String getPassCsd() {
        return passCsd;
    }

    public void setPassCsd(String passCsd) {
        this.passCsd = passCsd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
