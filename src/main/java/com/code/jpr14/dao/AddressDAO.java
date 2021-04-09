package com.code.jpr14.dao;
import com.code.jpr14.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class AddressDAO {
    @Autowired
    SessionFactory sessionFactory;




    private static int ADDRESS_COUNT;
    private List<Address> addresses;


    {
        addresses = new ArrayList<Address>();
    }



    public void save(Address address){
        Session session= sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(address);
        transaction.commit();
        session.close();
    }
    public void del(Long n){
        Session session= sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.delete(session.get(Address.class, n));
        transaction.commit();
        session.close();


    }

    public List<Address> index() {
        Session session= sessionFactory.openSession();
        List a= session.createQuery("select u from Address u",
                Address.class).getResultList();
        return a;

    }
}