package br.com.vidaplena;

import br.com.vidaplena.model.pessoas.Paciente;
import br.com.vidaplena.service.ClinicaServico;

import br.com.vidaplena.exceptions.ConsultaInvalidaException;
import br.com.vidaplena.exceptions.ConvenioNaoCobreException;
import br.com.vidaplena.exceptions.HorarioIndisponivelException;
import br.com.vidaplena.exceptions.LimiteParcelasExcedidoException;
import br.com.vidaplena.exceptions.OperacaoInvalidaException;
import br.com.vidaplena.exceptions.PacienteInativoException;
import br.com.vidaplena.exceptions.PacienteNaoEncontradoException;
import br.com.vidaplena.exceptions.ProfissionalNaoEncontradoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClinicaServico servico = new ClinicaServico();
        boolean sistemaAtivo = true;

        while (sistemaAtivo) {
            try {
                System.out.println("\n--- Clínica VidaPlena (AV2) ---");
                System.out.println("1. Cadastrar Paciente (Mínimo)");
                System.out.println("2. Buscar Paciente por CPF");
                System.out.println("3. Emitir Relatório Geral");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Informe o Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Informe o CPF: ");
                        String cpf = scanner.nextLine();
                        
                        Paciente novoPaciente = new Paciente(nome, cpf);
                        servico.registrarPaciente(novoPaciente);
                        System.out.println("Sucesso: Paciente registrado!");
                        break;
                        
                    case 2:
                        System.out.print("Digite o CPF para busca: ");
                        String cpfBusca = scanner.nextLine();
                        
                        Paciente pacienteEncontrado = servico.buscarPacientePorCpf(cpfBusca);
                        System.out.println("\n--- Resultado da Busca ---");
                        pacienteEncontrado.exibirResumo();
                        break;
                        
                    case 3:
                        servico.gerarRelatorioGeral();
                        break;
                        
                    case 4:
                        sistemaAtivo = false;
                        System.out.println("Encerrando o sistema...");
                        break;
                        
                    default:
                        System.out.println("Aviso: Opção inválida. Tente novamente.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Erro de Digitação: Por favor, insira o formato numérico correto.");
                scanner.nextLine();
                
            } catch (IllegalArgumentException e) {
                System.out.println("Erro de Validação (Model): " + e.getMessage());
                
            } 
            catch (PacienteNaoEncontradoException e) {
                System.out.println("Busca Falhou: " + e.getMessage());
                
            } catch (ProfissionalNaoEncontradoException e) {
                System.out.println("Busca Falhou: " + e.getMessage());
                
            } catch (PacienteInativoException e) {
                System.out.println("Bloqueio de Agenda: " + e.getMessage());
                
            } catch (HorarioIndisponivelException e) {
                System.out.println("Conflito de Agenda: " + e.getMessage());
                
            } catch (ConsultaInvalidaException e) {
                System.out.println("Erro de Agendamento: " + e.getMessage());
                
            } catch (ConvenioNaoCobreException e) {
                System.out.println("Aviso de Cobertura: " + e.getMessage());
                
            } catch (LimiteParcelasExcedidoException e) {
                System.out.println("Erro Financeiro: " + e.getMessage());
                
            } catch (OperacaoInvalidaException e) {
                System.out.println("Operação Negada: " + e.getMessage());
                
            } 
            catch (Exception e) {
                System.out.println("Erro Inesperado Genérico: " + e.getMessage());
                
            } finally {
                if (!sistemaAtivo) {
                    System.out.println("Recursos liberados. Sessão do console finalizada com segurança.");
                }
            }
        }
        
        scanner.close();
    }
}
