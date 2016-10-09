package com.example;

import org.hibernate.Session;

import java.util.Date;

@SuppressWarnings("Duplicates")
public final class Program {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        ProteinUser joeUser = new ProteinUser();
        joeUser.setName("Joe");
        joeUser.addHistory(new UserHistory(new Date(), "Set name to Joe"));
        joeUser.getProteinData().setGoal(250);
        joeUser.addHistory(new UserHistory(new Date(), "Set the goal to 250"));
        session.save(joeUser);

        session.getTransaction().commit();

        session.beginTransaction();

        ProteinUser marianUser = new ProteinUser();
        marianUser.setName("Marian");
        marianUser.addHistory(new UserHistory(new Date(), "Set name to Marian"));
        marianUser.getProteinData().setGoal(250);
        marianUser.addHistory(new UserHistory(new Date(), "Set the goal to 500"));
        session.save(marianUser);

        session.getTransaction().commit();


        session.beginTransaction();

        ProteinUser loadedUser = session.load(ProteinUser.class, 1);
        System.out.println(loadedUser.getName());
        System.out.println(loadedUser.getProteinData().getGoal());

        for (UserHistory history : loadedUser.getHistory()) {
            System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
        }

        loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
        loadedUser.addHistory(new UserHistory(new Date(), "Added 50 protein"));

        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}
