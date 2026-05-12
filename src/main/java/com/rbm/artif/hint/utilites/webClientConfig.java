package com.rbm.artif.hint.utilites;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class webClientConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
