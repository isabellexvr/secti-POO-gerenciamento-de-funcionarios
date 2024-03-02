import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Departamento {
    private String nome;
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

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

        Funcionario fulana = new Funcionario("Fulana Sicrana", "123123123123", "RH001", 2000.0, RH);
        Funcionario judite = new Funcionario("Judite Justa", "12345678901", "RH002", 1890.0, RH);

        Funcionario joao = new Funcionario("João Silva", "98765432109", "TI001", 2500.0, ti);
        Funcionario maria = new Funcionario("Maria Santos", "13579246801", "TI002", 2200.0, ti);

        Funcionario carlos = new Funcionario("Carlos Oliveira", "45678912345", "Ger001", 3000.0, gerencia);
        Funcionario ana = new Funcionario("Ana Pereira", "32165498701", "Ger002", 2800.0, gerencia);

        Funcionario pedro = new Funcionario("Pedro Souza", "65432198765", "Marketing001", 2300.0, marketing);
        Funcionario lucia = new Funcionario("Lúcia Mendes", "14725836901", "Marketing002", 2100.0, marketing);

        Funcionario andre = new Funcionario("André Costa", "78912345632", "Financeiro001", 2700.0, financeiro);
        Funcionario julia = new Funcionario("Júlia Almeida", "36925814701", "Financeiro002", 2400.0, financeiro);

        Funcionario antonio = new Funcionario("Antônio Santos", "85296374103", "Operacoes001", 2600.0, operacoes);
        Funcionario luiza = new Funcionario("Luíza Oliveira", "15975346801", "Operacoes002", 2250.0, operacoes);

        Funcionario gabriel = new Funcionario("Gabriel Costa", "25814736902", "Suporte001", 2000.0, suporte);
        Funcionario laura = new Funcionario("Laura Martins", "98765412306", "Suporte002", 1900.0, suporte);

        funcionarios.add(fulana);
        funcionarios.add(judite);
        funcionarios.add(joao);
        funcionarios.add(maria);
        funcionarios.add(carlos);
        funcionarios.add(ana);
        funcionarios.add(pedro);
        funcionarios.add(lucia);
        funcionarios.add(andre);
        funcionarios.add(julia);
        funcionarios.add(antonio);
        funcionarios.add(luiza);
        funcionarios.add(gabriel);
        funcionarios.add(laura);

    }

    public static ArrayList<Departamento> getDepartamentos(){
        return departamentos;
    }

    public static Departamento getDepartamentoByIndex(int index){
        return departamentos.get(index);
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

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
