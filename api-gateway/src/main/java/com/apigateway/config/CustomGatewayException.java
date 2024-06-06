package com.apigateway.config;

import java.net.ConnectException;

/**
 * AbstractChannelCustom
 *
 * @author DucLN
 * @version 01-00
 * @since 6/6/2024
 */
public class CustomGatewayException extends RuntimeException {
    public CustomGatewayException(String message) {
        super(message);
    }
}
