package fretamento;

import funcionario.FuncionarioMotorista;
import veiculo.VeiculoTransportePassageiros;

import java.util.Date;

public class FretamentoTransportePassageiros {

    private int id;
    private VeiculoTransportePassageiros veiculoTransportePassageiros;
    private FuncionarioMotorista funcionarioMotorista;
    private Date dataInicio;
    private Date dataTermino;
    private double distanciaPercorridaKM;
    private double valorCobrado;

    public FretamentoTransportePassageiros() {
    }

    public FretamentoTransportePassageiros(int id, VeiculoTransportePassageiros veiculoTransportePassageiros, FuncionarioMotorista funcionarioMotorista, Date dataInicio, Date dataTermino, double distanciaPercorridaKM, double valorCobrado) {
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
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
}
