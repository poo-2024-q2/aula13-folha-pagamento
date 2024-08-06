public class RelatorioFolhaPagamento {
    public static void main(String[] args) {
        RepositorioFuncionarios repositorio = new RepositorioFuncionarios(20);

        System.out.println("Folha de Pagamento");
        System.out.printf("%-20s %-25s %-10s %10s %10s %10s %10s %10s\n", "CPF", "Nome", "Cargo", "Base", "Descontos", "Adicionais", "Bruto", "Líquido");
        for (var funcionario : repositorio.getFuncionarios()) {
            String cargo = "";

            if (funcionario instanceof AssistenteAdministrativo) {
                cargo = "Ass. Adm.";
            } else if (funcionario instanceof Vendedor) {
                cargo = "Vendedor";
            } else {
                cargo = "Outro";
            }
            System.out.printf(
                "%-20s %-25s %-10s %10.2f %10.2f %10.2f %10.2f %10.2f\n",
                funcionario.getCpf(),
                funcionario.getNomeCompleto(),
                cargo,
                funcionario.getSalarioBase(),
                funcionario.getDescontos(),
                funcionario.getAdicionais(),
                funcionario.getSalarioBruto(),
                funcionario.getSalarioLiquido()
            );
        }
    }
}
