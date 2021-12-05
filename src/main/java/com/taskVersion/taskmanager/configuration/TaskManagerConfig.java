package com.taskVersion.taskmanager.configuration;

import com.faunadb.client.FaunaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
public class TaskManagerConfig{

    @Value("${fauna-db.secret}")
    private String serverKey;
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public FaunaClient faunaConfiguration() {
        log.info("Inside fauna client");
        FaunaClient faunaClient = FaunaClient.builder()
                .withSecret(serverKey)
                .build();
        log.info("returning fauna client");
        return faunaClient;
    }
}
