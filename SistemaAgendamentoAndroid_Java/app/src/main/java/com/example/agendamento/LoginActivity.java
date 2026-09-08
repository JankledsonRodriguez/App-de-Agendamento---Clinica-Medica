package com.example.agendamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.agendamento.repository.ClinicaRepository;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private boolean isLoggingIn = false;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.edtEmail);
        EditText senha = findViewById(R.id.edtSenha);
        Button btnLogin = findViewById(R.id.btnLogin);
        ProgressBar progressBar = findViewById(R.id.progressLogin);

        btnLogin.setOnClickListener(v -> {
            if (isLoggingIn) return; // Evita cliques múltiplos enquanto carrega

            String emailText = email.getText().toString();
            String senhaText = senha.getText().toString();

            if (emailText.isEmpty() || senhaText.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Iniciar carregamento
            isLoggingIn = true;
            progressBar.setVisibility(View.VISIBLE);
            btnLogin.setText(R.string.carregando_login);
            // Mantemos o botão visualmente habilitado (cor azul), mas controlamos o clique pela variável isLoggingIn

            executor.execute(() -> {
                try {
                    boolean ok = new ClinicaRepository().login(emailText, senhaText);
                    runOnUiThread(() -> {
                        isLoggingIn = false;
                        progressBar.setVisibility(View.GONE);
                        if (ok) {
                            startActivity(new Intent(this, MainActivity.class));
                            finish();
                        } else {
                            btnLogin.setText(R.string.acessar_sistema);
                            Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    runOnUiThread(() -> {
                        isLoggingIn = false;
                        progressBar.setVisibility(View.GONE);
                        btnLogin.setText(R.string.acessar_sistema);
                        Toast.makeText(this, "Erro MySQL: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    });
                }
            });
        });

        findViewById(R.id.txtEsqueceuSenha).setOnClickListener(v -> 
            startActivity(new Intent(this, ForgotPasswordActivity.class))
        );

        findViewById(R.id.btnIrParaCadastro).setOnClickListener(v -> 
            startActivity(new Intent(this, CadastroMedicoActivity.class))
        );
    }
}
