package SistemaBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private Long id;
    private String titulo;
    private String isbn;
    private Editora editora;
    private List<Autor> autores;
    private List<Copia> copias;

    public Livro(Long id, String titulo, String isbn, Editora editora) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.editora = editora;
        this.autores = new ArrayList<>();
        this.copias = new ArrayList<>();

        editora.publicarLivro(this); //registrar o livro na editora
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
        autor.adicionarLivro(this);
    }

    public Copia criarCopia(String codigo, Biblioteca biblioteca) {
        Copia copia = new Copia(codigo, this, biblioteca);
        copias.add(copia); //so o livro pode criar copias
        return copia;
    }

    public Copia buscarCopiaDisponivel() {
        return copias.stream()
                .filter(Copia::verificarDisponibilidade)
                .findFirst()
                .orElse(null);
    }

    public String getTitulo() { return titulo; }
}
