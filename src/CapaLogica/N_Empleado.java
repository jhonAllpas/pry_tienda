
package CapaLogica;

import CapaDatos.M_Empleado;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class N_Empleado implements IN_Empleado{
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
        String[] titulos = {"Codigo", "Nombre", "Apellidos", "DNI", "Telefono", "Direccion"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[6];
        
        sql=("sp_buscar_empleado'"+ buscar +"'");
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
                modelo.addRow(registro);
            }
            return modelo;
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    public boolean insertar(M_Empleado dts){
        sql=("{call sp_guardar_empleados (?,?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getId());
            pst.setString(2,dts.getNombre());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getDireccion());
            
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
    public boolean editar(M_Empleado dts){
        sql=("{call sp_editar_empleados (?,?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getId());
            pst.setString(2,dts.getNombre());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getDireccion());
            
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
    public boolean eliminar(M_Empleado dts){
        sql=("{call sp_eliminar_empleado (?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getId());
                        
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
    public int generarIdEmpleado(){
        String sql=("select max(idempleado) as id from empleados");
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
    public boolean modificar(M_Empleado dts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public M_Empleado buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
