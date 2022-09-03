package com.wjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

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
@EnableHystrixDashboard
public class HystrixDashboardMain9001
{
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}