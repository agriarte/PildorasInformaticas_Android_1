package com.example.app5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Toolbar miToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pasos a seguir para ToolBar:
        //1-crear layout xml con el toolbar
        //2-incluirlo en el layout de la actividad correspondiente
        //3-registrar el nuevo toolbar en MainActivity.java
        //4-activar el toolbar como barra de accciones en MainActivity.java
        //5- en styles.xml escoger un tema que no tenga actionbar o añadir:
        //<item name="windowActionBar">false</item> para deshabilitarlo. Sin esto el programa cae
        //6- el toolbar contiene los items xml de la carpeta menu
        miToolbar = (Toolbar)findViewById(R.id.id_mi_tool_bar);
        setSupportActionBar(miToolbar);//registramos la toolbar y ya podemos manejarla como un menu

    }

  public void Ejecutar_Info (View view){
      //intencion de abrir otra actividad, 2 parametros: el contexto, 2 la clase del otro activity
      Intent intent = new Intent(this,InfoActivity.class);
      startActivity(intent);
  }

   public void Ejecutar_Config (View view){
       Intent intent = new Intent(this,ConfigActivity.class);
       startActivity(intent);

   }

   public void Ejecutar_Salir (View view){
        //cerrar app
        finish();
   }


    //infla la toolbar con el menu xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainactivity,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //lectura items de toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.idMenuConfig){

        }
        if (id==R.id.idMenuInfo){
            Ejecutar_Info(null);
        }
        return super.onOptionsItemSelected(item);
    }
}
