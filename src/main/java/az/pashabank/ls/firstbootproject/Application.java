package az.pashabank.ls.firstbootproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    @Bean
    public Paper createPaper() {
        return new Paper("learning session");
    }

    @Bean
    public Printer createPrinter(Paper paper) {
        return new Printer(paper);
    }
}
