

public class Mot implements Comparable<Mot> {
	protected String motFr ;
	protected String motEn ;
	
	public Mot(){
		this.motFr="";
		this.motEn="";
	}
	
	public Mot(String motFr , String motEn){
		this.motFr = motFr ;
		this.motEn = motEn ;
	}
	
	public void changerMotFr(String motFr){
		this.motFr = motFr ;
	}
	
	public void changerMotEn(String motEn){
		this.motEn = motEn ;
	}
	
	public String afficheMotFr(){
		return motFr;
	}
	
	public String afficheMotEn(){
		return motEn;
	}
	
	public int compareTo(Mot m){
			return motFr.compareToIgnoreCase(m.afficheMotFr());
	}
	
	
	public String afficher(){
		
		return "[ Terme : "+motFr+"| Traduction : "+motEn+" ]\n";
		
		
	}
	
	public String toString(){
		
		return motFr+";"+motEn+"\n";
	}

}
