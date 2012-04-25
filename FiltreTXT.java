import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.*;

public class FiltreTXT extends FileFilter{
	
	private String extension,desciption;
	
	public FiltreTXT(){
		
		this.desciption = "Fichier texte";
		this.extension = "txt";
	}
	
	public boolean accept(File file){
		if(file.isDirectory()){
			return true;
		}
		
		String nomFichier = file.getName().toLowerCase();
		
		return nomFichier.endsWith(extension);
	}
	
	public String getDescription(){
		return desciption;
	}
}
