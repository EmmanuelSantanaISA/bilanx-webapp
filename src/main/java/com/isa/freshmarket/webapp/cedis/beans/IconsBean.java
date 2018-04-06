/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.freshmarket.webapp.cedis.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author emmanuelsantana
 */
@ManagedBean
@ViewScoped
public class IconsBean implements Serializable {

    private IconStyle iconStyle = IconStyle.fal;

    private final String FAXS = "fa-xs";
    private final String FASM = "fa-sm";
    private final String FALG = "fa-lg";
    private final String FA2X = "fa-2x";
    private final String FA3X = "fa-3x";
    private final String FA5X = "fa-5x";
    private final String FA7X = "fa-7x";
    private final String FA10X = "fa-10x";

    public enum IconStyle {
        fal, far, fas
    }

    public IconStyle getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(IconStyle iconStyle) {
        this.iconStyle = iconStyle;
    }

    public String getFAXS() {
        return FAXS;
    }

    public String getFASM() {
        return FASM;
    }

    public String getFALG() {
        return FALG;
    }

    public String getFA2X() {
        return FA2X;
    }

    public String getFA3X() {
        return FA3X;
    }

    public String getFA5X() {
        return FA5X;
    }

    public String getFA7X() {
        return FA7X;
    }

    public String getFA10X() {
        return FA10X;
    }

}
