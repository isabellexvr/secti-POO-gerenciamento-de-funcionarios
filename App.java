import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {


        Departamento.popularDepartamentos();
        Cargo.popularCargos();
        Funcionario.popularFuncionarios();


        ArrayList<Departamento> departamentos = new ArrayList<>();
        departamentos = Departamento.getDepartamentos();

        ArrayList<Cargo> cargos = new ArrayList<>();
        cargos = Cargo.getAllCargos();

        System.out.println("tamanho de cargos: " + cargos.size());

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

                        ArrayList<Funcionario> funcs = Funcionario.getFuncionarios();


                        System.out.println("\nDepartamento de " + dep.getNome() + ":");
                        ArrayList<Funcionario> filteredFuncs = new ArrayList<>();

                        for (int j = 0; j < funcs.size(); j++) {
                            //System.out.println(funcs.get(j).getDepartamento().getNome());
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

                case 2:

                    listarDepartamentos(departamentos);

                    continuarOuSair(input);

                    break;

                case 3:
                    System.out.println("De qual departamento o funcionário fará parte?\n\t(insira o número correspondente ao departamento)");
                    listarDepartamentos(departamentos);
                    int depIndex = input.nextInt() - 1;

                    while (depIndex > departamentos.size()-1 || depIndex < 0){
                        System.out.println("Departamento não encontrado. Tente novamente.");
                        depIndex = input.nextInt() - 1;
                    }
                    input.nextLine();

                    String depName = Departamento.getDepartamentoByIndex(depIndex).getNome();

                    System.out.println("Qual será o cargo do novo funcionário na empresa?");

                    listarCargosFiltradosPorDep(depName, cargos);
                    int cargoIndex = input.nextInt();
                    input.nextLine();

                    System.out.println("Insira o nome do novo funcionário:");
                    String name = input.nextLine();

                    if (name.isBlank()) name = "Sem nome";

                    System.out.println("Insira o CPF do novo funcionário:");
                    String cpf = input.nextLine();

                    while (cpf.length() != 11){
                        System.out.println("O CPF deve ter 11 dígitos. Tente novamente.");
                        cpf = input.nextLine();
                    }

                    //matricula automaticamente computada
                    System.out.println("Insira o salário do novo funcionário:");
                    double salario = input.nextDouble();

                    while (salario < 1412){
                        System.out.println("Salário abaixo do salário mínimo. Tente novamente.");
                        salario = input.nextDouble();
                    }
                    input.nextLine();



                    break;


            }
        }



    }

    public static void listarDepartamentos(ArrayList<Departamento> deps){
        for (int i = 0; i < deps.size(); i++) {
            System.out.println(i + 1 + ". " + "Departamento de " + deps.get(i).getNome());
        }
    }

    public static void listarCargosDeps(String depName, ArrayList<Cargo> cargos ){

        for (int i = 0; i < cargos.size(); i++) {
            if(cargos.get(i) != null){
                System.out.println(i + 1 + ". " + "Cargo de " + cargos.get(i).getNome() + " do Departamento de " + cargos.get(i).getDepName());
            }

        }
    }

    public static void listarCargosFiltradosPorDep(String depName, ArrayList<Cargo> cargos){
        ArrayList<Cargo> filtered = new ArrayList<>();
        filtered =  Cargo.getCargosByDep(depName, cargos);
        for (int i = 0; i < filtered.size(); i++) {
            if(filtered.get(i) != null){
                System.out.println(i + 1 + ". " + "Cargo de " + filtered.get(i).getNome());
            }

        }
    }

    public static void exibirMenu() {

        System.out.println("\nMenu:");
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
