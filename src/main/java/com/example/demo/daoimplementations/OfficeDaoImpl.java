package com.example.demo.daoimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.daointerfaces.OfficeDao;
import com.example.demo.models.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> list(Integer organizationId) {
        TypedQuery<Office> query = em.createQuery("from Office where orgId = :organizationId", Office.class).setParameter("organizationId", organizationId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office byId(Integer id) {
        return em.find(Office.class, id);
    }

    @Override
    public void update(Office office) {
        Office target = em.find(Office.class, office.getOfId());
        target.setOrgId(office.getOrgId());
        target.setVersion(office.getVersion());
        target.setName(office.getName());
        target.setAddress(office.getAddress());
        target.setPhone(office.getPhone());
        target.setIsActive(office.getIsActive());
        em.merge(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }

//    @Override
//    public void delete(Integer id) {
//        Office office = em.find(Office.class, id);
//        em.remove(office);
//    }
}
