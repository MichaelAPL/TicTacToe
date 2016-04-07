/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.maquina;

/**
 *
 * @author MiguelAngel
 */
public class Nodo {
    protected int mejorMovimiento;
    protected boolean turno;
    protected int indice;
    protected int ganador;
    
    protected int casillas[];
    protected Nodo nodos[];
    
    public Nodo(){
        ganador = 0;
        casillas = new int[9];
    }
    
    
    public void setNodos(int num){
        nodos = new Nodo[num];
    }
    
    public Nodo[] getNodos(){
        return nodos;
    }
    
    public int[] getCasillas(){
        return casillas;
    }

    public int getMejorMovimiento() {
        return mejorMovimiento;
    }

    public void setMejorMovimiento(int mejorMovimiento) {
        this.mejorMovimiento = mejorMovimiento;
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

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
    
    
}
