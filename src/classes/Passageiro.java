package classes;

public class Passageiro {
    private  String nome;
    private final int id;
    private String endereco;
    private String telefone;
    private boolean fidelidade;
    private int pontosFidelidade;


    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public boolean isFidelidade() {
        return fidelidade;
    }

    public int getId() {
        return id;
    }

    public Passageiro(int id, String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id = id;
    }

}
