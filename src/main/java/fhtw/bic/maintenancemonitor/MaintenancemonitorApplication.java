package fhtw.bic.maintenancemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import org.thymeleaf.context.Context;
import java.time.LocalDateTime;

@SpringBootApplication
public class MaintenancemonitorApplication {

    public static void main(String[] args) {

        /*
        var resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");

        var context = new Context();
        context.setVariable("name", "Lind");
        context.setVariable("date", LocalDateTime.now().toString());

        var templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        var result = templateEngine.process("/", context);
        System.out.println(result);
        */

        SpringApplication.run(MaintenancemonitorApplication.class, args);

    }

}
