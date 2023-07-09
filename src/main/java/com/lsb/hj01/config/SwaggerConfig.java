// package com.lsb.hj01.config;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.info.Info;
// import lombok.RequiredArgsConstructor;
// import org.springdoc.core.models.GroupedOpenApi;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @OpenAPIDefinition(
//     info = @Info(title = "lsb app",version = "v1"))
// @RequiredArgsConstructor
// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public GroupedOpenApi chatOpenApi() {
//         String[] paths = {"/**"};

//         return GroupedOpenApi.builder()
//                 .group("lsb open API v1")
//                 .pathsToMatch(paths)
//                 .build();
//     }
// }