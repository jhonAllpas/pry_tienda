/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import java.util.Date;

/**
 *
 * @author benja
 */
public class M_Venta extends M_Transaccion {
    
    private String serie;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    private String idCliente;

    public M_Venta(String serie, String cliente, int id, Date fecha, String hora, String num_documento, String tipo_documento, double subtotal, double igv, double total, String estado, int idusuario) {
        super(id, fecha, hora, num_documento, tipo_documento, subtotal, igv, total, estado, idusuario);
        this.serie = serie;
        this.idCliente = cliente;
    }

    
    
    @Override
    protected void ingresarDetalle(M_Detalle detalle) {
        super.detalle.add(detalle);
    }
    
    
}
