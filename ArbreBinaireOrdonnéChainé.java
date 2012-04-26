public class ArbreBinaireOrdonnéChainé<E> implements ArbreBinaireOrdonné<E> {
	
	protected ArbreBinaire<E> abr ;

	
	public ArbreBinaireOrdonnéChainé(){
		abr=ArbreBinaireChainé.arbreBinaireVide;
	}
	
	public ArbreBinaire<E> abr(){
		return abr;
	}	
	
/*
    //Version récursive
	public void ajouterEnFeuille(E e){
		try{
			abr=ajouterEnFeuille(abr,e);
		}
		catch(ArbreBinaireVideException ex){}
	}
	// méthode récursive
	private ArbreBinaire<E> ajouterEnFeuille(ArbreBinaire<E> abr , E e) throws ArbreBinaireVideException{
		
		if(abr.estVide()){
			return new ArbreBinaireChainé<E>(e);
		}
		// si e <= abr.valeur() => ajouterEnFeuille  e dans le sag
		if(((Comparable)e).compareTo(abr.valeur())<= 0){
			abr.changerSag(ajouterEnFeuille(abr.sag(),e));
		}
		// sinon ajouterEnFeuille e dans le sad
		else {
			abr.changerSad(ajouterEnFeuille(abr.sad(),e));
		}
		
		return abr;
	}
*/

	public void ajouterEnFeuille(E e) throws ArbreBinaireVideException{
		ArbreBinaire<E> p , q;
		p=abr;
		q=null;
		while(!p.estVide()){
			q=p;
			if(((Comparable)e).compareTo(p.valeur()) <= 0){
				p=p.sag();
			}
			else {
				p=p.sad();
			}
		}
		//si q != null alors q désigne le noeud où ajouter la feuille
		//sinon il faut modifier l'arbre car il est vide
		p = new ArbreBinaireChainé<E>(e);
		if(q==null){
			abr=p;
		}
		else{
			if(((Comparable)e).compareTo(q.valeur()) <= 0 ){
				q.changerSag(p);
			}
			else{
				q.changerSad(p);
			}
			
		}
	}
	
/*
	public E rechercher(E e) throws ArbreBinaireVideException{
		ArbreBinaire<E> p=abr;
		while(!p.estVide()){
			if(((Comparable)e).compareTo(p.valeur()) == 0){
				return p.valeur();
			}
			else if(((Comparable)e).compareTo(p.valeur()) < 0){
				p=p.sag();
			}
			else {
				p=p.sad();
			}
		}
		return null;
	}
*/
	
	
	public String toString(){
		return abr.toString();
	}
	
	// Just for fun 
	public ArbreBinaire<E> ajouter( E e) throws ArbreBinaireVideException{
		ArbreBinaire<E> p,q;
		p=this.abr;
		q=null;
		while(!p.estVide()){
			q=p;
			if(((Comparable)e).compareTo(p.valeur()) == 0){
				// on a trouvé la valeur
				return p;
			}
			else if(((Comparable)e).compareTo(p.valeur()) < 0){
				p=p.sag();
			}
			else {
				p=p.sad();
			}
		}
		p= new ArbreBinaireChainé<E>(e);
		if(q==null){
			// l'arbre est vide
			abr=p;
		}
		else if(((Comparable)e).compareTo(q.valeur()) < 0){
			q.changerSag(p);
		}
		else {
			q.changerSad(p);
		}
		return p;
	}
			
		
	
	
/*
	public static void main(String args[]) throws ArbreBinaireVideException{
		ArbreBinaireOrdonnéChainé<Integer> a = new ArbreBinaireOrdonnéChainé<Integer>();
		a.ajouterEnFeuille(89);
		a.ajouterEnFeuille(99);
		a.ajouterEnFeuille(12);
		a.afficher();

		

	}
*/
	
}
