package az.pashabank.learning_sessions.crud_operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrudOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudOperationApplication.class, args);
    }

}
