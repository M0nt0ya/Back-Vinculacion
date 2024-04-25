package Yavirac.Vin.Vinculacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import Yavirac.Vin.Vinculacion.config.SwaggerConfig;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfig.class)
public class VinculacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinculacionApplication.class, args);
    }

}
