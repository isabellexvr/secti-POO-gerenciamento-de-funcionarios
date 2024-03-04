import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Funcionario {
    private String nome, cpf, matricula;
    private double salario;
    private Departamento departamento;
    private Cargo cargo;

    private Date dataCadastro, dataDemissao;

    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    //dicionario:
    private static Map<String, Integer> matriculasCount = new HashMap<>();

    Funcionario(String nome, String cpf, double salario, Departamento departamento, Cargo cargo, Date dataCadastro) throws ParseException {

        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
        this.matricula = generateMatricula();

        if(dataCadastro == null){
            //Date data = new Date();
            this.dataCadastro = new Date();
        }else{
            this.dataCadastro = dataCadastro;
        }

        this.dataDemissao = null;
    }

    public static void popularFuncionarios() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        ArrayList<Cargo> cargos = new ArrayList<>();
        cargos = Cargo.getAllCargos();

        ArrayList<Cargo> cargosRH = new ArrayList<>();
        cargosRH = Cargo.getCargosByDep("RH", cargos);

        ArrayList<Cargo> cargosTI = new ArrayList<>();
        cargosTI = Cargo.getCargosByDep("TI", cargos);

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


        Funcionario fulana = new Funcionario("Fulana Sicrana", "123123123123",  2000.0, Departamento.getDepByName("RH"), cargosRH.get(0), formatter.parse("20/12/2015"));
        Funcionario judite = new Funcionario("Judite Justa", "12345678901", 1890.0, Departamento.getDepByName("RH"), cargosRH.get(1), formatter.parse("10/01/2015"));

        Funcionario joao = new Funcionario("João Silva", "98765432109",  2500.0, Departamento.getDepByName("TI"), cargosTI.get(0), formatter.parse("10/02/2013"));
        Funcionario maria = new Funcionario("Maria Santos", "13579246801",  2200.0, Departamento.getDepByName("TI"), cargosTI.get(1), formatter.parse("05/08/2014"));

        Funcionario carlos = new Funcionario("Carlos Oliveira", "45678912345",  3000.0, Departamento.getDepByName("Gerência"), cargosGer.get(0), formatter.parse("26/04/2013"));
        Funcionario ana = new Funcionario("Ana Pereira", "32165498701",  2800.0, Departamento.getDepByName("Gerência"), cargosGer.get(1), formatter.parse("15/11/2015"));

        Funcionario pedro = new Funcionario("Pedro Souza", "65432198765",  2300.0, Departamento.getDepByName("Marketing"), cargosMark.get(0), formatter.parse("14/10/2015"));
        Funcionario lucia = new Funcionario("Lúcia Mendes", "14725836901",  2100.0, Departamento.getDepByName("Marketing"), cargosMark.get(1), formatter.parse("08/09/2014"));

        Funcionario andre = new Funcionario("André Costa", "78912345632",  2700.0, Departamento.getDepByName("Financeiro"), cargosFin.get(0), formatter.parse("01/02/2015"));
        Funcionario julia = new Funcionario("Júlia Almeida", "36925814701",  2400.0, Departamento.getDepByName("Financeiro"), cargosFin.get(1), formatter.parse("01/02/2015"));

        Funcionario antonio = new Funcionario("Antônio Santos", "85296374103",  2600.0, Departamento.getDepByName("Operações"), cargosOp.get(0), formatter.parse("20/02/2019"));
        Funcionario luiza = new Funcionario("Luíza Oliveira", "15975346801",  2250.0, Departamento.getDepByName("Operações"), cargosOp.get(1), formatter.parse("01/12/2018"));

        Funcionario gabriel = new Funcionario("Gabriel Costa", "25814736902",  2000.0, Departamento.getDepByName("Suporte ao Cliente"), cargosSup.get(0), formatter.parse("22/03/2013"));
        Funcionario laura = new Funcionario("Laura Martins", "98765412306", 1900.0, Departamento.getDepByName("Suporte ao Cliente"), cargosSup.get(1), formatter.parse("26/04/2015"));

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
    private String formatarData(Date data) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        return formatter.format(data);
    }
    public String getDataCadastro() {
        return formatarData(dataCadastro);
    }

    public String getDataDemissao() {
        return formatarData(dataDemissao);
    }



    public String getMatricula() {
        return matricula;
    }

    private String generateMatricula() {
        String departamentoNome = departamento.getNome();
        String departamentoPrefixo = departamentoNome.substring(0, Math.min(departamentoNome.length(), 2));
        matriculasCount.putIfAbsent(departamentoPrefixo, 0);
        int count = matriculasCount.get(departamentoPrefixo) + 1;
        matriculasCount.put(departamentoPrefixo, count);
        return departamentoPrefixo + String.format("%03d", count);
    }

    public static void addNewFuncionario(Funcionario newFunc){
        funcionarios.add(newFunc);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
