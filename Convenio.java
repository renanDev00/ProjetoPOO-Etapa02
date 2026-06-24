public class Convenio {
    
    private String nome;
    private String cnpj;
    private double percentualCobertura;

    public Convenio(String nome, String cnpj, double percentualCobertura) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.percentualCobertura = percentualCobertura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getPercentualCobertura() {
        return percentualCobertura;
    }

    public void setPercentualCobertura(double percentualCobertura) {
        this.percentualCobertura = percentualCobertura;
    }
}    
