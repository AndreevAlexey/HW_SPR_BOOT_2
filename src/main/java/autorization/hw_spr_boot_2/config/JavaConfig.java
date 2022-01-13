package autorization.hw_spr_boot_2.config;

import autorization.hw_spr_boot_2.repository.UserRepository;
import autorization.hw_spr_boot_2.resolver.UserHandlerResolver;
import autorization.hw_spr_boot_2.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class JavaConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private UserHandlerResolver userHandlerResolver;

    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userHandlerResolver);
    }

}
