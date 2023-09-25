/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.points;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author q
 */
public class DB_hibernate implements IntDB{
    SessionFactory sf = HibernateSessionFactory.getSessionFactory();
    public DB_hibernate() {
//            Session session .openSession();
//            Transaction tx1 = session.beginTransaction();
//            MyPoint mp = new MyPoint(10,10);
//            session.save(mp);
//            tx1.commit();
//            session.close();
    }

    @Override
    public ArrayList<MyPoint> getAllPoint_h() {
        ArrayList<MyPoint> res = new ArrayList<>();
        List<MyPoint> pointList = sf.openSession().
                createQuery("From MyPoint", MyPoint.class).list();
        for(MyPoint mp: pointList){
            res.add(mp);
        }
        return res;
    }

    @Override
    public void addPointToBD_h(MyPoint mp) {
            Session session = sf.openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(mp);
            tx1.commit();
            session.close();
    }

    @Override
    public void movePointToBD_h(MyPoint mp) {
            Session session = sf.openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(mp);
            tx1.commit();
            session.close();
    }
    
}
