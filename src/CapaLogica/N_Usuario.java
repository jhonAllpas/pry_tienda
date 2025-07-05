/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public class N_Usuario implements IN_Usuario {
    private Conexion SQL=new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) {
        sql=("{call sp_iniciar_sesion (?)}");
        
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,usuario);
            
            ResultSet res = pst.executeQuery();
            
            
            
            if(res.next()) if(res.getString(1).equals(contrasena))  return true;
            return false;
            
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }

    @Override
    public boolean insertar(M_Usuario dts) {
      
        sql=("{call sp_guardar_usuario (?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getIdEmpleado());
            pst.setString(2,dts.getUsuario());
            pst.setString(3,dts.getPass());
            pst.setString(4,dts.getAcceso());
            pst.setString(5,dts.getEstado());
            
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

    @Override
    public boolean editar(M_Usuario dts) {
        sql=("{call sp_editar_usuario (?,?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            
            pst.setString(1,dts.getIdEmpleado());
            pst.setString(2,dts.getUsuario());
            pst.setString(3,dts.getPass());
            pst.setString(4,dts.getAcceso());
            pst.setString(5,dts.getEstado());
            pst.setInt(6,dts.getId());
            
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

    @Override
    public boolean eliminar(int id) {
        sql=("{call sp_eliminar_usuario(?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1,id);
            
            int n = pst.executeUpdate();
            if(n!=0){
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
    public DefaultTableModel mostrar(String buscar) {
        
    DefaultTableModel modelo;
    
        String[] titulos = {"ID", "ID Empleado", "Usuario", "Contrasena", "Acceso", "Estado"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[6];
        
        sql=("sp_listar_usuarios '"+buscar+"'");
        try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                registro[0]=""+rs.getInt(1);
                registro[1]=rs.getString(2);
                registro[2]=rs.getString(3);
                registro[3]=rs.getString(4);
                registro[4]=rs.getString(5);
                registro[5]=rs.getString(6);
                modelo.addRow(registro);
            }
            return modelo;
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public int generarIdUsuario(){
        String sql=("select max(idusuario) as id from usuarios");
        int cod=0;
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                cod=rs.getInt("id")+1;
            }
        }catch (SQLException el){
           JOptionPane.showConfirmDialog(null, el);
        }
        return cod;
        
    }
    @Override
    public M_Usuario buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<M_Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editarNoContrasena(M_Usuario dts) {
        sql=("{call sp_editar_usuario (?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            
            pst.setString(1,dts.getIdEmpleado());
            pst.setString(2,dts.getUsuario());
            pst.setString(3,dts.getAcceso());
            pst.setString(4,dts.getEstado());
            pst.setInt(5,dts.getId());
            
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
    
    
    
}
