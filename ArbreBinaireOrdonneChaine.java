public class ArbreBinaireOrdonneChaine<E> implements ArbreBinaireOrdonne<E> {
	
	protected ArbreBinaire<E> abr ;

	
	public ArbreBinaireOrdonneChaine(){
		abr=ArbreBinaireChaine.arbreBinaireVide;
	}
	
	public ArbreBinaire<E> abr(){
		return abr;
	}	
	

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
		p = new ArbreBinaireChaine<E>(e);
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
		p= new ArbreBinaireChaine<E>(e);
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
			
	
}
