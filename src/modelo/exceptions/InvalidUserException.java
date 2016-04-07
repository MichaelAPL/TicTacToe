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
public class InvalidUserException extends Exception {
    public InvalidUserException(){
        super("Error en la autenticación del usuario. Correo o contraseña inválida");
    }
}
