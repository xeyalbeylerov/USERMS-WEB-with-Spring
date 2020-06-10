package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //bunu yazmaqda məqsəd, aşağıdakı interfeysi implement
    // edən classda hər şeyi custom olaraq edə bilməkdir.
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //some folder ignored
    @Override
    public void configure(WebSecurity web) throws Exception {
        String[] unsecuredResources = {"/css/**", "**/js/**", "/img/**", "/fonts/**", "/assets/**", "WEB-INF/assets/**"};
        web.ignoring().antMatchers(unsecuredResources);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/login**").permitAll()

//                .authorizeRequests().antMatchers("sign**").permitAll()
//                .and()
                .and()
                .authorizeRequests().antMatchers("/registration").permitAll()
                .and()
                .authorizeRequests().antMatchers("/css/**", "/js/**", "/img/**", "**/favicon.ico").anonymous()
                .and()
                .authorizeRequests().antMatchers("/users","/useredit","/foo","/index","/userdetail","/userdelete").hasAnyAuthority("USER", "ADMIN")//"USER",
                .and()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
//                    .loginProcessingUrl("/login")
                .defaultSuccessUrl("/users", true)
                .permitAll()
                .and()
                .logout()
//                .logoutUrl("/logout")
                .logoutSuccessUrl("/login").permitAll()
                .and().csrf().disable()
        ;
    }

}
