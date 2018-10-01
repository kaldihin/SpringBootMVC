package com.example.demo.serviceinterfaces;

import com.example.demo.views.OfficeView;
import com.example.demo.views.OfficeViewList;
import com.example.demo.views.OfficeViewSave;
import com.example.demo.views.OfficeViewUpdate;

import java.util.List;

/**
 * Сервис
 */
public interface OfficeService {

    /**
     * Добавить новый офис в БД
     *
     * @param officeViewSave save filter
     */
    void save(OfficeViewSave officeViewSave);

    /**
     * Получить список офисов по Идентификатору Организации
     *
     * @return Office
     */
    List<OfficeViewList> list(Integer orgId);

    /**
     * Получить список офисов по Идентификатору
     *
     * @return Office
     */
    OfficeView getById(Integer id);

    /**
     * Обновить данные в БД
     *
     * @param officeViewUpdate update filter
     */
    void update(OfficeViewUpdate officeViewUpdate);

    /**
     * Удалить Office
     *
     * @param id delete by
     */
    void delete(Integer id);
}