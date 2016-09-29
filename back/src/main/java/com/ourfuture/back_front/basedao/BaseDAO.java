package com.ourfuture.back_front.basedao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author ice
 * 
 */
public class BaseDAO {

    /**
     * @param sessionFactory
     *            the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }

    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate
     *            the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 会话工厂
     */
    private SessionFactory sessionFactory;

    /**
     * 会话
     */
    private Session session;

    /**
     * JDBC模板类
     */
    private JdbcTemplate jdbcTemplate;
}
