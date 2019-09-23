package az.pashabank.learning_session.ms_student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsStudentApplication.class, args);
    }

}
