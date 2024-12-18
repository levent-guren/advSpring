package com.advspring.config;

import java.util.HashMap;
import java.util.Map;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;

@Configuration
public class SwaggerConfig {
	@SuppressWarnings("rawtypes")
	@Bean
	OpenApiCustomizer removeSchemasCustomizer() {
		return openApi -> {
			if (openApi.getComponents() != null) {
				Components components = openApi.getComponents();
				Map<String, Schema> schemas = components.getSchemas();
				Map<String, Schema> schemas2 = new HashMap<String, Schema>();
				schemas.keySet().stream().forEach(className -> {
					if (className.endsWith("DTO") || "GlobalResponse".equals(className)) {
						schemas2.put(className, schemas.get(className));
					}
				});
				openApi.getComponents().setSchemas(schemas2);
			}
		};
	}

	// @formatter:off
	@Bean
	OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Swagger Örnek Uygulaması")
						.description("Veritabanında Employees ve Departments tablolarında işlemler yapan swagger uygulaması")
						.version("v0.0.1")
						.license(
								new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")
						)
					)
				 .externalDocs(
						 new ExternalDocumentation()
						 	.description("Ektra link oluşturabiliyoruz")
						 	.url("https://springshop.wiki.github.org/docs")
				);
	}
	// @formatter:on
}
