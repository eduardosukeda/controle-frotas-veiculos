import funcionario.FuncionarioAdministrativo;
import funcionario.FuncionarioManobrista;
import funcionario.FuncionarioMotorista;
import funcionario.service.FuncionarioService;
import veiculo.VeiculoPasseio;
import veiculo.VeiculoTransporteCargas;
import veiculo.VeiculoTransportePassageiros;
import veiculo.service.VeiculoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static FuncionarioService funcionarioService = new FuncionarioService();
    private static VeiculoService veiculoService = new VeiculoService();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    static List<FuncionarioAdministrativo> funcionarioAdministrativoList = new ArrayList<>();
    static List<FuncionarioManobrista> funcionarioManobristaList = new ArrayList<>();
    static List<FuncionarioMotorista> funcionarioMotoristaList = new ArrayList<>();
    static List<VeiculoPasseio> veiculoPasseioList = new ArrayList<>();
    static List<VeiculoTransporteCargas> veiculoTransporteCargasList = new ArrayList<>();
    static List<VeiculoTransportePassageiros> veiculoTransportePassageirosList = new ArrayList<>();

    public static void main(String[] args) {

        MenuPrincipal();
//
//        VeiculoService veiculoService = new VeiculoService();
//        List<VeiculoPasseio> veiculoPasseioList = new ArrayList<>();
//        veiculoPasseioList.add(new VeiculoPasseio("asdasd", "asdasd", 2020, 18.2));
//        veiculoPasseioList.add(new VeiculoPasseio("asdasd", "asdasd", 2021, 18.2));
//        veiculoPasseioList.add(new VeiculoPasseio("asdasd", "asdasd", 2000, 18.2));
//        veiculoPasseioList.add(new VeiculoPasseio("asdasd", "asdasd", 2019, 18.2));
//        veiculoPasseioList.add(new VeiculoPasseio("asdasd", "asdasd", 2015, 18.2));
//        veiculoPasseioList.add(new VeiculoPasseio("asdasd", "asdasd", 2008, 18.2));
//
//        List<VeiculoTransporteCargas> veiculoTransporteCargasList = new ArrayList<>();
//        veiculoTransporteCargasList.add(new VeiculoTransporteCargas("asdasd", "asdasd", 2008, 18.2, 15.2, 4, true));
//        veiculoTransporteCargasList.add(new VeiculoTransporteCargas("asdasd", "asdasd", 2001, 18.2, 15.2, 4, true));
//        veiculoTransporteCargasList.add(new VeiculoTransporteCargas("asdasd", "asdasd", 2000, 18.2, 15.2, 4, true));
//        veiculoTransporteCargasList.add(new VeiculoTransporteCargas("asdasd", "asdasd", 2015, 18.2, 15.2, 4, true));
//
//        List<VeiculoTransportePassageiros> veiculoTransportePassageirosList = new ArrayList<>();
//        veiculoTransportePassageirosList.add(new VeiculoTransportePassageiros("asdasd", "asdasd", 2011, 18.2, 46));
//        veiculoTransportePassageirosList.add(new VeiculoTransportePassageiros("asdasd", "asdasd", 2008, 18.2, 46));
//        veiculoTransportePassageirosList.add(new VeiculoTransportePassageiros("asdasd", "asdasd", 2015, 18.2, 46));
//        veiculoTransportePassageirosList.add(new VeiculoTransportePassageiros("asdasd", "asdasd", 2008, 18.2, 46));
//        veiculoTransportePassageirosList.add(new VeiculoTransportePassageiros("asdasd", "asdasd", 2007, 18.2, 46));
//        veiculoTransportePassageirosList.add(new VeiculoTransportePassageiros("asdasd", "asdasd", 2008, 18.2, 46));
//        veiculoTransportePassageirosList.add(new VeiculoTransportePassageiros("asdasd", "asdasd", 2008, 18.2, 46));
//
//        veiculoService.buscarVeiculosOrdemFabricacao(veiculoPasseioList, veiculoTransporteCargasList, veiculoTransportePassageirosList);
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
                    break;
                case 2:
                    MenuVeiculos();
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
                ok = true;
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

                            if (!funcionarioService.cpfFuncionarioCadastrado(funcionarioAdministrativoList, funcionarioManobristaList, funcionarioMotoristaList, cpf)) {

                                funcionarioAdministrativoList.add(funcionarioService.cadastrarFuncionarioAdministrativo(nome, dataNascimento, cpf));
                            } else {
                                System.out.println("CPF já cadastrado, por gentileza informe outro CPF !");
                            }

                            ok = false;
                            break;
                        case 2:
                            System.out.printf("Nome:\n");
                            nome = scanner.nextLine();

                            System.out.printf("Data de Nascimento (ex: 02/12/2020): \n");
                            dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

                            System.out.printf("CPF:\n");
                            cpf = scanner.nextLine();

                            if (!funcionarioService.cpfFuncionarioCadastrado(funcionarioAdministrativoList, funcionarioManobristaList, funcionarioMotoristaList, cpf)) {

                                System.out.printf("Número CNH:\n");
                                numeroCNH = scanner.nextLine();

                                System.out.printf("Categoria CNH:\n");
                                categoriaCNH = scanner.nextLine();

                                System.out.printf("Data de Vencimento CNH:\n");
                                dataVencimentoCNH = LocalDate.parse(scanner.nextLine(), formatter);

                                funcionarioManobristaList.add(funcionarioService.cadastrarFuncionarioManobrista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH));
                            } else {
                                System.out.println("CPF já cadastrado, por gentileza informe outro CPF !");
                            }

                            ok = false;
                            break;
                        case 3:
                            System.out.printf("Nome:\n");
                            nome = scanner.nextLine();

                            System.out.printf("Data de Nascimento (ex: 02/12/2020): \n");
                            dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);

                            System.out.printf("CPF:\n");
                            cpf = scanner.nextLine();

                            if (!funcionarioService.cpfFuncionarioCadastrado(funcionarioAdministrativoList, funcionarioManobristaList, funcionarioMotoristaList, cpf)) {

                                System.out.printf("Número CNH:\n");
                                numeroCNH = scanner.nextLine();

                                System.out.printf("Categoria CNH:\n");
                                categoriaCNH = scanner.nextLine();

                                System.out.printf("Data de Vencimento CNH (ex: 02/12/2020):\n");
                                dataVencimentoCNH = LocalDate.parse(scanner.nextLine(), formatter);

                                System.out.printf("Possui curso para cargas perigosas? (S-Sim/N-Não):\n");
                                cursoCargasPerigosas = scanner.nextLine().equals("S") ? true : false;

                                System.out.printf("Possui curso para transporte de passageiros? (S-Sim/N-Não):\n");
                                cursoTransportePassageiros = scanner.nextLine().equals("S") ? true : false;

                                funcionarioMotoristaList.add(funcionarioService.cadastrarFuncionarioMotorista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH, cursoCargasPerigosas, cursoTransportePassageiros));
                            } else {
                                System.out.println("CPF já cadastrado, por gentileza informe outro CPF !");
                            }

                            ok = false;
                            break;
                    }
                    while (ok == true && select != 4) ;
                    break;
                case 2:
                    funcionarioService.buscarFuncionariosOrdemAlfabetica(funcionarioAdministrativoList, funcionarioManobristaList, funcionarioMotoristaList);
                    break;
                case 3:
                    System.out.printf("Digite o CPF desejado para busca:\n");
                    cpf = scanner.nextLine();

                    funcionarioService.buscarFuncionarioPorCpf(funcionarioAdministrativoList, funcionarioManobristaList, funcionarioMotoristaList, cpf);
                    break;
            }
        } while (select != 4);
    }

    public static void MenuVeiculos() {
        int select, anoFabricacao, numeroEixos, lotacaoMax;
        String placa, modelo;
        double peso, capacidadeCarga;
        boolean unidadeAcoplada;
        boolean ok = true;

        do {
            do {
                System.out.printf("\nMenu Veiculos\nDeseja:\n 1. Cadastrar Veiculos\n 2. Listar veículos em ordem de ano de fabricação\n 3. Buscar veículo por placa\n\n 4. Sair\n");
                select = scanner.nextInt();
                scanner.nextLine();
            } while (select < 1 || select > 5);

            switch (select) {
                case 1:
                    System.out.printf("\nQual o tipo de Veículo que você deseja cadastrar ?\n 1. Veículo de Passeio\n 2. Veículo de Transporte de Cargas\n 3. Veículo de Transporte de Passageiros\n\n 4. Sair\n");
                    select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select) {
                        case 1:
                            System.out.printf("Placa:\n");
                            placa = scanner.nextLine();

                            if (!veiculoService.placaVeiculoCadastrada(veiculoPasseioList, veiculoTransporteCargasList, veiculoTransportePassageirosList, placa)) {

                                System.out.printf("Modelo:\n");
                                modelo = scanner.nextLine();

                                System.out.printf("Ano de Fabricação:\n");
                                anoFabricacao = scanner.nextInt();

                                System.out.printf("Peso:\n");
                                peso = scanner.nextDouble();

                                veiculoPasseioList.add(veiculoService.cadastrarVeiculoPasseio(placa, modelo, anoFabricacao, peso));
                            } else {
                                System.out.println("Placa já cadastrada, por gentileza informe outra placa !");
                            }

                            ok = false;
                            break;
                        case 2:
                            System.out.printf("Placa:\n");
                            placa = scanner.nextLine();

                            if (!veiculoService.placaVeiculoCadastrada(veiculoPasseioList, veiculoTransporteCargasList, veiculoTransportePassageirosList, placa)) {
                                System.out.printf("Modelo:\n");
                                modelo = scanner.nextLine();

                                System.out.printf("Ano de Fabricação:\n");
                                anoFabricacao = scanner.nextInt();

                                System.out.printf("Peso:\n");
                                peso = scanner.nextDouble();

                                System.out.printf("Capacidade de Carga:\n");
                                capacidadeCarga = scanner.nextDouble();

                                System.out.printf("Número de Eixos:\n");
                                numeroEixos = scanner.nextInt();

                                scanner.nextLine();

                                System.out.printf("Possui unidade acoplada? (S-Sim/N-Não):\n");
                                unidadeAcoplada = scanner.nextLine().equals("S") ? true : false;

                                veiculoTransporteCargasList.add(veiculoService.cadastrarVeiculoTransporteCargas(placa, modelo, anoFabricacao, peso, capacidadeCarga, numeroEixos, unidadeAcoplada));
                            } else {
                                System.out.println("Placa já cadastrada, por gentileza informe outra placa !");
                            }

                            ok = false;
                            break;

                        case 3:
                            System.out.printf("Placa:\n");
                            placa = scanner.nextLine();

                            if (!veiculoService.placaVeiculoCadastrada(veiculoPasseioList, veiculoTransporteCargasList, veiculoTransportePassageirosList, placa)) {

                                System.out.printf("Modelo:\n");
                                modelo = scanner.nextLine();

                                System.out.printf("Ano de Fabricação:\n");
                                anoFabricacao = scanner.nextInt();

                                System.out.printf("Peso:\n");
                                peso = scanner.nextDouble();

                                System.out.printf("Lotacação Máxima (Informar somente 15, 26 ou 46):\n");
                                lotacaoMax = scanner.nextInt();

                                VeiculoTransportePassageiros veiculoTransportePassageiros = veiculoService.cadastrarVeiculoTransportePassageiros(placa, modelo, anoFabricacao, peso, lotacaoMax);

                                if (veiculoTransportePassageiros != null) {
                                    veiculoTransportePassageirosList.add(veiculoTransportePassageiros);
                                } else {
                                    System.out.println("Quantidade de Lotação Máxima inválida. Por gentileza Informar somente 15, 26 ou 46");
                                }
                            } else {
                                System.out.println("Placa já cadastrada, por gentileza informe outra placa !");
                            }

                            ok = false;
                            break;
                    }
                    while (ok == true) ;
                    break;
                case 2:
                    veiculoService.buscarVeiculosOrdemFabricacao(veiculoPasseioList, veiculoTransporteCargasList, veiculoTransportePassageirosList);
                    break;
                case 3:
                    System.out.printf("Digite a placa desejada para busca:\n");
                    placa = scanner.nextLine();

                    veiculoService.buscarVeiculoPorPlaca(veiculoPasseioList, veiculoTransporteCargasList, veiculoTransportePassageirosList, placa);
                    break;
            }
        } while (select != 4);
    }
}
