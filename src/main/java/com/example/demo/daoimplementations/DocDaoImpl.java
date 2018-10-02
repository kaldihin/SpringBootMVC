package com.example.demo.daoimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.daointerfaces.DocDao;
import com.example.demo.models.Doc;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class DocDaoImpl implements DocDao {

    private final EntityManager em;
    private String queryString = "SELECT d FROM Doc d";

    @Autowired
    public DocDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Doc> docs() {
        TypedQuery<Doc> query = em.createQuery(queryString, Doc.class);
        return query.getResultList();
    }

}
