package modeles;

public class Case {
	// Coordonnées de la case
	private int abscisse;
	private int ordonnée;
	
	// Qui controle la case (égal à 0 si non controlée)
	private int controleePar = 0;
	
	// Couleur de la case
	private Couleur couleur = Couleur.randomCouleur();
	
	// Constructeur de la classe
	public Case(int _abscisse,int _ordonnée){
		this.setAbscisse(_abscisse);
		this.setOrdonnée(_ordonnée);
	}
	
	public int getControleePar() {
		return controleePar;
	}
	
	public void setControleePar(int numJoueur) {
		if (numJoueur>0 && numJoueur<5){
			this.controleePar = numJoueur;
		}
		else System.out.println("Erreur : numJoueur controlant la case hors de portée.");
	}
	
	public Couleur getCouleurCase() {
		return couleur;
	}
	
	public void setCouleurCase(Couleur _couleur) {
		this.couleur = _couleur;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnée() {
		return ordonnée;
	}

	public void setOrdonnée(int ordonnée) {
		this.ordonnée = ordonnée;
	}
}
