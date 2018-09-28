package com.example.demo.serviceimplementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.daointerfaces.DocDao;
import com.example.demo.models.Doc;
import com.example.demo.serviceinterfaces.DocService;
import com.example.demo.views.DocView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class DocServiceImpl implements DocService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final DocDao dao;

    @Autowired
    public DocServiceImpl(DocDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<DocView> docs() {
        List<Doc> all = dao.docs();

        return all.stream()
                .map(mapDoc())
                .collect(Collectors.toList());
    }

    private Function<Doc, DocView> mapDoc() {
        return doc -> {
            DocView view = new DocView(doc);

            log.debug(view.toString());

            return view;
        };
    }
}
