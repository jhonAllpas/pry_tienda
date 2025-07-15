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
public class M_Compra extends M_Transaccion{
    
    private String idProveedor;

    public M_Compra() {
    }

    
    public M_Compra(String idProveedor, int id, Date fecha, String hora, String num_documento, String tipo_documento, double subtotal, double igv, double total, String estado, int idusuario) {
        super(id, fecha, hora, num_documento, tipo_documento, subtotal, igv, total, estado, idusuario);
        this.idProveedor = idProveedor;
    }

    
    

    @Override
    protected void ingresarDetalle(M_Detalle detalle) {
        super.detalle.add(detalle);
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
}
