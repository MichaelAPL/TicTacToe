/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import modelo.Board;
import modelo.PlayMoveBoundary;
import modelo.exceptions.CasillaOcupadaException;
import modelo.exceptions.GameOverException;
import modelo.maquina.Maquina;
import vista.VentanaTicTacToe;

/**
 *
 * @author MiguelAngel
 */
public class PlayMoveController {

    private Board board;
    private VentanaTicTacToe ticTacToe;
    private Maquina maquina;
    private int ganador;
    private int resultadoFinal[];
    private String correoJugador;

    public PlayMoveController(Board board, VentanaTicTacToe ticTacToe) {
        this.board = board;
        this.ticTacToe = ticTacToe;
        maquina = new Maquina();
    }
    
    public void inicializarVentana(){
        startGame();
        this.ticTacToe.setVisible(true);
    }

    private void startGame() {
        ticTacToe.getC1().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(0, 1);
                    ticTacToe.getC1().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC2().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(1, 1);
                    ticTacToe.getC2().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC3().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC3().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(2, 1);
                    ticTacToe.getC3().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC4().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(3, 1);
                    ticTacToe.getC4().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC5().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC5().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(4, 1);
                    ticTacToe.getC5().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC6().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC6().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(5, 1);
                    ticTacToe.getC6().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC7().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC7().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(6, 1);
                    ticTacToe.getC7().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC8().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC8().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(7, 1);
                    ticTacToe.getC8().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });

        ticTacToe.getC9().setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ticTacToe.getC9().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    gameOver(board.getCasillas());
                    board.ocuparCasilla(8, 1);
                    ticTacToe.getC9().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/circulo-icono-7439-128.png")));
                    gameOver(board.getCasillas());
                    ponerFichaMaquina();
                    gameOver(board.getCasillas());
                } catch (CasillaOcupadaException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceInvalidMove(ex);
                } catch (GameOverException ex) {
                    PlayMoveBoundary pmb = new PlayMoveBoundary();
                    pmb.announceResult(ganador);
                    resultadoFinal = board.getCasillas();
                    pmb.guardarPartidas(correoJugador, resultadoFinal);
                    reset();
                }
            }
        });
    }

    private void ponerFichaMaquina() throws CasillaOcupadaException {
        int i = maquina.movimiento(board);
        switch (i) {
            case 0:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC1().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 1:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC2().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 2:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC3().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 3:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC4().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 4:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC5().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 5:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC6().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 6:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC7().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 7:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC8().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
            case 8:
                board.ocuparCasilla(i, 2);
                ticTacToe.getC9().setIcon(new ImageIcon(this.getClass().getResource("/imagenes/672366-x-128.png")));
                break;
        }
    }
    
    private void gameOver(int[] tablero) throws GameOverException{
        if(tablero[0] == tablero[1] && tablero[0] == tablero[2] && tablero[0] != 0){
            ganador = tablero[0]; 
            throw new GameOverException();
        }else{
            if(tablero[3] == tablero[4] && tablero[3] == tablero[5]  && tablero[3] != 0){
                ganador = tablero[3];
                throw new GameOverException();
            }else{
                if(tablero[6] == tablero[7] && tablero[6]== tablero[8]  && tablero[6] != 0){
                    ganador = tablero[6];
                    throw new GameOverException();
                }else{
                    if(tablero[0] == tablero[3] && tablero[0] == tablero[6]  && tablero[0] != 0){
                        ganador = tablero[0];
                        throw new GameOverException();
                    }else{
                        if(tablero[1] == tablero[4] && tablero[1] == tablero[7]  && tablero[1] != 0){
                            ganador = tablero[1];
                            throw new GameOverException();
                        }else{
                            if(tablero[2] == tablero[5] && tablero[2] == tablero[8]  && tablero[2] != 0){
                                ganador = tablero[2];
                                throw new GameOverException();
                            }else{
                                if(tablero[0] == tablero[4] && tablero[0] == tablero[8] && tablero[0] !=0){
                                    ganador = tablero[0];
                                    throw new GameOverException();
                                }else{
                                    if(tablero[2] == tablero[4] && tablero[2] == tablero[6] && tablero[2] != 0){
                                        ganador = tablero[2];
                                        throw new GameOverException();
                                    }else{
                                        if(board.numMovDisponibles() == 0){
                                            ganador = 0;
                                            throw new GameOverException();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void reset(){
        this.ticTacToe.getC1().setIcon(null);
        this.ticTacToe.getC2().setIcon(null);
        this.ticTacToe.getC3().setIcon(null);
        this.ticTacToe.getC4().setIcon(null);
        this.ticTacToe.getC5().setIcon(null);
        this.ticTacToe.getC6().setIcon(null);
        this.ticTacToe.getC7().setIcon(null);
        this.ticTacToe.getC8().setIcon(null);
        this.ticTacToe.getC9().setIcon(null);
        
        for(int i = 0; i < 9; i++){
            board.borrarCasilla(i);
        }
    }

    public void setCorreoJugador(String correoJugador) {
        this.correoJugador = correoJugador;
    }
}
