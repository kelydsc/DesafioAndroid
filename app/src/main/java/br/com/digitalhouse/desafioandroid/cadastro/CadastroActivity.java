package br.com.digitalhouse.desafioandroid.cadastro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.home.view.HomeActivity;

public class CadastroActivity extends AppCompatActivity {

    //Declaração de atributos
    private TextInputLayout textInputLayoutRegNome;
    private TextInputLayout textInputLayoutRegEmail;
    private TextInputLayout textInputLayoutRegSenha;
    private TextInputLayout textInputLayoutRegConfSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Inicializa as Views
        initViews();

        //valida o preenchimento do Cadastro
        validaDadosCadastro();

    }

    private void initViews() {
        textInputLayoutRegNome = findViewById(R.id.textInputLayoutRegName);
        textInputLayoutRegEmail = findViewById(R.id.textInputLayoutRegEmail);
        textInputLayoutRegSenha = findViewById(R.id.textInputLayoutRegPassword);
        textInputLayoutRegConfSenha = findViewById(R.id.textInputLayoutRegConfPassword);
        btnCadastrar = findViewById(R.id.btnRegistro);
    }

    private void validaDadosCadastro() {
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = textInputLayoutRegNome.getEditText().getText().toString();
                String email = textInputLayoutRegEmail.getEditText().getText().toString();
                String senha = textInputLayoutRegSenha.getEditText().getText().toString();
                String confsenha = textInputLayoutRegConfSenha.getEditText().getText().toString();

                //minimo de caracteres permitidos para o cadastro de senha
                int minimalPassLen = 6;

                //Inicializa o set Error
                textInputLayoutRegNome.setError("");
                textInputLayoutRegEmail.setError("");
                textInputLayoutRegSenha.setError("");
                textInputLayoutRegConfSenha.setError("");

                if (nome.isEmpty()) {
                    textInputLayoutRegNome.setError("Informe seu nome");
                    return;
                }

                if (email.isEmpty()) {
                    textInputLayoutRegEmail.setError("Informe seu e-mail");
                    return;
                }

                if (senha.isEmpty()) {
                    textInputLayoutRegSenha.setError("Informe sua senha");
                    return;
                }

                if (senha.length() < minimalPassLen) {
                    textInputLayoutRegSenha.setError("Digite uma senha com 6 ou mais caracteres");
                    return;
                }

                if (confsenha.isEmpty()) {
                    textInputLayoutRegConfSenha.setError("Confirme sua senha");
                    return;
                }

                //Verifica se a confirmação de senha está igual a senha
                if (!confsenha.equals(senha)) {
                    textInputLayoutRegConfSenha.setError("Senha diferente da senha informada");
                    return;
                }

                //Se todos os campos estiverem preenchidos chama a tela de Home
                if (!(nome.isEmpty()) && !(email.isEmpty()) && !(senha.isEmpty())
                        && !(confsenha.isEmpty())) {

                    //Grava as Preferencias do Usuario
                    SharedPreferences preferences = getSharedPreferences("APP", MODE_PRIVATE);

                    preferences.edit().putString("NOME", nome).commit();
                    preferences.edit().putString("EMAIL", email).commit();
                    preferences.edit().putString("SENHA", senha).commit();

                    //Chama a tela de Home
                    Intent intentHome = new Intent(
                            CadastroActivity.this, HomeActivity.class);

                    startActivity(intentHome);
                }
            }
        });
    }
}
