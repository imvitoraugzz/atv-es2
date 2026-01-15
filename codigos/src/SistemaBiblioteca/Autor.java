package SistemaBiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Autor {
    private Long id;
    private String nome;
    private String nacionalidade;
    private List<Livro> livros;

    public Autor(Long id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.livros = new ArrayList<>();
    }

    // Package-private
    void adicionarLivro(Livro livro) {
        if (!livros.contains(livro)) {
            livros.add(livro);
        }
    }

    public String getNome() { return nome; }
}
