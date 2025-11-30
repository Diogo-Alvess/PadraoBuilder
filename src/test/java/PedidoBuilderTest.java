package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class PedidoBuilderTest {

    @Test
    void deveRetornarExcecaoParaPedidoSemId() {
        try {
            PedidoBuilder builder = new PedidoBuilder();
            Pedido pedido = builder
                    .setCliente("João")
                    .setValorTotal(150.0)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("ID do pedido inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPedidoSemCliente() {
        try {
            PedidoBuilder builder = new PedidoBuilder();
            Pedido pedido = builder
                    .setId(1)
                    .setValorTotal(150.0)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Cliente inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaValorTotalInvalido() {
        try {
            PedidoBuilder builder = new PedidoBuilder();
            Pedido pedido = builder
                    .setId(1)
                    .setCliente("Maria")
                    .setValorTotal(0)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor total inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarPedidoValido() {
        PedidoBuilder builder = new PedidoBuilder();
        Pedido pedido = builder
                .setId(1)
                .setCliente("Carlos")
                .setValorTotal(250.0)
                .setDataPedido(new Date())
                .setEnderecoEntrega("Rua A, 123")
                .setFormaPagamento("Cartão")
                .setValorFrete(20.0)
                .setCupomDesconto("PROMO10")
                .setObservacoes("Entregar até 18h")
                .build();

        assertNotNull(pedido);
        assertEquals(1, pedido.getId());
        assertEquals("Carlos", pedido.getCliente());
        assertEquals(250.0, pedido.getValorTotal());
    }
}
