package autorization.hw_spr_boot_2.config;

import autorization.hw_spr_boot_2.controller.AuthorizationController;
import autorization.hw_spr_boot_2.repository.UserRepository;
import autorization.hw_spr_boot_2.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
