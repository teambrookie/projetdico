import javax.swing.*;
import java.awt.Image;
import java.io.*;

public class Fenetre extends JFrame{
	
	public Fenetre(){
		setVisible(true);
		
		JTabbedPane onglet = new JTabbedPane();
		JTabbedPane ongletTraduire = new JTabbedPane();
		onglet.addTab("Accueil",new OngletAccueil());
		onglet.addTab("Traduction",ongletTraduire);
		ongletTraduire.addTab("Francais --> Anglais",new JButton(""));
		ongletTraduire.addTab("Anglais --> Francais",new JButton(""));
		onglet.addTab("Import/Export",new OngletImportExport());
		onglet.addTab("Ajouter/Supprimer",new OngletAjoutSupprimer());
		onglet.addTab("Index",new JButton(""));
		this.setContentPane(onglet);
		this.pack();
		setLocationRelativeTo(null);
		
	}
	
	public static void main (String[]args) throws IOException{
		new Fenetre();
	}
}
