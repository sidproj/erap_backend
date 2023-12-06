package dao;

import models.Appointment;
import models.Professional;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class AppointmentDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("erap");
    private EntityManager em =emf.createEntityManager();

    public ArrayList<Appointment> find(){
        TypedQuery<Appointment> typedQuery = em.createQuery("SELECT a FROM Appointment a",Appointment.class);
        return (ArrayList<Appointment>) typedQuery.getResultList();
    }

    public Appointment findById(int id){
        Appointment appointment = em.find(Appointment.class,id);
        return appointment;
    }

    public ArrayList<Appointment> findByUser(User user){
        TypedQuery<Appointment> typedQuery = em.createQuery("SELECT a from Appointment a WHERE a.user=:user",Appointment.class);
        typedQuery.setParameter("user",user);
        return (ArrayList<Appointment>) typedQuery.getResultList();
    }

    public ArrayList<Appointment> findByUserPast(User user){
        TypedQuery<Appointment> typedQuery = em.createQuery("SELECT a FROM Appointment a WHERE a.user=:id AND is_completed = 1",Appointment.class);
        typedQuery.setParameter("id",user);
        return (ArrayList<Appointment>) typedQuery.getResultList();
    }

    public ArrayList<Appointment> findByUserCurrent(User user){
        TypedQuery<Appointment> typedQuery = em.createQuery("SELECT a FROM Appointment a WHERE a.user=:id AND is_completed = 0",Appointment.class);
        typedQuery.setParameter("id",user);
        return (ArrayList<Appointment>) typedQuery.getResultList();
    }

    public ArrayList<Appointment> findByProfessional(Professional professional){
        TypedQuery<Appointment> typedQuery = em.createQuery("SELECT a from Appointment a WHERE a.professional =: id",Appointment.class);
        typedQuery.setParameter("id",professional);
        return (ArrayList<Appointment>) typedQuery.getResultList();
    }

    public void save(Appointment appointment){
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
    }

    public void update(Appointment appointment){
        Appointment oldAppointment = this.findById(appointment.getId());
        oldAppointment.copy(appointment);
        em.getTransaction().begin();
        em.merge(oldAppointment);
        em.getTransaction().commit();
    }

    public void delete(Appointment appointment){
        em.getTransaction().begin();
        em.remove(appointment);
        em.getTransaction().commit();
    }
}
