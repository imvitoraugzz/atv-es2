package SistemaBiblioteca;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SISTEMA DE BIBLIOTECA INICIADO ---");

        // Criar Infraestrutura (Biblioteca, Editora, Autor)
        Biblioteca bibliotecaCentral = new Biblioteca(1L, "IFMA Coelho Neto", "Rua A, 123");
        Editora editoraTech = new Editora(1L, "EDIVITOR", "12.345.678/0001-99");
        Autor autorBob = new Autor(1L, "Robert C. Martin", "EUA");

        // Criar a Obra (Livro)
        Livro livroEng = new Livro(10L, "Engenharia de Software Limpa", "978-85", editoraTech);
        livroEng.adicionarAutor(autorBob);

        System.out.println("Livro cadastrado: " + livroEng.getTitulo());

        // Adquirir Exemplares (Cópias Físicas)
        Copia copia01 = livroEng.criarCopia("TOMBO-001", bibliotecaCentral);
        Copia copia02 = livroEng.criarCopia("TOMBO-002", bibliotecaCentral);

        System.out.println("Cópias disponíveis no acervo: " + bibliotecaCentral.consultarAcervo().size());

        //Usuário entra no sistema
        Usuario aluno = new Usuario(55L, "Vitor Augusto", "vitorsampi16@gmail.com");

        //Usuário faz Reserva Online
        System.out.println("\n--- " + aluno.getNome() + " solicitou reserva ---");
        Reserva reserva = aluno.realizarReserva(livroEng);
        System.out.println("Status da Reserva: " + reserva.getStatus());

        //Usuário vai ao balcão retirar o livro (Transformar Reserva em Empréstimo)
        System.out.println("\n--- Confirmando retirada no balcão ---");
        Emprestimo emprestimo = reserva.confirmarRetirada();

        if (emprestimo != null) {
            System.out.println("Empréstimo realizado com sucesso!");
            System.out.println("Copia levada: " + emprestimo.getCopia().getCodigo());
            System.out.println("Devolver até: " + emprestimo.getDataPrevistaDevolucao());
            System.out.println("Status da reserva agora: " + reserva.getStatus());
            System.out.println("Status da cópia física: " + emprestimo.getCopia().getStatus());
        } else {
            System.out.println("Falha: Não há cópias disponíveis ou reserva inválida.");
        }

        //Devolução
        System.out.println("\n--- Realizando Devolução ---");
        if (emprestimo != null) {
            emprestimo.registrarDevolucao();
            System.out.println("Livro devolvido.");
            System.out.println("Multa a pagar: R$ " + emprestimo.calcularMulta());
            System.out.println("Status da cópia física: " + emprestimo.getCopia().getStatus());
        }
    }
}
