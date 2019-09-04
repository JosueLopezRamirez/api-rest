package com.darkcode.apirest.DTO;

public class EfectuarPago {

    private boolean pagado;
    private Long id;

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EfectuarPago(){}

    public EfectuarPago(boolean pagado, Long id) {
        this.pagado = pagado;
        this.id = id;
    }

    @Override
    public String toString() {
        return "EfectuarPago{" +
                "pagado=" + pagado +
                ", id=" + id +
                '}';
    }
}
