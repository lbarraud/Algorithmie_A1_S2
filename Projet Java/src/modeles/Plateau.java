package modeles;

public class Plateau implements Cloneable{
	// Etat actuel du plateau
	private Case[][] grille;
	
	public Plateau() {
		this.grille = new Case[13][13];
		for (int i=0; i<13; i++) {
			for (int j=0; j<13; j++) {
				this.grille[i][j] = new Case(i,j);
			}
		}
	}
	
	// Modifier
	public void modifierCase(int abscisse, int ordonnee, Case _case){
	    this.grille[ordonnee][abscisse] = _case;
	  }
	
	// Méthodes get
	public Case[][] getPlateau() {
		return this.grille;
	  }
	
	public Case getCase(int i, int j) {
		return this.grille[i][j];
	  }
	
	// Fonction qui vérifie si il reste des cases non contrôlées
	public Boolean pasDeCasesLibres() {
		Boolean pasDeCasesLibres = true;
		for (int i=0; i<13; i++) {
			for (int j=0; j<13; j++) {
				if (this.grille[i][j].getControleePar() == 0) {
					pasDeCasesLibres = false;
					return pasDeCasesLibres;
				}
			}
		}
		return pasDeCasesLibres;
	}
	
	// Retourne une copie du plateau
	public Object clone()
    {
        Plateau p = null;
        try 
        { p = (Plateau) super.clone(); } 
            catch(CloneNotSupportedException e) 
            { System.err.println("Plateau impossible à cloner..."); }
        return p;
    }
	
	


}
