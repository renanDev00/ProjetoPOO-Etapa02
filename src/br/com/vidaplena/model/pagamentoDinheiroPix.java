package br.com.vidaplena.model.pagamentos;


public class PagamentoDinheiroPix extends Pagamento {

    
   
    private static final double PERCENTUAL_DESCONTO = 0.05; // 5%

   
    private String modalidade;


    public PagamentoDinheiroPix(int idPagamento, String descricao,
                                 double valorBase, String modalidade) {
        super(idPagamento, descricao, valorBase);
        this.modalidade = modalidade;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public double calcularValorFinal(double valorBase) {
        double desconto   = valorBase * PERCENTUAL_DESCONTO;
        double valorFinal = valorBase - desconto;

        System.out.printf(
            "[Dinheiro/Pix] Valor base: R$ %.2f | Desconto (5%%): -R$ %.2f | Valor final: R$ %.2f%n",
            valorBase, desconto, valorFinal
        );

        return valorFinal;
    }

    @Override
    public String exportarDados() {
        return String.format(
            "[PAGAMENTO - %s] ID: %d | Descricao: %s | Valor Base: R$ %.2f"
            + " | Desconto: 5%% | Valor Final: R$ %.2f",
            getModalidade().toUpperCase(),
            getIdPagamento(),
            getDescricao(),
            getValorBase(),
            calcularValorFinal(getValorBase())
        );
    }

    @Override
    public String toString() {
        return exportarDados();
    }
}
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public double calcularValorFinal(double valorBase) {
        double desconto   = valorBase * PERCENTUAL_DESCONTO;
        double valorFinal = valorBase - desconto;

        System.out.printf(
            "[Dinheiro/Pix] Valor base: R$ %.2f | Desconto (5%%): -R$ %.2f | Valor final: R$ %.2f%n",
            valorBase, desconto, valorFinal
        );

        return valorFinal;
    }

    @Over