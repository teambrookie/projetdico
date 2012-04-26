import java.io.*;

public class Dico {
	
	protected ArbreBinaireOrdonneChaine<Mot> arbreDico = new ArbreBinaireOrdonneChaine<Mot>();
	
	public Dico(){
		try{
			BufferedReader in = new BufferedReader(new FileReader("dictionnaires/default.dico"));
			while(in.ready()){
				String[] motsLigne = in.readLine().split(";");
				arbreDico.ajouter(new Mot(motsLigne[0],motsLigne[1]));
				
			}
			
		}
		
		catch(FileNotFoundException e1){
			System.err.println("Le dictionnaire spécifié n'existe pas");
			System.exit(1);
		}
		catch(IOException e2){
			System.err.println("Erreur pendant la lecture du dictionnaire");
			System.exit(2);
		}
		catch(ArbreBinaireVideException e3){
			System.err.println("L'arbre est vide !");
			System.exit(3);
		}
		
		
	}
	
	public String toString(){
		return arbreDico.toString();
	}
	
	public static void main(String[] args){
		Dico d = new Dico();
		System.out.println(d);
	}
	
}


