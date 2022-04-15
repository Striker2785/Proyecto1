import javax.swing.JButton;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Ficha {
    private int i = 0;
    private int j = 0;
    public JButton boton;
    private String coords;
    DataOutputStream exit;

    public Ficha(int i, int j){
        this.i=i;
        this.j=j;
        boton = new JButton();

        ActionListener evento = new ActionListener(){

            public void actionPerformed(ActionEvent q){
                try{
                    coords = ("I:"+ i +"J:" + j);
                    Socket envio = new Socket("127.0.0.1", 9090);
                    exit = new DataOutputStream(envio.getOutputStream());
                    exit.writeUTF(coords);

                    envio.close();
                } catch (IOException e){
                    e.printStackTrace();
                }

                
            }

        };
        boton.addActionListener(evento);
    }
}
