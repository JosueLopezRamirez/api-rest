package com.darkcode.apirest.DTO;

import java.math.BigInteger;
import java.util.Date;

public class PagosPendientes {

    private String id;
    private String nombre;
    private Date fecha_pago;
    private float valor_pagar;
    private float saldo_pendiente;
    private BigInteger mensualidad_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public float getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(float valor_pagar) {
        this.valor_pagar = valor_pagar;
    }

    public float getSaldo_pendiente() {
        return saldo_pendiente;
    }

    public void setSaldo_pendiente(float saldo_pendiente) {
        this.saldo_pendiente = saldo_pendiente;
    }

    public BigInteger getMensualidad_id() {
        return mensualidad_id;
    }

    public void setMensualidad_id(BigInteger mensualidad_id) {
        this.mensualidad_id = mensualidad_id;
    }

    public PagosPendientes(){}

    public PagosPendientes(String id, String nombre, Date fecha_pago, float valor_pagar, float saldo_pendiente,BigInteger mensualidad_id) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_pago = fecha_pago;
        this.valor_pagar = valor_pagar;
        this.saldo_pendiente = saldo_pendiente;
        this.mensualidad_id = mensualidad_id;
    }

    @Override
    public String toString() {
        return "PagosPendientes{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecha_pago=" + fecha_pago +
                ", valor_pagar=" + valor_pagar +
                ", saldo_pendiente=" + saldo_pendiente +
                ", mensualidad_id=" + mensualidad_id +
                '}';
    }
}
