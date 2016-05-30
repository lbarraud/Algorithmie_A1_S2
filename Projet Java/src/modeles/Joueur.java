package modeles;

import modeles.Couleur;

public class Joueur {
	// Définit si il s'agit d'un bot ou d'un joueur
	private Boolean isRandomIA = false;
	
	// Initialise le compte du nombre de cases controlees
	private int nbCasesControlees = 0;
	
	// Couleur du joueur
	private Couleur couleur;
	private int numJoueur;
	
	public Joueur(int _numJoueur, Couleur _couleur) {
		this.numJoueur = _numJoueur;
	    this.couleur = _couleur;
	  }
	
	public int getNbCasesControlees() {
	    return nbCasesControlees;
	  }

	  public void setNbCasesControlees(int nbCasesControlees) {
	    this.nbCasesControlees = nbCasesControlees;
	  }
	  
	  public void ajoutCaseControlee() {
		  this.nbCasesControlees++;
	  }
	  
	  public int getNumJoueur() {
		return numJoueur;
	  }

	  public void setNumJoueur(int _numJoueur) {
		this.numJoueur = _numJoueur;
	  }
	  
	  public String getPlayerName(){
		  if (this.numJoueur == 1) return "Joueur 1";
		  else if (this.numJoueur == 2) return "Joueur 2";
		  else if (this.numJoueur == 3) return "Joueur 3";
		  else if (this.numJoueur == 4) return "Joueur 4";
		  else return "Joueur #?";
	  }
	  
	  public Couleur getCouleurJoueur() {
	    return couleur;
	  }
	  
	  public void setCouleurJoueur(Couleur _couleur) {
		    this.couleur = _couleur;
		  }

	public Boolean getIsRandomIA() {
		return isRandomIA;
	}

	public void setIsRandomIA(Boolean _isRandomIA) {
		this.isRandomIA = _isRandomIA;
	}
}