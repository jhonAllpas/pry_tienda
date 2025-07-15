
package CapaDatos;

/**
 *
 * @author Jhon Allpas
 */
public class M_Cliente extends M_Persona {
    private String ruc;
    private String sexo;
    private int edad;

    public M_Cliente() {
    }

    public M_Cliente(String ruc, String sexo, int edad) {
        this.ruc = ruc;
        this.sexo = sexo;
        this.edad = edad;
    }

    public M_Cliente(String ruc, String sexo, int edad, String id, String nombre, String apellidos, String dni, String telefono, String direccion, String correo) {
        super(id, nombre, apellidos, dni, telefono, direccion, correo);
        this.ruc = ruc;
        this.sexo = sexo;
        this.edad = edad;
    }

    

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
        
}
