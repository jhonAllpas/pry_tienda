
package CapaLogica;

import CapaDatos.M_Categoria;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
public class N_Categoria implements IN_Categoria {
    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();
    String sql="";
    
public boolean insertar(M_Categoria dts) {
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

    @Override
    public List<M_Categoria> listar() {
        List<M_Categoria> lista = new ArrayList<>();
        return lista;
    }

    @Override
    public M_Categoria buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public boolean modificar(M_Categoria dts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
