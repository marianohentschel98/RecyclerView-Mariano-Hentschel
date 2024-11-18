package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {
    ArrayList<Contacto> listaContactos;
    Context context;

    public ContactoAdapter(ArrayList<Contacto> listaContactos, Context context) {
        this.listaContactos = listaContactos;
        this.context = context;
    }


    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcontacto, parent, false);
        return new ContactoViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = listaContactos.get(position);
        holder.foto1.setImageResource(contacto.getFoto());
        holder.nombre1.setText(contacto.getNombre() + " " + contacto.getApellido());
        holder.correo1.setText(contacto.getEmail());
        holder.telefono1.setText(contacto.getTelefono());

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }


    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        ImageView foto1;
        TextView nombre1, apellidos1, correo1, telefono1;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            foto1=itemView.findViewById(R.id.foto1);
            nombre1=itemView.findViewById(R.id.nombre1);
            correo1=itemView.findViewById(R.id.correo1);
            telefono1=itemView.findViewById(R.id.telefono1);
        }
    }
}
