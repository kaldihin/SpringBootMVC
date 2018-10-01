package com.example.demo.daointerfaces;

import com.example.demo.models.Country;

import java.util.List;

/**
 * DAO для работы с Country
 */
public interface CountryDao {

    /**
     * Получить все объекты Country
     *
     * @return List
     */
    List<Country> countries();

}
