package org.example;

import java.util.Date;

public class PedidoBuilder {

    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public Pedido build() {
        if (pedido.getId() == 0) {
            throw new IllegalArgumentException("ID do pedido inválido");
        }
        if (pedido.getCliente().equals("")) {
            throw new IllegalArgumentException("Cliente inválido");
        }
        if (pedido.getValorTotal() <= 0) {
            throw new IllegalArgumentException("Valor total inválido");
        }
        return pedido;
    }

    public PedidoBuilder setId(int id) {
        pedido.setId(id);
        return this;
    }

    public PedidoBuilder setCliente(String cliente) {
        pedido.setCliente(cliente);
        return this;
    }

    public PedidoBuilder setDataPedido(Date data) {
        pedido.setDataPedido(data);
        return this;
    }

    public PedidoBuilder setEnderecoEntrega(String endereco) {
        pedido.setEnderecoEntrega(endereco);
        return this;
    }

    public PedidoBuilder setFormaPagamento(String forma) {
        pedido.setFormaPagamento(forma);
        return this;
    }

    public PedidoBuilder setValorTotal(double valor) {
        pedido.setValorTotal(valor);
        return this;
    }

    public PedidoBuilder setValorFrete(double frete) {
        pedido.setValorFrete(frete);
        return this;
    }

    public PedidoBuilder setCupomDesconto(String cupom) {
        pedido.setCupomDesconto(cupom);
        return this;
    }

    public PedidoBuilder setObservacoes(String obs) {
        pedido.setObservacoes(obs);
        return this;
    }
}
