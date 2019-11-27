package br.ufc.crateus.localbus;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {
    private final List<MensagemModel> mMsg;
    DatabaseReference myRef;
    Iterable<DataSnapshot> children;
    MensagemModel msgAux;

    public LineAdapter(ArrayList msgs) {
        mMsg = msgs;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.nome.setText(String.format(Locale.getDefault(), "%s:\n %s",
                mMsg.get(position).getNome(), mMsg.get(position).getMensagem()
        ));
     //   Log.i("teste 2", mMsg.get(position).getMensagem());
    }

    @Override
    public int getItemCount() {
        return mMsg != null ? mMsg.size() : 0;
    }

    public void updateList(MensagemModel user) {
        insertItem(user);
    }

    public void insertItem(MensagemModel user) {
        Log.i("chegou aqui", user.getMensagem());
        mMsg.add(user);
        notifyItemInserted(getItemCount());
    }
    public void pegaMensagens(){
       Log.i("entrou", "entrou no metodo pega mensagem");
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://localbus-5f2fa.firebaseio.com/");
        myRef = database.getReference("mensagem");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                children = dataSnapshot.getChildren();
                for (DataSnapshot data : children) {
                    msgAux = data.getValue(MensagemModel.class);
                    Log.i("Mensagem", msgAux.getMensagem());
                    insertItem(msgAux);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("emailT", "veio pra ca");
            }
        });
    }

}
