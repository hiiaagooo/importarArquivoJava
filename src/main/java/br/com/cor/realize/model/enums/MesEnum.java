package br.com.correios.realize.model.enums;

public enum MesEnum {
    JAN,
    FEV,
    MAR,
    ABR,
    MAI,
    JUN,
    JUL,
    AGO,
    SET,
    OUT,
    NOV,
    DEZ;

    public Long valorMes() {
        return new Long(this.ordinal()+1);
    }

    public int valorMesInt() {
        return valorMes().intValue();
    }
}
