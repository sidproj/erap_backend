package dao;

import models.Professional;
import models.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ServiceDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("erap");
    private EntityManager em =emf.createEntityManager();

    public Service findById(int id){
        Service service = em.find(Service.class,id);
        return service;
    }

    public ArrayList<Service> find(){
        TypedQuery<Service> typedQuery = em.createQuery("SELECT s FROM Service s",Service.class);
        return (ArrayList<Service>) typedQuery.getResultList();
    }

    public ArrayList<Service> findByProfessional(Professional professional){
        TypedQuery<Service> typedQuery = em.createQuery("SELECT s FROM Service s WHERE s.professional =:professional",Service.class);
        typedQuery.setParameter("professional",professional);
        return (ArrayList<Service>) typedQuery.getResultList();
    }

    public void update(Service service){
        Service oldService = this.findById(service.getId());
        oldService.copy(service);
        em.getTransaction().begin();
        em.merge(oldService);
        em.getTransaction().commit();
    }

    public void delete(Service service){
        em.getTransaction().begin();
        em.remove(service);
        em.getTransaction().commit();
    }

    public void save(Service service){
        em.getTransaction().begin();
        em.persist(service);
        em.getTransaction().commit();
    }
}
