
package CapaLogica;

import CapaDatos.M_Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Jhon Allpas
 */
public class N_Producto implements IN_Producto{
    
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";
    public DefaultTableModel listar(){
    DefaultTableModel modelo;
    
        String[] titulos = {"ID", "Serie", "Nombre", "Fecha Ingreso", "Fecha de Vencimiento", "Precio Compra", "Precio Venta", "Cantidad", "ID Cat", "Categoria"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[10];
        
        sql=("sp_listar_productos");
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
                modelo.addRow(registro);
            }
            return modelo;
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    public DefaultTableModel buscar(String buscar){
    DefaultTableModel modelo;
    
        String[] titulos = {"ID", "Serie", "Nombre", "Fecha Ingreso", "Fecha de Vencimiento", "Precio Compra", "Precio Venta", "Cantidad", "ID Cat", "Categoria"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[10];
        
        sql=("sp_listar_producto'"+ buscar +"'");
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
                modelo.addRow(registro);
            }
            return modelo;
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    public boolean insertar(M_Producto dts){
        sql=("{call sp_guardar_producto (?,?,?,?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getIdproducto());
            pst.setString(2,dts.getSerie());
            pst.setString(3,dts.getNombre());
            java.sql.Date fechaIngreso = new java.sql.Date(dts.getF_ingreso().getTime());
        java.sql.Date fechaVencimiento = new java.sql.Date(dts.getF_vencimiento().getTime());

        pst.setDate(4, fechaIngreso);
        pst.setDate(5, fechaVencimiento);
            pst.setDouble(6,dts.getP_venta());
            pst.setDouble(7,dts.getP_compra());
            pst.setInt(8,dts.getIdcategoria());
                       
            int n = pst.executeUpdate();
            
            if (n !=0){
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
        
    }
    public boolean editar(M_Producto dts){
        sql=("{call sp_editar_producto (?,?,?,?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getIdproducto());
            pst.setString(2,dts.getSerie());
            pst.setString(3,dts.getNombre   ());
            java.sql.Date fechaIngreso = new java.sql.Date(dts.getF_ingreso().getTime());
            java.sql.Date fechaVencimiento = new java.sql.Date(dts.getF_vencimiento().getTime());
            pst.setDate(4, fechaIngreso);
            pst.setDate(5, fechaVencimiento);
            pst.setDouble(6,dts.getP_venta());
            pst.setDouble(7,dts.getP_compra());
            pst.setInt(8,dts.getIdcategoria());
                       
            int n = pst.executeUpdate();
            
            if (n !=0){
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    }
    
    public boolean eliminar(M_Producto dts){
     sql=("(call sp_eliminar_producto(?))");
     try{
         PreparedStatement pst=cn.prepareStatement(sql);
         pst.setString(1,dts.getIdproducto());
         
         int n= pst.executeUpdate();
         
         if (n !=0){
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
            
        }
    }
    public int generarIdProducto(){
        String sql=("select max(idproducto) as id from producto");
        int cod=0;
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                cod=rs.getInt("id")+1;
            }
        }catch (SQLException el){
           JOptionPane.showMessageDialog(null,"Error sql: "+ el.getMessage());
        }
        return cod;
    }
    public boolean disminuir(int idproducto, int cantidad){
        sql="update producto set cantidad=cantidad-?"+
                "where idproducto=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, cantidad);
            pst.setInt(2, idproducto);
            int n = pst.executeUpdate();
            if (n !=0){
                return true;
            } else {
                return false;
            }
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
     public boolean aumentar(int idproducto, int cantidad){
        sql="update producto set cantidad=cantidad+?"+
                "where idproducto=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, cantidad);
            pst.setInt(2, idproducto);
            int n = pst.executeUpdate();
            if (n !=0){
                return true;
            } else {
                return false;
            }
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }   
    }

    @Override
    public boolean modificar(M_Producto dts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public M_Producto buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
    


