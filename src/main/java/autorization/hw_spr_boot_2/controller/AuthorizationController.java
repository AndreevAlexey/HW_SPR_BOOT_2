package autorization.hw_spr_boot_2.controller;

import autorization.hw_spr_boot_2.annotation.LoginUser;
import autorization.hw_spr_boot_2.constants.Authorities;
import autorization.hw_spr_boot_2.exceptions.InvalidCredentials;
import autorization.hw_spr_boot_2.exceptions.UnauthorizedUser;
import autorization.hw_spr_boot_2.service.AuthorizationService;

import autorization.hw_spr_boot_2.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @LoginUser User user) {
        return service.getAuthorities(user);
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

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handlerConstraintViolationException(ConstraintViolationException exp) {
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
