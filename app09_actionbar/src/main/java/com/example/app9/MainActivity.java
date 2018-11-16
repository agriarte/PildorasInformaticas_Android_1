package com.example.app9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //para crear un menu ActionBar(obsoleto) se crea un resource de tipo menu en carpeta menu
    //se sobreescriben estos 2 metodos para manejar items menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.idItem01){
            System.out.println("opcion 1");
        }
        if (id==R.id.idItem02){
            System.out.println("opcion 2");
        }
        if (id==R.id.idItem03){
            System.out.println("opcion 3");
        }

        return super.onOptionsItemSelected(item);
    }
}
