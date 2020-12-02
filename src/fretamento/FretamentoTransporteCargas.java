package fretamento;

import funcionario.FuncionarioMotorista;
import veiculo.VeiculoTransporteCargas;

import java.util.Date;

public class FretamentoTransporteCargas {

    private int id;
    private VeiculoTransporteCargas veiculoTransporteCargas;
    private FuncionarioMotorista funcionarioMotorista;
    private Date dataInicio;
    private Date dataTermino;
    private double distanciaPercorridaKM;
    private boolean cargaPerigosa;
    private double valorCobrado;

    public FretamentoTransporteCargas() {
    }

    public FretamentoTransporteCargas(int id, VeiculoTransporteCargas veiculoTransporteCargas, FuncionarioMotorista funcionarioMotorista, Date dataInicio, Date dataTermino, double distanciaPercorridaKM, boolean cargaPerigosa, double valorCobrado) {
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
