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

        if(!cursoTransportePassageiros)
            return false;

        switch (categoriaCNH) {
            case "B":
                return false;
            case "C":
                if (peso <= 3.500)
                    return false;
            case "D":
                if (lotacaoMax <= 8)
                    return false;
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

        if(!cursoCargasPerigosas)
            return false;

        switch (categoriaCNH) {
            case "B":
                return false;
            case "C":
                if (peso <= 3.500)
                    return false;
            case "D":
                return false;
            case "E":
                if (!unidadeAcoplada && peso <= 6.000)
                    return false;
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
