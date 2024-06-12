package model;

import java.sql.Date;

public class RecetasMedicasModel {
    private int id;
    private String paciente;
    private String medicamento;
    private String dosis;
    private Date fechaPrescripcion;

    public RecetasMedicasModel(int id, String paciente, String medicamento, String dosis, Date fechaPrescripcion) {
        this.id = id;
        this.paciente = paciente;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.fechaPrescripcion = fechaPrescripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Date getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    public void setFechaPrescripcion(Date fechaPrescripcion) {
        this.fechaPrescripcion = fechaPrescripcion;
    }
}
