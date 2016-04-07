/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorPrincipal;
import controlador.PlayMoveController;
import modelo.Board;
import vista.VentanaLogin;
import vista.VentanaRegistro;
import vista.VentanaTicTacToe;

/**
 *
 * @author MiguelAngel
 */
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        VentanaTicTacToe ticTacToe = new VentanaTicTacToe();
        
        PlayMoveController controller = new PlayMoveController(board, ticTacToe);
        
        VentanaLogin ventanaLogin = new VentanaLogin();
        VentanaRegistro ventanaRegistro = new VentanaRegistro();
        ControladorPrincipal cp = new ControladorPrincipal(ventanaLogin, ventanaRegistro, controller);
    }
}
