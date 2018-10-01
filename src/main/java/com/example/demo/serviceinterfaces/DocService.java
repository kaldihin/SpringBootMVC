package com.example.demo.serviceinterfaces;

import com.example.demo.views.DocView;

import java.util.List;

/**
 * Сервис
 */
public interface DocService {

    /**
     * Получить список документов
     *
     * @return Docs
     */
    List<DocView> docs();
}