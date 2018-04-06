/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.freshmarket.webapp.cedis.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author imjesr
 */
@ManagedBean
@ViewScoped
public class MenuBean implements Serializable {

    private boolean ordersVisible = false;
    private boolean storesVisible = false;
    private boolean driversVisible = false;
    private boolean providersVisible = false;
    private boolean zonesVisible = false;
    private boolean productsVisible = false;

    @PostConstruct
    public void init() {

        Subject currentUser = SecurityUtils.getSubject();
        ordersVisible = currentUser.isPermitted("menu:orders");
        storesVisible = currentUser.isPermitted("menu:customers");
        driversVisible = currentUser.isPermitted("menu:drivers");
        providersVisible = currentUser.isPermitted("menu:providers");
        zonesVisible = currentUser.isPermitted("menu:zones");
        productsVisible = currentUser.isPermitted("menu:products");
    }

    public boolean isOrdersVisible() {
        return ordersVisible;
    }

    public boolean isStoresVisible() {
        return storesVisible;
    }

    public boolean isDriversVisible() {
        return driversVisible;
    }

    public boolean isProvidersVisible() {
        return providersVisible;
    }

    public boolean isZonesVisible() {
        return zonesVisible;
    }

    public boolean isProductsVisible() {
        return productsVisible;
    }

}
