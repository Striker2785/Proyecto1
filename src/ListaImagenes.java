/**
 * Se crea la clase ListaImagenes
 */

public class ListaImagenes {
    Nodo head;
    int size;


    public ListaImagenes(){

        head = null;
        size = 0;   

    }
    /**
     * con esto obtenemos el valor en una posicion dada.
     * @param i
     * @return
     */
    public String obtener(int i){
        int contador = 0;
        Nodo temp = head;
        while (contador < i){

            temp= temp.obtenerSiguiente();
            contador++;

        }
        return temp.obtenerValor();
    }

    /**
     * Con esto agregamos un nuevo valor a la lista
     * @param valor
     */
    public void addPrimero(String valor){

        if (head == null){
            head = new Nodo(valor);
        }
        else{
            Nodo temp = head;
            Nodo nuevo = new Nodo(valor);
            while (temp.obtenerSiguiente() != null){
                temp = temp.obtenerSiguiente();


            }
            temp.enlazarSiguiente(nuevo); 
        }
        size++;
    }

    /**
     * Esto elimina un valor en una posicion dada.
     * @param i
     */
    public void eliminar(int i){

        if (i==0){
            head = head.obtenerSiguiente();
        }
        else{

            int contador = 0;
            Nodo temp = head;
        
            while (contador < i-1){
                temp = temp.obtenerSiguiente();
                contador++;
            }
            temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
        }
        size--;

    }
    /**
     * Con esto se puede dividir la lista en una posicion dada.
     * @param i
     */
    public void cortar(int i){

        int contador = 0;
        Nodo temp = head;

        while (contador < i-1){
            temp = temp.obtenerSiguiente();
            contador++;
        }
        temp.enlazarSiguiente(null);
        size = i;

    }
    /**
     * Con esto eliminamos el primer valor de la lista.
     */
    public void eliminarPrimero(){
        head = head.obtenerSiguiente();
        System.err.println(head);
        size--;
    }

    /**
     * Esto nos devuelve el tamaño de la lista.
     * @return
     */
    public int getSize(){

        return size;
    }
    
}
