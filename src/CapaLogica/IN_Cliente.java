/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Cliente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public interface IN_Cliente {
    
    boolean insertar(M_Cliente dts);
    boolean modificar(M_Cliente dts);
    boolean eliminar(int id);
    DefaultTableModel listar();
    M_Cliente buscar(int id);    
}
