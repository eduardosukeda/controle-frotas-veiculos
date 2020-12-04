package fretamento.service;

import fretamento.FretamentoTransporteCargas;
import fretamento.FretamentoTransportePassageiros;
import funcionario.FuncionarioAdministrativo;
import funcionario.FuncionarioMotorista;
import funcionario.service.FuncionarioService;
import veiculo.VeiculoTransporteCargas;
import veiculo.VeiculoTransportePassageiros;
import veiculo.service.VeiculoService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FretamentoService {

    private static FuncionarioService funcionarioService = new FuncionarioService();
    private static VeiculoService veiculoService = new VeiculoService();

    public FretamentoTransportePassageiros cadastrarFretamentoTransportePassageiros(List<FretamentoTransportePassageiros> fretamentoTransportePassageirosList, List<FuncionarioMotorista> funcionarioMotoristaList, List<VeiculoTransportePassageiros> veiculoTransportePassageirosList, String cpf, String placa, LocalDate dataInicio, LocalDate dataTermino, double distanciaPercorridaKM) {
        FuncionarioMotorista funcionarioMotorista = funcionarioService.buscaFuncionarioMotoristaPorCPF(funcionarioMotoristaList, cpf);
        VeiculoTransportePassageiros veiculoTransportePassageiros = veiculoService.buscaVeiculoTransportePassageirosPorPlaca(veiculoTransportePassageirosList, placa);

        long diarias = ChronoUnit.DAYS.between(dataInicio, dataTermino);
        int lotacaoMax = veiculoTransportePassageiros.getLotacaoMax();

        double valorCobrado = (diarias * valorDiaria(lotacaoMax) + (distanciaPercorridaKM * valorPorKm(lotacaoMax)));

        System.out.println((new FretamentoTransportePassageiros(proximoIdFretamentoTransportePassageiros(fretamentoTransportePassageirosList), veiculoTransportePassageiros, funcionarioMotorista, dataInicio, dataTermino, distanciaPercorridaKM, valorCobrado)).toString());

        return new FretamentoTransportePassageiros(proximoIdFretamentoTransportePassageiros(fretamentoTransportePassageirosList), veiculoTransportePassageiros, funcionarioMotorista, dataInicio, dataTermino, distanciaPercorridaKM, valorCobrado);
    }

    public FretamentoTransporteCargas cadastrarFretamentoTransporteCargas(List<FretamentoTransporteCargas> fretamentoTransporteCargasList, List<FuncionarioMotorista> funcionarioMotoristaList, List<VeiculoTransporteCargas> veiculoTransporteCargasList, String cpf, String placa, LocalDate dataInicio, LocalDate dataTermino, boolean cargaPerigosa, double distanciaPercorridaKM) {
        FuncionarioMotorista funcionarioMotorista = funcionarioService.buscaFuncionarioMotoristaPorCPF(funcionarioMotoristaList, cpf);
        VeiculoTransporteCargas veiculoTransporteCargas = veiculoService.buscaVeiculoTransporteCargasPorPlaca(veiculoTransporteCargasList, placa);

        int numeroEixos = veiculoTransporteCargas.getNumeroEixos();
        double valorCobrado;

        if (cargaPerigosa) {
            valorCobrado = (1.50 * numeroEixos * distanciaPercorridaKM);
        } else {
            valorCobrado = (1.20 * numeroEixos * distanciaPercorridaKM);
        }

        System.out.println(new FretamentoTransporteCargas(proximoIdFretamentoTransporteCargas(fretamentoTransporteCargasList), veiculoTransporteCargas, funcionarioMotorista, dataInicio, dataTermino, distanciaPercorridaKM, cargaPerigosa, valorCobrado));

        return new FretamentoTransporteCargas(proximoIdFretamentoTransporteCargas(fretamentoTransporteCargasList), veiculoTransporteCargas, funcionarioMotorista, dataInicio, dataTermino, distanciaPercorridaKM, cargaPerigosa, valorCobrado);
    }

    public void listaMotoristasLivres(List<FretamentoTransportePassageiros> fretamentoTransportePassageirosList, List<FretamentoTransporteCargas> fretamentoTransporteCargasList, List<FuncionarioMotorista> funcionarioMotoristaList) {
        System.out.println("\n-- Lista Motoristas Livres --");

        if (fretamentoTransportePassageirosList != null && fretamentoTransportePassageirosList.size() > 0) {
            for (FretamentoTransportePassageiros fretamentoTransportePassageiros : fretamentoTransportePassageirosList) {
                for (FuncionarioMotorista funcionarioMotorista : funcionarioMotoristaList) {
                    if (!fretamentoTransportePassageiros.getFuncionarioMotorista().getCpf().equals(funcionarioMotorista.getCpf())) {
                        System.out.println("\nNome: " + funcionarioMotorista.getNome());
                        System.out.println("Data de Nascimento: " + funcionarioMotorista.getDataNascimento());
                        System.out.println("CPF: " + funcionarioMotorista.getCpf());
                        System.out.println("Número CNH: " + funcionarioMotorista.getNumeroCNH());
                        System.out.println("Categoria CNH: " + funcionarioMotorista.getCategoriaCNH());
                        System.out.println("Data de Vencimento CNH: " + funcionarioMotorista.getDataVencimentoCNH());
                        System.out.println("Possui o curso de cargas perigosas ?: " + (funcionarioMotorista.isCursoCargasPerigosas() == true ? "Sim" : "Não"));
                        System.out.println("Possui o curso de transporte de passageiros ?: " + (funcionarioMotorista.isCursoTransportePassageiros() == true ? "Sim" : "Não"));
                    }
                }
            }
        }

        if (fretamentoTransporteCargasList != null && fretamentoTransporteCargasList.size() > 0) {
            for (FretamentoTransporteCargas fretamentoTransporteCargas : fretamentoTransporteCargasList) {
                for (FuncionarioMotorista funcionarioMotorista : funcionarioMotoristaList) {
                    if (!fretamentoTransporteCargas.getFuncionarioMotorista().getCpf().equals(funcionarioMotorista.getCpf())) {
                        System.out.println("\nNome: " + funcionarioMotorista.getNome());
                        System.out.println("Data de Nascimento: " + funcionarioMotorista.getDataNascimento());
                        System.out.println("CPF: " + funcionarioMotorista.getCpf());
                        System.out.println("Número CNH: " + funcionarioMotorista.getNumeroCNH());
                        System.out.println("Categoria CNH: " + funcionarioMotorista.getCategoriaCNH());
                        System.out.println("Data de Vencimento CNH: " + funcionarioMotorista.getDataVencimentoCNH());
                        System.out.println("Possui o curso de cargas perigosas ?: " + (funcionarioMotorista.isCursoCargasPerigosas() == true ? "Sim" : "Não"));
                        System.out.println("Possui o curso de transporte de passageiros ?: " + (funcionarioMotorista.isCursoTransportePassageiros() == true ? "Sim" : "Não"));
                    }
                }
            }
        }
    }

    public void listaVeiculosLivres(List<FretamentoTransportePassageiros> fretamentoTransportePassageirosList, List<FretamentoTransporteCargas> fretamentoTransporteCargasList, List<VeiculoTransporteCargas> veiculoTransporteCargasList, List<VeiculoTransportePassageiros> veiculoTransportePassageirosList) {
        System.out.println("\n-- Lista Veículos Livres --");

        if (fretamentoTransportePassageirosList != null && fretamentoTransportePassageirosList.size() > 0) {
            for (FretamentoTransportePassageiros fretamentoTransportePassageiros : fretamentoTransportePassageirosList) {
                for (VeiculoTransportePassageiros veiculoTransportePassageiros : veiculoTransportePassageirosList) {
                    if (!fretamentoTransportePassageiros.getVeiculoTransportePassageiros().getPlaca().equals(veiculoTransportePassageiros.getPlaca())) {
                        System.out.println("\nPlaca: " + veiculoTransportePassageiros.getPlaca());
                        System.out.println("Modelo: " + veiculoTransportePassageiros.getModelo());
                        System.out.println("Ano de Fabricação: " + veiculoTransportePassageiros.getAnoFabricacao());
                        System.out.println("Peso: " + veiculoTransportePassageiros.getPeso());
                        System.out.println("Lotação Máxima: " + veiculoTransportePassageiros.getLotacaoMax());
                    }
                }
            }
        }

        if (fretamentoTransporteCargasList != null && fretamentoTransporteCargasList.size() > 0) {
            for (FretamentoTransporteCargas fretamentoTransporteCargas : fretamentoTransporteCargasList) {
                for (VeiculoTransporteCargas veiculoTransporteCargas : veiculoTransporteCargasList) {
                    if (!fretamentoTransporteCargas.getVeiculoTransporteCargas().getPlaca().equals(veiculoTransporteCargas.getPlaca())) {
                        System.out.println("\nPlaca: " + veiculoTransporteCargas.getPlaca());
                        System.out.println("Modelo: " + veiculoTransporteCargas.getModelo());
                        System.out.println("Ano de Fabricação: " + veiculoTransporteCargas.getAnoFabricacao());
                        System.out.println("Peso: " + veiculoTransporteCargas.getPeso());
                        System.out.println("Capacidade de Carga: " + veiculoTransporteCargas.getCapacidadeCarga());
                        System.out.println("Número de Eixos: " + veiculoTransporteCargas.getNumeroEixos());
                        System.out.println("Unidade Acoplada: " + (veiculoTransporteCargas.isUnidadeAcoplada() == true ? "Sim" : "Não"));
                    }
                }
            }
        }
    }

    public void listaHistoricoFretamentos(List<FretamentoTransportePassageiros> fretamentoTransportePassageirosList, List<FretamentoTransporteCargas> fretamentoTransporteCargasList) {

        if (fretamentoTransportePassageirosList != null && fretamentoTransportePassageirosList.size() > 0) {

            System.out.println("\n-- Histórico de Fretamentos Veículos de Transporte de Passageiros --");
            for (FretamentoTransportePassageiros fretamentoTransportePassageiros : fretamentoTransportePassageirosList) {
                System.out.println("\nId: " + fretamentoTransportePassageiros.getId());
                System.out.println("Placa Veículo de Transporte de Passageiros: " + fretamentoTransportePassageiros.getVeiculoTransportePassageiros().getPlaca());
                System.out.println("CPF Funcionário Motorista: " + fretamentoTransportePassageiros.getFuncionarioMotorista().getCpf());
                System.out.println("Data Inicio: " + fretamentoTransportePassageiros.getDataInicio());
                System.out.println("Data Término: " + fretamentoTransportePassageiros.getDataTermino());
                System.out.println("Distância Percorrida em KM: " + fretamentoTransportePassageiros.getDistanciaPercorridaKM());
                System.out.println("Valor Cobrado: " + fretamentoTransportePassageiros.getValorCobrado());
            }
        }

        if (fretamentoTransporteCargasList != null && fretamentoTransporteCargasList.size() > 0) {

            System.out.println("\n-- Histórico de Fretamentos Veículos de Transporte de Cargas --");
            for (FretamentoTransporteCargas fretamentoTransporteCargas : fretamentoTransporteCargasList) {
                System.out.println("\nId: " + fretamentoTransporteCargas.getId());
                System.out.println("Placa Veículo de Transporte de Passageiros: " + fretamentoTransporteCargas.getVeiculoTransporteCargas().getPlaca());
                System.out.println("CPF Funcionário Motorista: " + fretamentoTransporteCargas.getFuncionarioMotorista().getCpf());
                System.out.println("Data Inicio: " + fretamentoTransporteCargas.getDataInicio());
                System.out.println("Data Término: " + fretamentoTransporteCargas.getDataTermino());
                System.out.println("Distância Percorrida em KM: " + fretamentoTransporteCargas.getDistanciaPercorridaKM());
                System.out.println("Carga Perigosa: " + (fretamentoTransporteCargas.isCargaPerigosa() == true ? "Sim" : "Não"));
                System.out.println("Valor Cobrado: " + fretamentoTransporteCargas.getValorCobrado());
            }
        }
    }

    public void listaTop5VeiculosMaisLucrativos(List<FretamentoTransportePassageiros> fretamentoTransportePassageirosList, List<FretamentoTransporteCargas> fretamentoTransporteCargasList) {
        System.out.println("\n-- TOP 5 Veículos mais lucrativos --");

        if (fretamentoTransportePassageirosList != null && fretamentoTransportePassageirosList.size() > 0) {
            System.out.println("\n-- TOP 5 Veículos mais lucrativos (Fretamento de Transporte de Passageiros) --");
            Collections.sort(fretamentoTransportePassageirosList, new Comparator<FretamentoTransportePassageiros>() {
                @Override
                public int compare(FretamentoTransportePassageiros o1, FretamentoTransportePassageiros o2) {
                    return o1.getValorCobrado() < o2.getValorCobrado() ? +1 : (o1.getValorCobrado() > o2.getValorCobrado() ? -1 : 0);
                }
            });

            for (int i = 0; i <= 4; i++) {
                if (fretamentoTransporteCargasList.get(i) != null) {
                    System.out.println("\nId: " + fretamentoTransportePassageirosList.get(i).getId());
                    System.out.println("Placa Veículo de Transporte de Passageiros: " + fretamentoTransportePassageirosList.get(i).getVeiculoTransportePassageiros().getPlaca());
                    System.out.println("CPF Funcionário Motorista: " + fretamentoTransportePassageirosList.get(i).getFuncionarioMotorista().getCpf());
                    System.out.println("Data Inicio: " + fretamentoTransportePassageirosList.get(i).getDataInicio());
                    System.out.println("Data Término: " + fretamentoTransportePassageirosList.get(i).getDataTermino());
                    System.out.println("Distância Percorrida em KM: " + fretamentoTransportePassageirosList.get(i).getDistanciaPercorridaKM());
                    System.out.println("Valor Cobrado: " + fretamentoTransportePassageirosList.get(i).getValorCobrado());
                }
            }
        }

        if (fretamentoTransporteCargasList != null && fretamentoTransporteCargasList.size() > 0) {
            System.out.println("\n-- TOP 5 Veículos mais lucrativos (Fretamento de Transporte de Cargas) --");
            Collections.sort(fretamentoTransporteCargasList, new Comparator<FretamentoTransporteCargas>() {
                @Override
                public int compare(FretamentoTransporteCargas o1, FretamentoTransporteCargas o2) {
                    return o1.getValorCobrado() < o2.getValorCobrado() ? +1 : (o1.getValorCobrado() > o2.getValorCobrado() ? -1 : 0);
                }
            });

            for (int i = 0; i <= 4; i++) {
                if (fretamentoTransporteCargasList.get(i) != null) {
                    System.out.println("\nId: " + fretamentoTransporteCargasList.get(i).getId());
                    System.out.println("Placa Veículo de Transporte de Passageiros: " + fretamentoTransporteCargasList.get(i).getVeiculoTransporteCargas().getPlaca());
                    System.out.println("CPF Funcionário Motorista: " + fretamentoTransporteCargasList.get(i).getFuncionarioMotorista().getCpf());
                    System.out.println("Data Inicio: " + fretamentoTransporteCargasList.get(i).getDataInicio());
                    System.out.println("Data Término: " + fretamentoTransporteCargasList.get(i).getDataTermino());
                    System.out.println("Distância Percorrida em KM: " + fretamentoTransporteCargasList.get(i).getDistanciaPercorridaKM());
                    System.out.println("Carga Perigosa: " + (fretamentoTransporteCargasList.get(i).isCargaPerigosa() == true ? "Sim" : "Não"));
                    System.out.println("Valor Cobrado: " + fretamentoTransporteCargasList.get(i).getValorCobrado());
                }
            }
        }
    }

    public int proximoIdFretamentoTransporteCargas(List<FretamentoTransporteCargas> fretamentoTransporteCargasList) {

        if (fretamentoTransporteCargasList != null && fretamentoTransporteCargasList.size() == 0)
            return 1;

        Collections.sort(fretamentoTransporteCargasList, new Comparator<FretamentoTransporteCargas>() {
            @Override
            public int compare(FretamentoTransporteCargas o1, FretamentoTransporteCargas o2) {
                return o1.getId() < o2.getId() ? +1 : (o1.getId() > o2.getId() ? -1 : 0);
            }
        });

        return fretamentoTransporteCargasList.get(0).getId() + 1;
    }

    public int proximoIdFretamentoTransportePassageiros(List<FretamentoTransportePassageiros> fretamentoTransportePassageirosList) {

        if (fretamentoTransportePassageirosList != null && fretamentoTransportePassageirosList.size() == 0)
            return 1;

        Collections.sort(fretamentoTransportePassageirosList, new Comparator<FretamentoTransportePassageiros>() {
            @Override
            public int compare(FretamentoTransportePassageiros o1, FretamentoTransportePassageiros o2) {
                return o1.getId() < o2.getId() ? +1 : (o1.getId() > o2.getId() ? -1 : 0);
            }
        });

        return fretamentoTransportePassageirosList.get(0).getId() + 1;
    }

    public boolean validaFuncionarioMotoristaParaVeiculoTransportePassageiros(FuncionarioMotorista funcionarioMotorista, VeiculoTransportePassageiros veiculoTransportePassageiros) {
        String categoriaCNH = funcionarioMotorista.getCategoriaCNH();
        boolean cursoTransportePassageiros = funcionarioMotorista.isCursoTransportePassageiros();
        double peso = veiculoTransportePassageiros.getPeso();
        int lotacaoMax = veiculoTransportePassageiros.getLotacaoMax();

        if (!cursoTransportePassageiros)
            return false;

        switch (categoriaCNH) {
            case "B":
                return false;
            case "C":
                if (peso <= 3.500)
                    return false;
                break;
            case "D":
                if (lotacaoMax <= 8)
                    return false;
                break;
            case "E":
                return false;

        }
        return true;
    }

    public boolean validaFuncionarioMotoristaParaVeiculoTransporteCarga(FuncionarioMotorista funcionarioMotorista, VeiculoTransporteCargas veiculoTransporteCargas) {
        String categoriaCNH = funcionarioMotorista.getCategoriaCNH();
        boolean cursoCargasPerigosas = funcionarioMotorista.isCursoCargasPerigosas();
        double peso = veiculoTransporteCargas.getPeso();
        boolean unidadeAcoplada = veiculoTransporteCargas.isUnidadeAcoplada();

        if (!cursoCargasPerigosas)
            return false;

        switch (categoriaCNH) {
            case "B":
                return false;
            case "C":
                if (peso <= 3.500)
                    return false;
                break;
            case "D":
                return false;
            case "E":
                if (!unidadeAcoplada && peso <= 6.000)
                    return false;
                break;
        }
        return true;
    }

    public double valorDiaria(int lotacaoMax) {

        switch (lotacaoMax) {
            case 15:
                return 410;
            case 26:
                return 490;
            case 46:
                return 560;
        }

        return 0;
    }

    public double valorPorKm(int lotacaoMax) {

        switch (lotacaoMax) {
            case 15:
                return 2.20;
            case 26:
                return 2.80;
            case 46:
                return 3;
            default:
        }

        return 0;
    }
}
