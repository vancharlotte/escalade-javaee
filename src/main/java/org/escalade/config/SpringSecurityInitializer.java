package org.escalade.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    static final Logger logger = LoggerFactory.getLogger(SpringSecurityInitializer.class);

    public SpringSecurityInitializer() {
        super(SpringSecurity.class);
        logger.info("Spring Security Initializer");

    }
}
