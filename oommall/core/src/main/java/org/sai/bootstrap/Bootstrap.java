package org.sai.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Bootstrap {

        public static void main(String[] args) {
            SpringApplication.run(Bootstrap.class, args);
        }

}
