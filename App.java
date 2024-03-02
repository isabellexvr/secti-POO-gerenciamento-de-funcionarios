import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Departamento.popularDepartamentos();

        ArrayList<Departamento> departamentos = new ArrayList<>();
        departamentos = Departamento.getDepartamentos();

        Scanner input = new Scanner(System.in);

        System.out.println("- Seja bem-vindo(a) ao\n");
        System.out.println("\t  ***  ***  ***  ***  ***  ***  ***  ***  ***  ***");
        System.out.println("\t* Sistema de Gerenciamento de Funcionários Oxetech *");

        System.out.println("\t  ***  ***  ***  ***  ***  ***  ***  ***  ***  ***\n");

        boolean exibirMenu = true;

        while (true){
            if (exibirMenu) {
                exibirMenu();
            }

            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:

                    for (int i = 0; i < departamentos.size(); i++) {
                        Departamento dep = departamentos.get(i);

                        ArrayList<Funcionario> funcs = dep.getFuncionarios();

                        System.out.println("\nDepartamento de " + dep.getNome() + ":");
                        ArrayList<Funcionario> filteredFuncs = new ArrayList<>();

                        for (int j = 0; j < funcs.size(); j++) {
                            if(funcs.get(j).getDepartamento().getNome().equals(dep.getNome())){
                                filteredFuncs.add(funcs.get(j));
                            }
                        }

                        for (int j = 0; j < filteredFuncs.size(); j++) {
                            Funcionario func = filteredFuncs.get(j);
                            System.out.println(j + 1 + ". " + func.getNome() + ": ");
                            System.out.println("\t- Código de Matrícula: " + func.getMatricula());
                            System.out.println("\t- Salario: " + func.getSalario());
                        }
                    }

                    continuarOuSair(input);
                    break;

            }
        }



    }

    public static void listarDepartamentos(ArrayList<Departamento> deps){
        for (int i = 0; i < deps.size(); i++) {
            System.out.println(i + 1 + ". " + deps.get(i).getNome());
        }
    }

    public static void exibirMenu() {

        System.out.println("Menu:");
        System.out.println("(Insira um número para cada funcionalidade)");
        System.out.println("1. Listar todos os funcionários");
        System.out.println("2. Listar departamentos");
        System.out.println("3. Adicionar novo funcionário");
        System.out.println("4. Deletar funcionário");
        System.out.println("5. Filtrar");
        System.out.println("6. Sair");
    }

    public static void continuarOuSair(Scanner input) {
        System.out.println("\n");
        System.out.println("1. Voltar ao menu principal");
        System.out.println("2. Sair do programa");

        int escolha = input.nextInt();
        input.nextLine();

        switch (escolha) {
            case 1:
                break;
            case 2:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Voltando ao menu principal.");
        }
    }

}
