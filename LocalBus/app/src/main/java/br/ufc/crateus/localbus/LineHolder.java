package br.ufc.crateus.localbus;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder{

    public TextView nome;
  //  public TextView mensagem;

    public LineHolder(View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.tvNomeRV);
       // mensagem = (TextView) itemView.findViewById(R.id.tvMensagemRV);

    }
}
