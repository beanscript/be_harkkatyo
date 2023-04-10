package k23BE.Harkkatyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	
	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/project/**")
    };
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests()
		.requestMatchers(WHITE_LIST_URLS)
		.permitAll()
		.and()
		.authorizeHttpRequests()
			.antMatchers("/css/**", "/js/**").permitAll()
			.antMatchers("/", "/index").permitAll()
			.anyRequest().authenticated()
			.and()
			.headers().frameOptions().disable()			
			.and()
		.formLogin()
//			.loginPage("/login")
			.defaultSuccessUrl("/index", true)
			.permitAll()
			.and()
		.logout()
			.permitAll()
			.and()
		.httpBasic();
		http.cors().and().csrf().disable();
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
