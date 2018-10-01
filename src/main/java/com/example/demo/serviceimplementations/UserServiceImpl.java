package com.example.demo.serviceimplementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.daointerfaces.UserDao;
import com.example.demo.models.User;
import com.example.demo.serviceinterfaces.UserService;
import com.example.demo.views.UserView;
import com.example.demo.views.UserViewList;
import com.example.demo.views.UserViewSave;
import com.example.demo.views.UserViewUpdate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(UserViewSave userViewSave) {
        User user = new User(userViewSave.getId(), userViewSave.getOfficeId(), userViewSave.getFirstName(), userViewSave.getSecondName(),
                userViewSave.getMiddleName(), userViewSave.getLastName(), userViewSave.getPosition(), userViewSave.getDocCode(), userViewSave.getDocName(),
                userViewSave.getDocNumber(), userViewSave.getDocDate(), userViewSave.getCitizenshipName(), userViewSave.getCitizenshipCode(),
                userViewSave.getPhone(), userViewSave.getIsIdentified());
        dao.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserViewList> list() {
        List<User> all = dao.list();

        return all.stream()
                .map(mapUser())
                .collect(Collectors.toList());
    }

    private Function<User, UserViewList> mapUser() {
        return user -> {
            UserViewList userViewList = new UserViewList();
            userViewList.setOfficeId(user.getOfficeId());
            userViewList.setFirstName(user.getFirstName());
            userViewList.setMiddleName(user.getMiddleName());
            userViewList.setLastName(user.getLastName());
            userViewList.setPosition(user.getPosition());
            userViewList.setDocCode(user.getDocCode());
            userViewList.setCitizenshipCode(user.getCitizenshipCode());

            log.debug(userViewList.toString());

            return userViewList;
        };
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void update(UserViewUpdate userViewUpdate) {
        User userUpdate = new User(userViewUpdate.getId(), userViewUpdate.getOfficeId(), userViewUpdate.getFirstName(), userViewUpdate.getSecondName(),
                userViewUpdate.getMiddleName(), userViewUpdate.getLastName(), userViewUpdate.getPosition(), userViewUpdate.getDocCode(), userViewUpdate.getDocName(),
                userViewUpdate.getDocNumber(), userViewUpdate.getDocDate(), userViewUpdate.getCitizenshipName(), userViewUpdate.getCitizenshipCode(),
                userViewUpdate.getPhone(), userViewUpdate.getIsIdentified());
        dao.update(userUpdate);
    }

    @Override
    @Transactional
    public UserView getUser(Integer id) {
        User userById = dao.getUser(id);
        return new UserView(userById);
    }
}
