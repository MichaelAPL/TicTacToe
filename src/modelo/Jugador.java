/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MiguelAngel
 */
public class Jugador {
    protected String nombre;
    protected String correo;
    protected String password;
    
    public Jugador(String nombre, String correo, String password){
        this.nombre = nombre;
        this.correo = correo;
        this.password = encriptarPassword(password);
    }
    
    public Jugador(){
        this.nombre = "";
        this.correo = "";
        this.password = "";
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    public void setPassword(String password){
        this.password = password;
    }
    
    private String encriptarPassword(String password){
        char array[] = password.toCharArray();
        for(int i=0;i<array.length;i++){ 
            array[i]=(char)(array[i]+(char)5);
        }
        String encriptado = String.valueOf(array);
        return encriptado;
    }
}
