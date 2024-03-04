import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws ParseException {


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

                    System.out.println("\n Listando todos os funcionários da empresa...\n");

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
                            System.out.println("\t- Cargo: " + func.getCargo().getNome());
                            System.out.println("\t- Salario: " + func.getSalario());
                            System.out.println("\t- Data de cadastro: " + func.getDataCadastro());
                            if(func.getDataDemissao() != null){
                                System.out.println("\t- Data de demissao: " + func.getDataDemissao());
                            }
                        }
                    }

                    continuarOuSair(input);
                    break;

                case 2:
                    System.out.println("\n Listando todos os departamentos da empresa...\n");
                    listarDepartamentos(departamentos);

                    continuarOuSair(input);

                    break;

                case 3:
                    System.out.println("\n* Cadastro de Funcionário *\n");
                    System.out.println("De qual departamento o funcionário fará parte?\n(insira o número correspondente ao departamento)\n");
                    listarDepartamentos(departamentos);
                    int depIndex = input.nextInt() - 1;

                    while (depIndex > departamentos.size()-1 || depIndex < 0){
                        System.out.println("Departamento não encontrado. Tente novamente.");
                        depIndex = input.nextInt() - 1;
                    }
                    input.nextLine();

                    String depName = Departamento.getDepartamentoByIndex(depIndex).getNome();

                    System.out.println("\nQual será o cargo do novo funcionário na empresa?\n(insira o número correspondente ao departamento)\n");

                    listarCargosFiltradosPorDep(depName, cargos);
                    int cargoIndex = input.nextInt() - 1;
                    input.nextLine();

                    System.out.println("\nInsira o nome do novo funcionário:\n");
                    String name = input.nextLine();

                    if (name.isBlank()) name = "Sem nome";

                    System.out.println("\nInsira o CPF do novo funcionário:\n");
                    String cpf = input.nextLine();

                    while (cpf.length() != 11){
                        System.out.println("\nO CPF deve ter 11 dígitos. Tente novamente.\n");
                        cpf = input.nextLine();
                    }

                    //matricula automaticamente computada
                    System.out.println("\nInsira o salário do novo funcionário:\n");
                    double salario = input.nextDouble();

                    while (salario < 1412){
                        System.out.println("\nSalário abaixo do salário mínimo. Tente novamente.\n");
                        salario = input.nextDouble();
                    }
                    input.nextLine();

                    Funcionario newFunc = new Funcionario(name, cpf, salario, Departamento.getDepartamentoByIndex(depIndex), Cargo.getCargoByIndex(cargoIndex), null);
                    Funcionario.addNewFuncionario(newFunc);

                    System.out.println("\n* Funcionário cadastrado com sucesso! *\n");

                    break;

                case 4:
                    //deletar

                    System.out.println("\n* Demissão de funcionário *\n");

                    System.out.println("De qual departamento o funcionário faz parte?\n(insira o número correspondente ao departamento)\n");
                    listarDepartamentos(departamentos);
                    int depIndexDem = input.nextInt() - 1;

                    while (depIndexDem > departamentos.size()-1 || depIndexDem < 0){
                        System.out.println("Departamento não encontrado. Tente novamente.");
                        depIndexDem = input.nextInt() - 1;
                    }
                    input.nextLine();

                    System.out.println("Qual o índice do funcionário a ser demitido?\n(insira o número correspondente ao funcionário)\n");
                    listarFuncionariosPorDep(Departamento.getDepartamentoByIndex(depIndexDem));
                    int funcIndexDem = input.nextInt() - 1;
                    input.nextLine();

                    System.out.println("\nConfirma em remover o funcionário " + Funcionario.getFuncionarioByIndex(funcIndexDem).getNome() + "?");
                    System.out.println("1. Sim");
                    System.out.println("2. Não");

                    int confirmation = input.nextInt();
                    input.nextLine();

                    while (confirmation != 1 && confirmation != 2){
                        System.out.println("Opção incorreta. Tente novamente.");
                        confirmation = input.nextInt();
                    }

                    if(confirmation == 1){
                        Funcionario.removeFuncionario(Funcionario.getFuncionarioByIndex(funcIndexDem));
                        System.out.println("\nFuncionário removido com sucesso.\n");
                    }else{
                        System.out.println("\nCancelando operação...\n");
                    }
                    continuarOuSair(input);

                    break;

                case 5:
                    System.out.println("\n* Consulta de salário mensal de departamento *\n");
                    System.out.println("Selecione o departamento para consultar o salário mensal:\n(insira o número correspondente ao departamento)\n");
                    listarDepartamentos(departamentos);

                    int depIndexCons = input.nextInt() - 1;

                    while (depIndexCons > departamentos.size()-1 || depIndexCons < 0){
                        System.out.println("Departamento não encontrado. Tente novamente.");
                        depIndexCons = input.nextInt() - 1;
                    }
                    input.nextLine();

                    Departamento dep = Departamento.getDepartamentoByIndex(depIndexCons);

                    ArrayList<Funcionario> filteredFuncs = new ArrayList<>();
                    filteredFuncs = Funcionario.getFuncsByDep(dep);
                    double total = Departamento.calcularSalarioTotal(filteredFuncs);

                    System.out.println("\nO salário mensal total do departamento de " + dep.getNome() + " é: " + total + "\n");

                    continuarOuSair(input);

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

    public static void listarFuncionariosPorDep(Departamento departamento){
        System.out.println("oi");
        ArrayList<Funcionario> funcs = new ArrayList<>();
        System.out.println(funcs.size());
        funcs = Funcionario.getFuncsByDep(departamento);
        System.out.println(funcs.size());
        for (int i = 0; i < funcs.size(); i++) {
            Funcionario func = funcs.get(i);
            if(func.getDataDemissao() != null) continue;
            System.out.println(i + 1 + ". " + func.getNome() + ": ");
            System.out.println("\t- Código de Matrícula: " + func.getMatricula());
            System.out.println("\t- Cargo: " + func.getCargo().getNome());
            System.out.println("\t- Salario: " + func.getSalario());
            System.out.println("\t- Data de cadastro: " + func.getDataCadastro());

        }
    }

    public static void exibirMenu() {

        System.out.println("\nMenu:");
        System.out.println("(Insira um número para cada funcionalidade)");
        System.out.println("1. Listar todos os funcionários");
        System.out.println("2. Listar departamentos");
        System.out.println("3. Adicionar novo funcionário");
        System.out.println("4. Deletar funcionário");
        System.out.println("5. Consultar salário mensal por departamento");
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
                System.out.println("\nVoltando ao menu principal...\n");
                break;
            case 2:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Voltando ao menu principal...\n");
        }
    }

}
