package veiculo.service;

import veiculo.VeiculoPasseio;
import veiculo.VeiculoTransporteCargas;
import veiculo.VeiculoTransportePassageiros;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VeiculoService {

    public VeiculoPasseio cadastrarVeiculoPasseio(String placa, String modelo, int anoFabricacao, double peso) {
        return new VeiculoPasseio(placa, modelo, anoFabricacao, peso);
    }

    public VeiculoTransporteCargas cadastrarVeiculoTransporteCargas(String placa, String modelo, int anoFabricacao, double peso, double capacidadeCarga, int numeroEixos, boolean unidadeAcoplada) {
        return new VeiculoTransporteCargas(placa, modelo, anoFabricacao, peso, capacidadeCarga, numeroEixos, unidadeAcoplada);
    }

    public VeiculoTransportePassageiros cadastrarVeiculoTransportePassageiros(String placa, String modelo, int anoFabricacao, double peso, int lotacaoMax) {

        if (lotacaoMax == 15 || lotacaoMax == 26 || lotacaoMax == 46) {
            return new VeiculoTransportePassageiros(placa, modelo, anoFabricacao, peso, lotacaoMax);
        } else {
            return null;
        }
    }

    public void buscarVeiculosOrdemFabricacao(List<VeiculoPasseio> veiculoPasseioList, List<VeiculoTransporteCargas> veiculoTransporteCargasList, List<VeiculoTransportePassageiros> veiculoTransportePassageirosList) {

        if (veiculoPasseioList != null && veiculoPasseioList.size() > 0) {
            Collections.sort(veiculoPasseioList, new Comparator<VeiculoPasseio>() {
                @Override
                public int compare(VeiculoPasseio o1, VeiculoPasseio o2) {
                    return o1.getAnoFabricacao() < o2.getAnoFabricacao() ? -1 : (o1.getAnoFabricacao() > o2.getAnoFabricacao() ? +1 : 0);
                }
            });

            System.out.println("\n-- Veiculos de Passeio --");
            for (VeiculoPasseio veiculoPasseio : veiculoPasseioList) {
                System.out.println("\nPlaca: " + veiculoPasseio.getPlaca());
                System.out.println("Modelo: " + veiculoPasseio.getModelo());
                System.out.println("Ano de Fabricação: " + veiculoPasseio.getAnoFabricacao());
                System.out.println("Peso: " + veiculoPasseio.getPeso());
            }
        }

        if (veiculoTransporteCargasList != null && veiculoTransporteCargasList.size() > 0) {
            Collections.sort(veiculoTransporteCargasList, new Comparator<VeiculoTransporteCargas>() {
                @Override
                public int compare(VeiculoTransporteCargas o1, VeiculoTransporteCargas o2) {
                    return o1.getAnoFabricacao() < o2.getAnoFabricacao() ? -1 : (o1.getAnoFabricacao() > o2.getAnoFabricacao() ? +1 : 0);
                }
            });

            System.out.println("\n-- Veiculos de Transporte de Cargas --");
            for (VeiculoTransporteCargas veiculoTransporteCargas : veiculoTransporteCargasList) {
                System.out.println("\nPlaca: " + veiculoTransporteCargas.getPlaca());
                System.out.println("Modelo: " + veiculoTransporteCargas.getModelo());
                System.out.println("Ano de Fabricação: " + veiculoTransporteCargas.getAnoFabricacao());
                System.out.println("Peso: " + veiculoTransporteCargas.getPeso());
                System.out.println("Capacidade de Carga: " + veiculoTransporteCargas.getCapacidadeCarga());
                System.out.println("Número de Eixos: " + veiculoTransporteCargas.getNumeroEixos());
                System.out.println("Unidade Acoplada: " + (veiculoTransporteCargas.isUnidadeAcoplada() == true ? "Sim" : "Não"));
            }
        }

        if (veiculoTransportePassageirosList != null && veiculoTransportePassageirosList.size() > 0) {
            Collections.sort(veiculoTransportePassageirosList, new Comparator<VeiculoTransportePassageiros>() {
                @Override
                public int compare(VeiculoTransportePassageiros o1, VeiculoTransportePassageiros o2) {
                    return o1.getAnoFabricacao() < o2.getAnoFabricacao() ? -1 : (o1.getAnoFabricacao() > o2.getAnoFabricacao() ? +1 : 0);
                }
            });

            System.out.println("\n-- Veiculos de Transporte de Passageiros --");
            for (VeiculoTransportePassageiros veiculoTransportePassageiros : veiculoTransportePassageirosList) {
                System.out.println("\nPlaca: " + veiculoTransportePassageiros.getPlaca());
                System.out.println("Modelo: " + veiculoTransportePassageiros.getModelo());
                System.out.println("Ano de Fabricação: " + veiculoTransportePassageiros.getAnoFabricacao());
                System.out.println("Peso: " + veiculoTransportePassageiros.getPeso());
                System.out.println("Lotação Máxima: " + veiculoTransportePassageiros.getLotacaoMax());
            }
        }
    }

    public void buscarVeiculoPorPlaca(List<VeiculoPasseio> veiculoPasseioList, List<VeiculoTransporteCargas> veiculoTransporteCargasList, List<VeiculoTransportePassageiros> veiculoTransportePassageirosList, String placa) {

        System.out.println("\n-- Busca Veículo por placa --");

        if (veiculoPasseioList != null && veiculoPasseioList.size() > 0) {
            System.out.println("\n-- Veiculos de Passeio --");
            for (VeiculoPasseio veiculoPasseio : veiculoPasseioList) {
                if (veiculoPasseio.getPlaca().equals(placa)) {
                    System.out.println("\nPlaca: " + veiculoPasseio.getPlaca());
                    System.out.println("Modelo: " + veiculoPasseio.getModelo());
                    System.out.println("Ano de Fabricação: " + veiculoPasseio.getAnoFabricacao());
                    System.out.println("Peso: " + veiculoPasseio.getPeso());
                }
            }
        }

        if (veiculoTransporteCargasList != null && veiculoTransporteCargasList.size() > 0) {
            System.out.println("\n-- Veiculos de Transporte de Cargas --");
            for (VeiculoTransporteCargas veiculoTransporteCargas : veiculoTransporteCargasList) {
                if (veiculoTransporteCargas.getPlaca().equals(placa)) {
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

        if (veiculoTransportePassageirosList != null && veiculoTransportePassageirosList.size() > 0) {
            System.out.println("\n-- Veiculos de Transporte de Passageiros --");
            for (VeiculoTransportePassageiros veiculoTransportePassageiros : veiculoTransportePassageirosList) {
                if (veiculoTransportePassageiros.getPlaca().equals(placa)) {
                    System.out.println("\nPlaca: " + veiculoTransportePassageiros.getPlaca());
                    System.out.println("Modelo: " + veiculoTransportePassageiros.getModelo());
                    System.out.println("Ano de Fabricação: " + veiculoTransportePassageiros.getAnoFabricacao());
                    System.out.println("Peso: " + veiculoTransportePassageiros.getPeso());
                    System.out.println("Lotação Máxima: " + veiculoTransportePassageiros.getLotacaoMax());
                }
            }
        }
    }

    public boolean placaVeiculoCadastrada(List<VeiculoPasseio> veiculoPasseioList, List<VeiculoTransporteCargas> veiculoTransporteCargasList, List<VeiculoTransportePassageiros> veiculoTransportePassageirosList, String placa) {

        if (veiculoPasseioList != null && veiculoPasseioList.size() > 0) {
            for (VeiculoPasseio veiculoPasseio : veiculoPasseioList) {
                if (veiculoPasseio.getPlaca().equals(placa)) {
                    return true;
                }
            }
        }

        if (veiculoTransporteCargasList != null && veiculoTransporteCargasList.size() > 0) {
            for (VeiculoTransporteCargas veiculoTransporteCargas : veiculoTransporteCargasList) {
                if (veiculoTransporteCargas.getPlaca().equals(placa)) {
                    return true;
                }
            }
        }

        if (veiculoTransportePassageirosList != null && veiculoTransportePassageirosList.size() > 0) {
            for (VeiculoTransportePassageiros veiculoTransportePassageiros : veiculoTransportePassageirosList) {
                if (veiculoTransportePassageiros.getPlaca().equals(placa)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean placaVeiculoTransporteCargaCadastrada(List<VeiculoTransporteCargas> veiculoTransporteCargasList, String placa) {


        if (veiculoTransporteCargasList != null && veiculoTransporteCargasList.size() > 0) {
            for (VeiculoTransporteCargas veiculoTransporteCargas : veiculoTransporteCargasList) {
                if (veiculoTransporteCargas.getPlaca().equals(placa)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean placaVeiculoTransportePassageiroCadastrada(List<VeiculoTransportePassageiros> veiculoTransportePassageirosList, String placa) {

        if (veiculoTransportePassageirosList != null && veiculoTransportePassageirosList.size() > 0) {
            for (VeiculoTransportePassageiros veiculoTransportePassageiros : veiculoTransportePassageirosList) {
                if (veiculoTransportePassageiros.getPlaca().equals(placa)) {
                    return true;
                }
            }
        }

        return false;
    }

    public VeiculoTransportePassageiros buscaVeiculoTransportePassageirosPorPlaca(List<VeiculoTransportePassageiros> veiculoTransportePassageirosList, String placa) {

        if (veiculoTransportePassageirosList != null && veiculoTransportePassageirosList.size() > 0) {
            for (VeiculoTransportePassageiros veiculoTransportePassageiros : veiculoTransportePassageirosList) {
                if (veiculoTransportePassageiros.getPlaca().equals(placa)) {
                    return veiculoTransportePassageiros;
                }
            }
        }

        return null;
    }

    public VeiculoTransporteCargas buscaVeiculoTransporteCargasPorPlaca(List<VeiculoTransporteCargas> veiculoTransporteCargasList, String placa) {

        if (veiculoTransporteCargasList != null && veiculoTransporteCargasList.size() > 0) {
            for (VeiculoTransporteCargas veiculoTransporteCargas : veiculoTransporteCargasList) {
                if (veiculoTransporteCargas.getPlaca().equals(placa)) {
                    return veiculoTransporteCargas;
                }
            }
        }

        return null;
    }
}
