package com.ourfuture.back_front.service;

import com.ourfuture.back_front.bean.User;

import java.util.List;

/**
 * @author ice
 * 
 */
public interface IUserService {

    /**
     * 保存更新用户
     * 
     * @param user
     *            用户实例
     */
    public void saveOrUpdateUser(User user);

    /**
     * 获取用户列表
     * 
     * @param page
     *            页数
     * @param pageSize
     *            页数大小
     * @return 用户列表
     */
    public List<User> getUserList(int page, int pageSize);

    /**
     * 删除用户
     * 
     * @param user
     *            用户
     */
    public void deleteUser(User user);
}
