package com.mporium.testcase.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({ "com.mporium.testcase" })
@SpringBootApplication
@EnableSwagger2
public class AppConfig {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppConfig.class, args);
	}

	@Bean
	public Docket apiDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api").apiInfo(apiInfo()).select()
				.paths(internalPaths()).build()
				.globalOperationParameters(new ArrayList<>(Arrays.asList(new ParameterBuilder().name("Authorization")
						.description(
								"Bearer token for oauth2 (if you have logged in, you do not need to enter this, it will be added automatically.")
						.modelRef(new ModelRef("string")).parameterType("header").required(false).build())));
	}

	private Predicate<String> internalPaths() {
		return regex("/.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring REST Sample with Swagger")
				.description("Spring REST Sample with Swagger")
				.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE").version("2.0")
				.build();
	}

}
