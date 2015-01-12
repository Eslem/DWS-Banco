/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.dao.impl.hibernate;

import com.fpmislata.banco.persistencia.dao.GenericDAO;
import com.fpmislata.banco.persistencia.common.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author eslem
 */
public class GenericDAOImplHibernate<T> implements GenericDAO<T> {

    final public Class<?> getClazz() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    final public T get(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        this.preGet(session, id);
        T object = (T) session.get(getClazz(), id);
        this.postGet(session, object);

        return object;
    }

    @Override
    final public T insert(T object) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            this.preInsert(session, object);
            session.save(object);
            session.getTransaction().commit();
            this.postInsert(session, object);
            session.flush();
        } catch (ConstraintViolationException cve) {
            session.getTransaction().rollback();
        }

        return (T) object;
    }

    @Override
    final public T update(T object) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            this.preUpdate(session, object);
            session.update(object);
            session.getTransaction().commit();
            this.postUpdate(session, object);
        } catch (ConstraintViolationException cve) {
            session.getTransaction().rollback();
        }

        return (T) object;
    }

    @Override
    final public void delete(int id) {
        T object = this.get(id);
        if (object != null) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                this.preDelete(session, id);
                session.delete(object);
                this.postDelete(session, id);
                session.getTransaction().commit();
            } catch (ConstraintViolationException cve) {
                session.getTransaction().rollback();
            }

        }
    }

    @Override
    final public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List usuarios = session.createCriteria(getClazz()).list();

        return usuarios;
    }

    protected void preInsert(Session session, T object) {
    }

    ;
    protected void preUpdate(Session session, T object) {
    }

    ;
    protected void preGet(Session session, int id) {
    }

    ;
    protected void preDelete(Session session, int id) {
    }

    ;
    protected void postInsert(Session session, T object) {
    }

    ;
    protected void postUpdate(Session session, T object) {
    }

    ;
    protected void postGet(Session session, T object) {
    }

    ;
    protected void postDelete(Session session, int t) {
    }
;

}
