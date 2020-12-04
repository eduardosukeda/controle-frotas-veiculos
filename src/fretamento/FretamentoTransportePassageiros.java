package fretamento;

import funcionario.FuncionarioMotorista;
import veiculo.VeiculoTransportePassageiros;

import java.time.LocalDate;

public class FretamentoTransportePassageiros {

    private int id;
    private VeiculoTransportePassageiros veiculoTransportePassageiros;
    private FuncionarioMotorista funcionarioMotorista;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double distanciaPercorridaKM;
    private double valorCobrado;

    public FretamentoTransportePassageiros() {
    }

    public FretamentoTransportePassageiros(int id, VeiculoTransportePassageiros veiculoTransportePassageiros, FuncionarioMotorista funcionarioMotorista, LocalDate dataInicio, LocalDate dataTermino, double distanciaPercorridaKM, double valorCobrado) {
        this.id = id;
        this.veiculoTransportePassageiros = veiculoTransportePassageiros;
        this.funcionarioMotorista = funcionarioMotorista;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.distanciaPercorridaKM = distanciaPercorridaKM;
        this.valorCobrado = valorCobrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VeiculoTransportePassageiros getVeiculoTransportePassageiros() {
        return veiculoTransportePassageiros;
    }

    public void setVeiculoTransportePassageiros(VeiculoTransportePassageiros veiculoTransportePassageiros) {
        this.veiculoTransportePassageiros = veiculoTransportePassageiros;
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

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    @Override
    public String toString() {
        return "FretamentoTransportePassageiros{" +
                "id=" + id +
                ", veiculoTransportePassageiros=" + veiculoTransportePassageiros +
                ", funcionarioMotorista=" + funcionarioMotorista +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", distanciaPercorridaKM=" + distanciaPercorridaKM +
                ", valorCobrado=" + valorCobrado +
                '}';
    }
}
