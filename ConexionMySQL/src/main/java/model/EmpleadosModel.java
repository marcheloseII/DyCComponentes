package model;

public class EmpleadosModel {
    private int id;
    private String nombre;
    private String rol;
    private String email;
    private char sexo;
    private int doctorID; // Clave foránea hacia Doctores

    public EmpleadosModel() {
    }

    public EmpleadosModel(int id, String nombre, String rol, String email, char sexo, int doctorID) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.email = email;
        this.sexo = sexo;
        this.doctorID = doctorID;
    }

    // Getters y setters
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
}
