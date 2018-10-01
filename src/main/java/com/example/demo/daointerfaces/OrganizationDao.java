package com.example.demo.daointerfaces;

import com.example.demo.models.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить все объекты Organization
     *
     * @return List
     */
    List<Organization> list();

    /**
     * Получить Organization по ID
     *
     * @param id load by
     * @return Organization
     */
    Organization getById(Integer id);

    /**
     * Добавить или поменять значения Organization
     *
     * @param organization update
     */
    void update(Organization organization);

    /**
     * Сохранить Organization
     *
     * @param organization save
     */
    void save(Organization organization);

    /**
     * Удалить Organization по ID
     *
     * @param id delete
     */
    void delete(Integer id);
}
