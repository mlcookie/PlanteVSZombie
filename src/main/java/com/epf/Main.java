package com.epf;

import com.epf.Core.Map;
import com.epf.Core.Plante;
import com.epf.Persistance.MapDAO;
import com.epf.Persistance.PlanteDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.epf.Persistance.Config;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configuration manuelle de la DataSource
        DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/ton_db", "user", "password");

        // Création du contexte Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Récupération du DAO
        PlanteDAO planteDAO = context.getBean(PlanteDAO.class);

        // Ajout d'une nouvelle plante
       // Plante nouvellePlante = new Plante("Tournesol", 100, 0.0, 0, 50, 25.0, Plante.Effet.NORMAL, "tournesol.png");
       // planteDAO.addPlante(nouvellePlante);
        //System.out.println("✅ Plante ajoutée !");

        // Récupération et affichage de toutes les plantes
        List<Plante> plantes = planteDAO.getAllPlantes();
        System.out.println("📜 Liste des plantes : " + plantes);

    }
}
