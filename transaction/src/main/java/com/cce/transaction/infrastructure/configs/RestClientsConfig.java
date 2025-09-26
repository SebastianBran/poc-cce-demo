package com.cce.transaction.infrastructure.configs;

import com.cce.transaction.application.ports.DirectoryServiceClient;
import com.cce.transaction.application.ports.NotificationServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestClientBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientsConfig {
    @Value("${rest.client.directory-service}")
    private String directoryServiceBaseUrl;

    @Value("${rest.client.notification-service}")
    private String notificationServiceBaseUrl;

    @Bean
    DirectoryServiceClient directoryServiceClient(RestClient.Builder restClientBuilder,
                                                  RestClientBuilderConfigurer configurer) {
        RestClient restClient = configurer.configure(restClientBuilder)
                .baseUrl(directoryServiceBaseUrl)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(DirectoryServiceClient.class);
    }

    @Bean
    NotificationServiceClient notificationServiceClient(RestClient.Builder restClientBuilder,
                                                  RestClientBuilderConfigurer configurer) {
        RestClient restClient = configurer.configure(restClientBuilder)
                .baseUrl(notificationServiceBaseUrl)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(NotificationServiceClient.class);
    }
}
