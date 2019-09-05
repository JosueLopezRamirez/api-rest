package com.darkcode.apirest.DTO;

import java.math.BigInteger;

public class EstadoCliente {

    private boolean estado;
    private BigInteger id;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public EstadoCliente(boolean estado, BigInteger id) {
        this.estado = estado;
        this.id = id;
    }

    public EstadoCliente() {
    }

    @Override
    public String toString() {
        return "EstadoCliente{" +
                "estado=" + estado +
                ", id=" + id +
                '}';
    }
}
