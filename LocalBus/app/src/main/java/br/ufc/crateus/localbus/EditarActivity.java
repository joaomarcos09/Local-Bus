package br.ufc.crateus.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditarActivity extends AppCompatActivity {
    EditText etNome2;
    EditText etEmail2;
    EditText etCurso2;
    EditText etMatricula2;
    EditText etSenha2;
    EditText etConfirmaSenha2;
    Button btCadastrar2;
    Iterable<DataSnapshot> children;
    Bundle dados = new Bundle();
    DatabaseReference myRef;
    UserService service = RetrofitClientInstance
            .getRetrofitInstance()
            .create(UserService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        etNome2 = (EditText) findViewById(R.id.etNome2);
        etEmail2 = (EditText) findViewById(R.id.etEmail2);
        etCurso2 = (EditText) findViewById(R.id.etCurso2);
        etMatricula2 = (EditText) findViewById(R.id.etMatricula2);
        etSenha2 = (EditText) findViewById(R.id.etSenha2);
        etConfirmaSenha2 = (EditText) findViewById(R.id.etConfirmaSenha2);
        btCadastrar2 = (Button) findViewById(R.id.btCadastrar2);
        Intent intent = getIntent();

        dados = intent.getExtras();
        etNome2.setText(dados.getString("nome"));
        etEmail2.setText(dados.getString("email"));
        etCurso2.setText(dados.getString("curso"));
        etMatricula2.setText(dados.getString("matricula"));
        etSenha2.setText(dados.getString("senha"));
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://localbus-5f2fa.firebaseio.com/");
        myRef = database.getReference("users");

        btCadastrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel usuario = new UserModel(etNome2.getText().toString(), etEmail2.getText().toString(), Integer.parseInt(etMatricula2.getText().toString()), etCurso2.getText().toString(), etSenha2.getText().toString());
                myRef.child(dados.getString("key")).setValue(usuario);
                dados.putString("nome", usuario.getNome());
                dados.putString("email", usuario.getEmail());
                dados.putString("curso", usuario.getCurso());
                dados.putString("matricula", String.valueOf(usuario.getMatricula()));
                dados.putString("senha", usuario.getSenha());
                dados.putString("key", usuario.getKey());
                Intent i = new Intent(EditarActivity.this, PrincipalActivity.class);
                i.putExtras(dados);
                startActivity(i);
            }
        });
    }
}
