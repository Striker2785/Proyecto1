import java.awt.GridLayout;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;


public class Juego{

    

    private Juego(){
        int x = 0;
        int y = 0;
        JFrame espera = new JFrame();
        espera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        espera.setSize(500,500);
        espera.setTitle("Espera");
        espera.pack();
        espera.setVisible(true);

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Memoria");
        frame.pack();
        frame.setVisible(false);

        try{
            //ServerSocket cliente = new ServerSocket(8080);
            Socket client = new Socket("127.0.0.1", 8080);

            
            DataInputStream entrada = new DataInputStream(client.getInputStream());
            String mensaje = entrada.readUTF();
            System.out.println(mensaje);
            x = mensaje.charAt(0);
            y = mensaje.charAt(2);
                
            //cliente.close();
                
            

        }catch(Exception e){
            System.out.println(e.getMessage());

        }
        
        frame.setLayout(new GridLayout(y,x));


        int i = 0;
        int j = 0;
        
        while (j < y){
            while (i < x){
                Ficha boton = new Ficha(i,j);
                frame.add(boton.boton);
                i += 1;
            }
            j += 1;
            i = 0;
 
        }

        frame.setVisible(true);
        espera.setVisible(false); 
    }

  
    
    public static void  main(String[] args){

        new Juego();
    }
}
