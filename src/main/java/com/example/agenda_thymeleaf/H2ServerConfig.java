package com.example.agenda_thymeleaf;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2ServerConfig {

    /**
     * Configuração para transformar o H2 em um servidor
     * Não muda a porta pelo amor de Deus
     * https://www.baeldung.com/spring-boot-access-h2-database-multiple-apps
     * @return
     * @throws SQLException
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }
}
