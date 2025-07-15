/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Venta;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 *
 * @author benja
 */
public class N_Venta implements IN_Venta {

    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql = "";

    @Override
    public boolean insertar(M_Venta dts) {
        try {
            sql = ("{call sp_guardar_venta (?,?,?,?,?,?,?,?,?,?,?)}");
            PreparedStatement pst = cn.prepareStatement(sql);

            java.sql.Date fecha = new java.sql.Date(dts.getFecha().getTime());
            String hora = String.format("%02d:%02d:%02d", dts.getFecha().getHours(), dts.getFecha().getMinutes(), dts.getFecha().getSeconds());

            pst.setDate(1, fecha);
            pst.setString(2, hora);
            pst.setString(3, dts.getSerie());
            pst.setString(4, dts.getNum_documento());
            pst.setString(5, dts.getTipo_documento());
            pst.setDouble(6, dts.getSubtotal());
            pst.setDouble(7, dts.getIgv());
            pst.setDouble(8, dts.getTotal());
            pst.setString(9, dts.getEstado());
            pst.setInt(10, dts.getIdusuario());
            pst.setString(11, dts.getIdCliente());

            int n = pst.executeUpdate();

            if (n == 0) {
                return false;
            }

            sql = ("select max(idventa) from ventas");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                dts.setId(rs.getInt(1));
            }
            dts.getDetalle().forEach(detalle -> {
                try {
                    String busqueda = ("{call sp_guardar_detalle_venta (?,?,?)}");
                    PreparedStatement ps = cn.prepareStatement(busqueda);
                    ps.setInt(1, dts.getId());
                    ps.setString(2, detalle.getIdproducto());
                    ps.setInt(3, detalle.getCantidad());
                    ps.executeUpdate();
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(null, e);

                }

            });
            return true;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }
    }

    public String generarNumero(String tipo) {

        String sql = ("{call sp_buscar_venta_ultimo_documento (" + tipo + ")}");

        DecimalFormat formato = new DecimalFormat("0000");
        String res[] = new String[2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                res = rs.getString(1).split("-");
            } else {
                return tipo.equalsIgnoreCase("B") ? "B001-0001" : "F001-0001";
            }

        } catch (SQLException el) {
            JOptionPane.showMessageDialog(null, "Error sql: " + el.getMessage());
        }
        return res[0] + "-" + formato.format(Integer.parseInt(res[1]) + 1);
    }

    @Override
    public boolean modificar(M_Venta dts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel buscar(String buscar) {
        
    DefaultTableModel modelo;
    
        String[] titulos = {"ID", "FECHA", "HORA", "SERIE", "NUM DOC", "TIPO DOC", "SUBTOTAL", "IGV", "TOTAL", "ESTADO","USUARIO","CLIENTE"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[12];
        
        sql=("sp_buscar_ventas'"+ buscar +"'");
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                registro[0]=rs.getString(1);
                registro[1]=rs.getString(2);
                registro[2]=rs.getString(3);
                registro[3]=rs.getString(4);
                registro[4]=rs.getString(5);
                registro[5]=rs.getString(6);
                registro[6]=rs.getString(7);
                registro[7]=rs.getString(8);
                registro[8]=rs.getString(9);
                registro[9]=rs.getString(10);
                registro[10]=rs.getString(11);
                registro[11]=rs.getString(12);
                modelo.addRow(registro);
            }
            return modelo;
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    @Override
    public M_Venta buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificarEstado(int idVenta, String estado) {
        try {
            sql = ("{call sp_actualizar_estado_venta (?,?)}");
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setInt(1, idVenta);
            pst.setString(2, estado);

            int n = pst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;

        }
    }

}
