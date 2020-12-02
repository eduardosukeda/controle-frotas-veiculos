import funcionario.FuncionarioAdministrativo;
import funcionario.FuncionarioManobrista;
import funcionario.FuncionarioMotorista;
import funcionario.service.FuncionarioService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static FuncionarioService funcionarioService = new FuncionarioService();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    static List<FuncionarioAdministrativo> funcionarioAdministrativoList = new ArrayList<>();
    static List<FuncionarioManobrista> funcionarioManobristaList = new ArrayList<>();
    static List<FuncionarioMotorista> funcionarioMotoristaList = new ArrayList<>();

    public static void main(String[] args) {

        MenuPrincipal();

        FuncionarioService funcionarioService = new FuncionarioService();


        List<FuncionarioAdministrativo> funcionarioAdministrativoList = new ArrayList<>();
        funcionarioAdministrativoList.add(new FuncionarioAdministrativo("Eduardo", LocalDate.parse("02/12/2020", formatter), "123"));
        funcionarioAdministrativoList.add(new FuncionarioAdministrativo("Aduardo", LocalDate.parse("02/12/2020", formatter), "123"));
        funcionarioAdministrativoList.add(new FuncionarioAdministrativo("Bduardo", LocalDate.parse("02/12/2020", formatter), "123"));
        funcionarioAdministrativoList.add(new FuncionarioAdministrativo("Gduardo", LocalDate.parse("02/12/2020", formatter), "123"));

        List<FuncionarioManobrista> funcionarioManobristas = new ArrayList<>();
        funcionarioManobristas.add(new FuncionarioManobrista("Eduardo", LocalDate.parse("02/12/2020", formatter), "1234", "123", "B", LocalDate.parse("02/12/2020", formatter)));
        funcionarioManobristas.add(new FuncionarioManobrista("Bduardo", LocalDate.parse("02/12/2020", formatter), "123", "123", "B", LocalDate.parse("02/12/2020", formatter)));
        funcionarioManobristas.add(new FuncionarioManobrista("Sduardo", LocalDate.parse("02/12/2020", formatter), "123", "123", "B", LocalDate.parse("02/12/2020", formatter)));
        funcionarioManobristas.add(new FuncionarioManobrista("Aduardo", LocalDate.parse("02/12/2020", formatter), "123", "123", "B", LocalDate.parse("02/12/2020", formatter)));
        funcionarioManobristas.add(new FuncionarioManobrista("Qduardo", LocalDate.parse("02/12/2020", formatter), "1234", "123", "B", LocalDate.parse("02/12/2020", formatter)));

        List<FuncionarioMotorista> funcionarioMotoristaList = new ArrayList<>();

        funcionarioService.buscarFuncionariosOrdemAlfabetica(funcionarioAdministrativoList, funcionarioManobristas, funcionarioMotoristaList);

        funcionarioService.buscarFuncionarioByCpf(funcionarioAdministrativoList, funcionarioManobristas, funcionarioMotoristaList, "1234");
    }

    public static void MenuPrincipal() {
        int select;

        do {
            do {
                System.out.printf("Menu Principal\nDeseja Gerenciar:\n 1. Funcionários\n 2. Veículos\n 3. Fretamentos\n\n 4. Sair\n");
                select = scanner.nextInt();
            } while (select < 1 || select > 5);

            switch (select) {
                case 1:
                    MenuFuncionario();
                case 2:
                    break;

                case 3:
                    break;
            }
        } while (select != 4);
    }

    public static void MenuFuncionario() {
        int select;
        String nome, cpf, numeroCNH, categoriaCNH;
        LocalDate dataNascimento, dataVencimentoCNH;
        boolean cursoCargasPerigosas, cursoTransportePassageiros;
        boolean ok = true;

        do {
            do {
                System.out.printf("\nMenu Funcionário\nDeseja:\n 1. Cadastrar Funcionários\n 2. Listar funcionários em ordem alfabética\n 3. Buscar funcionário por CPF\n\n 4. Sair\n");
                select = scanner.nextInt();
                scanner.nextLine();
            } while (select < 1 || select > 5);

            switch (select) {
                case 1:
                    System.out.printf("\nQual o tipo de Funcionário que você deseja cadastrar ?\n 1. Funcionário Administrativo\n 2. Funcionário Manobrista\n 3. Funcionário Motorista\n\n 4. Sair\n");
                    select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select) {
                        case 1:
                            System.out.printf("Nome:\n");
                            nome = scanner.nextLine();

                            System.out.printf("Data de Nascimento (ex: 02/12/2020): \n");
                            dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

                            System.out.printf("CPF:\n");
                            cpf = scanner.nextLine();
                            funcionarioAdministrativoList.add(funcionarioService.cadastrarFuncionarioAdministrativo(nome, dataNascimento, cpf));

                            ok = false;
                            break;
                        case 2:
                            System.out.printf("Nome:\n");
                            nome = scanner.nextLine();

                            System.out.printf("Data de Nascimento (ex: 02/12/2020): \n");
                            dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

                            System.out.printf("CPF:\n");
                            cpf = scanner.nextLine();

                            System.out.printf("Número CNH:\n");
                            numeroCNH = scanner.nextLine();

                            System.out.printf("Categoria CNH:\n");
                            categoriaCNH = scanner.nextLine();

                            System.out.printf("Data de Vencimento CNH:\n");
                            dataVencimentoCNH = LocalDate.parse(scanner.nextLine(), formatter);

                            funcionarioManobristaList.add(funcionarioService.cadastrarFuncionarioManobrista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH));

                            ok = false;
                            break;
                        case 3:
                            System.out.printf("Nome:\n");
                            nome = scanner.nextLine();

                            System.out.printf("Data de Nascimento (ex: 02/12/2020): \n");
                            dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

                            System.out.printf("CPF:\n");
                            cpf = scanner.nextLine();

                            System.out.printf("Número CNH:\n");
                            numeroCNH = scanner.nextLine();

                            System.out.printf("Categoria CNH:\n");
                            categoriaCNH = scanner.nextLine();

                            System.out.printf("Data de Vencimento CNH:\n");
                            dataVencimentoCNH = LocalDate.parse(scanner.nextLine(), formatter);

                            System.out.printf("Possui curso para cargas perigosas? (S-Sim/N-Não) :\n");
                            cursoCargasPerigosas = scanner.nextLine().equals("S") ? true : false;

                            System.out.printf("Possui curso para transporte de passageiros? :\n");
                            cursoTransportePassageiros = scanner.nextLine().equals("S") ? true : false;

                            funcionarioMotoristaList.add(funcionarioService.cadastrarFuncionarioMotorista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH, cursoCargasPerigosas, cursoTransportePassageiros));

                            ok = false;
                            break;
                    }
                    while (ok == true) ;
                case 2:
                    funcionarioService.buscarFuncionariosOrdemAlfabetica(funcionarioAdministrativoList, funcionarioManobristaList, funcionarioMotoristaList);
                    break;
                case 3:
                    System.out.printf("Digite o CPF desejado para busca:\n");
                    cpf = scanner.nextLine();
                    funcionarioService.buscarFuncionarioByCpf(funcionarioAdministrativoList, funcionarioManobristaList, funcionarioMotoristaList, cpf);
                    break;
            }
        } while (select != 4);
    }
}
