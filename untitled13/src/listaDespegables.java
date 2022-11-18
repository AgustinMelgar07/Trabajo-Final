import javax.swing.*;
import java.awt.*;

public class listaDespegables extends  JFrame{
    JPanel panel =new JPanel();

    public  listaDespegables(){
        setSize(500,500);//establecemos el tamaño
        // setLocation(550,200);//estableces la posicion
        // setBounds(300,200,500,500);//establece la poscion y el tamaño de la ventana
        setTitle("Nombres");//el titulo de la ventana
        setLocationRelativeTo(null);//establecemos la pantalla en el centro
        setMinimumSize(new Dimension(200,200));//establece el tamaño minimo
        setVisible(true);
        iniciarcomponentes2();
        setDefaultCloseOperation(EXIT_ON_CLOSE);//al cerrar la venta se cierra el programa

    }
    public   void iniciarcomponentes2(){
        colocarPaneles2();
        colocarListasDespegables();

    }
    public  void colocarPaneles2(){
        panel = new JPanel();
        panel.setLayout(null);//elimina la ubicacion por defecto de los elementos del poanel
        this.getContentPane().add(panel);

    }

    private   void     colocarListasDespegables(){


            JComboBox listaDespegable = new JComboBox();
            listaDespegable.setBounds(45,32,100,30);


            panel.add(listaDespegable);

        }



}
