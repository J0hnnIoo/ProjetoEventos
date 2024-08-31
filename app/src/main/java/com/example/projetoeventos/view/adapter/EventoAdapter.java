package com.example.projetoeventos.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoeventos.databinding.ItemListRowEventoBinding;
import com.example.projetoeventos.modelDominio.Evento;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.MyViewHolder> {
    private List<Evento> listaEventos;

    private EventoAdapter.EventoOnClickListener EventoOnClickListener;

    public EventoAdapter(List<Evento> listaEventos, EventoAdapter.EventoOnClickListener EventoOnClickListener) {
        this.listaEventos = listaEventos;
        this.EventoOnClickListener = EventoOnClickListener;
    }

    @NonNull
    @Override
    public EventoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListRowEventoBinding itemListRowEventoBinding = ItemListRowEventoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new EventoAdapter.MyViewHolder(itemListRowEventoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Evento evento = listaEventos.get(position);
        holder.itemListRowBinding.tvItemNome.setText(evento.getTitulo());

        if (EventoOnClickListener != null) {
            holder.itemListRowBinding.getRoot().setOnClickListener(view -> {
                EventoOnClickListener.onClickEvento(holder.itemView, position, evento);
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ItemListRowEventoBinding itemListRowBinding;
        public MyViewHolder(ItemListRowEventoBinding itemListRowBinding) {
            super(itemListRowBinding.getRoot());
            this.itemListRowBinding = itemListRowBinding;
        }
    }

    public interface EventoOnClickListener {
        public void onClickEvento(View view, int position, Evento evento);
    }
}
