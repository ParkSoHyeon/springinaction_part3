package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)    //Secured annotation 사용하기 위한 설정
//@EnableGlobalMethodSecurity(jsr250Enabled = true) //RolesAllowed annotation 사용하기 위한 설정
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
