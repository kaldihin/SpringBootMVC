package com.example.demo.daointerfaces;

import com.example.demo.models.Doc;

import java.util.List;

/**
 * DAO для работы с Doc
 */
public interface DocDao {

    /**
     * Получить все объекты Doc
     *
     * @return List
     */
    List<Doc> docs();

}
