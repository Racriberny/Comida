package com.cristobalbernal.comida.modelo;

import java.io.Serializable;

public class Alimentos implements Serializable {
    private String comida;
    private int cantidad;

    public Alimentos(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getComida() {
        return comida;
    }

    @Override
    public String toString() {
        return "Alimentos{" +
                "cantidad=" + cantidad +
                '}';
    }
}
