import java.util.List;

public class Departamento {
    private String nome;
    private List<Funcionario> funcionarios;

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
}
