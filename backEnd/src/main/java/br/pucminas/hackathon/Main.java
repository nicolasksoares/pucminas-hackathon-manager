package br.pucminas.hackathon;

import br.pucminas.hackathon.model.avaliacao.Banca;
import br.pucminas.hackathon.model.colecoes.Apresentacoes;
import br.pucminas.hackathon.model.colecoes.Equipes;
import br.pucminas.hackathon.model.colecoes.Projetos;
import br.pucminas.hackathon.model.entidades.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Simulação do Hackathon ---");

        Universidade puc = new Universidade("PUC Minas", "17.166.753/0001-48", "Av. Dom José Gaspar, 500");
        Empresa google = new Empresa("Google", "06.990.590/0001-23", "Av. Brigadeiro Faria Lima, 3477", "Tecnologia", "Multinacional");
        Empresa takeBlip = new Empresa("Take Blip", "03.435.542/0001-19", "Av. dos Andradas, 3000", "Tecnologia", "Grande Empresa");

        criarEquipes(puc);
        criarProjetos(puc);
        criarApresentacoesEAvaliar(google, takeBlip);
        listarProjetosAprovados();

        System.out.println("\n--- Simulação Finalizada ---");
    }

    private static void criarEquipes(Universidade universidade) {
        System.out.println("\n1. Criando equipes...");
        Equipe equipe1 = new Equipe("Devs do Futuro");
        for (int i = 1; i <= 5; i++) {
            equipe1.adicionarMembro(new Estudante("Aluno " + i, "111.111.111-0" + i, "aluno" + i + "@email.com", universidade, "1234" + i, "Eng. de Software"));
        }
        Equipes.getInstance().adicionar(equipe1);
        System.out.println("Equipe '" + equipe1.getNomeEquipe() + "' criada com " + equipe1.getMembros().size() + " membros.");

        Equipe equipe2 = new Equipe("Codificadores Anônimos");
        for (int i = 6; i <= 10; i++) {
            equipe2.adicionarMembro(new Estudante("Aluno " + i, "111.111.111-1" + (i - 5), "aluno" + i + "@email.com", universidade, "5678" + i, "Ciência da Computação"));
        }
        Equipes.getInstance().adicionar(equipe2);
        System.out.println("Equipe '" + equipe2.getNomeEquipe() + "' criada com " + equipe2.getMembros().size() + " membros.");
    }

    private static void criarProjetos(Universidade universidade) {
        System.out.println("\n2. Criando e associando projetos...");
        Orientador orientador1 = new Orientador("Prof. Daniel", "222.222.222-22", "daniel@email.com", universidade, "Docente", "Engenharia de Software");
        Orientador orientador2 = new Orientador("Prof. Salles", "333.333.333-33", "salles@email.com", universidade, "Docente", "Inteligência Artificial");

        Equipe equipe1 = Equipes.getInstance().buscarPorNome("Devs do Futuro");
        Equipe equipe2 = Equipes.getInstance().buscarPorNome("Codificadores Anônimos");

        Projeto projeto1 = new Projeto("Sistema de Gestão de Hortas Urbanas", "Um app para conectar produtores e consumidores de hortaliças.", equipe1, orientador1);
        Projeto projeto2 = new Projeto("Plataforma de Caronas Universitárias", "Um sistema para organizar caronas seguras entre alunos.", equipe2, orientador2);

        Projetos.getInstance().adicionar(projeto1);
        Projetos.getInstance().adicionar(projeto2);
        System.out.println("Projeto '" + projeto1.getTitulo() + "' associado à equipe '" + projeto1.getEquipe().getNomeEquipe() + "'.");
        System.out.println("Projeto '" + projeto2.getTitulo() + "' associado à equipe '" + projeto2.getEquipe().getNomeEquipe() + "'.");
    }

    private static void criarApresentacoesEAvaliar(Empresa empresa1, Empresa empresa2) {
        System.out.println("\n3. Criando bancas e simulando avaliações...");
        List<Projeto> todosProjetos = Projetos.getInstance().getTodosOsProjetos();
        Sala sala1 = new Sala("Prédio 43", "Auditório 1");

        Jurado juradoA = new Jurado("Jurado A", "444.444.444-44", "juradoA@email.com", empresa1, "Eng. Sênior", "Backend");
        Jurado juradoB = new Jurado("Jurado B", "555.555.555-55", "juradoB@email.com", empresa1, "Product Owner", "Gestão");
        Jurado juradoC = new Jurado("Jurado C", "666.666.666-66", "juradoC@email.com", empresa2, "UX Designer", "Design");
        Jurado juradoD = new Jurado("Jurado D", "777.777.777-77", "juradoD@email.com", empresa2, "Data Scientist", "Dados");

        Banca banca1 = new Banca(todosProjetos.get(0));
        banca1.adicionarJurado(juradoA);
        banca1.adicionarJurado(juradoB);
        banca1.adicionarJurado(juradoC);
        banca1.adicionarJurado(juradoD);
        banca1.atribuirNota(juradoA, 8);
        banca1.atribuirNota(juradoB, 9);
        banca1.atribuirNota(juradoC, 7);
        banca1.atribuirNota(juradoD, 8);

        Apresentacao apresentacao1 = new Apresentacao(todosProjetos.get(0), banca1, sala1, LocalDateTime.now().plusHours(1));
        apresentacao1.avaliar();
        Apresentacoes.getInstance().adicionar(apresentacao1);
        System.out.println("Projeto '" + apresentacao1.getProjeto().getTitulo() + "' avaliado. Nota Final: " + apresentacao1.getProjeto().getNotaFinal());

        Banca banca2 = new Banca(todosProjetos.get(1));
        banca2.adicionarJurado(juradoA);
        banca2.adicionarJurado(juradoB);
        banca2.adicionarJurado(juradoC);
        banca2.adicionarJurado(juradoD);
        banca2.atribuirNota(juradoA, 6);
        banca2.atribuirNota(juradoB, 7);
        banca2.atribuirNota(juradoC, 6);
        banca2.atribuirNota(juradoD, 5);

        Apresentacao apresentacao2 = new Apresentacao(todosProjetos.get(1), banca2, sala1, LocalDateTime.now().plusHours(2));
        apresentacao2.avaliar();
        Apresentacoes.getInstance().adicionar(apresentacao2);
        System.out.println("Projeto '" + apresentacao2.getProjeto().getTitulo() + "' avaliado. Nota Final: " + apresentacao2.getProjeto().getNotaFinal());
    }

    private static void listarProjetosAprovados() {
        System.out.println("\n4. Listando projetos com nota final >= 7...");
        Projetos.getInstance().getTodosOsProjetos()
                .stream()
                .filter(p -> p.getNotaFinal() >= 7)
                .forEach(p -> System.out.println(" - " + p));
    }
}