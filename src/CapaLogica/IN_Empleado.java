/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Empleado;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public interface IN_Empleado {
    boolean insertar(M_Empleado dts);
    boolean modificar(M_Empleado dts);
    boolean eliminar(int id);
    DefaultTableModel listar();
    M_Empleado buscar(int id); 
}
