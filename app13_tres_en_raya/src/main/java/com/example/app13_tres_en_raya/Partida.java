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
        if (casillas[casilla]!=0){
            return false;
        }else{
            casillas[casilla]=jugador;
        }
        return true;
    }

    public int ia(){
        int casilla;
        Random casilla_azar = new Random();
        casilla=casilla_azar.nextInt(9);
        return casilla;
    }

    public void turno(){
        for (int i = 0; i < COMBINACIONES.length; i++) {
            for(int pos:COMBINACIONES[i]){

            }
            
        }

        jugador++;
        if (jugador>2) jugador=1;
    }


}
