import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.io.*;

public class Fenetre extends JFrame{
	
	public Fenetre(){
		setVisible(true);
		setSize(450,450);
		setLocationRelativeTo(null);
		JTabbedPane onglet = new JTabbedPane();
		onglet.addTab("Accueil",new JButton(""));
		onglet.addTab("Traduction",new JButton(""));
		onglet.addTab("Import/Export",new OngletImportExport());
		onglet.addTab("Ajouter/Supprimer",new OngletAjoutSupprimer());
		onglet.addTab("Index",new JButton(""));
		this.setContentPane(onglet);
		
	}
	
	public static void main (String[]args) throws IOException{
		new Fenetre();
	}
}
