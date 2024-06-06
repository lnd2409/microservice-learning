package com.apigateway.filter;

import com.apigateway.config.CustomGatewayException;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.ConnectException;

/**
 * CustomFilter
 *
 * @author DucLN
 * @version 01-00
 * @since 6/6/2024
 */
public class CustomFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).onErrorResume(e -> {
            if (e instanceof ConnectException) {
                throw new CustomGatewayException("Custom message: Connection refused to service at " + exchange.getRequest().getURI().getPath());
            }
            return Mono.error(e);
        });
    }
}
