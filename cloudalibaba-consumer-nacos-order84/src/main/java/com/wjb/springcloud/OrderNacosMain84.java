package com.wjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
@EnableFeignClients
public class OrderNacosMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain84.class, args);
    }
}