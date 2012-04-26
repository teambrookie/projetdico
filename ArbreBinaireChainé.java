

public class ArbreBinaireChainé<N> implements ArbreBinaire<N> {
	
	public static final ArbreBinaire arbreBinaireVide = new ArbreBinaireChainé();
	protected N val;
	protected ArbreBinaire<N> sag ;
	protected ArbreBinaire<N> sad ;
	
	private ArbreBinaireChainé(){
		val=null;
		sag=sad=null;
	}
	
	public ArbreBinaireChainé(N e , ArbreBinaire<N> g , ArbreBinaire<N> d ) {
		val = e;
		sag = g==null?arbreBinaireVide:g;
		sad = d==null?arbreBinaireVide:d;
	}
	
	public ArbreBinaireChainé(N e){
		val=e;
		sag=sad = arbreBinaireVide ;
	}
	
	public boolean estVide(){
		return this==arbreBinaireVide;
	}
	
	public N valeur() throws ArbreBinaireVideException{
		if(estVide()){ throw new ArbreBinaireVideException();}
		return val;
	}
	
	public ArbreBinaire<N> sag() throws ArbreBinaireVideException {
		if(estVide()){ throw new ArbreBinaireVideException();}
		return sag;
	}
	
	public ArbreBinaire<N> sad() throws ArbreBinaireVideException {
		if(estVide()){ throw new ArbreBinaireVideException();}
		return sad;
	}
	
	public void changerSag(ArbreBinaire<N> a){
		this.sag=a;
	}
	
	public void changerSad(ArbreBinaire<N> a){
		this.sad=a;
	}
	
	public void écrireArbre() throws ArbreBinaireVideException{
		
		écrireArbre(this,"");
		
	} 
	
	private void écrireArbre(ArbreBinaire<N> a,String d) throws ArbreBinaireVideException{
		String offset = "   ";
		if(!a.estVide()){
			écrireArbre(a.sad(),d+offset);
			System.out.println(d+a.valeur());
			écrireArbre(a.sag(),d+offset);
		}
	}
	
	
	public int hauteur() throws ArbreBinaireVideException{
		if(estVide()){ throw new ArbreBinaireVideException();}
		else{ return hauteur(this)-1;}
		
	}
	
	private int hauteur(ArbreBinaire<N> a) throws ArbreBinaireVideException{
		return a.estVide()?0:Math.max(hauteur(a.sag()),hauteur(a.sad()))+1;
		
	}
	
	public boolean miroir(ArbreBinaire<N> a) throws ArbreBinaireVideException{
		if(estVide()) throw new ArbreBinaireVideException();
		return miroir(this,a);
	}

	private boolean miroir(ArbreBinaire<N> a, ArbreBinaire<N> b) throws ArbreBinaireVideException{
		if(a.estVide() && b.estVide()) return true;
		if(a.estVide() || b.estVide()) return false;
		if(a.valeur() == b.valeur()){
			return miroir(a.sag(),b.sad()) && miroir(a.sad(),b.sag());		
		}
		else return false;
	}
	
	
	
	public String toString(){
		if(this==arbreBinaireVide){
			return "";
		}
		else {
			return sag.toString()+val+sad.toString();
		}
	}
	
	
	public ArbreBinaire<N> créerMiroir(){
		return estVide()?this: new ArbreBinaireChainé(val,sad.créerMiroir(),sag.créerMiroir());
	}
	
	
}
