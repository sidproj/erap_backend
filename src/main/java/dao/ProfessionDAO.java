package dao;

import models.Profession;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ProfessionDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("erap");
    private EntityManager em =emf.createEntityManager();

    public Profession findById(int id){
        Profession profession = em.find(Profession.class,id);
        return profession;
    }

    public ArrayList<Profession> findByName(String name){
        TypedQuery<Profession> typedQuery = em.createQuery("SELECT p from Profession p WHERE p.name =: name",Profession.class);
        typedQuery.setParameter("name",name);
        return (ArrayList<Profession>) typedQuery.getResultList();
    }

    public ArrayList<Profession> find(){
        TypedQuery<Profession> typedQuery = em.createQuery("SELECT p from Profession p",Profession.class);
        return (ArrayList<Profession>) typedQuery.getResultList();
    }

    public void update(Profession profession){
        Profession oldProfession = this.findById(profession.getId());
        oldProfession.copy(profession);
        em.getTransaction().begin();
        em.merge(profession);
        em.getTransaction().commit();
    }

    public void save(Profession profession){
        em.getTransaction().begin();
        em.persist(profession);
        em.getTransaction().commit();
    }

    public void delete(Profession profession){
        em.getTransaction().begin();
        em.remove(profession);
        em.getTransaction().commit();
    }
}