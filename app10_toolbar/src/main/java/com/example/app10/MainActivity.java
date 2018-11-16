package com.example.app10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar miToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miToolbar = (Toolbar)findViewById(R.id.id_mi_tool_bar);
        setSupportActionBar(miToolbar);//registramos la toolbar y ya podemos manejarla como un menu


    }
    //ejemplo básico del nuevo ToolBar. Pasos a seguir:
    //1-crear layout xml con el toolbar
    //2-incluirlo en el layout de la actividad correspondiente
    //3-registrar el nuevo toolbar en MainActivity.java
    //4-activar el toolbar como barra de accciones en MainActivity.java
    //5- en styles.xml escoger un tema que no tenga actionbar o añadir:
    //<item name="windowActionBar">false</item> para deshabilitarlo. Sin esto el programa cae
    //6- el toolbar contiene los items xml de la carpeta menu

    //infla la toolbar con un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tool_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_1:
                Toast.makeText(this, "Accion 1 seleccionada", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_2:
                Toast.makeText(this, "Accion 2 seleccionada", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
