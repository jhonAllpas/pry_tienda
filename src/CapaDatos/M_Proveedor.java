
package CapaDatos;

/**
 *
 * @author Jhon Allpas
 */
public class M_Proveedor {
    private String idproveedor;
    private String razonsocial;
    private String ruc;
    private String telefono;
    private String direccion;

    public M_Proveedor() {
    }

    public M_Proveedor(String idproveedor, String razonsocial, String ruc, String telefono, String direccion) {
        this.idproveedor = idproveedor;
        this.razonsocial = razonsocial;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
           
}
