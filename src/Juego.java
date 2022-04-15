import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Juego{

    

    private Juego(){

        String recivied;
        int x = 0;
        int y = 0;
        int n = 0;
        JFrame espera = new JFrame();
        JLabel etiqueta = new JLabel("Espere");
        etiqueta.setBounds(215, 120, 200, 200);
        espera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        espera.setLayout(null);
        espera.setSize(new Dimension(500,500));
        espera.setMinimumSize(new Dimension(500, 500));
        espera.setTitle("Espera");
        espera.pack();
        espera.setVisible(true);
        espera.add(etiqueta);

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500,500));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Memoria");
        frame.pack();
        frame.setVisible(false);

        try{
            ServerSocket cliente = new ServerSocket(8080);
            //Socket client = new Socket("127.0.0.1", 8080);
            Socket client;

            client = cliente.accept();

            DataInputStream entrada = new DataInputStream(client.getInputStream());
            String mensaje = entrada.readUTF();
            x = mensaje.charAt(0);
            y = mensaje.charAt(2);
            n = mensaje.charAt(4);
            x = Character.getNumericValue(x);
            y = Character.getNumericValue(y);  
            n = Character.getNumericValue(n);
            cliente.close();
                
            

        }catch(Exception e){

        }
        
        frame.setLayout(new GridLayout(y,x));

        ListaBotones botones = new ListaBotones();
        int i = 0;
        int j = 0;
        
        while (j < y){
            while (i < x){
                Ficha boton = new Ficha(i,j);
                botones.addPrimero(boton);
                frame.add(boton.boton);
                i += 1;
            }
            j += 1;
            i = 0;
 
        }
        frame.setVisible(true);
        espera.setVisible(false); 


        try{
            recivied = ("Recibido");
            Socket envia_cliente = new Socket("127.0.0.1", 1488);
            DataOutputStream recibido = new DataOutputStream(envia_cliente.getOutputStream());
            recibido.writeUTF(recivied); 
            envia_cliente.close();

            
        } catch (IOException e){
            e.printStackTrace();

        }
    }

  
    
    public static void  main(String[] args){

        new Juego();
    }
}
