package br.com.vidaplena.model.pagamentos;


public class PagamentoConvenio extends Pagamento {


    public static final double COBERTURA_BASICO        = 0.30; // 30%
    public static final double COBERTURA_INTERMEDIARIO  = 0.50; // 50%
    public static final double COBERTURA_PREMIUM        = 0.70; // 70%
    public static final double COBERTURA_TOTAL          = 1.00; // 100%

   
    private String nomeConvenio;

    private double coberturaConvenio;

    private String numeroCarteirinha;


    public PagamentoConvenio(int idPagamento, String descricao, double valorBase,
                              String nomeConvenio, double coberturaConvenio,
                              String numeroCarteirinha) {
        super(idPagamento, descricao, valorBase);
        this.nomeConvenio      = nomeConvenio;
        this.coberturaConvenio = coberturaConvenio;
        this.numeroCarteirinha = numeroCarteirinha;
    }


    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public double getCoberturaConvenio() {
        return coberturaConvenio;
    }

    public void setCoberturaConvenio(double coberturaConvenio) {
        this.coberturaConvenio = coberturaConvenio;
    }

    public String getNumeroCarteirinha() {
        return numeroCarteirinha;
    }

    public void setNumeroCarteirinha(String numeroCarteirinha) {
        this.numeroCarteirinha = numeroCarteirinha;
    }

    @Override
    public double calcularValorFinal(double valorBase) {

        if (coberturaConvenio < 0.0 || coberturaConvenio > 1.0) {
            throw new IllegalArgumentException(
                "Percentual de cobertura invalido: " + (coberturaConvenio * 100)
                + "%. Deve estar entre 0% e 100%."
            );
        }

        double valorCoberto  = valorBase * coberturaConvenio;
        double valorPaciente = valorBase - valorCoberto;

        System.out.printf(
            "[Convenio %s] Carteirinha: %s | Cobertura: %.0f%% | "
            + "Convenio paga: R$ %.2f | Paciente paga: R$ %.2f%n",
            nomeConvenio, numeroCarteirinha,
            coberturaConvenio * 100, valorCoberto, valorPaciente
        );

        return valorPaciente;
    }

   
    public double calcularValorConvenio() {
        return getValorBase() * coberturaConvenio;
    }

    @Override
    public String exportarDados() {
        double valorPaciente = calcularValorFinal(getValorBase());
        double valorCoberto  = calcularValorConvenio();

        return String.format(
            "[PAGAMENTO - CONVENIO %s] ID: %d | Carteirinha: %s | Descricao: %s"
            + " | Valor Base: R$ %.2f | Cobertura: %.0f%% (R$ %.2f)"
            + " | Paciente Paga: R$ %.2f",
            getNomeConvenio().toUpperCase(),
            getIdPagamento(),
            getNumeroCarteirinha(),
            getDescricao(),
            getValorBase(),
            coberturaConvenio * 100,
            valorCoberto,
            valorPaciente
        );
    }

    @Override
    public String toString() {
        return exportarDados();
    }
}
",
            nomeConvenio, numeroCarteirinha,
            coberturaConvenio * 100, valorCoberto, valorPaciente
        );

        return valorPaciente;
    }

   
    public double calcularValorConvenio() {
        return getValorBase() * coberturaConvenio;
    }

    @Override
    public String exportarDados() {
        double valorPaciente = calcularValorFinal(getValorBase());
        double valorCoberto  = calcularValorConvenio();

        return String.format(
            "[PAGAMENTO - CONVENIO %s] ID: %d | Carteirinha: %s | Descricao: %s"
            + " | Valor Base: R$ %.2f | Cobertura: %.0f%% (R$ %.2f)"
            + " | Paciente Paga: R$ %.2f",
            getNomeConvenio().toUpperCase(),
            getIdPagamento(),
            getNumeroCarteirinha(),
            getDescricao(),
            getValorBase(),
            coberturaConvenio * 100,
            valorCoberto,
            valorPaciente
        )