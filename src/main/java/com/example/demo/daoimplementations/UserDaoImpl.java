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

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> list() {
        TypedQuery<User> query = em.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(Integer id) {
        return em.find(User.class, id);
    }

//    @Override
//    public void delete(Integer id) {
//        User user = em.find(User.class, id);
//        em.remove(user);
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {
        User target = em.find(User.class, user.getId());
        target.setOfficeId(user.getOfficeId());
        target.setVersion(user.getVersion());
        target.setFirstName(user.getFirstName());
        target.setSecondName(user.getSecondName());
        target.setMiddleName(user.getMiddleName());
        target.setLastName(user.getLastName());
        target.setPosition(user.getPosition());
        target.setDocCode(user.getDocCode());
        target.setDocName(user.getDocName());
        target.setDocNumber(user.getDocNumber());
        target.setDocDate(user.getDocDate());
        target.setCitizenshipName(user.getCitizenshipName());
        target.setCitizenshipCode(user.getCitizenshipCode());
        target.setPhone(user.getPhone());
        target.setIdentified(user.getIsIdentified());
        em.merge(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {
        em.persist(user);
    }

}
