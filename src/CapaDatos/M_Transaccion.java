/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author benja
 */
public abstract class M_Transaccion {
protected int id;
protected Date fecha;
protected String hora;
protected String num_documento;
protected String tipo_documento;
protected double subtotal;
protected double igv;
protected double total;
protected String estado;
protected int idusuario; 

protected List<M_Detalle> detalle = new ArrayList<M_Detalle>();

    
    public M_Transaccion() {
    }

    public M_Transaccion(int id, Date fecha, String hora, String num_documento, String tipo_documento, double subtotal, double igv, double total, String estado, int idusuario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.num_documento = num_documento;
        this.tipo_documento = tipo_documento;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.estado = estado;
        this.idusuario = idusuario;
    }
    
    protected abstract void ingresarDetalle(M_Detalle detalle );
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public List<M_Detalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<M_Detalle> detalle) {
        this.detalle = detalle;
    }
    
    
    
}
