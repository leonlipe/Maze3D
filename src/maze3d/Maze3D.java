/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maze3d;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leon
 */
public class Maze3D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero tablero = new Tablero(10, 10, 10);
        try {
            tablero.avanzar();
            System.out.println("Avanzó "+tablero.obtenCoordenadas());
            // TODO code application logic here
        } catch (Exception ex) {
            System.out.println("Error al avanzar: "+ex.getMessage());
        }
    }
    
}
