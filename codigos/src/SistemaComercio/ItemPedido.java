package SistemaComercio;

import java.math.BigDecimal;

public class ItemPedido {
    private Long id;
    private int quantidade;
    private BigDecimal precoUnitario;
    private Produto produto;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    public BigDecimal calcularSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}