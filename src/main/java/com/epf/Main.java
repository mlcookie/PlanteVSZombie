package com.epf;

import com.epf.Persistance.Config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Main extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{Config.class}; // Charge la configuration de la base de données
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.WebConfig.class}; // Charge la configuration de Spring MVC
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Toutes les requêtes passent par Spring MVC
    }

    public static void main(String[] args) {
        // Spring se charge de démarrer l'application via l'initialisation configurée ci-dessus.
        // Donc pas besoin d'ajouter des appels dans cette méthode.
    }
}
