import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Ficha {
    private int i = 0;
    private int j = 0;
    public JButton boto;
    String coords, bot;
    DataOutputStream exit;
    DataInputStream intro;
    ImageIcon img;

    public Ficha(int i, int j){
        this.i=i;
        this.j=j;
        boto = new JButton();

        ActionListener evento = new ActionListener(){

            public void actionPerformed(ActionEvent q){
                try{
                    coords = ("I:"+ i +"J:" + j);
                    Socket envio = new Socket("127.0.0.1", 9090);
                    intro = new DataInputStream(envio.getInputStream());
                    exit = new DataOutputStream(envio.getOutputStream());
                    exit.writeUTF(coords);
                    bot = intro.readUTF();
                    img = new ImageIcon(bot);
                    boto.setIcon(new ImageIcon(img.getImage().getScaledInstance(boto.getWidth(), boto.getHeight(), Image.SCALE_SMOOTH)));
                    envio.close();
                   
                
                } catch (IOException e){
                    e.printStackTrace();
                }
            

            }

        };
        boto.addActionListener(evento);
    }
}
