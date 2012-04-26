import javax.swing.*;
import java.awt.*;

public class OngletAccueil extends JPanel{
	
	JLabel image , presentation;
	
	public OngletAccueil(){
		
		image = new JLabel(new ImageIcon("img/dictionnaire.png"));
		presentation = new JLabel("Bienvenue sur le programme de traduction gnagngagna...");
		
		this.setLayout(new FlowLayout());
		
		this.add(image);
		this.add(presentation);
	}
	
	
	
	
}
