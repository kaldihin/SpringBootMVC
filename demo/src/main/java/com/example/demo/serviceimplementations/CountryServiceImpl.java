package com.example.demo.serviceimplementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.daointerfaces.CountryDao;
import com.example.demo.models.Country;
import com.example.demo.serviceinterfaces.CountryService;
import com.example.demo.views.CountryView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final CountryDao dao;

    @Autowired
    public CountryServiceImpl(CountryDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryView> countries(CountryView view) {
        List<Country> all = dao.countries(new Country(view.getName(), view.getCode()));

        return all.stream()
                .map(mapOffice())
                .collect(Collectors.toList());
    }

    private Function<Country, CountryView> mapOffice() {
        return country -> {
            CountryView view = new CountryView(country);

            log.debug(view.toString());

            return view;
        };
    }
}
