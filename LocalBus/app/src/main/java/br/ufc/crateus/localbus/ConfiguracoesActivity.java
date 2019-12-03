package br.ufc.crateus.localbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConfiguracoesActivity extends AppCompatActivity {

    Button btEditar;
    Button btRemover;
    DatabaseReference myRef;
    Iterable<DataSnapshot> children;
    Bundle dados = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);
        btEditar = (Button) findViewById(R.id.btEditar);
        btRemover = (Button) findViewById(R.id.btRemover);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://localbus-5f2fa.firebaseio.com/");
        myRef = database.getReference("users");
        Intent intent = getIntent();

        dados = intent.getExtras();
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfiguracoesActivity.this, EditarActivity.class);
                i.putExtras(dados);
                startActivity(i);
            }
        });

        btRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child(dados.getString("key")).removeValue();
                Intent i = new Intent(ConfiguracoesActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        /*
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        children = dataSnapshot.getChildren();
                        for (DataSnapshot data : children) {
                            Log.i("User", data.getKey() + " " + data.getValue(UserModel.class));
                            userAux = data.getValue(UserModel.class);
                            Log.i("emailT", etEmail.getText().toString());
                            Log.i("senhaT", etSenha.getText().toString());
                            if (etEmail.getText().toString().equals(userAux.getEmail()) && etSenha.getText().toString().equals(userAux.getSenha())) {
                                usuario = userAux;
                                dados.putString("nome", usuario.getNome());
                                dados.putString("email", usuario.getEmail());
                                Log.i("email", usuario.getEmail());
                                Log.i("senha", usuario.getSenha());
                            } else {
                                usuario = null;
                            }
                            login(usuario);
                        }
                        if(cont == 0){
                            Toast.makeText(getApplicationContext(), "verifique as configurações de login!",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.i("emailT", "veio pra ca");
                    }
                });
            }
        });
*/

    }
}
