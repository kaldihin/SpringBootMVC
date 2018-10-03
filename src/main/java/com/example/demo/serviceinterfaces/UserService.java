package com.example.demo.serviceinterfaces;

import com.example.demo.views.UserView;
import com.example.demo.views.UserViewList;
import com.example.demo.views.UserViewSave;
import com.example.demo.views.UserViewUpdate;

import java.util.List;

/**
 * Сервис
 */
public interface UserService {

    /**
     * Добавить нового сотрудника в БД
     *
     * @param userViewSave
     */
    void save(UserViewSave userViewSave);

    /**
     * Получить список сотрудников
     *
     * @return {@List<UserView>}
     */
    List<UserViewList> list();

    /**
     * Получить список сотрудников по ID
     *
     * @param id
     * @return {@User}
     */
    UserView getUser(Integer id);

    /**
     * Обновить данные в БД
     *
     * @param userViewUpdate
     */
    void update(UserViewUpdate userViewUpdate);

//    /**
//     * Удалить User по id
//     *
//     * @param id
//     */
//    void delete(Integer id);

}