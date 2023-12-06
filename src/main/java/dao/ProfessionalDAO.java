package dao;

import exceptions.NoRecordFound;
import models.Profession;
import models.Professional;
import models.Service;

import javax.persistence.*;
import java.util.ArrayList;

public class ProfessionalDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("erap");
    private EntityManager em = emf.createEntityManager();

    public Professional findById(int id){
        Professional professional = em.find(Professional.class,id);
        return professional;
    }

    public Professional findByEmail(String email)throws NoRecordFound {
        try {
            TypedQuery<Professional> typedQuery = em.createQuery("SELECT p FROM Professional p WHERE p.email=:email", Professional.class);
            typedQuery.setParameter("email",email);
            return typedQuery.getSingleResult();
        }catch (NoResultException nre){
            throw new NoRecordFound("No Professional Found");
        }
    }

    public ArrayList<Professional> find(){
        TypedQuery<Professional> typedQuery = em.createQuery("SELECT p from Professional p",Professional.class);
        return (ArrayList<Professional>) typedQuery.getResultList();
    }

    public ArrayList<Professional> findByProfession(Profession profession){
        TypedQuery<Professional> typedQuery = em.createQuery("SELECT p from Professional p WHERE p.profession=:profession",Professional.class);
        typedQuery.setParameter("profession",profession);
        return (ArrayList<Professional>) typedQuery.getResultList();
    }

    public Professional findByService(Service service){
        TypedQuery<Professional> typedQuery = em.createQuery("SELECT p from Professional p WHERE p.service=:service",Professional.class);
        typedQuery.setParameter("service",service);
        return typedQuery.getSingleResult();
    }

    public void update(Professional professional){
        Professional oldProfessional = this.findById(professional.getId());
        oldProfessional.copy(professional);
        em.getTransaction().begin();
        em.merge(oldProfessional);
        em.getTransaction().commit();
    }

    public Professional save(Professional professional){
        em.getTransaction().begin();
        em.persist(professional);
        em.getTransaction().commit();
        return professional;
    }

    public void delete(Professional professional){
        em.getTransaction().begin();
        em.remove(professional);
        em.getTransaction().commit();
    }
}
