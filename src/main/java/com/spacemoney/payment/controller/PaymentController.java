package com.spacemoney.payment.controller;

import com.spacemoney.payment.model.PagoRequest;
import com.spacemoney.payment.model.Ticket;
import com.spacemoney.payment.orders.Pedido;
import com.spacemoney.payment.orders.pais.PedidoArgentina;
import com.spacemoney.payment.orders.pais.PedidoColombia;
import com.spacemoney.payment.orders.pais.PedidoMexico;
import com.spacemoney.payment.orders.pais.PedidoPeru;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import java.util.ArrayList;
import java.util.List;

import static com.spacemoney.payment.model.Pais.*;

@Controller
public class PaymentController {

    private Pedido pedido;
    private  static List<Ticket> tickets = new ArrayList<Ticket>();

    @Post
    public Ticket pagarViajeEpacio(PagoRequest pago){
        Ticket ticketCompra = null;

        switch (pago.pais){
            case ARGENTINA:
                pedido = new PedidoArgentina();
                pedido.setImporteSinIVA(pago.importe);
                pedido.calculaPrecioConIVA();
                ticketCompra = pedido.obtenerPagoRealizado(pago.nombreCliente, pago.pais);
                break;

            case MEXICO:
                pedido = new PedidoMexico();
                pedido.setImporteSinIVA(pago.importe);
                pedido.calculaPrecioConIVA();
                ticketCompra = pedido.obtenerPagoRealizado(pago.nombreCliente, pago.pais);
                break;

            case COLOMBIA:
                pedido = new PedidoColombia();
                pedido.setImporteSinIVA(pago.importe);
                pedido.calculaPrecioConIVA();
                ticketCompra = pedido.obtenerPagoRealizado(pago.nombreCliente, pago.pais);
                break;

            case PERU:
                pedido = new PedidoPeru();
                pedido.setImporteSinIVA(pago.importe);
                pedido.calculaPrecioConIVA();
                ticketCompra = pedido.obtenerPagoRealizado(pago.nombreCliente, pago.pais);
                break;
            default:
                ticketCompra = new Ticket();

        }
        tickets.add(ticketCompra);
        return ticketCompra;
    }
}
