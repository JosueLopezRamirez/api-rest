package com.darkcode.apirest.DTO;

import java.util.Date;

public class Pago {
    private Date fecha_inicio;
    private Date fecha_fin;
    private Date fecha_actual;

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public Pago(){}

    public Pago(Date fecha_inicio, Date fecha_fin, Date fecha_actual) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_actual = fecha_actual;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", fecha_actual=" + fecha_actual +
                '}';
    }
}
