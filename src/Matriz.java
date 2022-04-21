import java.util.Random;

public class Matriz {
    public int i, j, randomNum, min;
    String [][] matriz;
    Random rn = new Random();

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
    public String[][] getMatriz(){
        return matriz;

    }
}
