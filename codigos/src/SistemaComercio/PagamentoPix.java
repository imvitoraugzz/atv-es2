package SistemaComercio;

import java.math.BigDecimal;

public class PagamentoPix extends Pagamento {
    private String chavePix;

    public PagamentoPix(BigDecimal valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    public boolean validar() {
        return chavePix != null && !chavePix.isEmpty();
    }

    @Override
    public boolean processar() {
        if (validar()) {
            System.out.println("Processando PIX para chave: " + chavePix);
            this.status = "APROVADO";
            return true;
        }
        return false;
    }
}
