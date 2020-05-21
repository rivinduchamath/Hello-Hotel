package lk.sliit.employeeManagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ServletComponentScan
public class AppInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AppInitializer.class,args);
    }

}//End Class