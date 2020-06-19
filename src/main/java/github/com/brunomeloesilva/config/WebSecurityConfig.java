package github.com.brunomeloesilva.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().withUser("bruno").password("{noop}123456").roles("USER");
        //O {noop} acima é para indicar o tipo de criptografia a ser usada na senha
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
        .antMatchers("/h2-console/**").permitAll() /* Essa linha é para dar passagem livre (sem pedir senha), para a url /h2-console/**, os ** é significa qualquer coisa */
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() /* Estou permitindo qualquer chamada via OPTIONS sem autenticação */
        .anyRequest().authenticated()
        .and().httpBasic()
        .and().csrf().disable(); //csrf é proteção contra ataques web, sem mais detalhes...
    }
}