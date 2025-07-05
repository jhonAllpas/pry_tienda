
package CapaLogica;
import CapaDatos.M_Proveedor;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Jhon Allpas
 */
public class N_Proveedor implements IN_Proveedor{
    private Conexion SQL=new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
    String[] titulos={"ID","Razon Social","Ruc","Telefono","Direccion"};
    modelo=new DefaultTableModel(null,titulos);
    String[] registro = new String[5];
    
    sql=("sp_buscar_proveedor'"+buscar+"'");
    try{
        Statement st=cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            registro[0] = rs.getString(1);
            registro[1] = rs.getString(2);
            registro[2] = rs.getString(3);
            registro[3] = rs.getString(4);
            registro[4] = rs.getString(5);
            modelo.addRow(registro);
            }
        return modelo;
    } catch (Exception e){
       JOptionPane.showConfirmDialog(null, e);
       return null; 
    }
    }
    public boolean insertar(M_Proveedor dts){
        sql=("{call sp_guardar_proveedor (?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getIdproveedor());
            pst.setString(2,dts.getRazonsocial());
            pst.setString(3,dts.getRuc());
            pst.setString(4,dts.getTelefono());
            pst.setString(5,dts.getDireccion());
            
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
     public boolean editar(M_Proveedor dts){
        sql=("{call sp_editar_proveedor (?,?,?,?,?)}");
        try{
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dts.getIdproveedor());
            pst.setString(2,dts.getRazonsocial());
            pst.setString(3,dts.getRuc());
            pst.setString(4,dts.getTelefono());
            pst.setString(5,dts.getDireccion());
            
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
     public boolean eliminar (M_Proveedor dts){
        sql=("{call sp_eliminar_proveedor(?)}");
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,dts.getIdproveedor());
            
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
     public int generarIdProveedor(){
        String sql=("select max(idproveedor) as id from proveedor");
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
    public boolean modificar(M_Proveedor dts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public M_Proveedor buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
}
    

