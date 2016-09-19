package com.vodafone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Ravi Aghera
 */
@SpringBootApplication
public class ApplicationLauncher extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationLauncher.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationLauncher.class, args);
    }

}
