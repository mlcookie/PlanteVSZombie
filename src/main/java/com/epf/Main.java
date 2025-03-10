package com.epf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.epf.Persistance.Config;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Connexion à la base de données réussie ! ✅");
        } catch (Exception e) {
            System.err.println("Erreur de connexion à la base de données ❌");
            e.printStackTrace();
        }
    }
}
