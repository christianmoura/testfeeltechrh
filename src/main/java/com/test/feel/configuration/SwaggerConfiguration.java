/**
 * 
 */
package com.test.feel.configuration;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Christian Bernardino de Moura
 *
 * christiabmoura@gmail.com
 */

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.test.feel.api","com.test.feel.configuration"})
public class SwaggerConfiguration {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.test.feel.api"))
                .build()
                .apiInfo(getApiInfo());
    }
	
	private ApiInfo getApiInfo() {
		
	       
	       return new ApiInfoBuilder()
	               .title("Request Manager API")
	               .description("Management of requests of products by customers")
	               .license("")
	               .licenseUrl("http://unlicense.org")
	               .termsOfServiceUrl("")
	               .version("1.0.0")
	               .contact(new Contact("Christian Bernardino de Moura","https://www.linkedin.com/in/christianmoura/", "christianbmoura@gmail.com"))
	               .build();
	    }
	
	
	
}
