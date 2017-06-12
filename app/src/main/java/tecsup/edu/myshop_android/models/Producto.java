package tecsup.edu.myshop_android.models;

public class Producto {
    private Integer id;
    private String nombre;
    private String precio;
    private String marca;
    private String dirreccion;
    private String imagen;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDirreccion() {
        return dirreccion;
    }
    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", marca='" + marca + '\'' +
                ", dirreccion='" + dirreccion + '\'' +
                ", imagen='" + imagen + '\'' +
                ']';
    }
}
