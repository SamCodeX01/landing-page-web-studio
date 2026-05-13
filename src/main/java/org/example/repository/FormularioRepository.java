package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Formulario;
import org.example.util.JPAUtil;

public class FormularioRepository {

    public void salvar(Formulario formulario){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(formulario);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }

    }
}
