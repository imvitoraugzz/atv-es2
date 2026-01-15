package SistemaComercio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private List<Pedido> pedidos;

    public Cliente(Long id, String nome, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    public Pedido realizarPedido() {
        Pedido pedido = new Pedido(this);
        pedidos.add(pedido);
        return pedido;
    }

    public String getNome() {
        return nome;
    }
}
