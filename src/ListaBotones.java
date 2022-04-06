public class ListaBotones {
    
    Nodo head;
    int size;

    public ListaBotones(){

        head = null;
        size = 0;   

    }

    public Object obtener(int i){
        int contador = 0;
        Nodo temp = head;
        while (contador < 0){

            temp= temp.obtenerSiguiente();
            contador++;

        }
        return temp.obtenerValor();
    }

    public void addPrimero(Object valor){

        if (head == null){
            head = new Nodo(valor);
        }
        else{
            Nodo temp = head;
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente(temp);
        }
        size++;
    }

    public int getSize(){

        return size;
    }

}
