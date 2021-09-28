package com.spacemoney.payment.orders;

import com.spacemoney.payment.model.Pais;
import com.spacemoney.payment.model.Ticket;

public abstract class Pedido {
    protected double importeSinIVA;
    protected double importeIVA;
    protected double importeConIVA;

    protected abstract void calculaIVA();

    public void calculaPrecioConIVA(){
        this.calculaIVA();
        importeConIVA = importeSinIVA + importeIVA;
    }
    public void setImporteSinIVA(double importeSinIVA){
        this.importeSinIVA = importeSinIVA;
    }

    public Ticket obtenerPagoRealizado(String nombre, Pais pais){
        Ticket ticket = new Ticket();

        ticket.importeSinIva = importeSinIVA;
        ticket.importeIVA = importeIVA;
        ticket.importeConIva = importeConIVA;
        ticket.nombreCliente = nombre;
        ticket.pais = pais;

        return ticket;
    }
}
