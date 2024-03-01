import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    static ArrayList<Admin> admins = new ArrayList<>(Arrays.asList());

    public static void main(String[] args) {

        Departamento.popularDepartamentos();
        Scanner input = new Scanner(System.in);


        System.out.println("- Seja bem-vindo(a) ao\n");
        System.out.println("\t  ***  ***  ***  ***  ***  ***  ***  ***  ***  ***");
        System.out.println("\t* Sistema de Gerenciamento de Funcionários Oxetech *");

        System.out.println("\t  ***  ***  ***  ***  ***  ***  ***  ***  ***  ***\n");
        //cadastro do novo usuário do sistema:
        System.out.println("Insira o seu nome:");
        String adminName = input.nextLine();

        System.out.println("- Insira o índice corresponde ao seu departamento:");
        listarDepartamentos();
        int depIndex = input.nextInt();
        input.nextLine();

        Departamento depAnswer = Departamento.getDepartamentoByIndex(depIndex-1);
        //tenta verificar se o usuário está apto a ser um usuário do sistema (administrador do gerenciador de funcionários)
        try{
            Admin newAdmin = new Admin(adminName, "000000000000", "a0001", 0.00, depAnswer);
        }catch(IllegalArgumentException err){
            //se não for, o cadastro falha (falha de autorização)
        }



    }

    public static void listarDepartamentos(){
        ArrayList<Departamento> deps = new ArrayList<>();
        deps = Departamento.getDepartamentos();

        for (int i = 0; i < deps.size(); i++) {
            System.out.println(i + 1 + ". " + deps.get(i).getNome());
        }
    }


}
