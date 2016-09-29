package com.ourfuture.back_front.dao;

import com.ourfuture.back_front.basedao.BaseDAO;
import com.ourfuture.back_front.bean.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author ice
 * 
 */
public class UserDAO extends BaseDAO {

    /**
     * 保存更新用户
     * 
     * @param user
     *            用户
     */
    public void saveOrUpdate(User user) {
        Session session = getSession();
        session.getTransaction().begin();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    /**
     * 分页获取用户列表
     * 
     * @param page
     *            页数
     * @param pageSize
     *            每页数量
     * @return 用户列表
     */
    @SuppressWarnings("unchecked")
    public List<User> getUserList(int page, int pageSize) {
        StringBuilder sbHql = new StringBuilder();
        sbHql.append("from User");
        Session session = getSession();
        Query query = session.createQuery(sbHql.toString());
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<User> list = query.list();
        return list;
    }

    /**
     * 删除用户
     * 
     * @param userId
     *            用户id
     */
    public void deleteUser(User user) {
        Session session = getSession();
        session.getTransaction().begin();
        session.delete(user);
        session.getTransaction().commit();
    }
}
