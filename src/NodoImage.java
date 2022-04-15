import javax.swing.ImageIcon;

public class NodoImage {

    ImageIcon valor;
    NodoImage siguiente;

    public NodoImage(ImageIcon valor){

        this.valor = valor;
        this.siguiente = null;

    }
    
    public ImageIcon obtenerValor(){

        return valor;

    }
    
    public void enlazarSiguiente(NodoImage n){
        
        siguiente = n;

    }

    public NodoImage obtenerSiguiente(){
        
        return siguiente;

    }

    
}
