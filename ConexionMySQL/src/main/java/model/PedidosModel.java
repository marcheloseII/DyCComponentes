package model;

import java.sql.Date;

public class PedidosModel {
    private int pedidoID;
    private String descripcion;
    private Date fechaVenta;
    private int cliente;
    private int recetas;
    private int precios;
    private int farmaciaID;
    private String nombreFarmacia;

    public PedidosModel(int pedidoID, String descripcion, Date fechaVenta, int cliente, int recetas, int precios, int farmaciaID, String nombreFarmacia) {
        this.pedidoID = pedidoID;
        this.descripcion = descripcion;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.recetas = recetas;
        this.precios = precios;
        this.farmaciaID = farmaciaID;
        this.nombreFarmacia = nombreFarmacia;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getRecetas() {
        return recetas;
    }

    public void setRecetas(int recetas) {
        this.recetas = recetas;
    }

    public int getPrecios() {
        return precios;
    }

    public void setPrecios(int precios) {
        this.precios = precios;
    }

    public int getFarmaciaID() {
        return farmaciaID;
    }

    public void setFarmaciaID(int farmaciaID) {
        this.farmaciaID = farmaciaID;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }
}
