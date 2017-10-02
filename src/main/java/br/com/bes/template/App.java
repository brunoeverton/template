package br.com.bes.template;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import liquibase.integration.spring.SpringLiquibase;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.bes.template.entity" })
@EnableSwagger2
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    /**
     * Configuracao do liquibase
     * 
     * @param dataSource
     * @return
     */
    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
    	
    	SpringLiquibase springLiquibase = new SpringLiquibase();
    	springLiquibase.setDataSource(dataSource);
    	springLiquibase.setChangeLog("classpath:/db/db-changelog.xml");
    	springLiquibase.setContexts("test, production");
    	return springLiquibase;
    }

    /**
     * Configura e cria bean do swagger
     * 
     * @return
     */
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)  
        			.apiInfo(apiInfo())
                .select()                                  
                .apis(RequestHandlerSelectors.basePackage("br.com.bes.template.controller"))              
                .build();    
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Projeto Template")
                .description("Projeto template com frameworks básicos.")
                .contact("Bruno Everton")
                .version("1.0")
                .build();
    }
    
}
