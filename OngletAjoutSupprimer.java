import javax.swing.*;
import java.awt.*;


public class OngletAjoutSupprimer extends JPanel{
	
	public OngletAjoutSupprimer(){
		
		this.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("Ajouter vos entrées ici");	
		JTextField tff = new JTextField(15); 
		JTextField tfe = new JTextField(15); 
		JButton but1 = new JButton("Valider");
		this.add(label1);
		this.add(tff);
		this.add(tfe);
		this.add(but1);
		
	}
}

