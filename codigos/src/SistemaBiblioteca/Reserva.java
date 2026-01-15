package SistemaBiblioteca;

import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataExpiracao;
    private String status;
    private Usuario usuario;
    private Livro livro;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataSolicitacao = LocalDateTime.now();
        this.dataExpiracao = dataSolicitacao.plusDays(7);
        this.status = "ATIVA";
    }

    // O coração do sistema: Transforma Reserva em Empréstimo
    public Emprestimo confirmarRetirada() {
        if ("ATIVA".equals(status)) {
            // Busca se tem exemplar físico na estante
            Copia copia = livro.buscarCopiaDisponivel();

            if (copia != null) {
                this.status = "CONFIRMADA";
                return new Emprestimo(usuario, copia);
            }
        }
        return null; // Não há cópias ou reserva expirou
    }

    public String getStatus() { return status; }
}
