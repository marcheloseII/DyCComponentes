package model;

public class SucursalesModel {

    private int id;
    private String nombre;
    private String locacion;
    private String doctores;
    private String clientes;
    private String recetas;

    public SucursalesModel(String nombre, String locacion, String doctores, String clientes, String recetas) {
        this.nombre = nombre;
        this.locacion = locacion;
        this.doctores = doctores;
        this.clientes = clientes;
        this.recetas = recetas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public String getDoctores() {
        return doctores;
    }

    public void setDoctores(String doctores) {
        this.doctores = doctores;
    }

    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getRecetas() {
        return recetas;
    }

    public void setRecetas(String recetas) {
        this.recetas = recetas;
    }

}
