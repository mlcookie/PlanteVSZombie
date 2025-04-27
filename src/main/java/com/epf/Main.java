package com.epf;

import com.epf.Persistance.Config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Main extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{Config.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    public static void main(String[] args) {

    }
}
