/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isa.freshmarket.webapp.cedis.beans;

import com.isa.facturacion.api.client.Facturas;
import com.isa.facturacion.api.model.ComprobanteDTO;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author emmanuelsantana
 */
@ManagedBean
@ViewScoped
public class VisualizarFacturaBean implements Serializable {

    String invoiceID = "";

    @PostConstruct
    public void init() {
        // TODO cargar factura
        loadSelectedInvoice();
    }

    private void loadSelectedInvoice() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();

        invoiceID = request.getParameter("factura");
        if (invoiceID == null) {
            showMessage("Atencion", "La factura que buscas, no existe", FacesMessage.SEVERITY_WARN);
        }
    }

    public void downloadPDF() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        // Now you can write the InputStream of the file to the above OutputStream the usual way.
        byte[] bytesPDF = new Facturas().getPDF(invoiceID);
        if (bytesPDF == null) {
            showMessage("Atencion", "La factura que buscas, no existe", FacesMessage.SEVERITY_WARN);
        } else {
            ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
            ec.setResponseContentType("application/pdf"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
            ec.setResponseContentLength(bytesPDF.length); // Set it with the file size. This header is optional. It will work if it's omitted, but the downloadPDF progress will be unknown.
            ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + invoiceID + ".pdf\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.

            OutputStream output = ec.getResponseOutputStream();
            output.write(bytesPDF);
            output.close();
            fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
        }

    }

    public void downloadXML() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        // Now you can write the InputStream of the file to the above OutputStream the usual way.
        byte[] bytesXML = new Facturas().getXML(invoiceID);
        if (bytesXML == null) {
            showMessage("Atencion", "La factura que buscas, no existe", FacesMessage.SEVERITY_WARN);
        } else {
            ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
            ec.setResponseContentType("application/xml"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
            ec.setResponseContentLength(bytesXML.length); // Set it with the file size. This header is optional. It will work if it's omitted, but the downloadPDF progress will be unknown.
            ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + invoiceID + ".xml\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.

            OutputStream output = ec.getResponseOutputStream();
            output.write(bytesXML);
            output.close();
            fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
        }

    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    private void showMessage(String title, String message, FacesMessage.Severity severity) {
        System.out.println("Showing message: " + message);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, title, message));
    }

}
