/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Producto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public interface IN_Producto {
    boolean insertar(M_Producto dts);
    boolean modificar(M_Producto dts);
    boolean eliminar(int id);
    DefaultTableModel listar();
    M_Producto buscar(int id); 
    
}
