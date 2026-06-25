package br.com.vidaplena.model.pessoas;

import java.util.HashSet;
import java.util.Set;

public class Convenio {
    
    private String nome;
    private String cnpj;
    private double percentualCobertura;
    
    // Justificativa da Coleção:
    // HashSet<String>: escolhido pois precisamos apenas verificar a existência 
    // de uma especialidade sem duplicatas, não precisamos da ordenação.
    private Set<String> especialidadesCobertas;

    public Convenio(String nome, String cnpj, double percentualCobertura) {
        this.setNome(nome);
        this.setCnpj(cnpj);
        this.setPercentualCobertura(percentualCobertura);
        this.especialidadesCobertas = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do convênio não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ não pode ser vazio.");
        }
        this.cnpj = cnpj;
    }

    public double getPercentualCobertura() {
        return percentualCobertura;
    }

    public void setPercentualCobertura(double percentualCobertura) {
        if (percentualCobertura < 0 || percentualCobertura > 100) {
            throw new IllegalArgumentException("O percentual de cobertura deve estar entre 0 e 100.");
        }
        this.percentualCobertura = percentualCobertura;
    }

    public Set<String> getEspecialidadesCobertas() {
        return especialidadesCobertas;
    }

    public void adicionarEspecialidade(String especialidade) {
        if (especialidade != null && !especialidade.trim().isEmpty()) {
            this.especialidadesCobertas.add(especialidade.toLowerCase()); 
        }
    }

    public boolean cobreEspecialidade(String especialidade) {
        if (especialidade == null) return false;
        return this.especialidadesCobertas.contains(especialidade.toLowerCase());
    }
}
