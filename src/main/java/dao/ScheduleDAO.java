package dao;

import models.Professional;
import models.Schedule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ScheduleDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("erap");
    private EntityManager em =emf.createEntityManager();

    public Schedule findById(int id){
        Schedule schedule = em.find(Schedule.class,id);
        return schedule;
    }

    public ArrayList<Schedule> findByProfessional(Professional professional){
        TypedQuery<Schedule> typedQuery = em.createQuery("SELECT s from Schedule s WHERE s.professional=:professional",Schedule.class);
        typedQuery.setParameter("professional",professional);
        return (ArrayList<Schedule>) typedQuery.getResultList();
    }

    public ArrayList<Schedule> find(){
        TypedQuery<Schedule> typedQuery = em.createQuery("SELECT s FROM Schedule s",Schedule.class);
        return (ArrayList<Schedule>) typedQuery.getResultList();
    }

    public void update(Schedule schedule){
        Schedule oldSchedule = this.findById(schedule.getId());
        oldSchedule.copy(schedule);
        em.getTransaction().begin();
        em.merge(oldSchedule);
        em.getTransaction().commit();
    }

    public void delete(Schedule schedule){
        em.getTransaction().begin();
        em.remove(schedule);
        em.getTransaction().commit();
    }

    public void save(Schedule schedule){
        em.getTransaction().begin();
        em.persist(schedule);
        em.getTransaction().commit();
    }
}
