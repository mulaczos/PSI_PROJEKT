package shop.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired
    private SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;
    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;
    @Autowired
    private RestUnauthorizedEntryPoint restUnauthorizedEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .headers().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restUnauthorizedEntryPoint)
                .accessDeniedHandler(restAccessDeniedHandler)
                .and()
                .formLogin()
                .permitAll()
                .successHandler(securityAuthenticationSuccessHandler)
                .failureHandler(securityAuthenticationFailureHandler)
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/")
                .and()
                .formLogin()
                .loginPage("/api/login");
    }
}