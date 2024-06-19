package model;

public class SucursalesModel {

    private int id;
    private String nombre;
    private String locacion;
    private String clienteID; // Clave foránea hacia Clientes
    private String doctorID; // Clave foránea hacia Doctores
    private String recetaID; // Clave foránea hacia Recetas

    public SucursalesModel(String nombre, String locacion, String clientes, String doctores, String recetas) {
        this.nombre = nombre;
        this.locacion = locacion;
        this.clienteID = clientes;
        this.doctorID = doctores;
        this.recetaID = recetas;
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

    public String getClienteID() {
        return clienteID;
    }

    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getRecetaID() {
        return recetaID;
    }

    public void setRecetaID(String recetaID) {
        this.recetaID = recetaID;
    }

}
