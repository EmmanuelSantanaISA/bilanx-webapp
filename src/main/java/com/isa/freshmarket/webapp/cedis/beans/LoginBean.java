/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.freshmarket.webapp.cedis.beans;

import com.isa.freshmarket.webapp.cedis.ApplicationProperties;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.paradise.view.GuestPreferences;

/**
 *
 * @author imjesr
 */
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

    @ManagedProperty(value = "#{guestPreferences}")
    private GuestPreferences guestPreferences;
    @ManagedProperty(value = "#{applicationProperties}")
    private ApplicationProperties applicationProperties;

    private String username;
    private String password;

    @PostConstruct
    public void init() {
        guestPreferences.setOverlayMenu(false);
        guestPreferences.setSlimMenu(false);
//        TimeZone.setDefault(TimeZone.getTimeZone(sessionService.getTimezone()));
    }

    public String validateUsernamePassword() {

        return "factura";
    }

// Setters & Getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setApplicationProperties(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public void setGuestPreferences(GuestPreferences guestPreferences) {
        this.guestPreferences = guestPreferences;
    }
}
