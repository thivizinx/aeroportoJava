package classes;

public class Tripulacao {
    private String cargo;
    private final int id;
    private String nome;
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tripulacao(int id, String nome, String telefone, String cargo) {
        this.id = id;
        this.cargo = cargo;
        this.nome = nome;
        this.telefone = telefone;
    }
}
