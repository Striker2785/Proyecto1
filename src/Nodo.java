public class Nodo {

    String valor;
    Nodo siguiente;

    public Nodo(String valor){

        this.valor = valor;
        this.siguiente = null;

    }
    
    public String obtenerValor(){

        return valor;

    }
    
    public void enlazarSiguiente(Nodo n){
        
        siguiente = n;

    }

    public Nodo obtenerSiguiente(){
        
        return siguiente;

    }


}
