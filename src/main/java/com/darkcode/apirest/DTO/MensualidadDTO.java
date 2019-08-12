package com.darkcode.apirest.DTO;

import java.util.Date;

public class MensualidadDTO {

    private Long id;
    private String titular_id;
    private Long cobrador_id;
    private Long plan_id;
    private Long forma_id;
    private Date fecha_pago;
    private float valor_pagar;
    private int dias_mora;
    private float saldo_pendiente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular_id() {
        return titular_id;
    }

    public void setTitular_id(String titular_id) {
        this.titular_id = titular_id;
    }

    public Long getCobrador_id() {
        return cobrador_id;
    }

    public void setCobrador_id(Long cobrador_id) {
        this.cobrador_id = cobrador_id;
    }

    public Long getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }

    public Long getForma_id() {
        return forma_id;
    }

    public void setForma_id(Long forma_id) {
        this.forma_id = forma_id;
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

    public int getDias_mora() {
        return dias_mora;
    }

    public void setDias_mora(int dias_mora) {
        this.dias_mora = dias_mora;
    }

    public float getSaldo_pendiente() {
        return saldo_pendiente;
    }

    public void setSaldo_pendiente(float saldo_pendiente) {
        this.saldo_pendiente = saldo_pendiente;
    }

    public MensualidadDTO(){}

    public MensualidadDTO(Long id, String titular_id, Long cobrador_id, Long plan_id, Long forma_id, Date fecha_pago, float valor_pagar, int dias_mora, float saldo_pendiente) {
        this.id = id;
        this.titular_id = titular_id;
        this.cobrador_id = cobrador_id;
        this.plan_id = plan_id;
        this.forma_id = forma_id;
        this.fecha_pago = fecha_pago;
        this.valor_pagar = valor_pagar;
        this.dias_mora = dias_mora;
        this.saldo_pendiente = saldo_pendiente;
    }
}
