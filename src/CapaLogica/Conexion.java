/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jhon Allpas
 */
public class Conexion {
    static Connection conn=null;
    public static Connection conectar(){
        String url ="jdbc:sqlserver://localhost\\DESKTOP-R99KJO6\\SQLEXPRESS:1433;databaseName=db_ventas;encrypt=true;trustServerCertificate=true";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error de sql" + e.getMessage());
        }
        try{
            conn=DriverManager.getConnection(url,"sa","1234");
        }catch (SQLException e) {
            System.out.println("Error de conexion del driver" + e.getMessage());
         }
        return conn;
    }
    
}
