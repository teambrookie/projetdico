import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class OngletImportExport extends JPanel implements ActionListener{
	PrintWriter sortie;
	File fichier;
	String nomFichier;
	JButton but1;
	JLabel lab1;
	
	public OngletImportExport(){
		
		but1 = new JButton("Choisir");
		lab1 = new JLabel("Pas de fichier choisi");
		this.add(but1);
		this.add(lab1);
		but1.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		JFileChooser dialog = new JFileChooser(".");
		try{
			takeFile(dialog);
			lab1.setText(nomFichier);
		}
		catch(IOException e){}	
	}
	
	public void takeFile(JFileChooser dial) throws IOException{
		FileFilter txt = new FiltreTXT();
		dial.addChoosableFileFilter(txt);
		if(dial.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			fichier = dial.getSelectedFile();
			sortie = new PrintWriter(new FileWriter(fichier.getPath(),true));
			System.out.println("DOOONE !!!");
			nomFichier = dial.getName(fichier);
			sortie.close();
		}
		else{
			System.out.println("ARF !");
		}
	}
		
}

