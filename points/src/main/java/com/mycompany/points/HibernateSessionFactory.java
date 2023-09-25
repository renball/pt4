/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.points;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//В данном фрагменте кода создается класс HibernateSessionFactory,

// через который происходят все операции с базой данных.
//Внутри метода getSessionFactory() производится проверка, создан ли уже объект sessionFactory. Если нет, то выполняется следующее:
//Если при выполнении какого-либо из этих шагов возникает ошибка, то в консоль выводится сообщение об ошибке.
public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;
    // который содержит метод getSessionFactory() для получения объекта SessionFactory - главного объекта Hibernate,
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //- создается объект Configuration, который загружает конфигурацию Hibernate из файла hibernate.cfg.xml;
                Configuration configuration = new Configuration().
                        configure();
                //- добавляется аннотированный класс PlayerEntity, который является сущностью базы данных;
                configuration.addAnnotatedClass(MyPoint.class);
                //- создается объект StandardServiceRegistryBuilder, который применяет настройки для Configuration;
                //- создается объект SessionFactory с помощью метода buildSessionFactory() у Configuration и builder.build();
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().
                                applySettings(configuration.getProperties());
                //- объект sessionFactory сохраняется в статической переменной и возвращается методом.
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Hibernate Factory - " + e);
            }
        }
        return sessionFactory;
    }
}
