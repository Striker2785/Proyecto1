import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Juego{

    private JFrame frame;


    public Juego(){
        
        Icon icon1 = new ImageIcon("E:\\Back.png");
        

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(5,1));

        frame.add(new JButton(icon1));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));

        frame.setTitle("Memoria");
        frame.pack();
        frame.setVisible(true);
        

        
    }
    
    public static void  main(String[] args){

        new Juego();
    }
}
