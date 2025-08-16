package SpringStudy.config;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public void handleNoUserFoundException(){
        System.out.println("No such user");
    }
}
