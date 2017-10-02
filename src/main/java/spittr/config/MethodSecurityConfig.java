package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import spittr.security.SpitterPermissionEvaluator;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)    //Secured annotation 사용하기 위한 설정
//@EnableGlobalMethodSecurity(jsr250Enabled = true) //RolesAllowed annotation 사용하기 위한 설정
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    //맞춤형 권한 평가자
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();

        expressionHandler.setPermissionEvaluator(new SpitterPermissionEvaluator());

        return expressionHandler;
    }
}
