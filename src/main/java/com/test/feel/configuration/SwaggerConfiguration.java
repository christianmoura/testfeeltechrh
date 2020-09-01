/**
 * 
 */
package com.test.feel.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
@ComponentScan("com.test.feel.configuration")
public class SwaggerConfiguration {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.test.feel.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false);
    }
	
	private ApiInfo getApiInfo() {
	       return new ApiInfo("Feel Test",
	                    "Documentation | Feel Test APIs | Developer Test"
	                    , "V1"
	                    , "http://developertest.feel.com.br/terms"
	                    , new Contact("Christian Bernardino de Moura", "https://www.linkedin.com/in/christianmoura/","christianbmoura@gmail.com")
	                    , " Test License", "http://feeltechrh.com/test/license", Collections.emptyList());
	    }
	
}
