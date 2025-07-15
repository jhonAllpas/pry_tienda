/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Venta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public interface IN_Venta {
    
    boolean insertar(M_Venta dts);
    boolean modificar(M_Venta dts);
    boolean eliminar(int id);
    DefaultTableModel buscar(String buscar);
    M_Venta buscar(int id);
    boolean modificarEstado(int idVenta, String estado);
    
}
