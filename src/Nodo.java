/**
 * Se crea la clase nodo
 */
public class Nodo {

    String valor;
    Nodo siguiente;
    /**
     * Con esto creamos un nuevo nodo.
     * @param valor
     */
    public Nodo(String valor){

        this.valor = valor;
        this.siguiente = null;

    }
    /**
     * Esto nos devuelve el valor que se encuentre en el nodo
     * @return
     */
    public String obtenerValor(){

        return valor;

    }
    /**
     * Esto nos enlaza un nuevo nodo con el siguente en la lista.
     * @param n
     */
    public void enlazarSiguiente(Nodo n){
        
        siguiente = n;

    }
    /**
     * con esto obtenemos el nodo siguiente.
     * @return
     */
    public Nodo obtenerSiguiente(){
        
        return siguiente;

    }


}
