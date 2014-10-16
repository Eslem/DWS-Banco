/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.impl;

import com.fpmislata.banco.dominio.Usuario;
import com.fpmislata.banco.persistencia.UsuarioDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author eslem
 */
public class UsuarioDAOImplHibernate implements UsuarioDAO {

    private SessionFactory sessionFactory;

    private SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    @Override
    public Usuario get(int id) {
        Session session = getSessionFactory().openSession();
        Usuario bank = (Usuario) session.get(Usuario.class, id);
        session.close();
        return bank;
    }

    @Override
    public Usuario insert(Usuario entidad) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entidad);
        session.getTransaction().commit();
        session.flush();
        session.close();
        return entidad;
    }

    @Override
    public Usuario update(Usuario entidad) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(entidad);
        session.getTransaction().commit();
        session.close();
        return entidad;
    }

    @Override
    public void delete(int id) {
        Usuario usuario = this.get(id);
        if (usuario != null) {
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<Usuario> findAll() {
        Session session = getSessionFactory().openSession();
        List usuarios = session.createQuery("FROM usuarios").list();
        session.close();
        return usuarios;
    }

}
