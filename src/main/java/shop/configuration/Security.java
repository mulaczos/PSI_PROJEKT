package shop.configuration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class Security extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    private SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;
    private RestAccessDeniedHandler restAccessDeniedHandler;
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
                .antMatchers("/rest/**").authenticated()
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
                .and().logout().logoutSuccessUrl("/");


    }
}