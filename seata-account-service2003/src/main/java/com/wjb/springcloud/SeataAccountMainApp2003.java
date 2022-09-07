package com.wjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <b><code>${NAME}</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> ${DATE} ${TIME}.
 *
 * @author Arjun
 * @version 1.0.0
 * @since ${PROJECT_NAME} ${PROJECT_VERSION}
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataAccountMainApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class, args);
    }
}