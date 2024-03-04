import java.util.ArrayList;

public class Cargo {

    private String nome;
    private Departamento departamento;

    private static ArrayList<Cargo> cargos = new ArrayList<>();

    Cargo(String nome, Departamento departamento){
        this.nome = nome;
        this.departamento = departamento;
    }

    public static ArrayList<Cargo> getCargosByDep(String nomeDep, ArrayList<Cargo> cargos){
        ArrayList<Cargo> filtCargos = new ArrayList<>();

        for (int i = 0; i < cargos.size(); i++) {
            if(cargos.get(i).getDepName().equals(nomeDep)){
                filtCargos.add(cargos.get(i));
            }
        }
        return  filtCargos;
    }

    public String getNome() {
        return nome;
    }

    public String getDepName(){
        return departamento.getNome();
    }

    public static void popularCargos() {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        departamentos = Departamento.getDepartamentos();

        Departamento ti = Departamento.getDepByName("TI");
        Departamento ger = Departamento.getDepByName("Gerência");
        Departamento mark = Departamento.getDepByName("Marketing");
        Departamento rh = Departamento.getDepByName("RH");
        Departamento fin = Departamento.getDepByName("Financeiro");
        Departamento op = Departamento.getDepByName("Operações");
        Departamento sup = Departamento.getDepByName("Suporte ao Cliente");

        Cargo estagiarioFin = new Cargo("Estagiário", fin);
        Cargo controladorFin = new Cargo("Controlador Financeiro", fin);
        Cargo tesoureiroFin = new Cargo("Gerente de Tesouraria", fin);
        Cargo seniorFin = new Cargo("Analista Financeiro Sênior", fin);

        Cargo devJunior = new Cargo("Desenvolvedor de Software Júnior", ti);
        Cargo adminRede = new Cargo("Administrador de Rede", ti);
        Cargo analistaSeguranca = new Cargo("Analista de Segurança da Informação", ti);

        Cargo gerRH = new Cargo("Gerente de Recursos Humanos", ger);
        Cargo gerOperacoes = new Cargo("Gerente de Operações", ger);
        Cargo gerProjetos = new Cargo("Gerente de Projetos", ger);

        Cargo especialistaSocialMedia = new Cargo("Especialista em Mídias Sociais", mark);
        Cargo analistaPesquisaMercado = new Cargo("Analista de Pesquisa de Mercado", mark);
        Cargo gerProduto = new Cargo("Gerente de Produto", mark);

        Cargo analistaRH = new Cargo("Analista de Recursos Humanos", rh);
        Cargo treinamentoDesenvolvimento = new Cargo("Especialista em Treinamento e Desenvolvimento", rh);
        Cargo recrutamentoSelecao = new Cargo("Coordenador de Recrutamento e Seleção", rh);

        Cargo coordenadorOperacoes = new Cargo("Coordenador de Operações", op);
        Cargo especialistaLogistica = new Cargo("Especialista em Logística", op);
        Cargo analistaProcessos = new Cargo("Analista de Processos Operacionais", op);

        Cargo representanteAtendimento = new Cargo("Representante de Atendimento ao Cliente", sup);
        Cargo especialistaSuporteTecnico = new Cargo("Especialista em Suporte Técnico", sup);
        Cargo coordenadorSuporte = new Cargo("Coordenador de Suporte ao Cliente", sup);

        cargos.add(estagiarioFin);
        cargos.add(controladorFin);
        cargos.add(tesoureiroFin);
        cargos.add(seniorFin);
        cargos.add(devJunior);
        cargos.add(adminRede);
        cargos.add(analistaSeguranca);
        cargos.add(gerRH);
        cargos.add(gerOperacoes);
        cargos.add(gerProjetos);
        cargos.add(especialistaSocialMedia);
        cargos.add(analistaPesquisaMercado);
        cargos.add(gerProduto);
        cargos.add(analistaRH);
        cargos.add(treinamentoDesenvolvimento);
        cargos.add(recrutamentoSelecao);
        cargos.add(coordenadorOperacoes);
        cargos.add(especialistaLogistica);
        cargos.add(analistaProcessos);
        cargos.add(representanteAtendimento);
        cargos.add(especialistaSuporteTecnico);
        cargos.add(coordenadorSuporte);
    }

    public static ArrayList<Cargo>  getAllCargos(){
        return cargos;
    }
}
