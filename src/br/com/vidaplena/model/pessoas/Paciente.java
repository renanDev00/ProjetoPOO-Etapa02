package br.com.vidaplena.model.pessoas;

public class Paciente extends Pessoa {

    private Convenio convenio;
    private boolean ativo;

    public Paciente(String nome, String cpf) {
        super(nome, cpf);
        this.ativo = true;
    }

    public Paciente(String nome, String cpf, int idade, String telefone) {
        super(nome, cpf, idade, telefone);
        this.ativo = true;
    }

    public Paciente(String nome, String cpf, int idade, String telefone, Convenio convenio) {
        super(nome, cpf, idade, telefone);
        this.convenio = convenio;
        this.ativo = true;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void complementar(int idade, String telefone) {
        this.setIdade(idade);
        this.setTelefone(telefone);
    }

    public void complementar(int idade, String telefone, Convenio convenio) {
        this.setIdade(idade);
        this.setTelefone(telefone);
        this.convenio = convenio;
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public void exibirResumo() {
        String status = ativo ? "Sim" : "Não";
        String nomeConvenio = (convenio != null) ? convenio.getNome() : "Nenhum";
        System.out.println("Nome: " + nome + " | CPF: " + cpf + " | Idade: " + idade + " | Tel: " + telefone + " | Convenio: " + nomeConvenio + " | Ativo: " + status);
    }
}
