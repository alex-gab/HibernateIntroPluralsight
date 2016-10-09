package com.example;

import org.hibernate.Session;

public final class Program {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        ProteinUser user = new ProteinUser();
        user.setName("Joe");
        user.setGoal(250);
        session.save(user);

        session.getTransaction().commit();

        session.beginTransaction();

        ProteinUser loadedUser = session.load(ProteinUser.class, 0);
        System.out.println(loadedUser.getName());
        System.out.println(loadedUser.getGoal());

        loadedUser.setTotal(loadedUser.getTotal() + 50);

        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}
