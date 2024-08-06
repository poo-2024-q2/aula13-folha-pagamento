import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public class RepositorioFuncionarios {
    private ArrayList<Funcionario> funcionarios;
    private Faker faker;

    public RepositorioFuncionarios(int tamanho) {
        funcionarios = new ArrayList<>();
        faker = new Faker();

        for (int i = 0; i < tamanho; i++) {
            funcionarios.add(geraAleatorio());
        }
    }

    private String geraCPF() {
        return String.format("%03d.%03d.%03d-%02d", 
            faker.number().numberBetween(0, 999), 
            faker.number().numberBetween(0, 999), 
            faker.number().numberBetween(0, 999), 
            faker.number().numberBetween(0, 99));
    }

    private String geraTelefone() {
        int ddd = faker.number().numberBetween(11, 99);
        int prefixo = (Math.random() < 0.5) 
            ? faker.number().numberBetween(1000, 9999)
            : faker.number().numberBetween(90000, 99999);
        int sufixo = faker.number().numberBetween(1000, 9999);

        return String.format("(%d)%d-%d", ddd, prefixo, sufixo);
    }

    private Funcionario geraAleatorio() {
        int tipo = faker.random().nextInt(0, 2);

        if (tipo == 0) {
            return new AssistenteAdministrativo(
                faker.name().fullName(), 
                geraCPF(),
                geraTelefone(),
                faker.internet().emailAddress(), 
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 3000, 7000),
                faker.number().randomDouble(2, 0, 10));
        } else if (tipo == 1) {
            return new Vendedor(
                faker.name().fullName(), 
                geraCPF(),
                geraTelefone(),
                faker.internet().emailAddress(), 
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 3000, 7000),
                faker.number().randomDouble(2, 1000, 100000),
                faker.number().randomDouble(2, 0, 1) / 10
                );
        } else {
            return new Funcionario(
                faker.name().fullName(),
                geraCPF(),
                geraTelefone(),
                faker.internet().emailAddress(),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 500, 700),
                faker.number().randomDouble(2, 3000, 7000)
                );
        }
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
