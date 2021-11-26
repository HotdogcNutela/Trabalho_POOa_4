package br.ufscar.dc.dsw.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufscar.dc.dsw.security.ClienteDetailsServiceImpl;

@Configuration
@RequestMapping(value = "/login", method = RequestMethod.POST)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public UserDetailsService userDetailsService(){
        return new ClienteDetailsServiceImpl();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/cliente/**").hasAnyRole("CLIENTE", "ADMIN")
                .antMatchers("/compra/**").hasAnyRole("CLIENTE", "ADMIN")
                .antMatchers("/static/**", "/js/**", "/css/**", "/image/**", "/json/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login/**","/home/**","/pacote/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
				.loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .failureUrl("/login?error=true")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.
            ignoring().antMatchers("/pacote/lista","/pacotes/listar","/pacotes/ordenar");
    }
}
