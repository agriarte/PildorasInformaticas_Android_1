package com.example.app13_tres_en_raya;

import java.util.Random;

public class Partida {
    public final int dificultad;
    public int jugador;
    public int[] casillas;//array que controla casillas libres
    private final int[][] COMBINACIONES = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public Partida(int dificultad) {
        this.dificultad = dificultad;
        jugador=1;

        casillas = new int[9];
        for (int i = 0; i < 9; i++) {
            casillas[i]=0;//liberar todas las casillas, 0 = vacia, 1 = ocupada
        }
    }
    public boolean comprobarCasilla(int casilla){
        //si la posicion está vacía almacena 1 o 2 según jugador
        //si está ocupada, return false sin hacer nada
        if (casillas[casilla]!=0){
            return false;
        }else{
            casillas[casilla]=jugador;
        }
        return true;
    }

    public int ia(){
        //método que devuelve la casilla de la máquina
        int casilla;

        //mirar si jugador tiene posibilidad de hacer 3 en raya
        casilla=dosEnRaya(2);
        if (casilla!=-1) return casilla;// salimos del método

        //inteligencia para nivel normal o superior!
        //si jugador 1 tiene posibilidad de ganar chafarle la casilla para evitarlo
        if (dificultad>0) {
            casilla = dosEnRaya(1);
            if (casilla != -1) return casilla;// salimos del método
        }

        //nivel imposible, ocupamos esquinas para forzar empate
        if (dificultad==2) {
            if (casillas[0] == 0) return 0;
            if (casillas[2] == 0) return 2;
            if (casillas[6] == 0) return 6;
            if (casillas[8] == 0) return 8;
        }


        Random casilla_azar = new Random();
        casilla=casilla_azar.nextInt(9);
        return casilla;
    }

    //conmuta la variable jugador para cambio de turno y devuelve 0,1,2 o 3
    //1 = jugador1 gana 2 = 3 = empate; 0 = ninguna de las otras
    public int turno(){
        boolean empate = true;
        boolean ultimo_movimiento = true;


        for (int i = 0; i < COMBINACIONES.length; i++) {
            for(int pos:COMBINACIONES[i]){
                System.out.println("Valor en posición: " + pos + " " + casillas[pos]);

                // si en esta dimension del array 3 posiciones no coinciden, ese jugador NO ha ganado
                if (casillas[pos]!=jugador) ultimo_movimiento=false;
                //vamos recorriendo cada array de 3 para analizar resultado
                //1- no puede haber empate si alguna casilla esta en blanco. Quiere decir que la partida
                // sigue en juego. empate=false
                if (casillas[pos]==0) empate=false;

            } //cierra for each
            System.out.println("__________________________________________________________");
            if (ultimo_movimiento) return jugador;// sale del bucle
            ultimo_movimiento = true;//sigue en el bucle y vuelva a poner en valor inicial la boolena
        } // cierra for principal

        //aqui se cambia el turno, jugador conmuta entre 1 y 2 sucesivamente
        jugador++;
        if (jugador>2) jugador=1;

        // 1 = jugador1 gana 2 = 3 = empate; 0 = ninguna de las otras
        if (empate) return 3;

        return 0;//
    }

    public int dosEnRaya (int jugador_en_turno){
        //este método devuelve la casilla para hacer tres en raya
        int casilla=-1;
        //variable que almacena si el jugador ha obtenido dos en raya;
        int cuantas_lleva = 0;

        //de nuevo el bucle que recorre el array;

        for (int i = 0; i < COMBINACIONES.length; i++) {
            for (int pos : COMBINACIONES[i]) {
                //evaluar la casilla si está marcada por el jugador que le toca turno
                if (casillas[pos]==jugador_en_turno) cuantas_lleva++;
                //miramos si casillas[pos] está vacía. Si lo está esa es la clave para obtener 3 en raya
                if(casillas[pos]==0) casilla=pos;
            }
            //si se dan las condiciones salimos del método con la casilla clave
            if (cuantas_lleva==2 && casilla !=-1) return casilla;
            //si no se dan se vuelven a inicializar variables y seguimos
            casilla=-1;
            cuantas_lleva=0;
        }

        return -1;
    }


}
