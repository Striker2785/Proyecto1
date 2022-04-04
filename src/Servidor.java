import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
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

    String mensaje;
    DataOutputStream salida;
    try{

        Socket server = new Socket("127.0.0.1", 8080);
        salida = new DataOutputStream(server.getOutputStream());
        while(true){ 

            salida = new DataOutputStream(server.getOutputStream());
                
         }
                

            
    } catch (IOException e){
        e.printStackTrace();

    }
    
    public Marco(){

        setBounds(700,700,700,700);
        JPanel ventana = new JPanel();
        ventana.setLayout(new BorderLayout());
        ventana.setLayout(new GridLayout(1,3));
        setLocationRelativeTo(null);
        
        JButton boton1 = new JButton("2x3");
        JButton boton2 = new JButton("4x4");
        JButton boton3 = new JButton("5x4");

        ActionListener event1 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                mensaje = ("2x3");
                salida.writeUTF(mensaje);
            }

        };

        ActionListener event2 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                mensaje = ("4x4");
               
  
            }

        };

        ActionListener event3 = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                mensaje = ("5x4");
                
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
    }
            

}