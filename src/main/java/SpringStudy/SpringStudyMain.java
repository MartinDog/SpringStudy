package SpringStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableSpringConfigured
public class SpringStudyMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringStudyMain.class, args);
    }
}
