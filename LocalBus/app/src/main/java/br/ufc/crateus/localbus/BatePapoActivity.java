package br.ufc.crateus.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BatePapoActivity extends AppCompatActivity {
    Bundle dados = new Bundle();
    String nomeUsu;
    String emailUsu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bate_papo);
        Intent intent = getIntent();

        dados = intent.getExtras();

        if(dados != null) {



            nomeUsu = dados.getString("nome");
            emailUsu = dados.getString("email");
            Toast.makeText(BatePapoActivity.this, emailUsu, Toast.LENGTH_SHORT).show();
            Log.i("nome do usuario", nomeUsu);
        }
    }
}
