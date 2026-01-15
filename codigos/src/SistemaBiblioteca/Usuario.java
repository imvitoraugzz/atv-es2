package SistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private List<Reserva> reservas;
    private List<Emprestimo> emprestimos;

    public Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.reservas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public Reserva realizarReserva(Livro livro) {
        Reserva reserva = new Reserva(this, livro);
        reservas.add(reserva);
        return reserva;
    }

    public String getNome() { return nome; }
}