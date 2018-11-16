package com.example.ap6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //en este ejemplo se asignan resources por código
        //la primera es una imagen usando solo XML
        //la segunda imagen se inserta en un objeto ImageView en blanco usando código
        //
        //se crea objeto ImageView a partir del ID del imageview blanco creado con xml
        //se asigna imageResource drawable al objeto imageview

        ImageView miImageView = (ImageView) findViewById(R.id.IDimageView2);
        miImageView.setImageResource(R.drawable.grupo1);
    }
}
