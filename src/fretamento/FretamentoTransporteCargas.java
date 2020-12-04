package fretamento;

import funcionario.FuncionarioMotorista;
import veiculo.VeiculoTransporteCargas;

import java.time.LocalDate;

public class FretamentoTransporteCargas {

    private int id;
    private VeiculoTransporteCargas veiculoTransporteCargas;
    private FuncionarioMotorista funcionarioMotorista;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double distanciaPercorridaKM;
    private boolean cargaPerigosa;
    private double valorCobrado;

    public FretamentoTransporteCargas() {
    }

    public FretamentoTransporteCargas(int id, VeiculoTransporteCargas veiculoTransporteCargas, FuncionarioMotorista funcionarioMotorista, LocalDate dataInicio, LocalDate dataTermino, double distanciaPercorridaKM, boolean cargaPerigosa, double valorCobrado) {
        this.id = id;
        this.veiculoTransporteCargas = veiculoTransporteCargas;
        this.funcionarioMotorista = funcionarioMotorista;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.distanciaPercorridaKM = distanciaPercorridaKM;
        this.cargaPerigosa = cargaPerigosa;
        this.valorCobrado = valorCobrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VeiculoTransporteCargas getVeiculoTransporteCargas() {
        return veiculoTransporteCargas;
    }

    public void setVeiculoTransporteCargas(VeiculoTransporteCargas veiculoTransporteCargas) {
        this.veiculoTransporteCargas = veiculoTransporteCargas;
    }

    public FuncionarioMotorista getFuncionarioMotorista() {
        return funcionarioMotorista;
    }

    public void setFuncionarioMotorista(FuncionarioMotorista funcionarioMotorista) {
        this.funcionarioMotorista = funcionarioMotorista;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getDistanciaPercorridaKM() {
        return distanciaPercorridaKM;
    }

    public void setDistanciaPercorridaKM(double distanciaPercorridaKM) {
        this.distanciaPercorridaKM = distanciaPercorridaKM;
    }

    public boolean isCargaPerigosa() {
        return cargaPerigosa;
    }

    public void setCargaPerigosa(boolean cargaPerigosa) {
        this.cargaPerigosa = cargaPerigosa;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }
}
