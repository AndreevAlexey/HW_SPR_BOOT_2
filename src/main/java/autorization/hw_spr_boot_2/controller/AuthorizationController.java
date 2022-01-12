package autorization.hw_spr_boot_2.controller;

import autorization.hw_spr_boot_2.constants.Authorities;
import autorization.hw_spr_boot_2.exceptions.InvalidCredentials;
import autorization.hw_spr_boot_2.exceptions.UnauthorizedUser;
import autorization.hw_spr_boot_2.service.AuthorizationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handlerUnauthorizedUser(UnauthorizedUser exp) {
        System.out.println(exp.getMessage());
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handlerInvalidCredentials(InvalidCredentials exp) {
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
