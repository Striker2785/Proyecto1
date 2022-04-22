/**
 * Se importan las librerias a utilizar.
 */
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
        Server server = new Server();
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

/**
 * Se crea la clase Marco la cual creara la ventana del servidor.
 */
class Server extends JFrame{

    /**
     * Se definen las variables que se utilizaran mas adelante.
     */
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

    /** 
     * Se crea el constructor.
     */
    public Server(){
        /**
         * Se definen los tamaños de la ventana.
         */
        setBounds(700,700,700,700);
        JPanel ventana = new JPanel();
        ventana.setLayout(new BorderLayout());
        ventana.setLayout(new GridLayout(1,3));
        setLocationRelativeTo(null);
        
        /**
         * Se utiliza un JOptionPane para ingresar los nombres de los jugadores
         * Estos nombres se guardan en una etiqueta la cual se colocara en la ventana.
         */
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

        /**
         * Se crea una ventana para mostrar los puntajes.
         */
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
        

        /**
         * Se crean los botones con los cuales se escogera el tamaño de la matriz de juego.
         */
        JButton boton1 = new JButton("2x3");
        JButton boton2 = new JButton("3x4");
        JButton boton3 = new JButton("4x4");


        /**
         * Se crean los Action event para cada boton.
         */
        ActionListener event1 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent q) {
                mensaje = ("2x3,6");
                /**
                 * Se crea un socket con el cual se enviara un mensaje con el tamaño escogido.
                 */
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


        /**
         * Se agrega el action listener a cada boton.
         */
        boton1.addActionListener(event1);
        boton2.addActionListener(event2);
        boton3.addActionListener(event3);

        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);

        add(ventana);
        setVisible(true);

        /**
         * Con este socket esperamos a que el cliente nos envie un mensaje para poder continuar.
         */
        try{
            ServerSocket servidor = new ServerSocket(1488);
            Socket serv;

            serv = servidor.accept();
            servidor.close();

        } catch (IOException e){
            e.printStackTrace();
        }

        /**
         * Se crea una instancia de la clase matriz con los valores x, y, elegidos, previamente definidos.
         */
        Matriz mat = new Matriz(x,y,elegidos);
        

        /**
         * Este socket se encarga de recibir las coordenas del boton que se presiono.
         */
        try{
            while (true){
                ServerSocket socket = new ServerSocket(9090);
                Socket main = socket.accept();
                DataInputStream coords= new DataInputStream(main.getInputStream());
                DataOutputStream bot = new DataOutputStream(main.getOutputStream());
                cordenadas = coords.readUTF();
                coordx = cordenadas.charAt(2);
                coordy = cordenadas.charAt(5);
                coordx = Character.getNumericValue(coordx);
                coordy = Character.getNumericValue(coordy);

                /**
                 * Con este if nos damos cuenta de cuantos botones se han presionado, esto para poder
                 * compararlos.
                 */
                if (turno == 0){
                    newcoordx = coordx;
                    newcoordy = coordy;
                    turno++;

                    pos = ((mat.getMatriz())[newcoordx][newcoordy]);   
                    bot.writeUTF(pos);
                   


                }else{
                    /**
                     * Cuando se han presionado dos botones se comparan las imagenes que contengan estos y en caso de ser iguales
                     * se suma un punto al jugador que se encuentre jugando en ese momento, caso contrario se cambia de jugador y se
                     * voltean las cartas.
                     */
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
                            JOptionPane.showMessageDialog(null, "Turno de "+n2);
                            name = n2;
                        }else{
                            JOptionPane.showMessageDialog(null, "Turno de "+n1);
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

                    }
                    turno = 0;
                }
                socket.close();

            }

        } catch (Exception e){

        }
    }
            

}