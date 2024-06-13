package com.wipro.ekartManagemet_1.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper model(){
        return new ModelMapper();
    }


}
