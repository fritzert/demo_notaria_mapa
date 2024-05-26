package com.frodas.notaria.mapa.config.openapi;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

import static com.frodas.notaria.mapa.util.constants.ConstantsPath.API_MAPA_NOTARIAL;
import static com.frodas.notaria.mapa.util.constants.ConstantsPath.PATH_MAPA_NOTARIAL;

@Order(1)
@Configuration
public class OpenApiConfig {

    @Bean
    GroupedOpenApi mapaApi(@Value("${springdoc.version}") String appVersion) {
        return GroupedOpenApi.builder()
                .displayName(API_MAPA_NOTARIAL)
                .group(API_MAPA_NOTARIAL.toLowerCase())
                .pathsToMatch(PATH_MAPA_NOTARIAL + "/**")
                .addOpenApiCustomizer(openApi ->
                        openApi.info(new Info()
                                        .title(API_MAPA_NOTARIAL + " API")
                                        .version(appVersion)
                                        .description("Servicio para visualizar mapas notariales a nivel nacional")
                                        .contact(new Contact().name("Frodas").url("https://github.com/fertz").email("xxxxxxxx"))
                                        .license(new License().name("Apache 2.0").url("https://github.com/fertz")))
                                .servers(List.of(new Server().url("http://localhost:9002"), new Server().url("http://localhost:9022")))
                                .tags(List.of(new Tag().name("MapaService").description("Servicio de Mapas Notariales")))
                )
                .build();
    }

}
