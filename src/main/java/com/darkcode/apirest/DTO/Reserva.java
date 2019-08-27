package com.darkcode.apirest.DTO;

public class Reserva {

    private String fecha;
    private String hora;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Reserva(){}

    public Reserva(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }
}
