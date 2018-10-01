package com.example.demo.serviceimplementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.daointerfaces.OfficeDao;
import com.example.demo.models.Office;
import com.example.demo.serviceinterfaces.OfficeService;
import com.example.demo.views.OfficeView;
import com.example.demo.views.OfficeViewList;
import com.example.demo.views.OfficeViewSave;
import com.example.demo.views.OfficeViewUpdate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OfficeDao dao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(OfficeViewSave officeViewSave) {
        dao.save(new Office(officeViewSave.getId(), officeViewSave.getOrgId(), officeViewSave.getName(), officeViewSave.getAddress(),
                officeViewSave.getPhone(), officeViewSave.getIsActive()));
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeViewList> list(Integer orgId) {
        List<Office> all = dao.list(orgId);

        return all.stream()
                .map(mapOffice())
                .collect(Collectors.toList());
    }

    private Function<Office, OfficeViewList> mapOffice() {
        return office -> {
            OfficeViewList officeViewList = new OfficeViewList(office);

            log.debug(officeViewList.toString());

            return officeViewList;
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeView getById(Integer id) {
        return new OfficeView(dao.byId(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OfficeViewUpdate officeViewUpdate) {
        dao.update(new Office(officeViewUpdate.getId(), officeViewUpdate.getOrgId(), officeViewUpdate.getName(), officeViewUpdate.getAddress(),
                officeViewUpdate.getPhone(), officeViewUpdate.getIsActive()));
    }
}
