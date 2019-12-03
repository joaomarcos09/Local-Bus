package br.ufc.crateus.localbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MotoristaActivity extends AppCompatActivity {
    Button btCadastrarNoti;
    EditText etAviso;
    TextView tvNotificacao;
    DatabaseReference myRef;
    UserService service = RetrofitClientInstance
            .getRetrofitInstance()
            .create(UserService.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorista);
        btCadastrarNoti = (Button) findViewById(R.id.btCadastrarNoti);
        etAviso = (EditText) findViewById(R.id.etAviso);
        tvNotificacao = (TextView) findViewById(R.id.tvNotificacao);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://localbus-5f2fa.firebaseio.com/");
        myRef = database.getReference("avisos");

        btCadastrarNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.push().setValue(new MensagemModel("Motorista", etAviso.getText().toString()));
                etAviso.setText("");
                ;
            }
        });
    }
}
