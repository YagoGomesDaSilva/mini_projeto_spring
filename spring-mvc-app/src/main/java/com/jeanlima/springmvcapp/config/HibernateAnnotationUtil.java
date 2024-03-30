package com.jeanlima.springmvcapp.config;


import com.jeanlima.springmvcapp.Model.Aluno;
import com.jeanlima.springmvcapp.Model.Avatar;
import com.jeanlima.springmvcapp.Model.Curso;
import com.jeanlima.springmvcapp.Model.Disciplina;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@Component
//@PropertySource("classpath:application.properties")
public class HibernateAnnotationUtil {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private HibernateAnnotationUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(dbSettings())
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Aluno.class)
                .addAnnotatedClass(Avatar.class)
                .addAnnotatedClass(Curso.class)
                .addAnnotatedClass(Disciplina.class)
                .buildMetadata();

        return metadata.buildSessionFactory();
    }
    private static Map<String, Object> dbSettings() {
        Map<String, Object> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/mini_projeto_2");
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "mortadelaYY1@");
        dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        dbSettings.put(Environment.SHOW_SQL, "true");
        dbSettings.put(Environment.HBM2DDL_AUTO, "create");
        return dbSettings;
    }
}
