package com.spacemoney.payment.orders.pais;

import com.spacemoney.payment.orders.Pedido;

public class PedidoArgentina extends Pedido {
    @Override
    protected void calculaIVA() {
        importeIVA = importeSinIVA * 0.21;
    }
}
