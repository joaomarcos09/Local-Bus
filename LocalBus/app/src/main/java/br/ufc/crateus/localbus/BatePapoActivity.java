package br.ufc.crateus.localbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BatePapoActivity extends AppCompatActivity {
    Bundle dados = new Bundle();
    String nomeUsu;
    String emailUsu;
    EditText etMsg;
    Button btEnviarMsg;
    MensagemModel msgAux;
    DatabaseReference myRef;
    int marcador = 0;
    int cont = 1;
    private  ArrayList<MensagemModel> mMsgAux = new ArrayList<>();
    Iterable<DataSnapshot> children;
    RecyclerView recyclerView;
    private LineAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bate_papo);
        etMsg= (EditText) findViewById(R.id.etMensagem);
        btEnviarMsg = (Button) findViewById(R.id.btEnviarMsg);
        recyclerView = (RecyclerView) findViewById(R.id.rvMensagens);
        LinearLayoutManager layoutManager = new LinearLayoutManager( this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new LineAdapter(new ArrayList<>(0));
        recyclerView.setAdapter(mAdapter);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://localbus-5f2fa.firebaseio.com/");
        myRef = database.getReference("mensagens");
       // mAdapter.pegaMensagens();


        Intent intent = getIntent();

        dados = intent.getExtras();

        if(dados != null) {
            nomeUsu = dados.getString("nome");
            emailUsu = dados.getString("email");
            Toast.makeText(BatePapoActivity.this, emailUsu, Toast.LENGTH_SHORT).show();
           // Log.i("nome do usuario", nomeUsu);
        }
        btEnviarMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirMsg();
                etMsg.setText("");
            }
        });
       //while(true) {

        new Thread(new Runnable() {
            int size = mAdapter.size();
            public void run(){
                while(true) {
                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            children = dataSnapshot.getChildren();
                            if(cont != marcador){
                            for (DataSnapshot data : children) {
                                msgAux = data.getValue(MensagemModel.class);
                                Log.i("pegou", msgAux.getMensagem());
                                //mAdapter.insertItem(msgAux);
                                marcador++;
                                mMsgAux.add(msgAux);
                            }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.i("emailT", "veio pra ca");
                        }
                    });
                    if(mAdapter.size() != mMsgAux.size()){
                        for(int i = 0; i<mMsgAux.size(); i++){
                            mAdapter.insertItem(mMsgAux.get(i));
                        }
                    }
                    try {
                        Thread. sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //   try {
        //       Thread.sleep(1000);
     //      } catch (InterruptedException e) {
      //         e.printStackTrace();
     //      }
       //}
    }

    public void inserirMsg(){
        MensagemModel model = new MensagemModel();
        model.setNome(nomeUsu);
        model.setMensagem(etMsg.getText().toString());
        Log.i("teste 1", model.getMensagem());
//teste
        myRef.push().setValue(model, 1);
        mAdapter.pegaMensagens();
        mAdapter.insertItem(model);
    }
}
