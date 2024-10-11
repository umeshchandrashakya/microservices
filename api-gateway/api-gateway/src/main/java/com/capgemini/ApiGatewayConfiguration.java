package com.capgemini;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator routeLocatorBean(RouteLocatorBuilder builder){
        System.out.println("Api Gateways");
        Function<PredicateSpec, Buildable<Route>> routeFunction = p ->
                p.path("/get")
                        .filters(f -> f.addRequestHeader("myHeader", "MyUri")
                                        .addRequestParameter("Request Param", "Request Param"))
                        .uri("http://httpbin.org:80");

        return builder.routes()
                .route(p->p.path("/get")
                        .filters(f-> f.addRequestHeader("MyHeader","MyHeader")
                                .addRequestParameter("Request Parm","My Request Param"))
                        .uri("http://httpbin.org:80"))
                .route(p->p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route(p->p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p->p.path("/currency-conversion-feign/**").
                        uri("lb://currency-conversion"))
                .route(p->p.path("/currency-conversion-new/**")
                        .filters(f->f.rewritePath("currency-conversion-new",
                                "currency-conversion-feign"))
                        .uri("lb://currency-conversion"))
                .build();
    }
}
