
package CapaLogica;
import CapaDatos.M_Cliente;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jhon Allpas
 */
public class N_Cliente implements IN_Cliente{
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
        String[] titulos = {"ID", "Nombre", "Apellidos", "DNI", "RUC", "Edad", "Sexo", "Telefono", "Direccion"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[9];
        
        sql=("sp_buscar_cliente'"+ buscar +"'");
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
                modelo.addRow(registro);
            }
            return modelo;
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
       
    public boolean insertar(M_Cliente dts){
        sql=("{call sp_guardar_clientes (?,?,?,?,?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getId());
            pst.setString(2,dts.getNombre());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getRuc());
            pst.setInt(6,dts.getEdad());
            pst.setString(7,dts.getSexo());
            pst.setString(8,dts.getTelefono());
            pst.setString(9,dts.getDireccion());
            
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
    public boolean editar(M_Cliente dts){
        sql=("{call sp_editar_clientes (?,?,?,?,?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getId());
            pst.setString(2,dts.getNombre());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getRuc());
            pst.setInt(6,dts.getEdad());
            pst.setString(7,dts.getSexo());
            pst.setString(8,dts.getTelefono());
            pst.setString(9,dts.getDireccion());
            
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
    public boolean eliminar (M_Cliente dts){
        sql=("{call sp_eliminar_cliente(?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,dts.getId());
            
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
    public int generarIdCliente(){
        String sql=("select max(idcliente) as id from clientes");
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
    public boolean modificar(M_Cliente dts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public M_Cliente buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
