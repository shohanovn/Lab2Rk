package com.example.demo.Configuration;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DualServerConfig {

    @Bean
    @Primary
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> mvcServer() {
        return factory -> factory.setPort(8080); // Tomcat для MVC
    }

    @Bean
    public WebServerFactoryCustomizer<NettyReactiveWebServerFactory> webfluxServer() {
        return factory -> factory.setPort(8081); // Netty для WebFlux
    }
}
