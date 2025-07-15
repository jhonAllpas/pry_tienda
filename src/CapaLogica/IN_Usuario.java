/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Empleado;
import CapaDatos.M_Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public interface IN_Usuario {
    boolean insertar(M_Usuario dts);
    boolean editar(M_Usuario dts);
    boolean editarNoContrasena(M_Usuario dts);
    boolean eliminar(int id);
    List<M_Usuario> listar();
    DefaultTableModel mostrar(String nombre);
    M_Usuario buscar(String nomrbe); 
    boolean iniciarSesion (String usuario, String contrasena);
    
}
