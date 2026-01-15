package SistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private Long id;
    private String nome;
    private String endereco;
    private List<Copia> acervo;

    public Biblioteca(Long id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.acervo = new ArrayList<>();
    }

    void adicionarCopia(Copia copia) {
        acervo.add(copia); //so os que tem o pacote copia que acessam
    }

    public List<Copia> consultarAcervo() {
        return new ArrayList<>(acervo);
    }

    public String getNome() { return nome; }
}