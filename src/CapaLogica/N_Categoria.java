
package CapaLogica;

import CapaDatos.M_Categoria;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
public class N_Categoria {
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";
    
public boolean insertar(M_Categoria dts){
sql=("{call RegistrarCategoria(?)}");  
try{
    PreparedStatement pst=cn.prepareStatement(sql);
    pst.setString(1, dts.getNcategoria());
    
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
