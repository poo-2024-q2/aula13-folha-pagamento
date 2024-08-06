public class Vendedor extends Funcionario {
    private double vendasBrutas;
    private double taxaComissao;

    public Vendedor(
        String nomeCompleto, 
        String cpf, 
        String telefone, 
        String email,
        double planoSaude,
        double valeTransporte, 
        double valeAlimentacao, 
        double previdencia,
        double salarioBase,
        double vendasBrutas,
        double taxaComissao
        ) {
        super(
            nomeCompleto, 
            cpf, 
            telefone, 
            email, 
            planoSaude, 
            valeTransporte, 
            valeAlimentacao, 
            previdencia, 
            salarioBase
        );
        setVendasBrutas(vendasBrutas);
        setTaxaComissao(taxaComissao);
    }

    public final double getVendasBrutas() {
        return vendasBrutas;
    }

    public final void setVendasBrutas(double vendasBrutas) {
        if (vendasBrutas < 0.0) {
            throw new IllegalArgumentException("Gross sales cannot be negative");
        }
        this.vendasBrutas = vendasBrutas;
    }

    public final double getTaxaComissao() {
        return taxaComissao;
    }

    public final void setTaxaComissao(double taxaComissao) {
        if (taxaComissao < 0.0 || taxaComissao > 1.0) {
            throw new IllegalArgumentException("Comission rate must a percentage --- [0,1]");
        }
        this.taxaComissao = taxaComissao;
    }

    public double getComissao() {
        return vendasBrutas * taxaComissao;
    }

    @Override
    public double getAdicionais() {
        return super.getAdicionais() + getComissao();
    }
}
