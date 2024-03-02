import java.util.ArrayList;

public class Funcionario {
    //add: horario de entrada e saida
    //
    private String nome, cpf, matricula;
    private double salario;
    private Departamento departamento;
    private Cargo cargo;

    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();


    Funcionario(String nome, String cpf, String matricula, double salario, Departamento departamento, Cargo cargo){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;

    }

    public static void popularFuncionarios(){
        ArrayList<Cargo> cargos = new ArrayList<>();
        cargos = Cargo.getAllCargos();

        ArrayList<Cargo> cargosRH = new ArrayList<>();
        cargosRH = Cargo.getCargosByDep("RH", cargos);

        ArrayList<Cargo> cargosTI = new ArrayList<>();
        cargosTI = Cargo.getCargosByDep("T.I.", cargos);

        ArrayList<Cargo> cargosFin = new ArrayList<>();
        cargosFin = Cargo.getCargosByDep("Financeiro", cargos);

        ArrayList<Cargo> cargosOp = new ArrayList<>();
        cargosOp = Cargo.getCargosByDep("Operações", cargos);

        ArrayList<Cargo> cargosMark = new ArrayList<>();
        cargosMark = Cargo.getCargosByDep("Marketing", cargos);

        ArrayList<Cargo> cargosGer = new ArrayList<>();
        cargosGer = Cargo.getCargosByDep("Gerência", cargos);

        ArrayList<Cargo> cargosSup = new ArrayList<>();
        cargosSup = Cargo.getCargosByDep("Suporte ao Cliente", cargos);


        Funcionario fulana = new Funcionario("Fulana Sicrana", "123123123123", "RH001", 2000.0, Departamento.getDepByName("RH"), cargosRH.get(0));
        Funcionario judite = new Funcionario("Judite Justa", "12345678901", "RH002", 1890.0, Departamento.getDepByName("RH"), cargosRH.get(1));

        Funcionario joao = new Funcionario("João Silva", "98765432109", "TI001", 2500.0, Departamento.getDepByName("T.I."), cargosTI.get(0));
        Funcionario maria = new Funcionario("Maria Santos", "13579246801", "TI002", 2200.0, Departamento.getDepByName("T.I."), cargosTI.get(1));

        Funcionario carlos = new Funcionario("Carlos Oliveira", "45678912345", "Ger001", 3000.0, Departamento.getDepByName("Gerência"), cargosGer.get(0));
        Funcionario ana = new Funcionario("Ana Pereira", "32165498701", "Ger002", 2800.0, Departamento.getDepByName("Gerência"), cargosGer.get(1));

        Funcionario pedro = new Funcionario("Pedro Souza", "65432198765", "Marketing001", 2300.0, Departamento.getDepByName("Marketing"), cargosMark.get(0));
        Funcionario lucia = new Funcionario("Lúcia Mendes", "14725836901", "Marketing002", 2100.0, Departamento.getDepByName("Marketing"), cargosMark.get(1));

        Funcionario andre = new Funcionario("André Costa", "78912345632", "Financeiro001", 2700.0, Departamento.getDepByName("Financeiro"), cargosFin.get(0));
        Funcionario julia = new Funcionario("Júlia Almeida", "36925814701", "Financeiro002", 2400.0, Departamento.getDepByName("Financeiro"), cargosFin.get(1));

        Funcionario antonio = new Funcionario("Antônio Santos", "85296374103", "Operacoes001", 2600.0, Departamento.getDepByName("Operações"), cargosOp.get(0));
        Funcionario luiza = new Funcionario("Luíza Oliveira", "15975346801", "Operacoes002", 2250.0, Departamento.getDepByName("Operações"), cargosOp.get(1));

        Funcionario gabriel = new Funcionario("Gabriel Costa", "25814736902", "Suporte001", 2000.0, Departamento.getDepByName("Suporte ao Cliente"), cargosSup.get(0));
        Funcionario laura = new Funcionario("Laura Martins", "98765412306", "Suporte002", 1900.0, Departamento.getDepByName("Suporte ao Cliente"), cargosSup.get(1));

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

    protected void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    protected double getSalario() {
        return salario;
    }

    public String getNome(){
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }


    public Departamento getDepartamento() {
        return departamento;
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
