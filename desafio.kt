import java.time.LocalDate
import java.time.format.DateTimeFormatter

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

enum class Tipo {CURSO, DESAFIO_DE_PROJETO, DESAFIO_DE_CODIGO, LIVE}

open class Pessoa(nome: String, email: String)

data class Usuario(val matricula: Int, val senha: String, val nome: String, val email: String) : Pessoa(nome, email)

data class GrupoConteudoEducacional(val ordem: Int, val titulo: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val tipo: Tipo, val nivel: Nivel?, val ordemDaAtividade: Int, val grupoConteudoEducacional: GrupoConteudoEducacional)

data class Formacao(val nome: String, val sobre: String, val nivel: Nivel, val dataInicio: LocalDate, val dataFim: LocalDate) {

    val conteudosEducacionais = mutableSetOf<ConteudoEducacional>()
    
     val matriculas = mutableSetOf<Usuario>()
    
    //val inscritos = mutableListOf<Usuario>()
    
    var duracaoTotal: Int = 0 
    
    fun addConteudoEducational(conteudoEducacional: ConteudoEducacional)
    {
        duracaoTotal += conteudoEducacional.duracao
        conteudosEducacionais.add(conteudoEducacional)
    }
    
    fun calcConteudosPorTipo(tipo: Tipo): Int
    {
        var total = 0 
        conteudosEducacionais.forEach{ conteudo -> if(conteudo.tipo == tipo) total+= 1 else total}
        return total
    }
    
    fun getTodosConteudosEducacionais(): MutableSet<ConteudoEducacional>
    {
        return conteudosEducacionais
    }
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        matriculas.add(usuario)
    }
}

val sobre = "Bem-vindo(a) ao Santander Bootcamp 2023! Entre de cabeça na trilha de desenvolvimento Mobile Android com Kotlin, assistindo às aulas, resolvendo desafios de programação e finalizando todas as atividades propostas."




fun main() {
    
    
    
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    try
    {
        
        
        val grupo1 = GrupoConteudoEducacional(1, "Prepare-se Para a Jornada (Onboarding)")
        val grupo2 = GrupoConteudoEducacional(2, "Princípios de Desenvolvimento de Software")
        val grupo3 = GrupoConteudoEducacional(3, "Conhecendo a Linguagem de Programação Kotlin")
        val grupo4 = GrupoConteudoEducacional(4, "Resolvendo Seus Primeiros Desafios de Código")
        val grupo5 = GrupoConteudoEducacional(5, "Introdução ao Desenvolvimento Mobile com Kotlin")
        val grupo6 = GrupoConteudoEducacional(6, "Praticando Sua Abstração no Domínio Bancário")
        val grupo7 = GrupoConteudoEducacional(7, "Ganhando Produtividade com o Android Jetpack")
        
       	var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        
        val formacao = Formacao("Santander Bootcamp 2023 -  Mobile Android com Kotlin", sobre, Nivel.INTERMEDIARIO,LocalDate.parse("2023-08-16"), LocalDate.parse("2023-10-22"))
        formacao.addConteudoEducational(ConteudoEducacional("Bootcamps DIO: Educação Gratuita e Empregabilidade Juntas!", 1, Tipo.CURSO, Nivel.BASICO, 1, grupo1))
        formacao.addConteudoEducational(ConteudoEducacional("Aula Inaugural - Santander Bootcamps 2023", 2, Tipo.LIVE, null, 2, grupo1))
        formacao.addConteudoEducational(ConteudoEducacional("Organizando seus Estudos com os Roadmaps DIO e o Notion", 2, Tipo.CURSO, Nivel.BASICO, 1, grupo2))
        formacao.addConteudoEducational(ConteudoEducacional("Versionamento de Código com Git e GitHub", 2, Tipo.CURSO, Nivel.BASICO, 2, grupo2))
        formacao.addConteudoEducational(ConteudoEducacional("Desafios de Projetos: Crie Um Portfólio Vencedor", 1, Tipo.CURSO, Nivel.BASICO, 3, grupo2))
        formacao.addConteudoEducational(ConteudoEducacional("Contribuindo em um Projeto Open Source no GitHub", 1, Tipo.CURSO, Nivel.BASICO, 4, grupo2))
        formacao.addConteudoEducational(ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial", 1, Tipo.CURSO, Nivel.BASICO, 1, grupo3))
        formacao.addConteudoEducational(ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 2, Tipo.CURSO, Nivel.BASICO, 2, grupo3))
        formacao.addConteudoEducational(ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin", 2, Tipo.CURSO, Nivel.BASICO, 3, grupo3))
        formacao.addConteudoEducational(ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 2, Tipo.CURSO, Nivel.BASICO, 4, grupo3))
        formacao.addConteudoEducational(ConteudoEducacional("O Poder das Funções em Kotlin", 2, Tipo.CURSO, Nivel.BASICO, 5, grupo3))
        formacao.addConteudoEducational(ConteudoEducacional("Tratamento de Exceções em Kotlin", 2, Tipo.CURSO, Nivel.BASICO, 6, grupo3))
        formacao.addConteudoEducational(ConteudoEducacional("Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin", 2, Tipo.DESAFIO_DE_PROJETO, Nivel.BASICO, 7, grupo3))
        formacao.addConteudoEducational(ConteudoEducacional("Desafios Kotlin: Abrindo Contas", 1, Tipo.DESAFIO_DE_CODIGO, Nivel.INTERMEDIARIO, 1, grupo4))
        formacao.addConteudoEducational(ConteudoEducacional("Desafios Kotlin: Herança Bancária", 1, Tipo.DESAFIO_DE_CODIGO, Nivel.INTERMEDIARIO, 2, grupo4))
        formacao.addConteudoEducational(ConteudoEducacional("Desafios Kotlin: Cofres Seguros", 1, Tipo.DESAFIO_DE_CODIGO, Nivel.INTERMEDIARIO, 3, grupo4))
        formacao.addConteudoEducational(ConteudoEducacional("Desafios Kotlin: Reunião de Acionistas", 1, Tipo.DESAFIO_DE_CODIGO, Nivel.BASICO, 4, grupo4))
        formacao.addConteudoEducational(ConteudoEducacional("Desafios Kotlin: A Última Transação", 1, Tipo.DESAFIO_DE_CODIGO, Nivel.INTERMEDIARIO, 5, grupo4))
        //Ordenando
        formacao.conteudosEducacionais.sortedWith(compareBy({ it.grupoConteudoEducacional.ordem }, { it.ordemDaAtividade}))
        
        //Matrícula 1
        var matricula = formacao.matriculas.size + 1
        var usuario = Usuario(matricula = matricula, senha="123456", nome="José", email="jose@gmail.com" ) 
        formacao.matricular(usuario)
        
         //Matrícula 2
        matricula = formacao.matriculas.size + 1
        usuario = Usuario(matricula = matricula, senha="p@ssword", nome="Maria", email="maria@gmail.com" ) 
        formacao.matricular(usuario)
        
        println(formacao.nome)
        println()
        println("${formacao.nivel}          ${formacao.duracaoTotal}hs           ${formacao.matriculas.size} pessoas já se matricularam")
        println()
        println(formacao.sobre)
        println()
        println("Atividades")
        println()
        println("Finalize todos conteúdos até a data ${formacao.dataFim.format(formatter)} e certifique seu conhecimento.")
        println()
        println("${formacao.calcConteudosPorTipo(Tipo.CURSO)} cursos   .   ${formacao.calcConteudosPorTipo(Tipo.DESAFIO_DE_PROJETO)} desafios de projetos   .   ${formacao.calcConteudosPorTipo(Tipo.DESAFIO_DE_CODIGO)} desafios de código   .   ${formacao.calcConteudosPorTipo(Tipo.LIVE)} live")
        println()
        println("")
        var grupos: String = "" 
        for(conteudo in formacao.conteudosEducacionais)
        {
            if(grupos == "" || grupos!=conteudo.grupoConteudoEducacional.titulo)
            {
                println("V - ${conteudo.grupoConteudoEducacional.titulo}")
                println("  * - ${conteudo.tipo}")
                println("      ${conteudo.nome}             Iniciar Agora ->")
                println("      ${conteudo.nivel ?: ""}            ${conteudo.duracao}hs")
                grupos = conteudo.grupoConteudoEducacional.titulo
            }
            else
            {
                println("  * - ${conteudo.tipo}")
                println("      ${conteudo.nome}             Iniciar Agora ->")
                println("      ${conteudo.nivel ?: ""}            ${conteudo.duracao}hs")
            }
            
        }
        
    }
    catch(e: Exception)
    {
        println(e)
    }
    
    println()
    
}
