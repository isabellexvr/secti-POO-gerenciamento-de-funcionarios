import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Departamento {
    private String nome;

    private static ArrayList<Departamento> departamentos = new ArrayList<>();


    Departamento(String nome){
        this.nome = nome;
    }

    public static void popularDepartamentos() {
        Departamento ti = new Departamento("TI");
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
        return departamentos.get(index);
    }

    public static Departamento getDepByName(String name){
        Departamento result = null;
        for (int i = 0; i < departamentos.size(); i++) {
            if(departamentos.get(i).getNome().equals(name)){
                result = departamentos.get(i);
                break;
            }
        }
        return result;
    }

    public static double calcularSalarioTotal(ArrayList<Funcionario> funcionarios) {
        double salarioTotal = 0.0;
        for (Funcionario funcionario : funcionarios) {
            salarioTotal += funcionario.getSalario();
        }
        return salarioTotal;
    }

    public String getNome() {
        return nome;
    }

}
