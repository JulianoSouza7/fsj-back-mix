package br.com.fsjbackmix.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class SwaggerCofing  : WebMvcConfigurer {

    @Value("\${spring.application.name}")
    lateinit var name: String

    @Value("\${fsj.apiversion}")
    lateinit var version: String

    @Value("\${fsj.dev}")
    lateinit var isDev: String

    @Value("\${server.port}")
    lateinit var portLocal: String

    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("0 - All")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun springShopOpenAPI(): OpenAPI {
        return OpenAPI().info(
            Info().title(name)
//                .description(description)
                .version(version)
                .license(
                    License()
                        .name("Apache 2.0")
                        .url("https://springdoc.org")
                )
        ).externalDocs(
            ExternalDocumentation()
                .description("SpringShop Wiki Documentation")
                .url("https://springshop.wiki.github.org/docs")
        ).servers(
            arrayListOf(
                Server()
                    .url(
                        if (isDev == "true") {
                            "http://localhost:$portLocal"
                        } else {
                            "https://" + "[^a-zA-Z0-9]".toRegex().replace(name, "") + ".srv.farmaciassaojoao.com.br"
                        }
                    )
            )
        )
    }
}