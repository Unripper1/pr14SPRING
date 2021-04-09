package com.code.jpr14.dao;
import com.code.jpr14.Address;
import com.code.jpr14.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingDAO {
    @Autowired
    SessionFactory sessionFactory;


    public void save(Building building){
        Session session= sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(building);
        transaction.commit();
        session.close();
    }
    public void del(Long n) {
        Session session= sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.delete(session.get(Building.class, n));
        transaction.commit();
        session.close();
    }

    public List<Building> index() {
        Session session= sessionFactory.openSession();
        List a= session.createQuery("select u from Building u",
                Building.class).getResultList();
        return a;
    }
}