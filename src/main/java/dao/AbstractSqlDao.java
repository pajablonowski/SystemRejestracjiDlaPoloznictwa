package dao;

import hibernate.util.HibernateUtil;

import javax.persistence.EntityManager;

public class AbstractSqlDao {


    protected final HibernateUtil hibernateUtil = HibernateUtil.getInstance();
    protected final EntityManager entityManager = hibernateUtil.getManager();

}
