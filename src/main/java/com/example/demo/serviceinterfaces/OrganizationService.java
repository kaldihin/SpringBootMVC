package com.example.demo.serviceinterfaces;

import com.example.demo.views.OrganizationView;
import com.example.demo.views.OrganizationViewList;
import com.example.demo.views.OrganizationViewSave;
import com.example.demo.views.OrganizationViewUpdate;

import java.util.List;

/**
 * Сервис
 */
public interface OrganizationService {

    /**
     * Добавить новую организацию в БД
     *
     * @param viewSave save filter
     */
    void save(OrganizationViewSave viewSave);

    /**
     * Обновить данные в БД
     *
     * @param viewUpdate update filter
     */
    void update(OrganizationViewUpdate viewUpdate);

    /**
     * Получить список организаций
     *
     * @return OrganizationViewList
     */
    List<OrganizationViewList> list();

    /**
     * Получить организацию по ID
     *
     * @return OrganizationView
     */
    OrganizationView getById(Integer id);

//    /**
//     * Удалить организацию по ID
//     *
//     * @param id delete by
//     */
//    void delete(Integer id);

}