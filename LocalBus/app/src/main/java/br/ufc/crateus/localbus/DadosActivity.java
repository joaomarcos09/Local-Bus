package br.ufc.crateus.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DadosActivity extends AppCompatActivity {

    TextView nome;
    TextView email;
    Bundle dados = new Bundle();
    String nomeUsu;
    String emailUsu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        nome = (TextView) findViewById(R.id.tvNome);
        email = (TextView) findViewById(R.id.tvEmail);
        Intent intent = getIntent();

        dados = intent.getExtras();

        if (dados != null) {
            nomeUsu = dados.getString("nome").toString();
            emailUsu = dados.getString("email").toString();
            Toast.makeText(DadosActivity.this, emailUsu, Toast.LENGTH_SHORT).show();
            Log.i("nome do usuario", nomeUsu);

        }
        nome.setText(nomeUsu);
        email.setText(emailUsu);
    }

}
