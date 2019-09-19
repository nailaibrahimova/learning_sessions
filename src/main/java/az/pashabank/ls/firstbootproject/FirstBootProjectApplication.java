package az.pashabank.ls.firstbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstBootProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FirstBootProjectApplication.class, args);
        Paper paper = (Paper) context.getBean("createPaper");
        System.out.println(paper.getName());

        Printer printer = (Printer) context.getBean("createPrinter");
        System.out.println(printer.getPaper().getName());
    }

}
