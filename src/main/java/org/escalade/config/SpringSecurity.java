package org.escalade.config;

import org.escalade.model.dao.UserDetailsService;
import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    static final Logger logger = LoggerFactory.getLogger(SpringSecurity.class);

    private UserDetailsService userDetailsService;

    public SpringSecurity() {
        this.userDetailsService = new UserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        logger.info("configure web");
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers("/user/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().hasAnyRole("USER","ADMIN","ANONYMOUS")
                .and().formLogin()
                .loginPage("/login").successForwardUrl("/login").failureForwardUrl("/login").permitAll()
                .and().httpBasic();
    }


    public void configure(AuthenticationManagerBuilder authentication)
            throws Exception {
        logger.info("configure globale web");
        authentication.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");
        authentication.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        logger.info("password encoder");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        logger.info("auth provider");
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
