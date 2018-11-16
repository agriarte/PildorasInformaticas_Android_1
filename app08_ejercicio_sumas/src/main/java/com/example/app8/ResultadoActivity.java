package com.example.app8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle datos = getIntent().getExtras();
        int num1 = datos.getInt("numero1");
        int num2 = datos.getInt("numero2");

        TextView miResultado = (TextView)findViewById(R.id.idTextResultado);

        int resultado = num1+num2;
        miResultado.setText("la suma es " + resultado);
    }
}
