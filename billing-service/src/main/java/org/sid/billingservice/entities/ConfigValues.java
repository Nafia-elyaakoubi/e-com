package org.sid.billingservice.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigValues {

    // passing the key which you set in application.properties
    @Value("${my.keycloak.token}")
    private String token;

    // getting the value from that key which you set in application.properties
    @Bean
    public String getToken() {
        return token;
    }
}