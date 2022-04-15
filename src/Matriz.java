import javax.swing.ImageIcon;
import java.util.Random;

public class Matriz {
    public int i, j, randomNum, min;
    ImageIcon [][] matriz;
    Random rn = new Random();

    public Matriz(int x, int y, ListaImagenes copy){

        matriz = new ImageIcon[x][y];
        while (j<y){
            while (i<x){
                randomNum = rn.nextInt(copy.getSize()-min);
                System.out.println(randomNum);
                matriz[i][j] = (ImageIcon) copy.obtener(randomNum);
                copy.eliminar(randomNum);
                i++;
            }
            j++;
            i = 0;
        
        }


    }
    public ImageIcon[][] getMatriz(){
        return matriz;

    }
}
