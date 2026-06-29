package br.com.vidaplena.model.pagamentos;

import br.com.vidaplena.model.Exportavel;


public abstract class Pagamento implements Exportavel {

   
    private int idPagamento;

    private String descricao;

    private double valorBase;

    public Pagamento(int idPagamento, String descricao, double valorBase) {
        this.idPagamento = idPagamento;
        this.descricao   = descricao;
        this.valorBase   = valorBase;
    }

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

    public abstract double calcularValorFinal(double valorBase);


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

    @Override
    public String toString() {
        return exportarDados();
    }
}
     this.descricao   = descricao;
        this.valorBase   = valorBase;
    }

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

    public abstract double calcularValorFinal(double valorBase);


    @Override
    public String