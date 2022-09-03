package com.wjb.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>GateWayConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/9/3 16:28.
 *
 * @author Arjun
 * @version 1.0.0
 * @since springcloud
 */
@Configuration
public class GateWayConfig {
    // 方式一yml文件路由
    // 方式二配置文件路由
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("route1",r->r.path("/wjb").uri("https://baidu.com")).build();
        return routes.build();
    }
}
