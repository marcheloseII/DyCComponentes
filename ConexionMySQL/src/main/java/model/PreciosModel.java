package model;

import java.sql.Date;

public class PreciosModel {
    private int id;
    private String producto;
    private int precio;
    private Date fecha_actualizacion;

    public PreciosModel(int id,String producto, int precio, Date fecha_actualizacion) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFechaActualizacion() {
        return fecha_actualizacion;
    }

    public void setFechaActualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
}
