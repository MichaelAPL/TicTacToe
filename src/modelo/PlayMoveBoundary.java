/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MiguelAngel
 */
public class PlayMoveBoundary {
    
    public void announceInvalidMove(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage(), "Casilla ocupada", JOptionPane.ERROR_MESSAGE);
    }
    
    public void announceResult(int x){
        switch(x){
            case 1:
                JOptionPane.showMessageDialog(null, "¡Has Ganado!", "¡Felicidades!", JOptionPane.OK_OPTION);
            break;
            case 2:
                JOptionPane.showMessageDialog(null, "¡Has Perdido!", "¡Mejor suerte para la proxima!", JOptionPane.INFORMATION_MESSAGE);
            break;
            case 0:
                JOptionPane.showMessageDialog(null, "¡Empate! Nadie gana", "¡Empate!", JOptionPane.OK_OPTION);
            break;
        }
    } 
    
    public void guardarPartidas(String correoJugador, int resultadoFinal[]){
        String name = correoJugador+".txt";
        File file = new File(name);
        String partidas = "";
        for(int i = 0; i < 9; i++){
            if(resultadoFinal[i] == 1){
               partidas = partidas.concat("1");
            }else{
                partidas = partidas.concat("0");
            }
        }
        if(file.exists()){
            FileWriter fw = null;
            try {
                fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                Date date = new Date();
                DateFormat hdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
                bw.write(correoJugador+", ");
                bw.write(hdf.format(date)+", ");
                bw.write(partidas);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al momento de guardar la partida");
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al momento de guardar la partida");
                }
            }
        }else{
            FileWriter fw = null;
            try {
                fw = new FileWriter(name);
                BufferedWriter bw = new BufferedWriter(fw);
                Date date = new Date();
                DateFormat hdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
                bw.write(correoJugador+", ");
                bw.write(hdf.format(date)+", ");
                bw.write(partidas);
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al momento de guardar la partida");
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al momento de guardar la partida");
                }
            }
        }
    }
}
