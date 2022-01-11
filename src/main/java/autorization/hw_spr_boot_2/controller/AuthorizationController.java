package autorization.hw_spr_boot_2.controller;

import autorization.hw_spr_boot_2.constants.Authorities;
import autorization.hw_spr_boot_2.exceptions.InvalidCredentials;
import autorization.hw_spr_boot_2.exceptions.UnauthorizedUser;
import autorization.hw_spr_boot_2.service.AuthorizationService;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    String handlerUnauthorizedUser(UnauthorizedUser exp) {
        System.out.println(exp.getMessage());
        return exp.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    String handlerInvalidCredentials(InvalidCredentials exp) {
        return exp.getMessage();
    }
}
