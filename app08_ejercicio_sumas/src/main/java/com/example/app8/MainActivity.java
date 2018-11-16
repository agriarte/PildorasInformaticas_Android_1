package com.example.app8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aSumar(View view){
        Intent intent = new Intent(this,ResultadoActivity.class);
        num1 = (EditText)findViewById(R.id.idEditNum1);
        num2 = (EditText)findViewById(R.id.idEditNum2);

        int n1= Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        intent.putExtra("numero1",n1);
        intent.putExtra("numero2",n2);
        startActivity(intent);
    }
}
