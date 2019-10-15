package br.ufc.crateus.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DadosActivity extends AppCompatActivity {

    TextView nome;
    TextView email;
    TextView matricula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        nome = (TextView) findViewById(R.id.tvNome);
        email = (TextView) findViewById(R.id.tvEmail);
        matricula = (TextView) findViewById(R.id.tvMatricula);

    }
}
