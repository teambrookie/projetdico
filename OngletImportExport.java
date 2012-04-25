import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class OngletImportExport extends JPanel implements ActionListener{
	PrintWriter sortie;
	File fichier;
	
	public OngletImportExport(){
		
		JButton but1 = new JButton("Choisir");
		this.add(but1);
		but1.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		JFileChooser dialog = new JFileChooser(".");
		try{
			takeFile(dialog);
		}
		catch(IOException e){}	
	}
	
	public void takeFile(JFileChooser dial) throws IOException{
		if(dial.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			fichier = dial.getSelectedFile();
			sortie = new PrintWriter(new FileWriter(fichier.getPath(),true));
			System.out.println("DOOONE !!!");
			sortie.close();
		}
		else{
			System.out.println("ARF !");
		}
	}
		
}

