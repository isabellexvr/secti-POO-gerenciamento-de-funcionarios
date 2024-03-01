import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Funcionario> funcionarios;

    private static ArrayList<Departamento> departamentos = new ArrayList<>();


    Departamento(String nome){
        this.nome = nome;
    }

    public static void popularDepartamentos() {
        Departamento ti = new Departamento("T.I.");
        Departamento gerencia = new Departamento("Gerência");
        Departamento marketing = new Departamento("Marketing");
        Departamento RH = new Departamento("RH");
        Departamento financeiro = new Departamento("Financeiro");
        Departamento operacoes = new Departamento("Operações");
        Departamento suporte = new Departamento("Suporte ao Cliente");

        departamentos.add(ti);
        departamentos.add(gerencia);
        departamentos.add(marketing);
        departamentos.add(RH);
        departamentos.add(financeiro);
        departamentos.add(operacoes);
        departamentos.add(suporte);
    }

    public static ArrayList<Departamento> getDepartamentos(){
        return departamentos;
    }

    public static Departamento getDepartamentoByIndex(int index){
        departamentos.get(index);
    }

    public double calcularSalarioTotal() {
        double salarioTotal = 0.0;
        for (Funcionario funcionario : funcionarios) {
            salarioTotal += funcionario.getSalario();
        }
        return salarioTotal;
    }

    public void imprimirSalarioTotal() {
        double salarioTotal = calcularSalarioTotal();
        System.out.println("Salário total do departamento " + nome + ": R$" + salarioTotal);
    }

    public String getNome() {
        return nome;
    }
}
