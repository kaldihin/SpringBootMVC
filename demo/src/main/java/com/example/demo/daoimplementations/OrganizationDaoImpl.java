package com.example.demo.daoimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.daointerfaces.OrganizationDao;
import com.example.demo.models.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> list(String name, Integer inn, Boolean isActive) {
        TypedQuery<Organization> query = em.createQuery("SELECT p FROM Organization p", Organization.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getById(Integer id) {
        return em.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void delete(Integer id) {
        Organization organization = em.find(Organization.class, id);
        em.remove(organization);
    }
}
