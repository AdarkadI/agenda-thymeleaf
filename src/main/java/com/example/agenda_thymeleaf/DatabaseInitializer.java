package com.example.agenda_thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            jdbcTemplate.execute("INSERT INTO TB_TIPOACESSO (id_acesso, descricao) VALUES ('1', 'Admin');");
            jdbcTemplate.execute("INSERT INTO TB_TIPOACESSO (id_acesso, descricao) VALUES ('2', 'User');");

            jdbcTemplate.execute("INSERT INTO TB_USUARIO (id_usuario, usuario, senha, dt_cadastro, tipo_acesso_id_acesso) VALUES ('1','admin', 'admin123', '2024-01-01', '1');");
            jdbcTemplate.execute("INSERT INTO TB_USUARIO (id_usuario, usuario, senha, dt_cadastro, tipo_acesso_id_acesso) VALUES ('2','user', 'user123', '2024-01-01', '2');");

            jdbcTemplate.execute("INSERT INTO TB_ENDERECO (id_endereco, logradouro, UF, estado, cep, cidade, numero, complemento) VALUES ('1', 'Rua do Mercado', 'CA', 'California', '90210', 'Night City', '123', 'Apt. 1B');");

            jdbcTemplate.execute("INSERT INTO TB_CLIENTE (id_cliente, email, endereco_id_endereco, nome, telefone) VALUES ('1','clientechato@gmail.com', '1', 'Chatonildo', 40028922);");

            jdbcTemplate.execute("INSERT INTO TB_FUNCIONARIO (id_funcionario, email, endereco_id_endereco, salario,nome, telefone) VALUES ('1', 'riko.takahashi@shadownet.com', '1', 15000.00, 'Riko Takahashi', '555-0178');");

            jdbcTemplate.execute("INSERT INTO TB_SERVICO (id_servico, nome, valor) VALUES ('1', 'Solo', '15000.00');");

            jdbcTemplate.execute(
                    "INSERT INTO TB_AGENDA (" +
                            "id_agenda, " +
                            "descricao, " +
                            "data, " +
                            "status, " +
                            "servico_id_servico, " +
                            "cliente_id_cliente, " +
                            "usuario_id_usuario, " +
                            "funcionario_id_funcionario) " +
                            "VALUES (" +
                            "'1', " +
                            "'Eliminar o lider da gangue local', " +
                            "'2024-01-01', " +
                            "'Em Andamento', " +
                            "'1', " +
                            "'1', " +
                            "'1', " +
                            "'1');"
            );

        };
    }
}
