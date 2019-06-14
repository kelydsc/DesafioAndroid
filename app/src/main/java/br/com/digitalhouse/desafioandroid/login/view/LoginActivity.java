package br.com.digitalhouse.desafioandroid.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.cadastro.CadastroActivity;
import br.com.digitalhouse.desafioandroid.home.view.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    //Declaracao de atributos
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;
    private Button btnLogar;
    private Button btnRegistrar;
    private CheckBox checkBoxRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inicializa as Views
        initViews();

        //valida dados do Login e Chama tela de Home
        validaDadosLogin();

        //Chama a tela de Cadastro
        chamaTelaCadastro();

        //Recebe a chamada da tela de Cadastro
        Intent intent = getIntent();

    }

    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutSenha = findViewById(R.id.textInputLayoutPassword);
        btnLogar = findViewById(R.id.btnLogin);
        btnRegistrar = findViewById(R.id.btnRegister);
        checkBoxRemember = findViewById(R.id.checkBoxRemember);

    }

    private void validaDadosLogin() {

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Converte dados
                String email = textInputLayoutEmail.getEditText().getText().toString();
                String senha = textInputLayoutSenha.getEditText().getText().toString();

                //Inicializa o set Error
                textInputLayoutEmail.setError("");
                textInputLayoutSenha.setError("");

                if (email.isEmpty()) {
                    textInputLayoutEmail.setError("Informe o seu e-mail");
                    return;
                }

                if (senha.isEmpty()) {
                    textInputLayoutSenha.setError("Informe sua senha");
                    return;
                }

                //Se todos os campos estiverem preenchidos chama a tela de Home
                if (!(email.isEmpty()) && !(senha.isEmpty())) {

                    //Verifica se o Checkbox esta marcado para recuperar as preferencias do usuario
                    if (checkBoxRemember.isChecked()) {

                        SharedPreferences preferences = getSharedPreferences(
                                "APP", MODE_PRIVATE);

                        textInputLayoutEmail.getEditText().setText(preferences.getString(
                                "EMAIL", ""));

                        textInputLayoutSenha.getEditText().setText(preferences.getString(
                                "SENHA", ""));
                    }

                    //Chama a tela de Home
                    Intent intentTelaLogin = new Intent(
                            LoginActivity.this, HomeActivity.class);

                    startActivity(intentTelaLogin);
                }
            }
        });
    }

    private void chamaTelaCadastro() {

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chama a tela de Cadastro
                Intent intentTelaCadastro = new Intent(
                        LoginActivity.this, CadastroActivity.class);

                startActivity(intentTelaCadastro);
            }
        });
    }
}
