package exception;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeNotFoundException extends RuntimeException{
}
