package com.example.demo.daointerfaces;

import com.example.demo.models.Office;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {
    /**
     * Получить все объекты Office по ID организации
     *
     * @return List
     */
    List<Office> list(Integer orgId);

    /**
     * Получить Office по ID
     *
     * @param id by
     * @return Office
     */
    Office byId(Integer id);

    /**
     * Добавить или поменять значения Office
     *
     * @param office update
     */
    void update(Office office);

    /**
     * Сохранить Office
     *
     * @param office save
     */
    void save(Office office);

    /**
     * Удалить Office по ID
     *
     * @param id delete by
     */
    void delete(Integer id);
}
