package com.github.neoramon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new ApplicationStarter().configure(new SpringApplicationBuilder(ApplicationStarter.class)).run(args);
    }

    // @Bean
    // public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    // return args -> {
    //
    // System.out.println("Let's inspect the beans provided by Spring Boot:");
    //
    // String[] beanNames = ctx.getBeanDefinitionNames();
    // Arrays.sort(beanNames);
    // for (String beanName : beanNames) {
    // System.out.println(beanName);
    // }
    //
    // };
    // }

    // @Bean
    // // @Profile("docker")
    // public EurekaInstanceConfigBean eurekaInstanceConfig() {
    // InetUtilsProperties properties = new InetUtilsProperties();
    // InetUtils inetUtils = new InetUtils(properties);
    // EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
    // config.setHostname("172.0.0.1");
    // config.setIpAddress("172.0.0.1");
    // config.setNonSecurePort(8080);
    // config.setAppname("person");
    // config.set
    // return config;
    // }
}
