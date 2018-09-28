package com.example.demo.daointerfaces;

import com.example.demo.models.User;

import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {
    /**
     * Получить все объекты User
     *
     * @return
     */
    List<User> list();

    /**
     * Получить User по идентификатору
     *
     * @param id
     * @return
     */
    User getUser(Integer id);

    /**
     * Добавить или поменять значения User
     * @param user
     */
    void update(User user);

    /**
     * Сохранить User
     *
     * @param user
     */
    void save(User user);

    /**
     * Удалить User по id
     *
     * @param id
     */
    void delete(Integer id);
}
