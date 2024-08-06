public class RelatorioHolerite {

    private static String getCargo(Funcionario funcionario) {
        if (funcionario instanceof Vendedor) {
            return "Vendedor";
        } else if (funcionario instanceof AssistenteAdministrativo) {
            return "Assistente Administrativo";
        } else {
            return "Funcionario";
        }
    }
    public static void main(String[] args) {
        RepositorioFuncionarios repositorio = new RepositorioFuncionarios(20);
        int contador = 0;
        for (var funcionario : repositorio.getFuncionarios()) {
            System.out.println("Contracheque " + ++contador);

            System.out.printf("Dados Pessoais: \n\tNome: %s\n\tCPF: %s\n\tTelefone: %s\n\tEmail: %s\n",
                    funcionario.getNomeCompleto(), funcionario.getCpf(), funcionario.getTelefone(),
                    funcionario.getEmail());
            System.out.println("Cargo: " + getCargo(funcionario));
            System.out.printf("Salario Base: %.2f\n", funcionario.getSalarioBase());
            System.out.printf("Descontos: %.2f\n", funcionario.getDescontos());
            System.out.printf("\tPlano de Saude: %.2f\n", funcionario.getPlanoSaude());
            System.out.printf("\tVale Transporte: %.2f\n", funcionario.getValeTransporte());
            System.out.printf("\tPrevidencia: %.2f\n", funcionario.getPrevidencia());
            System.out.printf("Adicionais: %.2f\n", funcionario.getAdicionais());
            System.out.printf("\tVale Alimentacao: %.2f\n", funcionario.getValeAlimentacao());

            if (funcionario instanceof AssistenteAdministrativo) {
                AssistenteAdministrativo assistente = (AssistenteAdministrativo) funcionario;

                System.out.printf("\tRendimento hora-extra: %.2f\n", assistente.getRendimentoHorasExtras());
                System.out.printf("\t\tHoras Extras: %.2f\n", assistente.getHorasExtras());
                System.out.printf("\t\tValor hora-extra: %.2f\n", assistente.getValorHoraExtra());                
            } else if (funcionario instanceof Vendedor) {
                Vendedor vendedor = (Vendedor) funcionario;
                
                System.out.printf("\tComissão: %.2f\n", vendedor.getComissao());
                System.out.printf("\t\tVendas brutas: %.2f\n", vendedor.getVendasBrutas());
                System.out.printf("\t\tTaxa comissão: %.2f\n", vendedor.getTaxaComissao());
                
            }

            System.out.printf("Salário Bruto: %.2f\n", funcionario.getSalarioBruto());
            System.out.printf("Salário Líquido: %.2f\n", funcionario.getSalarioLiquido());
            System.out.println();

        }
    }
}
