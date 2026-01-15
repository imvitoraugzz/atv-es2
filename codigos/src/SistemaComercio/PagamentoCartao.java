package SistemaComercio;

import java.math.BigDecimal;

public class PagamentoCartao extends Pagamento {
    private String numeroCartao;

    public PagamentoCartao(BigDecimal valor, String numeroCartao) {
        super(valor);
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean validar() {
        return numeroCartao != null && numeroCartao.length() == 16;
    }

    @Override
    public boolean processar() {
        if (validar()) {
            System.out.println("Processando Cartão final " + numeroCartao.substring(12));
            this.status = "APROVADO";
            return true;
        }
        return false;
    }
}
