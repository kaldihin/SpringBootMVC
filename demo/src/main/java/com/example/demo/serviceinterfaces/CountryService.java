package com.example.demo.serviceinterfaces;

import com.example.demo.views.CountryView;

import java.util.List;

/**
 * Сервис
 */
public interface CountryService {

    /**
     * Получить список стран
     *
     * @return Countries
     */
    List<CountryView> countries(CountryView countryView);
}