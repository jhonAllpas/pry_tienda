/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public class N_Compra implements IN_Compra {

    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql = "";

    @Override
    public boolean insertar(M_Compra dts) {
        
        try {
            sql = ("{call sp_guardar_compra (?,?,?,?,?,?,?,?,?,?)}");
            PreparedStatement pst = cn.prepareStatement(sql);

            java.sql.Date fecha = new java.sql.Date(dts.getFecha().getTime());
            String hora = String.format("%02d:%02d:%02d", dts.getFecha().getHours(), dts.getFecha().getMinutes(), dts.getFecha().getSeconds());

            pst.setDate(1, fecha);
            pst.setString(2, hora);
            pst.setString(3, dts.getNum_documento());
            pst.setString(4, dts.getTipo_documento());
            pst.setDouble(5, dts.getSubtotal());
            pst.setDouble(6, dts.getIgv());
            pst.setDouble(7, dts.getTotal());
            pst.setString(8, dts.getEstado());
            pst.setInt(9, dts.getIdusuario());
            pst.setString(10, dts.getIdProveedor());

            int n = pst.executeUpdate();

            if (n == 0) {
                return false;
            }

            sql = ("select max(idcompra) from compras");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                dts.setId(rs.getInt(1));
            }
            dts.getDetalle().forEach(detalle -> {
                try {
                    String busqueda = ("{call sp_guardar_detalle_compra (?,?,?)}");
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

    @Override
    public boolean modificar(M_Compra dts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel buscar(String buscar) {
    DefaultTableModel modelo;
    
        String[] titulos = {"ID", "FECHA", "HORA", "NUM DOC", "TIPO DOC", "SUBTOTAL", "IGV", "TOTAL", "ESTADO","USUARIO","CLIENTE"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[12];
        
        sql=("sp_buscar_compras'"+ buscar +"'");
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
                modelo.addRow(registro);
            }
            return modelo;
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    @Override
    public M_Compra buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificarEstado(int idCompra, String estado) {
        
        try {
            sql = ("{call sp_actualizar_estado_compra (?,?)}");
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setInt(1, idCompra);
            pst.setString(2, estado);

            int n = pst.executeUpdate();

            return n != 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;

        }
    }
    
}
