public class Funcionario {
    protected String nomeCompleto;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected double planoSaude;
    protected double valeTransporte;
    protected double valeAlimentacao;
    protected double previdencia;
    protected double salarioBase;

    public Funcionario(String nomeCompleto, String cpf, String telefone, String email, double planoSaude,
            double valeTransporte, double valeAlimentacao, double previdencia, double salarioBase) {
        setNomeCompleto(nomeCompleto);
        setCpf(cpf);
        setTelefone(telefone);
        setEmail(email);
        setPlanoSaude(planoSaude);
        setValeTransporte(valeTransporte);
        setValeAlimentacao(valeAlimentacao);
        setPrevidencia(previdencia);
        setSalarioBase(salarioBase);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nomeCompleto = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty() 
            || !telefone.matches("\\(\\d\\d\\)\\d{4,5}-\\d{4}")) {
            throw new IllegalArgumentException("Telefone inválido: " + telefone);
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(double planoSaude) {
        if (planoSaude < 0) {
            throw new IllegalArgumentException("Plano de saúde não pode ser negativo");
        }
        this.planoSaude = planoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(double valeTransporte) {
        if (valeTransporte < 0) {
            throw new IllegalArgumentException("Vale transporte não pode ser negativo");
        }
        this.valeTransporte = valeTransporte;
    }

    public double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(double valeAlimentacao) {
        if (valeAlimentacao < 0) {
            throw new IllegalArgumentException("Vale alimentação não pode ser negativo");
        }
        this.valeAlimentacao = valeAlimentacao;
    }

    public double getPrevidencia() {
        return previdencia;
    }

    public void setPrevidencia(double previdencia) {
        if (previdencia < 0) {
            throw new IllegalArgumentException("Previdência não pode ser negativo");
        }
        this.previdencia = previdencia;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salário base não pode ser negativo");
        }
        this.salarioBase = salarioBase;
    }

    protected double getDescontos() {
        return getValeTransporte() + getPlanoSaude() + getPrevidencia();
    }

    protected double getAdicionais() {
        return getValeAlimentacao();
    }

    protected double getSalarioBruto() {
        return getSalarioBase() + getAdicionais();
    }

    protected double getSalarioLiquido() {
        return getSalarioBruto() - getDescontos();
    }
}
