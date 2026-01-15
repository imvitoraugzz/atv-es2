package SistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Editora {
    private Long id;
    private String nome;
    private String cnpj;
    private List<Livro> publicacoes;

    public Editora(Long id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.publicacoes = new ArrayList<>();
    }

    public void publicarLivro(Livro livro) {
        publicacoes.add(livro);
    }

    public String getNome() { return nome; }
}
