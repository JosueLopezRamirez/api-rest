package com.darkcode.apirest.DTO;

import java.math.BigInteger;
import java.util.Date;

public class EstadoCuenta {

    private String id;
    private Date fecha_pago;
    private float valor_pagar;
    private float saldo_pendiente;
    private boolean pagado;
    private BigInteger mensualidad_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public BigInteger getMensualidad_id() {
        return mensualidad_id;
    }

    public void setMensualidad_id(BigInteger mensualidad_id) {
        this.mensualidad_id = mensualidad_id;
    }

    public EstadoCuenta(){}

    public EstadoCuenta(String id, Date fecha_pago, float valor_pagar, float saldo_pendiente,boolean pagado,BigInteger mensualidad_id) {
        this.id = id;
        this.fecha_pago = fecha_pago;
        this.valor_pagar = valor_pagar;
        this.saldo_pendiente = saldo_pendiente;
        this.pagado = pagado;
        this.mensualidad_id = mensualidad_id;
    }
}
