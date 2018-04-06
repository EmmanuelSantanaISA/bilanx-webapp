/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.freshmarket.webapp.cedis.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author emmanuelsantana
 */
public class MessageUtil {

    public static void showMessage(String title, String message, FacesMessage.Severity severity) {
        System.out.println("Showing message: " + message);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, title, message));
    }
}
