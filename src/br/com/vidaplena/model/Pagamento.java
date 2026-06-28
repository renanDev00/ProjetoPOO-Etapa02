package br.com.vidaplena.model.pagamentos;

import br.com.vidaplena.model.Exportavel;

/**
 * Classe abstrata que representa a entidade base de pagamento do sistema Vida Plena.
 * Define o motor polimórfico responsável por calcular o valor final de qualquer
 * modalidade de pagamento aceita pela clínica.
 *
 * Implementa a interface Exportavel, garantindo que todo pagamento possa
 * ser exportado/registrado no sistema (ex.: relatório de fechamento diário).
 *
 * Jornadas associadas: 9 (Dinheiro/Pix), 10 (Cartão), 11 (Convênio)
 */
public abstract class Pagamento implements Exportavel {

    // -------------------------------------------------------------------------
    // Atributos privados — encapsulamento
    // -------------------------------------------------------------------------

    /** Identificador único do pagamento. */
    private int idPagamento;

    /** Descrição ou observação livre sobre o pagamento. */
    private String descricao;

    /** Valor base da consulta/serviço ANTES de qualquer ajuste. */
    private double valorBase;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Construtor completo.
     *
     * @param idPagamento identificador único do pagamento
     * @param descricao   descrição ou observação do pagamento
     * @param valorBase   valor bruto da consulta/serviço
     */
    public Pagamento(int idPagamento, String descricao, double valorBase) {
        this.idPagamento = idPagamento;
        this.descricao   = descricao;
        this.valorBase   = valorBase;
    }

    // -------------------------------------------------------------------------
    // Getters e Setters
    // -------------------------------------------------------------------------

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    // -------------------------------------------------------------------------
    // Motor polimórfico — assinatura obrigatória para todas as subclasses
    // -------------------------------------------------------------------------

    /**
     * Calcula o valor final do pagamento aplicando as regras específicas
     * de cada modalidade (desconto, juros, cobertura de convênio etc.).
     *
     * Cada subclasse DEVE sobrescrever este método com sua própria lógica.
     *
     * @param valorBase valor bruto da consulta/serviço
     * @return valor final ajustado conforme a modalidade de pagamento
     */
    public abstract double calcularValorFinal(double valorBase);

    // -------------------------------------------------------------------------
    // Implementação de Exportavel
    // -------------------------------------------------------------------------

    /**
     * Exporta os dados essenciais do pagamento em formato de texto.
     * Subclasses podem sobrescrever para enriquecer o relatório.
     *
     * @return string formatada com os dados do pagamento
     */
    @Override
    public String exportarDados() {
        return String.format(
            "[PAGAMENTO] ID: %d | Descricao: %s | Valor Base: R$ %.2f | Valor Final: R$ %.2f",
            idPagamento,
            descricao,
            valorBase,
            calcularValorFinal(valorBase)
        );
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return exportarDados();
    }
}
