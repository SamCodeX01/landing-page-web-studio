package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Formulario;
import org.example.util.JPAUtil;

import java.lang.reflect.Type;
import java.util.List;
//DAO = Padrão de projeto para encapsular lógica de acesso a dados
//Função: Isolar operações CRUD (find, save, delete) usando JPA
public class FormularioDao {

    public void salvar(Formulario formulario){
        EntityManager em = JPAUtil.getEntityManager();// O gerenciador de entidades esta recebendo getEntityManager() através da classe JPAUtil, responsável por criar e retornar a conexão pronta para uso.
        try{
            em.getTransaction().begin();//inicia uma transação de banco de dados.
            em.persist(formulario);
            em.getTransaction().commit(); //O método commit() significa "confirmar" ou "gravar definitivamente".Ele serve para avisar ao banco de dados que todas as operações da transação atual foram executadas com sucesso e que elas já podem ser salvas permanentemente no disco rígido.
        }
        catch (Exception e){
            em.getTransaction().rollback(); //Se o sistema falhar no meio, o JPA executa um rollback (cancelamento automaticamente)
            throw e;
        }
        finally {
            em.close();
        }
    }

    public void atualizar(Formulario formulario){
        EntityManager em = JPAUtil.getEntityManager();// O gerenciador de entidades esta recebendo getEntityManager() através da classe JPAUtil, responsável por criar e retornar a conexão pronta para uso.

        try{
            em.getTransaction().begin();//inicia uma transação de banco de dados.
            em.merge(formulario); //O merge serve para atualizar ou sincronizar um objeto com o banco de dados.
            em.getTransaction().commit();//O método commit() significa "confirmar" ou "gravar definitivamente".Ele serve para avisar ao banco de dados que todas as operações da transação atual foram executadas com sucesso e que elas já podem ser salvas permanentemente no disco rígido.
        }finally {
            em.close();
        }
    }

    public List<Formulario> listarTodos(){
        EntityManager em = JPAUtil.getEntityManager(); // O gerenciador de entidades esta recebendo getEntityManager() através da classe JPAUtil, responsável por criar e retornar a conexão pronta para uso.

        try{
        TypedQuery<Formulario> query = em.createQuery("select f from Formulario f", Formulario.class);
                return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void deletar(Formulario formulario){

        // O gerenciador de entidades esta recebendo getEntityManager() através da classe JPAUtil, responsável por criar e retornar a conexão pronta para uso.
        EntityManager em = JPAUtil.getEntityManager();

        try{
            em.getTransaction().begin(); //inicia uma transação de banco de dados.
            em.remove(formulario);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            em.close();
        }
    }

}
