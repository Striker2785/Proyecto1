import javax.swing.JButton;
import java.awt.event.*;

public class Ficha {
    private int i = 0;
    private int j = 0;
    public JButton boton;

    public Ficha(int i, int j){
        this.i=i;
        this.j=j;
        boton = new JButton();

        ActionListener evento = new ActionListener(){

            public void actionPerformed(ActionEvent e){
                System.out.println("Eduardo Gorrazo");


            }

        };
        boton.addActionListener(evento);
    }
}
