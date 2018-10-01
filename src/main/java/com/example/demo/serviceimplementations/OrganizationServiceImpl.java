package com.example.demo.serviceimplementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.daointerfaces.OrganizationDao;
import com.example.demo.models.Organization;
import com.example.demo.serviceinterfaces.OrganizationService;
import com.example.demo.views.OrganizationView;
import com.example.demo.views.OrganizationViewList;
import com.example.demo.views.OrganizationViewSave;
import com.example.demo.views.OrganizationViewUpdate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrganizationDao dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(OrganizationViewSave viewSave) {
        Organization organization = new Organization(viewSave.getId(), viewSave.getName(),
                viewSave.getFullName(),viewSave.getVersion(), viewSave.getInn(), viewSave.getKpp(), viewSave.getAddress(),
                viewSave.getPhone(), viewSave.getIsActive());
        dao.save(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationViewList> list() {
        List<Organization> all = dao.list();

        return all.stream()
                .map(mapOrganization())
                .collect(Collectors.toList());
    }

    private Function<Organization, OrganizationViewList> mapOrganization() {
        return organization -> {
            OrganizationViewList view = new OrganizationViewList(organization);

            log.debug(view.toString());

            return view;
        };
    }

    @Override
    public OrganizationView getById(Integer id) {
        Organization organization = dao.getById(id);
        return new OrganizationView(organization);
    }

    @Override
    public void update(OrganizationViewUpdate viewUpdate) {
        dao.update(new Organization(viewUpdate.getId(), viewUpdate.getName(),
                viewUpdate.getFullName(), viewUpdate.getInn(), viewUpdate.getVersion(), viewUpdate.getKpp(),
                viewUpdate.getAddress(), viewUpdate.getPhone(), viewUpdate.getIsActive()));
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
