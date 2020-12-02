package funcionario;

import java.time.LocalDate;

public class FuncionarioMotorista {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String numeroCNH;
    private String categoriaCNH;
    private LocalDate dataVencimentoCNH;
    private boolean cursoCargasPerigosas;
    private boolean cursoTransportePassageiros;


    public FuncionarioMotorista() {
    }

    public FuncionarioMotorista(String nome, LocalDate dataNascimento, String cpf, String numeroCNH, String categoriaCNH, LocalDate dataVencimentoCNH, boolean cursoCargasPerigosas, boolean cursoTransportePassageiros) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.numeroCNH = numeroCNH;
        this.categoriaCNH = categoriaCNH;
        this.dataVencimentoCNH = dataVencimentoCNH;
        this.cursoCargasPerigosas = cursoCargasPerigosas;
        this.cursoTransportePassageiros = cursoTransportePassageiros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public LocalDate getDataVencimentoCNH() {
        return dataVencimentoCNH;
    }

    public void setDataVencimentoCNH(LocalDate dataVencimentoCNH) {
        this.dataVencimentoCNH = dataVencimentoCNH;
    }

    public boolean isCursoCargasPerigosas() {
        return cursoCargasPerigosas;
    }

    public void setCursoCargasPerigosas(boolean cursoCargasPerigosas) {
        this.cursoCargasPerigosas = cursoCargasPerigosas;
    }

    public boolean isCursoTransportePassageiros() {
        return cursoTransportePassageiros;
    }

    public void setCursoTransportePassageiros(boolean cursoTransportePassageiros) {
        this.cursoTransportePassageiros = cursoTransportePassageiros;
    }

    @Override
    public String toString() {
        return "FuncionarioMotorista{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", numeroCNH='" + numeroCNH + '\'' +
                ", categoriaCNH='" + categoriaCNH + '\'' +
                ", dataVencimentoCNH=" + dataVencimentoCNH +
                ", cursoCargasPerigosas=" + cursoCargasPerigosas +
                ", cursoTransportePassageiros=" + cursoTransportePassageiros +
                '}';
    }
}
