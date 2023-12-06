package dao;

import exceptions.NoRecordFound;
import models.User;

import javax.persistence.*;
import java.util.ArrayList;

public class UserDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("erap");
    private EntityManager em =emf.createEntityManager();

    public User findById(int id){
        User user = em.find(User.class,id);
        return user;
    }

    public User findByEmail(String email) throws NoRecordFound {
        try {
            TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u WHERE u.email =: email",User.class);
            typedQuery.setParameter("email",email);
            return typedQuery.getSingleResult();
        }catch (NoResultException nre){
            throw new NoRecordFound("No Professional Found");
        }
    }

    public ArrayList<User> find(){
        TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u",User.class);
        return (ArrayList<User>) typedQuery.getResultList();
    }

    public void update(User user){
        User oldUser = this.findById(user.getId());
        oldUser.copy(user);
        em.getTransaction().begin();
        em.merge(oldUser);
        em.getTransaction().commit();
    }

    public void delete(User user){
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public User save(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }
}
