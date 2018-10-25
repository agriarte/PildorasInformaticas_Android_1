package com.example.app2;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    //Ejercicio App contador que sale en varios videos

    public int contador;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador=0;

        textoResultado = (TextView) findViewById(R.id.idContadorTxt);

    }

    public void incrementaContador(View vista){

        contador++;

        textoResultado.setText("" + contador );


    }


    public void restaContador(View vista){

        contador--;

        //si el checkBox no está activado no se permite bajar de 0
        if (contador<0){
            CheckBox negativos = (CheckBox) findViewById(R.id.idCheckNegativos);
            if (!negativos.isChecked()){
                contador=0;
            }
            System.out.println("NEGATIVO****");
        }

        textoResultado.setText("" + contador );


    }


    public void reseteaContador(View vista){

        EditText reseteo = (EditText) findViewById(R.id.idNumReseteo);

        //si no hay valor numérico en reseteo salta una excepcion, con try catch la capturamos
        //y forzamos que contador sea 0 sin que el programa caiga
        try{
            contador= Integer.parseInt(reseteo.getText().toString());//se parsea a int el objeto Editable
        }catch (Exception e){
            contador=0;
        }

        reseteo.setText("");//borrar el numero reset para limpiar pantalla
        textoResultado.setText("" + contador );

        //Las siguientes 2 lineas sirven para esconder teclado flotante al pulsar boton Reset.
        //miTeclado es una instancia que guarda que nuestro método de entrada es un teclado flotante
        //en otros casos puede ser voz, stich, etc
        //el metodo hideSoftInputFromInputMethod esconde el inputmethod que ha sido mostrado por
        //el objeto view Edittext "reseteo"
        InputMethodManager miTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        miTeclado.hideSoftInputFromWindow(reseteo.getWindowToken(),0);


        //el siguiente código mas la clase interna sirven para que el botón intro del teclado
        //flotante, detecta que el teclado se ha escondido y se invoca una clase interna que
        //altualizará el valor del EditText al Contador. De no estar este código al pulsar Intro no
        //no se refresca la pantalla

        EventoTeclado miEventoTeclado = new EventoTeclado();
        EditText n_reseteo = (EditText) findViewById(R.id.idNumReseteo);
        n_reseteo.setOnEditorActionListener(miEventoTeclado);



    }
    //clase interna que se invoca cuando hay evento de teclado
    class EventoTeclado implements TextView.OnEditorActionListener{
        /**
         * Called when an action is being performed.
         *
         * @param v        The view that was clicked.
         * @param actionId Identifier of the action.  This will be either the
         *                 identifier you supplied, or {@link EditorInfo#IME_NULL
         *                 EditorInfo.IME_NULL} if being called due to the enter key
         *                 being pressed.
         * @param event    If triggered by an enter key, this is the event;
         *                 otherwise, this is null.
         * @return Return true if you have consumed the action, else false.
         */
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId==EditorInfo.IME_ACTION_DONE){
                //este metodo por fuerza pide un argumento View, como realmente no es
                // necesario le pasamos un null para que no de error
                 reseteaContador(null);
                System.out.println("****resetea");

            }
            return false;
        }
    }


}
