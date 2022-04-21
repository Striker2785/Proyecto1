import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Servidor extends JFrame{
   
    public static void main(String[] args) throws InterruptedException{
        Marco marco = new Marco();
        Juego juego = new Juego();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Marco extends JFrame{

    BufferedImage image;
    static Images imagen = new Images();
    static int x, y, n, a, b, max, min, randomNum, turno, p1, p2;
    static ListaImagenes elegidos = new ListaImagenes();
    int i = 0;
    int j = 0;
    int coordx;
    int coordy;
    String cordenadas, des, n1, n2, name;
    int newcoordx, newcoordy;
    String pos, pos1;


    static String mensaje;
    DataOutputStream salida;

    public Marco(){
        setBounds(700,700,700,700);
        JPanel ventana = new JPanel();
        ventana.setLayout(new BorderLayout());
        ventana.setLayout(new GridLayout(1,3));
        setLocationRelativeTo(null);
        
        n1 = JOptionPane.showInputDialog("Digite el nombre 1: ");
        n2 = JOptionPane.showInputDialog("Digite el nombre 2: ");
        name = n1;
        JLabel nombre1 = new JLabel(n1);
        JLabel nombre2 = new JLabel(n2);
        JLabel pun1 = new JLabel(String.valueOf(p1));
        JLabel pun2 = new JLabel(String.valueOf(p2));

        nombre1.setBounds(10, 10, 200, 200);
        nombre2.setBounds(10, 40, 200, 200);
        pun1.setBounds(70, 10, 200, 200);
        pun2.setBounds(70, 40, 200, 200);


        JFrame puntajes = new JFrame();
        puntajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        puntajes.setLayout(null);
        puntajes.setSize(new Dimension(200,200));
        puntajes.setMinimumSize(new Dimension(200, 200));
        puntajes.setTitle("Puntajes");
        puntajes.setLocationRelativeTo(null);
        puntajes.pack();
        puntajes.setVisible(false);
        puntajes.add(nombre1);
        puntajes.add(nombre2);
        puntajes.add(pun1);
        puntajes.add(pun2);
        
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
                    puntajes.setVisible(true);
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
                    puntajes.setVisible(true);
                    setVisible(false);
                    server.close();
                    x = mensaje.charAt(0);
                    y = mensaje.charAt(2);
                    x = Character.getNumericValue(x);   
                    y = Character.getNumericValue(y);  
                    n = x*y;
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
                    puntajes.setVisible(true);
                    setVisible(false);
                    server.close();
                    x = mensaje.charAt(0);
                    y = mensaje.charAt(2);
                    x = Character.getNumericValue(x);   
                    y = Character.getNumericValue(y);  
                    n = x*y;
                    elegidos = imagen.getLista();
                    elegidos.cortar(n);
                        
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
                DataOutputStream bot = new DataOutputStream(main.getOutputStream());
                cordenadas = coords.readUTF();
                coordx = cordenadas.charAt(2);
                coordy = cordenadas.charAt(5);
                coordx = Character.getNumericValue(coordx);
                coordy = Character.getNumericValue(coordy);


                if (turno == 0){
                    newcoordx = coordx;
                    newcoordy = coordy;
                    turno++;

                    pos = ((mat.getMatriz())[newcoordx][newcoordy]);   
                    bot.writeUTF(pos);
                   


                }else{
                    pos1 = ((mat.getMatriz())[coordx][coordy]);
                    bot.writeUTF(pos1);
                    if (pos1 == pos){
                        if (name == n1){
                            p1++;
                            pun1.setText(String.valueOf(p1));

                        }else{
                            p2++;
                            pun2.setText(String.valueOf(p2));
                        }
                        des = ("x:"+coordx+"y:"+coordy+"x2:"+newcoordx+"y2:"+newcoordy+"iguales");
                        try{
                            Socket desha = new Socket("127.0.0.1", 7070);
                            DataOutputStream desBot = new DataOutputStream(desha.getOutputStream());
                            desBot.writeUTF(des);
                            desha.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }else{
                        if (name == n1){
                            name = n2;
                        }else{
                            name = n1;
                        }
                        des = ("x:"+coordx+"y:"+coordy+"x2:"+newcoordx+"y2:"+newcoordy);
                        try{
                            Socket desha2 = new Socket("127.0.0.1", 7070);
                            DataOutputStream desBot2 = new DataOutputStream(desha2.getOutputStream());
                            desBot2.writeUTF(des);
                            desha2.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                        System.out.println("hola");
                    }
                    turno = 0;
                }
            }

        } catch (Exception e){

        }
        
    
    }
            

}