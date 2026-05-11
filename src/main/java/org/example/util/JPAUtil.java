package org.example.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // Cria fábrica de conexões JPA para o banco "landingPage" (gerencia as entidades)
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("landingPage");

    //Metodo getEntityManager do tipo EntityManager retorna o resultado do metodo createEntityManager que pertence a variavel FACTORY que esta gerenciando o banco landingPages
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }


}
/*A variavel estatica e constante FACTORY do tipo EntityManagerFactory(Fábrica de Gerenciadores de Entidades),
recebe a classe Persistence que esta acessando o metodo createEntityManagerFactory(criar a Fábrica de Gerenciadores de Entidades),
trabalhando com a unidade banco chamado "loja" que sera persistido no banco de dados, que tera as suas classes(entidades) gerenciadas pela fabrica de gerenciadores*/