/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maze3d;

/**
 *
 * @author leon
 */
public class Tablero {
    
    public static final int ESTE = 0;
    public static final int OESTE = 1;
    public static final int NORTE = 2;
    public static final int SUR = 3;
    public static final int FONDO = 4;
    public static final int FRENTE = 5;
    
    private Integer[][][] tablero; // y, x, z
    
    private Integer x;
    private Integer y;
    private Integer z;
    
    private Integer topex;
    private Integer topey;
    private Integer topez;
    
    
    /**
     * Hacia donde está viendo el personaje
     * 0 Este, se cambia x ++
     * 1 Oeste, se cambia x --
     * 2 Norte, se cambia y --
     * 3 Sur, se cambia y ++
     * 4 Fondo, se cambia z ++
     * 5 Frente, se cambia z --
     * 
     */
    private Integer direccion_vista = 0; 
    
   
    public Tablero(Integer largo, Integer ancho, Integer profundo){
        //this.tablero = new Integer[largo][ancho][profundo];
        inicializaTablero();
        this.x = 0;
        this.y = 0;
        this.z = 0;
        
        this.topex = ancho;
        this.topey = largo;
        this.topez = profundo;
        
    }
    
     private void inicializaTablero(){
        this.tablero = new Integer[][][]{{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},
                                    {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},
                                    {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},
                                    {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},
                                    {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}};
    }
    
    
    public Integer avanzar() throws Exception{
        Integer resultado = 1;
        switch (direccion_vista){
            case Tablero.ESTE:
                if (this.x+1 > topex) throw new Exception("Sobrepasa el limite");
                verificaPosicion(x+1,y,z);
                this.x++;
                break;
            case Tablero.OESTE:
                if (this.x-1 < 0) throw new Exception("Sobrepasa el limite");
                verificaPosicion(x-1,y,z);
                this.x--;
                break;
            case Tablero.NORTE:
                if (this.y-1 < 0) throw new Exception("Sobrepasa el limite");
                verificaPosicion(x,y-1,z);
                this.y--;
                break;
            case Tablero.SUR:
                if (this.y+1 > topey) throw new Exception("Sobrepasa el limite");
                verificaPosicion(x,y+1,z);
                this.y++;
                break;
            case Tablero.FONDO:
                if (this.z+1 > topez) throw new Exception("Sobrepasa el limite");
                verificaPosicion(x,y,z+1);                
                this.z++;
                break;
            case Tablero.FRENTE:
                if (this.z-1 < 0) throw new Exception("Sobrepasa el limite");
                verificaPosicion(x,y,z-1);                
                this.z--;
                break;
                
        }
        
        return resultado;
    }
    
    private void verificaPosicion(Integer x, Integer y, Integer z) throws Exception{
      switch (tablero[y][x][z]){
          case 1:
              throw new Exception("Hay una pared.");
             
      }
    }
    
    public String obtenCoordenadas(){
       return "{x:"+this.x+", y:"+this.y+", z:"+this.z+"}";
    }
    
    
}
