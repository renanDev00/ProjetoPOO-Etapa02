package br.com.vidaplena.model.pessoas;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected int idade;
    protected String telefone;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // SOBRECARGA: mesmo nome, parâmetros diferentes (resolvido em tempo de compilação).
    public Pessoa(String nome, String cpf, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean possuiCpfPreenchido() {
        return this.cpf != null && !this.cpf.trim().isEmpty();
    }

    public abstract void exibirResumo();
}
