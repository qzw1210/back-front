package com.ourfuture.back_front.service;

import com.ourfuture.back_front.bean.User;
import com.ourfuture.back_front.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ice
 * 
 */
public class UserServiceImpl implements IUserService {

    public void saveOrUpdateUser(User user) {
        userDAO.saveOrUpdate(user);
    }

    public List<User> getUserList(int page, int pageSize) {
        List<User> list = userDAO.getUserList(page, pageSize);
        return list;
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    /**
     * 用户DAO
     */
    @Autowired
    private UserDAO userDAO;

}
