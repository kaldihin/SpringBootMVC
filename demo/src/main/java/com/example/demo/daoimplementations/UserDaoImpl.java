package com.example.demo.daoimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.daointerfaces.UserDao;
import com.example.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;
    private String queryString = "SELECT (user_id, user_office_id," +
            "user_firstname, user_secondname, user_middlename," +
            "user_lastname, user_position, user_doc_code, user_doc_name," +
            "user_doc_number, user_doc_date, user_citizenship_name," +
            "user_citizenship_code, user_phone, user_is_identified) FROM User";

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> list() {
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(Integer id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {
        em.merge(user);
    }
}
