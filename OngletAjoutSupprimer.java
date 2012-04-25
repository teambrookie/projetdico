import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;


public class OngletAjoutSupprimer extends JPanel{
	
	public OngletAjoutSupprimer(){
		
		this.setLayout(new FlowLayout());		
		JTextField tf1 = new JTextField(5); 
		JButton but1 = new JButton("button 1");
		this.add(but1);
		this.add(tf1);
	}
}

