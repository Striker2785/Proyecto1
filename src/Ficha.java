/**
 * Se importan las librerias a utilizar
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Se crea la clase ficha y se definen las variables a utilizar.
 */
public class Ficha {

    private int i = 0;
    private int j = 0;
    public JButton boto;
    String coords, bot;
    DataOutputStream exit;
    DataInputStream intro;
    ImageIcon img;

    /**
     * Se crea el constructor ficha el cual se encargara de crear los botones de juego.
     * @param i
     * @param j
     */
    public Ficha(int i, int j){
        this.i=i;
        this.j=j;
        boto = new JButton();
        /**
         * Se crea el actionListener para los botones.
         */
        ActionListener evento = new ActionListener(){

            public void actionPerformed(ActionEvent q){
                /**
                 * Este socket envia las coordenadas al servidor para asi saber que imagen le corresponde
                 * luego se le asigna dicha imagen al boton.
                 */
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
