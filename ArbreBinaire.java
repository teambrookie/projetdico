public interface ArbreBinaire<N> {
	public boolean estVide() ;
	public ArbreBinaire<N> sag() throws ArbreBinaireVideException ;
	public ArbreBinaire<N> sad() throws ArbreBinaireVideException ;
	public N valeur() throws ArbreBinaireVideException ;
	public int hauteur() throws ArbreBinaireVideException;
	public void écrireArbre() throws ArbreBinaireVideException;
	public boolean miroir(ArbreBinaire<N> abr) throws ArbreBinaireVideException;
	public ArbreBinaire<N> créerMiroir();
	public void changerSad(ArbreBinaire<N> a);
	public void changerSag(ArbreBinaire<N> a);
}
