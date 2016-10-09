package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtilities {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                    configure().
                    build();
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("There was an error building the factory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
