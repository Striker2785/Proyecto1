

public class ListaImagenes {
    Nodo head;
    int size;

    public ListaImagenes(){

        head = null;
        size = 0;   

    }

    public String obtener(int i){
        int contador = 0;
        Nodo temp = head;
        while (contador < i){

            temp= temp.obtenerSiguiente();
            contador++;

        }
        return temp.obtenerValor();
    }

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
            //NodoImage nuevo = new NodoImage(valor);
            //nuevo.enlazarSiguiente(temp);
        }
        size++;
    }

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

    public void eliminarPrimero(){
        head = head.obtenerSiguiente();
        System.err.println(head);
        size--;
    }



    public int getSize(){

        return size;
    }
    
}
