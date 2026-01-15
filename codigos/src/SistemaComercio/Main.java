package SistemaComercio;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- INICIANDO TESTE DO SISTEMA ---");

        // 1. Instanciar Produtos
        Produto notebook = new Produto(1L, "Dell G15", new BigDecimal("5000.00"), 10);
        Produto mouse = new Produto(2L, "Mouse Logitech", new BigDecimal("150.00"), 50);

        // 2. Criar Cliente
        Cliente vitor = new Cliente(1L, "Vitor Augusto", "vitorsampi16@gmail.com", "000.000.000-12");

        // 3. Cliente abre um pedido
        System.out.println("Cliente " + vitor.getNome() + " iniciou um pedido.");
        Pedido pedido01 = vitor.realizarPedido();

        // 4. Adicionar itens ao pedido
        pedido01.adicionarItem(notebook, 1);
        pedido01.adicionarItem(mouse, 2); // 2 mouses = 300 reais

        // 5. Verificar total
        System.out.println("Total calculado: R$ " + pedido01.getValorTotal());
        // Deve dar 5300.00

        // 6. Tentar pagar com PIX
        System.out.println("Tentando pagamento via PIX...");
        Pagamento pagamentoPix = new PagamentoPix(pedido01.getValorTotal(), "vitorteste@gmail.com");

        pedido01.realizarPagamento(pagamentoPix);

        // 7. Resultado final
        System.out.println("Status final do pedido: " + pedido01.getStatus());
    }
}
