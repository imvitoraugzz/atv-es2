package SistemaBiblioteca;

public class Copia {
    private String codigo;
    private String status;
    private Livro livro;
    private Biblioteca biblioteca;

    Copia(String codigo, Livro livro, Biblioteca biblioteca) {
        this.codigo = codigo;
        this.livro = livro;
        this.biblioteca = biblioteca;
        this.status = "DISPONIVEL";
        biblioteca.adicionarCopia(this);
    }

    public void marcarComoEmprestada() {
        this.status = "EMPRESTADA";
    }

    public void marcarComoDisponivel() {
        this.status = "DISPONIVEL";
    }

    public boolean verificarDisponibilidade() {
        return "DISPONIVEL".equals(status);
    }

    public String getCodigo() { return codigo; }
    public String getStatus() { return status; }
}