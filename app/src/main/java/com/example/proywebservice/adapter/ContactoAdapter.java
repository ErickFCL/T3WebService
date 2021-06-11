package com.example.proywebservice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proywebservice.R;
import com.example.proywebservice.entities.Contacto;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.PalabraViewHolder>{
    List<Contacto> contactos;
    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }
    @Override
    public PalabraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,parent,false); //contruye una mini activity

        return new PalabraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoAdapter.PalabraViewHolder holder, int position) {
        View view = holder.itemView;

        Contacto contacto = contactos.get(position);//ontener el elemeneto actual

        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvTipo = view.findViewById(R.id.tvNumero);



        tvNombre.setText(contacto.nombre);
        tvTipo.setText(contacto.tipo);

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }
    public class PalabraViewHolder extends  RecyclerView.ViewHolder{

        public PalabraViewHolder(View itemView) {
            super(itemView);
        }
    }
}
