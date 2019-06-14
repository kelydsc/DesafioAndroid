package br.com.digitalhouse.desafioandroid.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.desafioandroid.R;

public class ProfileActivity extends AppCompatActivity {

    //Declaração de atributos
    private TextInputLayout textInputLayoutPerfilNome;
    private TextInputLayout textInputLayoutPerfilEmail;
    private TextInputLayout textInputLayoutPerfilSenha;
    private TextInputLayout textInputLayoutPerfilConfSenha;
    private Button btnSalvarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Inicializa as Views
        initViews();

        //Valida o preenchimento do Perfil do usuário
        validaDadosPerfil();

        Intent intent = getIntent();
    }

    private void initViews() {

        textInputLayoutPerfilNome = findViewById(R.id.textInputLayoutProfName);
        textInputLayoutPerfilEmail = findViewById(R.id.textInputLayoutProfEmail);
        textInputLayoutPerfilSenha = findViewById(R.id.textInputLayoutProfPassword);
        textInputLayoutPerfilConfSenha = findViewById(R.id.textInputLayoutProfConfPassword);
        btnSalvarPerfil = findViewById(R.id.btnSaveProfile);
    }

    private void validaDadosPerfil() {
        btnSalvarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = textInputLayoutPerfilNome.getEditText().getText().toString();

                //Inicializa o set Error
                textInputLayoutPerfilNome.setError("");

                //Recuperar as preferencias do usuário
                SharedPreferences preferences = getSharedPreferences(
                        "APP", MODE_PRIVATE);

                textInputLayoutPerfilNome.getEditText().setText(preferences.getString(
                        "NOME", ""));

                textInputLayoutPerfilEmail.getEditText().setText(preferences.getString(
                        "EMAIL", ""));

                textInputLayoutPerfilSenha.getEditText().setText(preferences.getString(
                        "SENHA", ""));

                textInputLayoutPerfilConfSenha.getEditText().setText(preferences.getString(
                        "SENHA", ""));

                //Valida preenchimento do nome do usuário
                if (nome.isEmpty()) {

                    textInputLayoutPerfilNome.setError("Informe seu nome");

                    preferences.edit().putString("NOME", nome).commit();

                    return;

                } else {
                    finish();
                }
            }
        });
    }
}