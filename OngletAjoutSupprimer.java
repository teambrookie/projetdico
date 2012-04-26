import javax.swing.*;
import java.awt.*;


public class OngletAjoutSupprimer extends JPanel{
	
	// On déclare nos variables
	JPanel panelAjout, panelSuppression;
	JLabel drapeauFR , drapeauEN , introAjout , introSuppression , loupe;
	JTextField tfFR , tfEN , tfSearch;
	JButton valider , reset;
	
	public OngletAjoutSupprimer(){
		
		
		/**####################################################
		 * #          										  #
		 * #		PARTIE AJOUT D'UN NOUVEAU MOT			  #
		 * #												  #
		 * ####################################################
		 **/
		 
		// On instancie nos variables
		panelAjout = new JPanel();
		
		drapeauFR = new JLabel( new ImageIcon("france.png"));
		drapeauEN = new JLabel( new ImageIcon("ru.png"));
		introAjout = new JLabel("Ajouter vos entrées ici");
			
		tfFR = new JTextField(15); 
		tfEN = new JTextField(15); 
		
		valider = new JButton("Valider");
		reset = new JButton("Effacer");
		
		// On défini nos différents Layouts
		
		this.setLayout(new GridLayout(4,1,10,10));
		panelAjout.setLayout(new GridLayout(2,2,5,5));
		
		// On ajoute nos composants à leur Jpanel respectif
		
		panelAjout.add(drapeauFR);
		panelAjout.add(tfFR);
		panelAjout.add(drapeauEN);
		panelAjout.add(tfEN);
		
		this.add(introAjout);
		this.add(panelAjout);	
		
		/**####################################################
		 * #          										  #
		 * #		  PARTIE SUPPRESSION D'UN MOT			  #
		 * #												  #
		 * ####################################################
		 **/	
		 
		 // On instancie nos variables
		 
		 panelSuppression = new JPanel();
		 
		 loupe = new JLabel( new ImageIcon("loupe.png"));
		 introSuppression = new JLabel("Recherchez le mot à supprimer");
		 
		 tfSearch = new JTextField(15);
		 
		 // On défini le layout
		 
		 panelSuppression.setLayout(new GridLayout(2,2,5,5));
		 
		 // On ajoute nos composants à leur Jpanel respectif
		 
		 panelSuppression.add(loupe);
		 panelSuppression.add(tfSearch);
		 panelSuppression.add(valider);
		 panelSuppression.add(reset);
		 
		 this.add(introSuppression);
		 this.add(panelSuppression);
		 
		 
		 
		 
		
		
	}
}

