import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Juego{
    static JButton matBot[][];

    public Juego() throws InterruptedException{

        ImageIcon back;
        String recivied, des;
        int x = 0;
        int y = 0;
        int n = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        JFrame espera = new JFrame();
        JLabel etiqueta = new JLabel("Espere");
        etiqueta.setBounds(215, 120, 200, 200);
        espera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        espera.setLayout(null);
        espera.setSize(new Dimension(200,200));
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
        int i = 0;
        int j = 0;
        matBot= new JButton[x][y];
        back = new ImageIcon("C:/Users/menei/Desktop/Braulio/Trabajos/U2022/Semestre1/Datos1/Proyecto1/Proyecto1/src/Imagenes/Back.jpg");
        while (j < y){
            while (i < x){
                Ficha boton = new Ficha(i,j);
                matBot[i][j] = boton.boto;
                frame.add(boton.boto);
                boton.boto.setIcon(new ImageIcon(back.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
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
        while (true){
            try{
                ServerSocket deshab = new ServerSocket(7070);
                Socket desha;
                desha = deshab.accept();
                DataInputStream botDes = new DataInputStream(desha.getInputStream());
                des = botDes.readUTF();
                    a = des.charAt(2);
                    b = des.charAt(5);
                    c = des.charAt(9);
                    d = des.charAt(13);
                    a = Character.getNumericValue(a);
                    b = Character.getNumericValue(b);
                    c = Character.getNumericValue(c);
                    d = Character.getNumericValue(d);
                if (des.contains("iguales")){
                    matBot[a][b].setEnabled(false);
                    matBot[c][d].setEnabled(false);
                }else{
                    Thread.sleep(300);
                    matBot[a][b].setIcon(new ImageIcon(back.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                    matBot[c][d].setIcon(new ImageIcon(back.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                }
                desha.close();
                deshab.close();
    
            }catch (IOException e){
                e.printStackTrace();
            }
            
        }
    
    }


    public static JButton[][] getMat(){
        return matBot;

    }
  
    
    public static void  main(String[] args) throws InterruptedException{

        new Juego();
    }
}
