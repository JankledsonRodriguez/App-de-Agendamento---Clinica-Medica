package com.example.agendamento.database;

import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // Conexão do Banco
    public static final String URL = "jdbc:mysql://mysql-378a37e8-clinica-92d.d.aivencloud.com:26883/clinica_medica";
    public static final String USUARIO = "avnadmin"; // super usuário do banco de dados
    public static final String SENHA = "AVNS_a-6aLztou5YQrZ_YCiB";

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Permite requisição de rede na Thread principal (Apenas para ambiente de testes)
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}