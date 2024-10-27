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
            jdbcTemplate.execute("INSERT INTO TB_TIPOACESSO (id_acesso, descricao) VALUES ('4dm1n', 'Admin');");
            jdbcTemplate.execute("INSERT INTO TB_TIPOACESSO (id_acesso, descricao) VALUES ('U23r', 'User');");

            jdbcTemplate.execute("INSERT INTO TB_USUARIO (id_usuario, usuario, senha, dt_cadastro, tipo_acesso_id_acesso) VALUES ('U2u4r101','admin', 'admin123', '2024-01-01', '4dm1n');");
            jdbcTemplate.execute("INSERT INTO TB_USUARIO (id_usuario, usuario, senha, dt_cadastro, tipo_acesso_id_acesso) VALUES ('U2u4r102','user', 'user123', '2024-01-01', 'U23r');");

            jdbcTemplate.execute("INSERT INTO TB_ENDERECO (id_endereco, logradouro, UF, estado, cep, cidade, numero, complemento) VALUES ('Ru4d0M3rc4d0', 'Rua do Mercado', 'CA', 'California', '90210', 'Night City', '123', 'Apt. 1B');");

            jdbcTemplate.execute("INSERT INTO TB_CLIENTE (id_cliente, email, endereco_id_endereco, nome, telefone) VALUES ('Cl13nt3Ch4t0','clientechato@gmail.com', 'Ru4d0M3rc4d0', 'Chatonildo', 40028922);");

            jdbcTemplate.execute("INSERT INTO TB_FUNCIONARIO (id_funcionario, email, endereco_id_endereco, salario,nome, telefone) VALUES ('R1k0', 'riko.takahashi@shadownet.com', 'Ru4d0M3rc4d0', 15000.00, 'Riko Takahashi', '555-0178');");

            jdbcTemplate.execute("INSERT INTO TB_SERVICO (id_servico, nome, valor) VALUES ('S0l0', 'Solo', '15000.00');");

            /*jdbcTemplate.execute(
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
                            "'4g3nd4', " +
                            "'Eliminar o lider da gangue local', " +
                            "'2024-01-01', " +
                            "'Em Andamento', " +
                            "'S0l0', " +
                            "'Cl13nt3Ch4t0', " +
                            "'U2u4r101', " +
                            "'R1k0');"
            );*/

            //jdbcTemplate.execute("INSERT INTO TB_AGENDA (id_agenda, data, descricao, status) " +
              //      "VALUES ('111', '2024-01-01', 'Eliminar o lider da gangue local', 'atuando');");


        };
    }
}
