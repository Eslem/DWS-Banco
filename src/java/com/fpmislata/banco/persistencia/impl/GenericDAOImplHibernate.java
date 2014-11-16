/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.impl;

import com.fpmislata.banco.persistencia.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.type.EntityType;

/**
 *
 * @author eslem
 */
public class GenericDAOImplHibernate<T> implements GenericDAO<T> {

    private SessionFactory sessionFactory;

    protected SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
        
    }
    public Class<?> getClazz(){
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T get(int id) {
        Session session = getSessionFactory().openSession();
        this.preGet(session, id);
        T object = (T) session.get(getClazz(), id);
        this.postGet(session, object);
        session.close();
        return object;
    }

    @Override
    public T insert(T object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        this.preInsert(session, object);
        session.save(object);
        session.getTransaction().commit();
        this.postInsert(session, object);
        session.flush();
        session.close();
        return (T) object;
    }

    @Override
    public T update(T object) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        this.preUpdate(session, object);
        session.update(object);
        session.getTransaction().commit();
        this.postUpdate(session, object);
        session.close();
        return (T) object;
    }

    @Override
    public void delete(int id) {
        T object = this.get(id);
        if (object != null) {
           
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
             this.preDelete(session, id);
            session.delete(object);
            this.postDelete(session, id);
            session.getTransaction().commit();
            session.close();
        
        }
    }

    @Override
    public List<T> findAll() {
        Session session = getSessionFactory().openSession();
        List usuarios = session.createCriteria(getClazz()).list();
        session.close();
        return usuarios;
    }

    protected void preInsert(Session session, T object) {};
    protected void preUpdate(Session session, T object) {};
    protected void preGet(Session session, int id) {};
    protected void preDelete(Session session, int id) {};
    protected void postInsert(Session session, T object) {};
    protected void postUpdate(Session session, T object) {};
    protected void postGet(Session session, T object) {};
    protected void postDelete(Session session, int t) {};

}
