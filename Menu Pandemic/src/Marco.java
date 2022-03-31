import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Marco extends JFrame {
	PanelPrincipal lamina1;
	Dimension screenSize;
	Marco(){
		//setBounds(600,200,500,800); // donde va a salir y que tamaño va a tener.
		screenSize=Toolkit.getDefaultToolkit().getScreenSize();//poner la pantalla al maximo
		setSize(screenSize);//poner la pantalla al maximo
		setResizable(false);//No poder modificar el tamaño (false)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fin del programa al pulsar la X de cerrar.
		setTitle("Pandemic"); //titulo del marco.
		lamina1= new PanelPrincipal();
		add(lamina1);
		setVisible(true); //que salga el marco (true).
	}
}
