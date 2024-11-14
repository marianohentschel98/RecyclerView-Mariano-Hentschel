package com.example.recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imgFoto = foto.findViewById(R.id.foto1);
        ArrayList<Contacto> listaContacto= new ArrayList<>();
        listaContacto.add(new Contacto(R.drawable.icono,"Hentschel","Mariano","mariano.hentschel@gmail.com","5453454353"));
        listaContacto.add(new Contacto(R.drawable.icono,"hombre",40,""));
        listaContacto.add(new Contacto(R.drawable.icono,"hombre",36,false));
        listaContacto.add(new Contacto(R.drawable.icono,"hombre",40,true));

        RecyclerView lista = findViewById(R.id.listaContactos);
        AdaptadorRopa miAdaptadorRopa = new AdaptadorRopa(listaContacto,this);
        lista.setAdapter(miAdaptadorRopa);
    }
}