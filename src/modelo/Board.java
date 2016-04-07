/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.exceptions.CasillaOcupadaException;

/**
 *
 * @author MiguelAngel
 */
public class Board {

    private int casillas[];
    
    public Board(){
        this.casillas = new int[9];
    }

    public int[] getCasillas() {
        return casillas;
    }
    
    public boolean estaOcupada(int i){
        if(casillas[i] == 1 || casillas[i] ==2){
            return true;
        }else{
            return false;
        }
    }
    
    public void ocuparCasilla(int i, int x) throws CasillaOcupadaException{
        if(!estaOcupada(i)){
            casillas[i] = x;
        }else{
            throw new CasillaOcupadaException();
        }
    }
    
    public void borrarCasilla(int x){
        casillas[x] = 0;
    }

    public int numMovDisponibles() {
        int mov = 0;
        for (int i = 0; i < 9; i++) {
            if (casillas[i] == 0) {
                mov++;
            }
        }
        return mov;
    }
    
    public int[] posicionesVacias(){
        int[] indices = new int[numMovDisponibles()];
        int indice = 0;
        for (int  i = 0;  i < 9;  i++) {
            if(casillas[i] == 0){
                indices[indice] = i;
                indice++;
            }
        }
        return indices;
    }
}
