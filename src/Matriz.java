/**
 * Se importan las librerias a utilizar.
 */
import java.util.Random;

/**
 * Se crea la clase matriz y se definen las variables.
 */
public class Matriz {
    public int i, j, randomNum, min;
    String [][] matriz;
    Random rn = new Random();

    /**
     * Con este constructor se crean la matriz con todas las imagenes a utilizar
     * las imagenes se colocan de manera aleatoria en la matriz.
     * @param x
     * @param y
     * @param copy
     */
    public Matriz(int x, int y, ListaImagenes copy){

        matriz = new String [x][y];
        while (j<y){
            while (i<x){
                randomNum = rn.nextInt(copy.getSize()-min);
                matriz[i][j] = copy.obtener(randomNum);
                copy.eliminar(randomNum);
                i++;
            }
            j++;
            i = 0;
        
        }

    }
    /**
     * Con esto se obtiene la matriz para poder utilizarla en otros archivos.
     * @return
     */
    public String[][] getMatriz(){
        return matriz;

    }   
}
