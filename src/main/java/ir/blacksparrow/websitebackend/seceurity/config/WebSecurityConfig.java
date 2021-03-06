package ir.blacksparrow.websitebackend.seceurity.config;

//import ir.blacksparrow.websitebackend.business.sevice.user.UserService;
import ir.blacksparrow.websitebackend.business.sevice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurityConfig(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder1) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder1;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/", "index","/swagger-ui.html","/swagger-ui/**", "/user/**", "/category/**", "/category-element/**").permitAll()
                .antMatchers("/", "index","/swagger-ui.html","/swagger-ui/**", "/user/**", "/category-element/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
//                .httpBasic();
//                .antMatchers("/swagger-ui/**").permitAll()
//                .anyRequest()
//                .authenticated().and()
                .formLogin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails user=User.builder()
//                .username("mmd")
//                .password(bCryptPasswordEncoder.encode("mmd"))
//                .roles("STUDENT")
//                .build();
//        return new InMemoryUserDetailsManager(
//                user
//        );
//    }
}
