package dao;

import exceptions.NoRecordFound;
import models.Admin;

import javax.persistence.*;
import java.util.ArrayList;

public class AdminDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("erap");
    private EntityManager em =emf.createEntityManager();

    public ArrayList<Admin> find(){
        TypedQuery<Admin> typedQuery = em.createQuery("SELECT a from Admin a",Admin.class);
        return (ArrayList<Admin>) typedQuery.getResultList();
    }

    public Admin findById(int id){
        Admin admin = em.find(Admin.class,id);
        return admin;
    }

    public Admin findByEmail(String email) throws NoRecordFound{
        try {
            TypedQuery<Admin> typedQuery = em.createQuery("SELECT a from Admin a WHERE a.email =:email", Admin.class);
            typedQuery.setParameter("email", email);
            return typedQuery.getSingleResult();
        }catch (NoResultException nre){
            throw new NoRecordFound("No admin found");
        }
    }

    public void update(Admin admin){
        Admin oldAdmin = this.findById(admin.getId());
        oldAdmin.copy(admin);
        em.getTransaction().begin();
        em.merge(oldAdmin);
        em.getTransaction().commit();
    }

    public void save(Admin admin){
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
    }
}
