package com.example.app7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //repaso de como acceder y cambiar a vistas en el XML por Java

        ImageView imagen = (ImageView)findViewById(R.id.idImageView);
        imagen.setImageResource(android.R.drawable.btn_radio);

        TextView texto = (TextView)findViewById(R.id.idTexto);
        texto.setText("otra cosa");
    }
}
