package com.backend.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        Cloudinary cloudinary = new Cloudinary("cloudinary://952963554218591:Cqhnc9y10YKVS7W0fyv-hnHTaZg@dlt18old9");
        return cloudinary;
    }
}
