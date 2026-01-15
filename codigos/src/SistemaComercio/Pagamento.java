package SistemaComercio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Pagamento {
    protected Long id;
    protected BigDecimal valor;
    protected LocalDateTime dataPagamento;
    protected String status;

    public Pagamento(BigDecimal valor) {
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public abstract boolean processar();
    public abstract boolean validar();
}