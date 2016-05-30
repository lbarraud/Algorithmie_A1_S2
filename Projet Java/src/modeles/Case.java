package modeles;

public class Case {
	// Coordonn�es de la case
	private int abscisse;
	private int ordonn�e;
	
	// Qui controle la case (�gal � 0 si non control�e)
	private int controleePar = 0;
	
	// Couleur de la case
	private Couleur couleur = Couleur.randomCouleur();
	
	// Constructeur de la classe
	public Case(int _abscisse,int _ordonn�e){
		this.setAbscisse(_abscisse);
		this.setOrdonn�e(_ordonn�e);
	}
	
	public int getControleePar() {
		return controleePar;
	}
	
	public void setControleePar(int numJoueur) {
		if (numJoueur>0 && numJoueur<5){
			this.controleePar = numJoueur;
		}
		else System.out.println("Erreur : numJoueur controlant la case hors de port�e.");
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

	public int getOrdonn�e() {
		return ordonn�e;
	}

	public void setOrdonn�e(int ordonn�e) {
		this.ordonn�e = ordonn�e;
	}
}
