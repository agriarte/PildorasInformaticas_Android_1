package com.example.app13_tres_en_raya;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int jugadores;
    private int[] CASILLAS;
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // iniciamos el array CASILLAS[] que almacena el id del grafico contenido en cada casilla
        CASILLAS = new int[9];

        CASILLAS[0] = R.id.a1;
        CASILLAS[1] = R.id.a2;
        CASILLAS[2] = R.id.a3;
        CASILLAS[3] = R.id.b1;
        CASILLAS[4] = R.id.b2;
        CASILLAS[5] = R.id.b3;
        CASILLAS[6] = R.id.c1;
        CASILLAS[7] = R.id.c2;
        CASILLAS[8] = R.id.c3;
    }

    public void aJugar(View vista) {
        //inicializar tablero
        //CASILLAS almacena cada una de las imagenes contenidas en cada casilla
        //seteamos cada casilla al resource de casilla en blanco


        //limpiar tablero cada partida nueva
        ImageView imagen;
        for (int cadaCasilla : CASILLAS) {
            imagen = (ImageView) findViewById((cadaCasilla));
            imagen.setImageResource(R.drawable.casilla);
        }

        //si pulsamos DosJugadores se sobreescribe jugadores a 2, sino se mantiene en 1
        jugadores=1;
        if (vista.getId()==R.id.dos_jugadores){
            jugadores=2;
        }

        //idRadio almacena que radioButton está activo;
        RadioGroup configDificultad = (RadioGroup)findViewById(R.id.configDifi);
        int idRadio = configDificultad.getCheckedRadioButtonId();
        int dificultad=0; //valor por defecto

        if (idRadio==R.id.normal) {
            dificultad=1;
        } else if (idRadio==R.id.dificil){
            dificultad=2;
        }

        partida = new Partida(dificultad);
        //inhabilitar botones para que no sean pulsados al empezar la partida
        ((Button)findViewById(R.id.un_jugador)).setEnabled(false);
        ((Button)findViewById(R.id.dos_jugadores)).setEnabled(false);
        ((RadioGroup)findViewById(R.id.configDifi)).setAlpha(0);

    }

    //metodo que se llama al pulsar cualquier casilla
    public void toque(View vista){
        //si no se ha pulsado Jugador1 o Jugador2 objeto partida es null y por tanto no se debe
        //ejecutar el método
        if (partida==null){
            return;
        }

        //el bucle recorre el objeto vista buscando que id de casilla se ha pulsado
        //cuando lo encuentra se rompe y se almacena el indice en la var. casilla
        int casilla = 0;
        for (int i = 0; i < CASILLAS.length; i++) {
            if (CASILLAS[i]==vista.getId()){
                casilla=i;
                break;

            }
        }

        Toast toast = Toast.makeText(this,"Has pulsado la casilla " + casilla, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        //jugador 1 marca casilla
        //1-comprobar casilla está libre
        if (partida.comprobarCasilla(casilla)==false){
            return;
        }


        marca(casilla);//2-como está libre la marca

        int resultado = partida.turno();//3-cambio de turno
        if (resultado>0) {// si no hay empate
            termina(resultado);
            return; // este return es para que cuando el flujo vaya a termina y vuelva a este método
                    // salga sin continuar código.
        }

        if(jugadores==1) { // para un jugador usar IA
            //ahora jugador 2 marca casilla
            casilla = partida.ia();
            //si casilla ocupada, bucle hasta encontrar otra libre
            while (partida.comprobarCasilla(casilla) != true) {
                casilla = partida.ia();
            }
            marca(casilla);// tras buscar casilla libre la marca
            resultado = partida.turno();//cambio de turno
            if (resultado > 0) {// si no hay empate
                termina(resultado);
            }
        }//fin del if
    }

    private void termina(int resultado){
        String mensaje;

        if (resultado==1) mensaje = getResources().getString(R.string.circulos_ganan);
        else if (resultado==2) mensaje = getResources().getString(R.string.aspas_ganan);
        else mensaje = getResources().getString(R.string.empate);

        Toast toast = Toast.makeText(this,mensaje, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        //partida null permitirá empezar nueva partida
        partida=null;
        //habilitar botones para que sean pulsados al empezar la partida
        ((Button)findViewById(R.id.un_jugador)).setEnabled(true);
        ((Button)findViewById(R.id.dos_jugadores)).setEnabled(true);
        ((RadioGroup)findViewById(R.id.configDifi)).setAlpha(1);

    }

    private void marca (int casilla){
        ImageView imagen;
        imagen=(ImageView)findViewById(CASILLAS[casilla]);
        if (partida.jugador==1){
            imagen.setImageResource(R.drawable.circulo);
        }else{
            imagen.setImageResource(R.drawable.aspa);
        }
    }

}
