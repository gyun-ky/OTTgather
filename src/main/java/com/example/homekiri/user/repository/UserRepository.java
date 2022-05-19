package com.example.homekiri.user.repository;

import com.example.homekiri.user.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
import java.lang.reflect.Member;
import java.util.List;

@Repository
public class UserRepository{

    @PersistenceContext
    private EntityManager em;

//    private EntityTransaction tx = em.getTransaction();

    public Long save(User user){
        em.persist(user);
        em.flush();
        System.out.println("[JPA] save complete");
        return user.getIdx();
    }

    public User findUserByIdx(Long userIdx){

        User result = em.find(User.class, userIdx);
        System.out.println("[JPA] findUserByIdx complete");
        return result;
    }

    public User getReferenceByIdx(Long userIdx){
        User result = em.getReference(User.class, userIdx);
        System.out.println("[JPA] getReferenceByIdx complete");
        return result;
    }

    public User findSingleUserByEmail(String email){
        User result = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getSingleResult();
        System.out.println("[JPA] findUserByEmail complete");
        return result;
    }

    public List<User> findByEmail(String email){
        List<User> result = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getResultList();
        System.out.println("[JPA] findByEmail complete");
        return result;
    }

    public List<User> findByNickname(String nickName){
        List<User> result = em.createQuery("select u from User u where u.nickName = :nickName", User.class)
                .setParameter("nickName", nickName).getResultList();
        System.out.println("[JPA] findByNickname complete");
        return result;
    }

}
