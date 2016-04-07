/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.maquina;

import modelo.Board;

/**
 *
 * @author MiguelAngel
 */
public class Maquina {

    protected final int marca = 2;
    protected static int tiradas = 0;
    protected int casillas[];
    protected Nodo arbol;

    public Maquina() {
        casillas = new int[9];
        arbol = new Nodo();
    }

    public int movimiento(Board board) {
        casillas = board.getCasillas();
        tiradas++;

        for (int i = 0; i < 9; i++) {
            this.arbol.casillas[i] = casillas[i];
        }

        calcularMovimiento(arbol);

        return arbol.mejorMovimiento;
    }

    private void calcularMovimiento(Nodo raiz) {
        int movimientos = raiz.numMovDisponibles();
        int posVacias[] = raiz.posicionesVacias();
        
        raiz.setNodos(movimientos);
        
        int ganador = terminado(raiz.getCasillas());
        if(ganador == 1){
            ganador = -1;
        }else{
            if(ganador == 2){
                ganador = 1;
            }
        }
        
        if(ganador != 0 || movimientos == 0){
            raiz.setGanador(ganador);
        }else{
            for(int i = 0; i < movimientos; i++){
                raiz.nodos[i] = new Nodo();
                for(int j = 0; j < 9; j++){
                    raiz.nodos[i].casillas[j] = raiz.casillas[j];
                }
                if(raiz.turno){
                    raiz.nodos[i].casillas[posVacias[i]] = 1;
                }else{
                    raiz.nodos[i].casillas[posVacias[i]] = 2;
                }
                
                raiz.nodos[i].turno = !raiz.turno;
          
                raiz.nodos[i].indice = posVacias[i];
                    
                calcularMovimiento(raiz.nodos[i]);
            }    
            
            if(!raiz.turno){
                raiz.ganador = Max(raiz);
            }else{
                raiz.ganador = Min(raiz);
            }
        }
    }

    public int terminado(int[] tablero) {
        /*Comprobamos si el juego terminó.*/
        /*Filas*/
        if (tablero[0] == tablero[1] && tablero[0] == tablero[2] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[3] == tablero[4] && tablero[3] == tablero[5] && tablero[3] != 0) {
            return tablero[3];
        } else if (tablero[6] == tablero[7] && tablero[6] == tablero[8] && tablero[6] != 0) {
            return tablero[6];
        } /*Columnas*/ else if (tablero[0] == tablero[3] && tablero[0] == tablero[6] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[1] == tablero[4] && tablero[1] == tablero[7] && tablero[1] != 0) {
            return tablero[1];
        } else if (tablero[2] == tablero[5] && tablero[2] == tablero[8] && tablero[2] != 0) {
            return tablero[2];
        } /*Diagonales*/ else if (tablero[0] == tablero[4] && tablero[0] == tablero[8] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[2] == tablero[4] && tablero[2] == tablero[6] && tablero[2] != 0) {
            return tablero[2];
        }
        return 0;
    }

    private int Max(Nodo raiz) {
        int Max = -111;
        /*Máximo para la computadora, buscamos el valor donde gane.*/
        for (int i = 0; i < raiz.nodos.length; i++){
          /*Preguntamos por un nodo con un valor alto MAX*/
            if (raiz.nodos[i].ganador > Max){
                /*Lo asignamos y pasamos el mejor movimiento a la raíz.*/
                Max = raiz.nodos[i].ganador;
                raiz.mejorMovimiento = raiz.nodos[i].indice;
                /*Terminamos de buscar.*/
                if (Max == 1) break;
            }
         }
        
        /*Borramos los nodos.*/
        raiz.nodos = null;
        
        return Max;
    }

    private int Min(Nodo raiz) {
        int Min = 111;
        /*Mínimo para el jugador*/
        for (int i = 0; i < raiz.nodos.length; i++)
          if (raiz.nodos[i].ganador < Min ){
            Min = raiz.nodos[i].ganador;
            raiz.mejorMovimiento = raiz.nodos[i].indice;
            if (Min == -1) break;
          }
        
        /*Borramos los nodos.*/
        raiz.nodos = null;
        
        return Min;
    }
}
