public class Funcionario {
    //add: horario de entrada e saida
    //
    String nome, cpf, matricula;
    double salario;
    Departamento departamento;

    public void setDepartamento(Departamento departamento) {
        // Realize qualquer validação necessária
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }
}
