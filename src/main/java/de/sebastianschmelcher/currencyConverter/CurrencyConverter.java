package de.sebastianschmelcher.currencyConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CurrencyConverter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CurrencyConverter.class, args);
    }
    
    @Bean
    public RestTemplate restTemplate()
    {
    	return new RestTemplate();
    }
    
    @Bean
    public ObjectMapper objectMapper()
    {
    	return new ObjectMapper();
    }
}