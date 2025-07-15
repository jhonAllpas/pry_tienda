/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Compra;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public interface IN_Compra {
    boolean insertar(M_Compra dts);
    boolean modificar(M_Compra dts);
    boolean eliminar(int id);
    DefaultTableModel buscar(String buscar);
    M_Compra buscar(int id);
    boolean modificarEstado(int idCompra, String estado);
}
