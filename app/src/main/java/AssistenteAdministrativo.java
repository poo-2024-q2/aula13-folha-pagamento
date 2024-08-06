
public class AssistenteAdministrativo extends Funcionario {
    private double horasExtras;

    public AssistenteAdministrativo(
            String nomeCompleto,
            String cpf,
            String telefone,
            String email,
            double planoSaude,
            double valeTransporte,
            double valeAlimentacao,
            double previdencia,
            double salarioBase,
            double horasExtras) {
        super(nomeCompleto, cpf, telefone, email, planoSaude, valeTransporte, valeAlimentacao, previdencia,
                salarioBase);
        setHorasExtras(horasExtras);
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public double getValorHoraExtra() {
        return getSalarioBase() / 220 * 1.5;
    }

    public double getRendimentoHorasExtras() {
        return getValorHoraExtra() * getHorasExtras();
    }

    public void setHorasExtras(double horasExtras) {
        if (horasExtras < 0) {
            throw new IllegalArgumentException("Horas extras nao pode ser negativo");
        }
        this.horasExtras = horasExtras;
    }

    @Override
    public double getAdicionais() {
        return super.getAdicionais() + getSalarioBase() / 220 * getHorasExtras() * 1.5;
    }
}
