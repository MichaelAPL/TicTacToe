/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.exceptions;

/**
 *
 * @author MiguelAngel
 */
public class CorreoOcupadoException extends Exception {
    public CorreoOcupadoException(){
        super("Correo electrónico ya registrado por otro usuario... Ingrese otro");
    }
}
