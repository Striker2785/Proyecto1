import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.DataInputStream;
//import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.*;

public class Servidor extends JFrame{
   
    public static void main(String[] args){
        Marco marco = new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Marco extends JFrame{

    static Images imagen = new Images();
    static int x, y, n, a, b, max, min, randomNum, turno;
    static ListaImagenes elegidos = new ListaImagenes();
    int i = 0;
    int j = 0;
    int coordx;
    int coordy;
    String cordenadas;
    int newcoordx, newcoordy;
    ImageIcon boton;


    static String mensaje;
    DataOutputStream salida;

    public Marco(){

        setBounds(700,700,700,700);
        JPanel ventana = new JPanel();
        ventana.setLayout(new BorderLayout());
        ventana.setLayout(new GridLayout(1,3));
        setLocationRelativeTo(null);
        
        JButton boton1 = new JButton("2x3");
        JButton boton2 = new JButton("3x4");
        JButton boton3 = new JButton("4x4");



        ActionListener event1 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent q) {
                mensaje = ("2x3,6");
                try{

                    Socket server = new Socket("127.0.0.1", 8080);
                    salida = new DataOutputStream(server.getOutputStream());
                    salida.writeUTF(mensaje);
                    setVisible(false);
                    server.close();
                    x = mensaje.charAt(0);
                    y = mensaje.charAt(2);
                    n = mensaje.charAt(4);
                    x = Character.getNumericValue(x);   
                    y = Character.getNumericValue(y);  
                    n = Character.getNumericValue(n);
                    elegidos = imagen.getLista();
                    elegidos.cortar(n);
        

                        
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

        };

        ActionListener event2 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent q) {
                mensaje = ("3x4,12");
                try{

                    Socket server = new Socket("127.0.0.1", 8080);
                    salida = new DataOutputStream(server.getOutputStream());
                    salida.writeUTF(mensaje);
                    setVisible(false);
                    server.close();
                    x = mensaje.charAt(0);
                    y = mensaje.charAt(2);
                    n = mensaje.charAt(4);
                    x = Character.getNumericValue(x);   
                    y = Character.getNumericValue(y);  
                    n = Character.getNumericValue(n);

                    elegidos = imagen.getLista();
                    elegidos.cortar(n);
                        
                } catch (IOException e){
                    e.printStackTrace();
                }
               
  
            }

        };

        ActionListener event3 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent q) {
                mensaje = ("4x4,16");
                try{

                    Socket server = new Socket("127.0.0.1", 8080);
                    salida = new DataOutputStream(server.getOutputStream());
                    salida.writeUTF(mensaje);
                    elegidos = imagen.getLista();
                    setVisible(false);
                    server.close();
                        
                } catch (IOException e){
                    e.printStackTrace();
                }
                
            }

        };



        boton1.addActionListener(event1);
        boton2.addActionListener(event2);
        boton3.addActionListener(event3);

        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);

        add(ventana);
        setVisible(true);

        
        try{
            ServerSocket servidor = new ServerSocket(1488);
            Socket serv;

            serv = servidor.accept();
            servidor.close();

        } catch (IOException e){
            e.printStackTrace();
        }


        Matriz mat = new Matriz(x,y,elegidos);
        

        try{
            ServerSocket socket = new ServerSocket(9090);
            
            while (true){
                Socket main = socket.accept();
                DataInputStream coords= new DataInputStream(main.getInputStream());
                cordenadas = coords.readUTF();
                coordx = cordenadas.charAt(2);
                coordy = cordenadas.charAt(5);
                coordx = Character.getNumericValue(coordx);
                coordy = Character.getNumericValue(coordy);


                if (turno == 0){
                    newcoordx = coordx;
                    newcoordy = coordy;
                    turno++;
                    
                    //boton = new ImageIcon("mat[coordx][coordy]");
                    //System.out.println("X:"+ coordx+ "Y:"+ coordy);
                    System.out.println((mat.getMatriz())[coordx][coordy]);
                    
                }else{
                    System.out.println("Hola");
                    turno = 0;
                }
            }

        } catch (Exception e){

        }
        //System.out.println(imagen.getLista().getSize());
    
    }
            

}