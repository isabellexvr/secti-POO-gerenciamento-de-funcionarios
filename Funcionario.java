public class Funcionario {
    //add: horario de entrada e saida
    //
    private String nome, cpf, matricula;
    private double salario;
    private Departamento departamento;

    Funcionario(String nome, String cpf, String matricula, double salario, Departamento departamento){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.salario = salario;
        this.departamento = departamento;
    }

    protected void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    protected double getSalario() {
        return salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }


}
