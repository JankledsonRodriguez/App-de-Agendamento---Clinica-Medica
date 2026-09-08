package com.example.agendamento.database;

import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    // Conexão do Banco
    private static final String URL = "jdbc:mysql://COLOQUE_SEU_HOST_AQUI:PORTA/agendamento?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "SEU_USUARIO"; // super usuário do banco de dados
    private static final String SENHA = "SUA_SENHA_AQUI";

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