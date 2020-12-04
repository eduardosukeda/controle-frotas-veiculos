import fretamento.FretamentoTransporteCargas;
import fretamento.FretamentoTransportePassageiros;
import fretamento.service.FretamentoService;
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
    private static FretamentoService fretamentoService = new FretamentoService();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private static List<FuncionarioAdministrativo> funcionarioAdministrativoList = new ArrayList<>();
    private static List<FuncionarioManobrista> funcionarioManobristaList = new ArrayList<>();
    private static List<FuncionarioMotorista> funcionarioMotoristaList = new ArrayList<>();
    private static List<VeiculoPasseio> veiculoPasseioList = new ArrayList<>();
    private static List<VeiculoTransporteCargas> veiculoTransporteCargasList = new ArrayList<>();
    private static List<VeiculoTransportePassageiros> veiculoTransportePassageirosList = new ArrayList<>();
    private static List<FretamentoTransportePassageiros> fretamentoTransportePassageirosList = new ArrayList<>();
    private static List<FretamentoTransporteCargas> fretamentoTransporteCargasList = new ArrayList<>();

    public static void main(String[] args) {
        MenuPrincipal();
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
                    MenuFretamento();
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

                                System.out.printf("Categoria CNH (B, C, D ou E):\n");
                                categoriaCNH = scanner.nextLine();

                                if (funcionarioService.validaCategoriaCNH(categoriaCNH)) {
                                    System.out.printf("Data de Vencimento CNH (ex: 02/12/2020):\n");
                                    dataVencimentoCNH = LocalDate.parse(scanner.nextLine(), formatter);

                                    funcionarioManobristaList.add(funcionarioService.cadastrarFuncionarioManobrista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH));
                                } else {
                                    System.out.println("Categoria CNH Inválida, por gentileza informe uma categoria válida (B, C, D ou E)");
                                }
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

                                System.out.printf("Categoria CNH (B, C, D ou E):\n");
                                categoriaCNH = scanner.nextLine();

                                if (funcionarioService.validaCategoriaCNH(categoriaCNH)) {

                                    System.out.printf("Data de Vencimento CNH (ex: 02/12/2020):\n");
                                    dataVencimentoCNH = LocalDate.parse(scanner.nextLine(), formatter);

                                    System.out.printf("Possui curso para cargas perigosas? (S-Sim/N-Não):\n");
                                    cursoCargasPerigosas = scanner.nextLine().equals("S") ? true : false;

                                    System.out.printf("Possui curso para transporte de passageiros? (S-Sim/N-Não):\n");
                                    cursoTransportePassageiros = scanner.nextLine().equals("S") ? true : false;

                                    funcionarioMotoristaList.add(funcionarioService.cadastrarFuncionarioMotorista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH, cursoCargasPerigosas, cursoTransportePassageiros));
                                } else {
                                    System.out.println("Categoria CNH Inválida, por gentileza informe uma categoria válida (B, C, D ou E)");
                                }
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

    public static void MenuFretamento() {
        int select;
        String cpf, placa;
        LocalDate dataInicio, dataTermino;
        double distanciaPercorridaKM;
        boolean cargaPerigosa;
        boolean ok = true;

        do {
            do {
                System.out.printf("\nMenu Fretamento\nDeseja:\n 1. Cadastrar Fretamento de veículo\n 2. Listar motoristas livres\n 3. Listar veículos livres \n 4. Listar histórico de fretamentos \n 5. Listar top 5 veículos mais lucrativos\n\n 6. Sair\n");
                ok = true;
                select = scanner.nextInt();
                scanner.nextLine();
            } while (select < 1 || select > 6);

            switch (select) {
                case 1:
                    System.out.printf("\nQual o tipo de Fretamento que você deseja cadastrar ?\n 1. Fretamento para Veículos de Passageiros\n 2. Fretamento para Veículos de Cargas\n\n 3. Sair\n");
                    select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select) {
                        case 1:
                            System.out.printf("CPF do condutor do veículo:\n");
                            cpf = scanner.nextLine();

                            if (funcionarioService.cpfFuncionariMotoristaCadastrado(funcionarioMotoristaList, cpf)) {

                                FuncionarioMotorista funcionarioMotorista = funcionarioService.buscaFuncionarioMotoristaPorCPF(funcionarioMotoristaList, cpf);

                                System.out.printf("Placa do veículo:\n");
                                placa = scanner.nextLine();
                                if (veiculoService.placaVeiculoTransportePassageiroCadastrada(veiculoTransportePassageirosList, placa)) {

                                    VeiculoTransportePassageiros veiculoTransportePassageiros = veiculoService.buscaVeiculoTransportePassageirosPorPlaca(veiculoTransportePassageirosList, placa);

                                    if (fretamentoService.validaFuncionarioMotoristaParaVeiculoTransportePassageiros(funcionarioMotorista, veiculoTransportePassageiros)) {
                                        System.out.printf("Data Inicio do Fretamento (ex: 02/12/2020):\n");
                                        dataInicio = LocalDate.parse(scanner.nextLine(), formatter);

                                        System.out.printf("Data Término do Fretamento (ex: 02/12/2020):\n");
                                        dataTermino = LocalDate.parse(scanner.nextLine(), formatter);

                                        System.out.printf("Distância percorrida em Quilômetros:\n");
                                        distanciaPercorridaKM = scanner.nextDouble();

                                        fretamentoTransportePassageirosList.add(fretamentoService.cadastrarFretamentoTransportePassageiros(fretamentoTransportePassageirosList, funcionarioMotoristaList, veiculoTransportePassageirosList, cpf, placa, dataInicio, dataTermino, distanciaPercorridaKM));
                                    } else {
                                        System.out.println("Motorista não está elegível para realizar este fretamento, pois sua categoria é " + funcionarioMotorista.getCategoriaCNH() + " onde difere da lei para este tipo veículo ou não realizou o curso de transporte de passageiro !");
                                    }
                                } else {
                                    System.out.println("Veículo não cadastrado, por gentileza cadastre o Veículo !");
                                }
                            } else {
                                System.out.println("CPF não cadastrado, por gentileza cadastre o Funcionário !");
                            }


                            ok = false;
                            break;

                        case 2:
                            System.out.printf("CPF do condutor do veículo:\n");
                            cpf = scanner.nextLine();

                            if (funcionarioService.cpfFuncionariMotoristaCadastrado(funcionarioMotoristaList, cpf)) {

                                FuncionarioMotorista funcionarioMotorista = funcionarioService.buscaFuncionarioMotoristaPorCPF(funcionarioMotoristaList, cpf);

                                System.out.printf("Placa do veículo:\n");
                                placa = scanner.nextLine();

                                if (veiculoService.placaVeiculoTransporteCargaCadastrada(veiculoTransporteCargasList, placa)) {

                                    VeiculoTransporteCargas veiculoTransporteCargas = veiculoService.buscaVeiculoTransporteCargasPorPlaca(veiculoTransporteCargasList, placa);

                                    if (fretamentoService.validaFuncionarioMotoristaParaVeiculoTransporteCarga(funcionarioMotorista, veiculoTransporteCargas)) {
                                        System.out.printf("Data Inicio do Fretamento (ex: 02/12/2020):\n");
                                        dataInicio = LocalDate.parse(scanner.nextLine(), formatter);

                                        System.out.printf("Data Término do Fretamento (ex: 02/12/2020):\n");
                                        dataTermino = LocalDate.parse(scanner.nextLine(), formatter);

                                        System.out.printf("Distância percorrida em Quilômetros:\n");
                                        distanciaPercorridaKM = scanner.nextDouble();

                                        scanner.nextLine();

                                        System.out.printf("Carga Perigosa? (S-Sim/N-Não):\n");
                                        cargaPerigosa = scanner.nextLine().equals("S") ? true : false;

                                        fretamentoTransporteCargasList.add(fretamentoService.cadastrarFretamentoTransporteCargas(fretamentoTransporteCargasList, funcionarioMotoristaList, veiculoTransporteCargasList, cpf, placa, dataInicio, dataTermino, cargaPerigosa, distanciaPercorridaKM));
                                    } else {
                                        System.out.println("Motorista não está elegível para realizar este fretamento, pois sua categoria é " + funcionarioMotorista.getCategoriaCNH() + " onde difere da lei para este tipo veículo ou não realizou o curso de transporte de carga");
                                    }
                                } else {
                                    System.out.println("Veículo não cadastrado, por gentileza cadastre o Veículo !");
                                }
                            } else {
                                System.out.println("CPF não cadastrado, por gentileza cadastre o Funcionário !");
                            }

                            ok = false;
                            break;
                    }
                    while (ok == true && select != 3) ;
                    break;
                case 2:
                    fretamentoService.listaMotoristasLivres(fretamentoTransportePassageirosList, fretamentoTransporteCargasList, funcionarioMotoristaList);
                    break;
                case 3:
                    fretamentoService.listaVeiculosLivres(fretamentoTransportePassageirosList, fretamentoTransporteCargasList, veiculoTransporteCargasList, veiculoTransportePassageirosList);
                    ;
                    break;
                case 4:
                    fretamentoService.listaHistoricoFretamentos(fretamentoTransportePassageirosList, fretamentoTransporteCargasList);
                    break;
                case 5:
                    fretamentoService.listaTop5VeiculosMaisLucrativos(fretamentoTransportePassageirosList, fretamentoTransporteCargasList);
                    break;
            }
        } while (select != 6);
    }
}
