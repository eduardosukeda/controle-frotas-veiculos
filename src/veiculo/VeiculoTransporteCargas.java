package veiculo;

public class VeiculoTransporteCargas {

    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double peso;
    private double capacidadeCarga;
    private int numeroEixos;
    private boolean unidadeAcoplada;

    public VeiculoTransporteCargas() {
    }

    public VeiculoTransporteCargas(String placa, String modelo, int anoFabricacao, double peso, double capacidadeCarga, int numeroEixos, boolean unidadeAcoplada) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.peso = peso;
        this.capacidadeCarga = capacidadeCarga;
        this.numeroEixos = numeroEixos;
        this.unidadeAcoplada = unidadeAcoplada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    public boolean isUnidadeAcoplada() {
        return unidadeAcoplada;
    }

    public void setUnidadeAcoplada(boolean unidadeAcoplada) {
        this.unidadeAcoplada = unidadeAcoplada;
    }
}
