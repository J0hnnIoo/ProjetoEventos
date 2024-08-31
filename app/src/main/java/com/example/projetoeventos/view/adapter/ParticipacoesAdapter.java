package com.example.projetoeventos.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoeventos.databinding.ItemListRowEventoInscritoBinding;
import com.example.projetoeventos.modelDominio.Participacoes;

import java.util.List;

public class ParticipacoesAdapter extends RecyclerView.Adapter<ParticipacoesAdapter.MyViewHolder> {

    private List<Participacoes> listaParticipacoes;
    private ParticipacoesAdapter.ParticipacoesOnClickListener ParticipacaoOnClickListener;

    public ParticipacoesAdapter(List<Participacoes> listaParticipacoes, ParticipacoesAdapter.ParticipacoesOnClickListener ParticipacaoOnClickListener) {
        this.listaParticipacoes = listaParticipacoes;
        this.ParticipacaoOnClickListener = ParticipacaoOnClickListener;
    }

    @NonNull
    @Override
    public ParticipacoesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListRowEventoInscritoBinding itemListRowEventoInscritoBinding = ItemListRowEventoInscritoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ParticipacoesAdapter.MyViewHolder(itemListRowEventoInscritoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipacoesAdapter.MyViewHolder holder, int position) {
        Participacoes participacao = listaParticipacoes.get(position);
        holder.itemListRowEventoInscritoBinding.tvItemNomeInscrito.setText(participacao.getEvento().getTitulo());

        if (ParticipacaoOnClickListener != null) {
            holder.itemListRowEventoInscritoBinding.getRoot().setOnClickListener(view -> {
                ParticipacaoOnClickListener.onClickParticipacao(holder.itemView, position, participacao);
            });
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ItemListRowEventoInscritoBinding itemListRowEventoInscritoBinding;
        public MyViewHolder(ItemListRowEventoInscritoBinding itemListRowEventoInscritoBinding) {
            super(itemListRowEventoInscritoBinding.getRoot());
            this.itemListRowEventoInscritoBinding = itemListRowEventoInscritoBinding;
        }
    }

    public interface ParticipacoesOnClickListener {
        public void onClickParticipacao(View view, int position, Participacoes participacao);
    }
}
