package veiculo;

public class VeiculoTransportePassageiros {

    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double peso;
    private int lotacaoMax;

    public VeiculoTransportePassageiros() {
    }

    public VeiculoTransportePassageiros(String placa, String modelo, int anoFabricacao, double peso, int lotacaoMax) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.peso = peso;
        this.lotacaoMax = lotacaoMax;
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

    public int getLotacaoMax() {
        return lotacaoMax;
    }

    public void setLotacaoMax(int lotacaoMax) {
        this.lotacaoMax = lotacaoMax;
    }
}
