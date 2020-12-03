package funcionario.service;

import funcionario.FuncionarioAdministrativo;
import funcionario.FuncionarioManobrista;
import funcionario.FuncionarioMotorista;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;

public class FuncionarioService {

    public FuncionarioAdministrativo cadastrarFuncionarioAdministrativo(String nome, LocalDate dataNascimento, String cpf) {
        return new FuncionarioAdministrativo(nome, dataNascimento, cpf);
    }

    public FuncionarioManobrista cadastrarFuncionarioManobrista(String nome, LocalDate dataNascimento, String cpf, String numeroCNH, String categoriaCNH, LocalDate dataVencimentoCNH) {
        return new FuncionarioManobrista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH);
    }

    public FuncionarioMotorista cadastrarFuncionarioMotorista(String nome, LocalDate dataNascimento, String cpf, String numeroCNH, String categoriaCNH, LocalDate dataVencimentoCNH, boolean cursoCargasPerigosas, boolean cursoTransportePassageiros) {
        return new FuncionarioMotorista(nome, dataNascimento, cpf, numeroCNH, categoriaCNH, dataVencimentoCNH, cursoCargasPerigosas, cursoTransportePassageiros);
    }

    public void buscarFuncionariosOrdemAlfabetica(List<FuncionarioAdministrativo> funcionarioAdministrativoList, List<FuncionarioManobrista> funcionarioManobristaList, List<FuncionarioMotorista> funcionarioMotoristaList) {

        if (funcionarioAdministrativoList != null && funcionarioAdministrativoList.size() > 0) {
            Collections.sort(funcionarioAdministrativoList, new Comparator<FuncionarioAdministrativo>() {
                @Override
                public int compare(FuncionarioAdministrativo o1, FuncionarioAdministrativo o2) {
                    Collator cot = Collator.getInstance(new Locale("pt", "BR"));
                    if (o1 != null)
                        return cot.compare(o1.getNome(), o2.getNome());
                    else
                        return 0;
                }
            });

            System.out.println("\n-- Funcionarios Administrativos --");
            for (FuncionarioAdministrativo funcionarioAdministrativo : funcionarioAdministrativoList) {
                System.out.println("\nNome: " + funcionarioAdministrativo.getNome());
                System.out.println("Data de Nascimento: " + funcionarioAdministrativo.getDataNascimento());
                System.out.println("CPF: " + funcionarioAdministrativo.getCpf());
            }
        }

        if (funcionarioManobristaList != null && funcionarioManobristaList.size() > 0) {
            Collections.sort(funcionarioManobristaList, new Comparator<FuncionarioManobrista>() {
                @Override
                public int compare(FuncionarioManobrista o1, FuncionarioManobrista o2) {
                    Collator cot = Collator.getInstance(new Locale("pt", "BR"));
                    if (o1 != null)
                        return cot.compare(o1.getNome(), o2.getNome());
                    else
                        return 0;
                }
            });

            System.out.println("\n-- Funcionarios Manobristas --");
            for (FuncionarioManobrista funcionarioManobrista : funcionarioManobristaList) {
                System.out.println("\nNome: " + funcionarioManobrista.getNome());
                System.out.println("Data de Nascimento: " + funcionarioManobrista.getDataNascimento());
                System.out.println("CPF: " + funcionarioManobrista.getCpf());
                System.out.println("Número CNH: " + funcionarioManobrista.getNumeroCNH());
                System.out.println("Categoria CNH: " + funcionarioManobrista.getCategoriaCNH());
                System.out.println("Data de Vencimento CNH: " + funcionarioManobrista.getDataVencimentoCNH());
            }
        }

        if (funcionarioMotoristaList != null && funcionarioMotoristaList.size() > 0) {
            Collections.sort(funcionarioMotoristaList, new Comparator<FuncionarioMotorista>() {
                @Override
                public int compare(FuncionarioMotorista o1, FuncionarioMotorista o2) {
                    Collator cot = Collator.getInstance(new Locale("pt", "BR"));
                    if (o1 != null)
                        return cot.compare(o1.getNome(), o2.getNome());
                    else
                        return 0;
                }
            });

            System.out.println("\n-- Funcionarios Motoristas --");
            for (FuncionarioMotorista funcionarioMotorista : funcionarioMotoristaList) {
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

    public void buscarFuncionarioPorCpf(List<FuncionarioAdministrativo> funcionarioAdministrativoList, List<FuncionarioManobrista> funcionarioManobristaList, List<FuncionarioMotorista> funcionarioMotoristaList, String cpf) {
        System.out.println("\n-- Busca Funcionário por CPF --");

        if (funcionarioAdministrativoList != null && funcionarioAdministrativoList.size() > 0) {
            for (FuncionarioAdministrativo funcionarioAdministrativo : funcionarioAdministrativoList) {
                if (funcionarioAdministrativo.getCpf().equals(cpf)) {
                    System.out.println("\nNome: " + funcionarioAdministrativo.getNome());
                    System.out.println("Data de Nascimento: " + funcionarioAdministrativo.getDataNascimento());
                    System.out.println("CPF: " + funcionarioAdministrativo.getCpf());
                }
            }
        }

        if (funcionarioManobristaList != null && funcionarioManobristaList.size() > 0) {
            for (FuncionarioManobrista funcionarioManobrista : funcionarioManobristaList) {
                if (funcionarioManobrista.getCpf().equals(cpf)) {
                    System.out.println("\nNome: " + funcionarioManobrista.getNome());
                    System.out.println("Data de Nascimento: " + funcionarioManobrista.getDataNascimento());
                    System.out.println("CPF: " + funcionarioManobrista.getCpf());
                    System.out.println("Número CNH: " + funcionarioManobrista.getNumeroCNH());
                    System.out.println("Categoria CNH: " + funcionarioManobrista.getCategoriaCNH());
                    System.out.println("Data de Vencimento CNH: " + funcionarioManobrista.getDataVencimentoCNH());
                }
            }
        }

        if (funcionarioMotoristaList != null && funcionarioMotoristaList.size() > 0) {
            for (FuncionarioMotorista funcionarioMotorista : funcionarioMotoristaList) {
                if (funcionarioMotorista.getCpf().equals(cpf)) {
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

    public boolean cpfFuncionarioCadastrado(List<FuncionarioAdministrativo> funcionarioAdministrativoList, List<FuncionarioManobrista> funcionarioManobristaList, List<FuncionarioMotorista> funcionarioMotoristaList, String cpf) {

        if (funcionarioAdministrativoList != null && funcionarioAdministrativoList.size() > 0) {
            for (FuncionarioAdministrativo funcionarioAdministrativo : funcionarioAdministrativoList) {
                if (funcionarioAdministrativo.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        if (funcionarioManobristaList != null && funcionarioManobristaList.size() > 0) {
            for (FuncionarioManobrista funcionarioManobrista : funcionarioManobristaList) {
                if (funcionarioManobrista.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        if (funcionarioMotoristaList != null && funcionarioMotoristaList.size() > 0) {
            for (FuncionarioMotorista funcionarioMotorista : funcionarioMotoristaList) {
                if (funcionarioMotorista.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        return false;
    }
}
