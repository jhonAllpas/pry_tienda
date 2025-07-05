/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CapaLogica;

import CapaDatos.M_Categoria;
import java.util.List;

/**
 *
 * @author benja
 */
public interface IN_Categoria {
    
    boolean insertar(M_Categoria dts);
    boolean modificar(M_Categoria dts);
    boolean eliminar(int id);
    List<M_Categoria> listar();
    M_Categoria buscar(int id);
    
    
}
