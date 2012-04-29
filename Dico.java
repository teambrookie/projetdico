import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Dico {
	
	protected ArbreBinaireOrdonneChaine<Mot> arbreDico = new ArbreBinaireOrdonneChaine<Mot>();
	
	public Dico(){
		try{
			enrichirDico("dictionnaires/default.dico");
		}
		catch(FileNotFoundException e1){
			System.err.println("Le dictionnaire par defaut semble introuvable");
			System.exit(1);
		}
		catch(IOException e2){
			System.err.println("Le dictionnaire par defaut semble corrompu");
			System.exit(1);
		}
		catch(ArbreBinaireVideException e3){
			e3.printStackTrace();
			System.exit(1);
		}
	}
	
	public Dico(String filename)throws FileNotFoundException,IOException,ArbreBinaireVideException{
		enrichirDico(filename);
	}
		
	
	public void enrichirDico(String filename) throws FileNotFoundException,IOException,ArbreBinaireVideException{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while(in.ready()){
				String[] motsLigne = in.readLine().split(";");
				arbreDico.ajouter(new Mot(motsLigne[0],motsLigne[1]));
				
			}
		
	}
	
	public void sauvegarderDico(String filename) throws FileNotFoundException,ArbreBinaireVideException{
		PrintWriter fichier = new PrintWriter(new FileOutputStream(new File(filename)));
		fichier.print(arbreDico.toString());
		fichier.flush();
		fichier.close();
		
		
		
		
	}
	
	public String rechercheExacte(String terme) throws ArbreBinaireVideException,RechercheInfructueuseException{
		ArbreBinaire<Mot> p=arbreDico.abr();
		Mot e = new Mot(terme,"");
		while(!p.estVide()){
			if(((Comparable)e).compareTo(p.valeur()) == 0){
				return p.valeur().afficheMotFr()+";"+p.valeur().afficheMotEn();
			}
			else if(((Comparable)e).compareTo(p.valeur()) < 0){
				p=p.sag();
			}
			else {
				p=p.sad();
			}
		}
		throw new RechercheInfructueuseException();
	
		
	}
	
	public String rechercheRegExp(String regexp) throws ArbreBinaireVideException,RechercheInfructueuseException{
		Pattern pattern = Pattern.compile(regexp);
		ArbreBinaire<Mot> p = arbreDico.abr();
		return rechercheRegExp(pattern,p);
		
	}
	
	private String rechercheRegExp(Pattern pattern , ArbreBinaire<Mot> p) throws ArbreBinaireVideException{
		String resultat = "";
		if(!p.estVide()){
			Matcher m = pattern.matcher(p.valeur().afficheMotFr());
			
			resultat += rechercheRegExp(pattern,p.sag());
			resultat += m.matches()?p.valeur().afficher():"";
			resultat += rechercheRegExp(pattern,p.sad());
		}
		return resultat;
	}	
		
	
	public void ajouterMot(String motFr , String motEn) throws ArbreBinaireVideException{
		arbreDico.ajouter(new Mot(motFr,motEn));
	}
	
	
	public void modifierTraduction(String terme,String traduction) throws ArbreBinaireVideException, RechercheInfructueuseException{
		Mot m = new Mot(terme,traduction);
		ArbreBinaire<Mot> res = arbreDico.ajouter(m);
		res.valeur().changerMotEn(newTraduction);
	}
	
	public String toString(){
		return arbreDico.toString();
	}
	
	
	public static void main(String[] args)throws FileNotFoundException,IOException,ArbreBinaireVideException,RechercheInfructueuseException{
		Dico d = new Dico();
		d.ajouterMot("Libre","free");
		d.modifierTraduction("Libre","craquotte");
		System.out.println(d);
	}
	
}


