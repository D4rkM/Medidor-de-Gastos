package br.com.gasto.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.gasto.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void abrirCadastro(View view) {

        Intent intent = new Intent(this, CadastroEdicaoUsuario.class);
        startActivity(intent);

    }

    public void entrar(View view) {

        Intent intent = new Intent(this, AreaPrincipal.class);
        startActivity(intent);
    }
}
