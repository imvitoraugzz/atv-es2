package SistemaBiblioteca;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private LocalDate dataRetirada;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private BigDecimal multa;
    private Usuario usuario;
    private Copia copia;

    public Emprestimo(Usuario usuario, Copia copia) {
        this.usuario = usuario;
        this.copia = copia;
        this.dataRetirada = LocalDate.now();
        this.dataPrevistaDevolucao = dataRetirada.plusDays(14);
        this.multa = BigDecimal.ZERO;

        copia.marcarComoEmprestada(); //atualiza o status
    }

    public BigDecimal calcularMulta() {
        if (dataDevolucao == null) {
            // Simula devolução hoje para cálculo
            dataDevolucao = LocalDate.now();
        }

        if (dataDevolucao.isAfter(dataPrevistaDevolucao)) {
            long diasAtraso = ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
            multa = BigDecimal.valueOf(diasAtraso * 2.0);
        }
        return multa;
    }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDate.now();
        calcularMulta();
        copia.marcarComoDisponivel();
    }

    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public Copia getCopia() { return copia; }
}
