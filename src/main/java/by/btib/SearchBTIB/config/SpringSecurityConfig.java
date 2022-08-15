package by.btib.SearchBTIB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    /*@Autowired
    PasswordEncoder passwordEncoder;*/
    @Bean
    PasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
//        return bCryptPasswordEncoder;
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
//                .withUser("admin")
//                .password("$2a$12$UG0bgAYFpnQXLRxQoHSyIOuEH7v/Iqr.2ROmJMW8VcOq.3/VvDnpa")
//                .roles("ADMIN")
//                .withUser("user")
//                .password("$2a$12$/JCQFrFvQn4eeQmbElVQseJrGh/EKSyP6vawrFAMsB.5RCuDOdRkK")
//                .roles("USER")
//                .withUser("agent")
//                .password("$2a$12$f8MFvKxhYIU3vgm3iE76d.P7tLJ8D.E1NGQewHMbie7MLhuWAwWz.")
//                .roles("AGENT");
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()

                .antMatchers("/**/delete**", "/**/update**", "/users**")
                .hasAnyRole("ADMIN")

                //.antMatchers("index", "/search**")
                //.hasAnyRole("USER")

                .antMatchers("/policies/go/create")
                .hasAnyRole("AGENT")

                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        //.loginPage("/login");

    }
}
