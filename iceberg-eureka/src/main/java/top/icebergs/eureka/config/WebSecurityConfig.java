package top.icebergs.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author iceberg
 * @create 2020-09-27 18:57
 * Eureka Server & Spring Security 服务注册与发现安全认证  配置
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                // .csrf().disable();//不建议完全禁用掉csrf
                .csrf().ignoringAntMatchers("/eureka/**");
    }
}