package org.escalade.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@ComponentScan(basePackages = "org.escalade")
public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    static final Logger logger = LoggerFactory.getLogger(HibernateConfig.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("hib");
        return new Class[] { HibernateConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("servlet");

        return new Class[] { SpringConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        logger.info("mapping");

        return new String[] { "/" };
    }
}