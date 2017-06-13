package tecsup.edu.myshop_android.models;

/**
 * Created by Claudia on 13/06/2017.
 */

public class Tienda {
    private Integer idtienda;
    private String nombre;
    private String direccion;
    private double latitud;
    private double longitud;
    private String telefono;

    public Integer getIdtienda() {
        return idtienda;
    }
    public void setIdtienda(Integer idtienda) {
        this.idtienda = idtienda;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Double getLatitud() {
        return latitud;
    }
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getlLongitud() {
        return longitud;
    }
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "idtienda=" + idtienda +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", telefono='" + telefono + '\'' +
                ']';
    }
}
