/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.exceptions.CorreoOcupadoException;
import modelo.exceptions.InvalidUserException;

/**
 *
 * @author MiguelAngel
 */
public class DataBase {
    private ArrayList db;
    private File file;
    private final String ruta = "DataBase.txt";
    
    public DataBase() throws IOException{
        db = new ArrayList<Jugador>();
        cargarDatos();
    }
    
    private void cargarDatos() throws IOException{
        File f = new File(ruta);
        if(f.exists()){
            file = f;
        }else{
            FileWriter fw = new FileWriter(ruta);
            file = new File(ruta);
        }
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String temp, temp2;
        int i = 0;
        Jugador j = new Jugador();
        while((temp = bf.readLine())!=null){
            temp2 = temp;
            switch(i){
                case 0:
                    j.setNombre(temp2);
                break;
                case 1:
                    j.setCorreo(temp2);
                break;
                case 2:
                    j.setPassword(temp2);
                break;
            }
            i++;
            if(i > 2){
                addJugador(j);
                i = 0;
            }
        }
    }
    
    public void guardarJugador(Jugador j) throws IOException{
        FileWriter fr = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fr);
        bw.write(j.getNombre());
        bw.newLine();
        bw.write(j.getCorreo());
        bw.newLine();
        bw.write(j.getPassword());
        bw.newLine();
        bw.close();
    }
    
    public void guardarDatos() throws IOException{
        FileWriter fr = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fr);
        Jugador j;
        for(int i = 0; i < db.size(); i++){
            j = (Jugador) db.get(i);
            bw.write(j.getNombre());
            bw.newLine();
            bw.write(j.getCorreo());
            bw.newLine();
            bw.write(j.getPassword());
            bw.newLine();
        }
        bw.close();
    }
    
    public void addJugador(Jugador j){
        db.add(j);
    }
    
    public void checkCorreo(String correo) throws CorreoOcupadoException{
        Jugador j;
        for (int i = 0; i < db.size(); i++) {
            j = (Jugador) db.get(i);
            if(correo.equals(j.getCorreo())){
                throw new CorreoOcupadoException();
            }
        }
    }
    
    public Jugador checkUser(String password, String correo) throws InvalidUserException{
        Jugador j; int i ;
        for(i = 0; i < db.size(); i++){
            j = (Jugador) db.get(i);
            if(j.getPassword().equals(password)){
                if(!correo.equals(j.getCorreo())){
                    throw new InvalidUserException();
                }else{
                    return j;
                }
            }
        }
        if(i >= db.size()){
            throw new InvalidUserException();
        }
        return null;
    }
}
