/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Proveedor;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public interface IN_Proveedor {
    boolean insertar(M_Proveedor dts);
    boolean modificar(M_Proveedor dts);
    boolean eliminar(int id);
    DefaultTableModel listar();
    M_Proveedor buscar(int id); 
    
}
