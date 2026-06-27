package br.com.vidaplena.model.pessoas;

public class Paciente extends Pessoa {

    // ASSOCIAÇÃO: Paciente conhece Convenio, mas ambos existem independentemente
    private Convenio convenio;
    private boolean ativo;

    public Paciente(String nome, String cpf) {
        super(nome, cpf);
        this.setAvisoValidarCpf(cpf);
        this.ativo = true;
    }

    public Paciente(String nome, String cpf, int idade, String telefone) {
        super(nome, cpf);
        this.setAvisoValidarCpf(cpf);
        this.setIdade(idade);
        this.setTelefone(telefone);
        this.ativo = true;
    }

    public Paciente(String nome, String cpf, int idade, String telefone, Convenio convenio) {
        super(nome, cpf);
        this.setAvisoValidarCpf(cpf);
        this.setIdade(idade);
        this.setTelefone(telefone);
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

    @Override
    public void setCpf(String cpf) {
        this.setAvisoValidarCpf(cpf);
    }

    @Override
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade nao pode ser negativa.");
        }
        this.idade = idade;
    }

    private void setAvisoValidarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF nao pode ser nulo ou vazio.");
        }
        super.setCpf(cpf);
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

    // SOBRESCRITA: mesmo nome e parâmetros, classe filha redefine comportamento (resolvido em tempo de execução)
    @Override
    public void exibirResumo() {
        String status = ativo ? "Sim" : "Não";
        String nomeConvenio = (convenio != null) ? convenio.getNome() : "Nenhum";
        System.out.println("Nome: " + nome + " | CPF: " + cpf + " | Idade: " + idade + " | Tel: " + telefone + " | Convenio: " + nomeConvenio + " | Ativo: " + status);
    }
}
