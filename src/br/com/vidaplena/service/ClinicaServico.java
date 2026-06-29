package br.com.vidaplena.service;

import br.com.vidaplena.model.pessoas.Paciente;
import br.com.vidaplena.model.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClinicaServico {

    private List<Pessoa> todasAsPessoas;
    private Set<String> cpfsCadastrados;
    private Map<String, Paciente> mapaPacientes;

    public ClinicaServico() {
        this.todasAsPessoas = new ArrayList<>();
        this.cpfsCadastrados = new HashSet<>();
        this.mapaPacientes = new HashMap<>();
    }

    public void registrarPaciente(Paciente paciente) throws Exception {
        if (this.cpfsCadastrados.contains(paciente.getCpf())) {
            throw new Exception("Erro: O CPF " + paciente.getCpf() + " já está cadastrado no sistema.");
        }
        
        this.cpfsCadastrados.add(paciente.getCpf());
        this.mapaPacientes.put(paciente.getCpf(), paciente);
        this.todasAsPessoas.add(paciente);
    }

    public Paciente buscarPacientePorCpf(String cpf) throws Exception {
        Paciente paciente = this.mapaPacientes.get(cpf);
        
        if (paciente == null) {
            throw new Exception("Erro: Paciente com CPF " + cpf + " não encontrado.");
        }
        
        return paciente;
    }

    public void gerarRelatorioGeral() {
        System.out.println("\n=== Relatório Geral da Clínica ===");
        
        if (todasAsPessoas.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
            return;
        }

        for (Pessoa pessoa : todasAsPessoas) {
            pessoa.exibirResumo(); 
        }
        System.out.println("==================================");
    }
}
