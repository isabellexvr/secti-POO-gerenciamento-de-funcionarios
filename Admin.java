public class Admin extends Funcionario {
    // o admin é o usuário do sistema, que pode adicionar, deletar e atualizar informações acerca dos
    // funcionários e dos departamentos

    //adicionar novos funcionários, remover funcionários
    //que não fazem mais parte da empresa e atualizar informações como salário, cargo, etc.

    //apenas funcionarios de tecnologia da informaçao e gerentes podem ser admins

    public Admin(String nome, String cpf, String matricula, double salario, Departamento departamento) {
        super(nome, cpf, matricula, salario, departamento);

        if (!departamento.getNome().equals("T.I.") && !departamento.getNome().equals("Gerência")) {
            throw new IllegalArgumentException("A classe Admin só pode ser criada para o departamento de T.I. ou Gerência.");
        }
    }

    //

}
