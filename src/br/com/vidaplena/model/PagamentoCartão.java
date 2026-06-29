package br.com.vidaplena.model.pagamentos;

public class PagamentoCartao extends Pagamento {


    private static final int    PARCELAS_SEM_JUROS = 3;

    private static final double TAXA_JUROS_FAIXA1  = 0.0199; 

    private static final double TAXA_JUROS_FAIXA2  = 0.0299;

    private static final int    PARCELAS_MAXIMAS   = 12;

    private static final int    INICIO_FAIXA2      = 7;


    private int numeroParcelas;

    private String bandeira;

   
    public PagamentoCartao(int idPagamento, String descricao,
                            double valorBase, int numeroParcelas, String bandeira) {
        super(idPagamento, descricao, valorBase);
        this.numeroParcelas = numeroParcelas;
        this.bandeira       = bandeira;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }


    @Override
    public double calcularValorFinal(double valorBase) {

        if (numeroParcelas < 1 || numeroParcelas > PARCELAS_MAXIMAS) {
            throw new IllegalArgumentException(
                "Parcelamento invalido: " + numeroParcelas
                + " parcelas. Permitido de 1 a " + PARCELAS_MAXIMAS + "."
            );
        }

        double taxaTotal = 0.0;

        for (int parcela = PARCELAS_SEM_JUROS + 1; parcela <= numeroParcelas; parcela++) {
            if (parcela < INICIO_FAIXA2) {
                taxaTotal += TAXA_JUROS_FAIXA1;
            } else {
                taxaTotal += TAXA_JUROS_FAIXA2;
            }
        }

        double valorFinal      = valorBase * (1 + taxaTotal);
        double valorPorParcela = valorFinal / numeroParcelas;

        System.out.printf(
            "[Cartao %s] %dx | Taxa total: %.2f%% | Valor final: R$ %.2f | Parcela: R$ %.2f%n",
            bandeira, numeroParcelas, taxaTotal * 100, valorFinal, valorPorParcela
        );

        return valorFinal;
    }

   
    public double calcularValorParcela() {
        return calcularValorFinal(getValorBase()) / numeroParcelas;
    }

    @Override
    public String exportarDados() {
        double valorFinal      = calcularValorFinal(getValorBase());
        double valorPorParcela = valorFinal / numeroParcelas;

        return String.format(
            "[PAGAMENTO - CARTAO %s] ID: %d | Descricao: %s | Valor Base: R$ %.2f"
            + " | %dx de R$ %.2f | Valor Final: R$ %.2f",
            getBandeira().toUpperCase(),
            getIdPagamento(),
            getDescricao(),
            getValorBase(),
            numeroParcelas,
            valorPorParcela,
            valorFinal
        );
    }

    @Override
    public String toString() {
        return exportarDados();
    }
}
m.out.printf(
            "[Cartao %s] %dx | Taxa total: %.2f%% | Valor final: R$ %.2f | Parcela: R$ %.2f%n",
            bandeira, numeroParcelas, taxaTotal * 10