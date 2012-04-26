

public class Mot implements Comparable<Mot> {
	protected String motFr ;
	protected String motEn ;
	protected boolean modeFrToEn;
	
	public Mot(String motFr , String motEn){
		this.motFr = motFr ;
		this.motEn = motEn ;
		modeFrToEn = true;
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
		if(modeFrToEn){
			return motFr.compareToIgnoreCase(m.afficheMotFr());
		}
		else{
			return motEn.compareToIgnoreCase(m.afficheMotEn());
		}
	}
	
	public String toString(){
		if(modeFrToEn){
			return "[ Fr : "+motFr+"| En : "+motEn+" ]";
		}
		else{
			return "[ En : "+motEn+"| Fr : "+motFr+" ]";
		}
		
	}

}
