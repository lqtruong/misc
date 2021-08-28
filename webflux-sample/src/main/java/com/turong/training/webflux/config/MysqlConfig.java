package com.turong.training.webflux.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.turong.training.webflux.repository")
public class MysqlConfig extends AbstractR2dbcConfiguration {

    @Value("${spring.r2dbc.url}")
    private String url;

    @Value("${spring.r2dbc.host:localhost}")
    private String host;

    @Value("${spring.r2dbc.port:3306}")
    private int port;

    @Value("${spring.r2dbc.username}")
    private String username;

    @Value("${spring.r2dbc.password}")
    private String serverSecret;

    @Value("${spring.r2dbc.database:webflux}")
    private String database;

    @Value("${spring.r2dbc.connectTimeout:3000}")
    private int connectTimeout;

    @Value("${spring.r2dbc.pool.maxIdleTime:1000}")
    private int poolMaxIdleTime;

    @Value("${spring.r2dbc.pool.maxSize:60}")
    private int poolMaxSize;

    @Override
    public ConnectionFactory connectionFactory() {

        MySqlConnectionConfiguration configuration = MySqlConnectionConfiguration.builder()
                .host(host)
                .user(username)
                .port(port)
                .password(serverSecret)
                .database(database)
                .connectTimeout(Duration.ofMillis(connectTimeout))
                .build();

        ConnectionFactory connFactory = MySqlConnectionFactory.from(configuration);

        ConnectionPoolConfiguration poolConfiguration = ConnectionPoolConfiguration
                .builder(connFactory)
                .maxIdleTime(Duration.ofMillis(poolMaxIdleTime))
                .maxSize(poolMaxSize)
                .build();

        return new ConnectionPool(poolConfiguration);
    }

}
