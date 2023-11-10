package MensajeriaExpress.Configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/*
@Configuration
@EnableAutoConfiguration
public class SwaggerConfig {






    @Bean
    Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API REST de Mensajeria de paquetes \uD83C\uDFE3")
                .description("El proyecto es una REST API para un sistema de mensajería de paquetes \uD83D\uDCE6 que permite a los clientes enviar y hacer seguimiento de los paquetes a través de una interfaz web. "
                        + "\n" +   " La API utiliza el protocolo HTTP para permitir que los usuarios interactúen con el sistema a través de una serie de endpoints de API \uD83D\uDD17 definidos. Los controladores principales del sistema son el Cliente, el Empleado y el Envío.")
                .version("1.0.0")
                .build();
    }


    	<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>3.0.0</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-boot-starter</artifactId>
			<version>3.0.0</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>3.0.0</version>
		</dependency>

		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version> <!-- La versión puede variar -->
		</dependency>

}


 */
