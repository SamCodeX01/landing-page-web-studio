package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//util em projetos JPA puro serve para classes auxiliares e utilitárias que não se encaixam em outras camadas (como model, dao, service, controller).
//util é a gaveta de ferramentas do seu projeto JPA. Tudo que é genérico(métodos genéricos como validação de cpf, de email etc), reutilizável e não seja regra de negócios.
public class JPAUtil {
    // Cria fábrica de conexões JPA para o banco "landingPage" (gerencia as entidades)
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("landingPage");


    //Metodo getEntityManager do tipo EntityManager retorna o resultado do metodo createEntityManager que pertence a variavel FACTORY que esta gerenciando o banco landingPages
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }

    public static void close(){
        if(FACTORY != null && FACTORY.isOpen()){
            FACTORY.close();
        }
    }
}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*A variavel estatica e constante FACTORY do tipo EntityManagerFactory(Fábrica de Gerenciadores de Entidades),
recebe a classe Persistence que esta acessando o metodo createEntityManagerFactory(criar a Fábrica de Gerenciadores de Entidades),
trabalhando com a unidade banco chamado "loja" que sera persistido no banco de dados, que tera as suas classes(entidades) gerenciadas pela fabrica de gerenciadores*/

//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*O que é static { }?

É um bloco de código que executa uma única vez quando a classe é carregada pela JVM (antes de qualquer objeto ser criado ou método estático ser chamado).

java
public class MinhaClasse {
    static {
        System.out.println("Roda quando a classe carrega");
    }
}
Para que serve?
Para inicializar atributos estáticos que precisam de lógica mais complexa (com try-catch, loops, etc.) do que uma simples atribuição direta.
*/
//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*Por que precisa desse código? (close() method)

Esse método existe para liberar recursos que a EntityManagerFactory consome. Se você não fechar, pode causar vazamento de memória e conexões abertas com o banco de dados.

O que acontece se NÃO chamar o close()?
Pool de conexões não é liberado — mesmo que sua aplicação termine, o banco pode manter conexões ativas até expirar.

Threads em background do Hibernate continuam rodando (ex: cache de segundo nível).

Em servidores de aplicação (Tomcat, WildFly...) , o redeploy pode falhar ou vazar memória.*/
//-------------------------------------------------------------------------------------------------------------------------------------------------------