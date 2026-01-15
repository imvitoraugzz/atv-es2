package SistemaComercio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private LocalDateTime dataPedido;
    private String status;
    private BigDecimal valorTotal;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Pagamento pagamento;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.dataPedido = LocalDateTime.now();
        this.status = "PENDENTE";
        this.itens = new ArrayList<>();
        this.valorTotal = BigDecimal.ZERO;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
        calcularTotal();
    }

    public BigDecimal calcularTotal() {
        valorTotal = itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return valorTotal;
    }

    public void realizarPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
        if (pagamento.processar()) {
            this.status = "PAGO";
        } else {
            this.status = "FALHA_PAGAMENTO";
        }
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }
}
