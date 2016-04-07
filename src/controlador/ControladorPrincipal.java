/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import modelo.DataBase;
import modelo.Jugador;
import modelo.exceptions.CorreoOcupadoException;
import modelo.exceptions.InvalidUserException;
import vista.VentanaLogin;
import vista.VentanaRegistro;

/**
 *
 * @author MiguelAngel
 */
public class ControladorPrincipal {
    private VentanaLogin login;
    private VentanaRegistro registro;
    private PlayMoveController pmc;
    private DataBase db;
    
    public ControladorPrincipal(VentanaLogin login, VentanaRegistro registro, PlayMoveController pmc){
        try {
            this.db = new DataBase();
            this.login = login;
            this.registro = registro;
            this.pmc = pmc;
            inicializarLogin();
            login.setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos", "Error", JOptionPane.ERROR);
        }
    }

    private void inicializarLogin() {
        this.login.getIngresoBT().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String password = encriptarPassword(login.getPasswordTF().getText());
                    Jugador j = db.checkUser(password, login.getCorreoTF().getText());
                    pmc.setCorreoJugador(j.getCorreo());
                    pmc.inicializarVentana(); 
                    login.hide();
                } catch (InvalidUserException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }      
        });
        
        this.login.getRegistroBT().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                inicializarRegistro();
                registro.setVisible(true);
                login.hide();
            }      
        });
    }
    
    private void inicializarRegistro(){
        this.registro.getRegistroBT().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Jugador j = new Jugador(registro.getNombreTF().getText(), registro.getCorreoTF().getText(),
                            registro.getPasswordTF().getText());                    
                    if(j != null){
                        db.checkCorreo(j.getCorreo());
                        db.addJugador(j);
                        JOptionPane.showMessageDialog(null, "¡Has sido registrado con exito!");
                        db.guardarDatos();
                        registro.hide();
                        login.setVisible(true);
                    }
                } catch (CorreoOcupadoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    registro.getCorreoTF().setText("");
                    registro.getPasswordTF().setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar la base de datos");
                }
            }
        });
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
