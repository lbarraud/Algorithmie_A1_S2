package moteur;

import main.Scanneur;
import modeles.Plateau;
import vue.AffichageConsole;
import vue.AffichageGraphique;
import modeles.Couleur;
import modeles.Joueur;

public class Moteur {
	// Liste des joueurs
	private Joueur joueur1;
	private Joueur joueur2;	
	private Joueur joueur3;
	private Joueur joueur4;
	private int nbJoueurs;
	private Boolean withIA;
	
	private Boolean affGraph;
	
	// Le plateau de jeu
	private Plateau plateau = new Plateau();
	
	// Constructeur de la classe
	public Moteur() {
	  init(this.plateau);
	}
	
	// Initialisation
	private void init(Plateau plateau) {
		// Choix type affichage
		while ((true)) {
			System.out.println("Voulez-vous avoir un affichage graphique du plateau de jeu ? (o/n) :");
			String stringChoix = Scanneur.scan.nextLine();
			System.out.println("");
			if (stringChoix.equalsIgnoreCase("o")) {
				System.out.println("La grille de jeu s'affichera graphiquement.");
				System.out.println("");
				this.affGraph = true;
				break;
			}
			else if (stringChoix.equalsIgnoreCase("n")) {
				System.out.println("La grille de jeu s'affichera en console.");
				System.out.println("");
				this.affGraph = false;
				break;
			}
		}
		
		// Choix IA on/off
		while ((true)) {
			System.out.println("Voulez-vous jouer avec des IA ? (o/n) :");
			String stringChoix = Scanneur.scan.nextLine();
			System.out.println("");
			if (stringChoix.equalsIgnoreCase("o")) {
				System.out.println("Les IA sont activées.");
				System.out.println("");
				this.withIA = true;
				break;
			}
			else if (stringChoix.equalsIgnoreCase("n")) {
				System.out.println("Les IA sont désactivés.");
				System.out.println("");
				this.withIA = false;
				break;
			}
		}
		
		// Gestion du nombre de joueurs
		this.nbJoueurs = 0;
		while ((this.nbJoueurs<2 || this.nbJoueurs>4)) {
			System.out.println("Veuillez choisir le nombre de joueurs (2 à 4) :");
			try {
				this.nbJoueurs = Scanneur.scan.nextInt();
				Scanneur.scan.nextLine();
			} catch (java.util.InputMismatchException e){
				System.out.println("");
				System.out.println("Erreur "+e+" ! Veuillez entrer un entier.");
				Scanneur.scan.nextLine();
			}
			System.out.println("");
		}
		
		// Choix des couleurs de départ pour chaque joueur
		Couleur colorInit = null;
		String[] chosenColors = new String[3];
		for (int i=1; i<=this.nbJoueurs; i++){

		while ((colorInit==null)) {
			System.out.println("Joueur "+i+", veuillez choisir votre couleur de départ :");
			System.out.println("rouge (r/R), orange (o/O), jaune (j/J), vert (v/V), bleu (b/B) ou magenta (m/M)");
			String stringInit = Scanneur.scan.nextLine();
			System.out.println("");
			
			// Test du string reçu contre une liste des couleurs déjà choisies par les autres joueurs
			Boolean already_chosen = false;
			for (int e=0; e<3; e++) {
				if (stringInit.equalsIgnoreCase(chosenColors[e])) {
					System.out.println("Cette couleur a déjà été prise par un autre joueur. Veuillez en choisir une autre.");
					System.out.println("");
					already_chosen = true;
					break;
				}
			}
			if (already_chosen == true) {
				continue;
			}
			
			// Comparaison du strings reçu avec les lettres de chaque couleur acceptable
			// et mise en memoire du choix pour empêcher deux joueurs d'avoir la même couleur.
			if (stringInit.equalsIgnoreCase("r")) {
				colorInit = Couleur.ROUGE;
				if (chosenColors[0]==null) {chosenColors[0] = "r";}
				else if (chosenColors[1]==null) {chosenColors[1] = "r";}
				else if (chosenColors[2]==null) {chosenColors[2] = "r";}
			}
			else if (stringInit.equalsIgnoreCase("o")) {
				colorInit = Couleur.ORANGE;
				if (chosenColors[0]==null) {chosenColors[0] = "o";}
				else if (chosenColors[1]==null) {chosenColors[1] = "o";}
				else if (chosenColors[2]==null) {chosenColors[2] = "o";}
			}
			else if (stringInit.equalsIgnoreCase("j")) {
				colorInit = Couleur.JAUNE;
				if (chosenColors[0]==null) {chosenColors[0] = "j";}
				else if (chosenColors[1]==null) {chosenColors[1] = "j";}
				else if (chosenColors[2]==null) {chosenColors[2] = "j";}
			}
			else if (stringInit.equalsIgnoreCase("v")) {
				colorInit = Couleur.VERT;
				if (chosenColors[0]==null) {chosenColors[0] = "v";}
				else if (chosenColors[1]==null) {chosenColors[1] = "v";}
				else if (chosenColors[2]==null) {chosenColors[2] = "v";}
			}
			else if (stringInit.equalsIgnoreCase("b")) {
				colorInit = Couleur.BLEU;
				if (chosenColors[0]==null) {chosenColors[0] = "b";}
				else if (chosenColors[1]==null) {chosenColors[1] = "b";}
				else if (chosenColors[2]==null) {chosenColors[2] = "b";}
			}
			else if (stringInit.equalsIgnoreCase("m")) {
				colorInit = Couleur.MAGENTA;
				if (chosenColors[0]==null) {chosenColors[0] = "m";}
				else if (chosenColors[1]==null) {chosenColors[1] = "m";}
				else if (chosenColors[2]==null) {chosenColors[2] = "m";}
			}
		}
		
		// Création des instances Joueurs et réécriture de leurs cases initiales dans les coins
		if (i==1) {
			this.joueur1 = new Joueur(1,colorInit);
			this.plateau.getCase(0,0).setControleePar(1);
			this.plateau.getCase(0,0).setCouleurCase(colorInit);
			joueur1.ajoutCaseControlee();
			if (withIA) {
				while ((true)) {
					System.out.println("Voulez-vous faire du joueur "+i+" une IA aléatoire ? (o/n) :");
					String stringChoix = Scanneur.scan.nextLine();
					System.out.println("");
					if (stringChoix.equalsIgnoreCase("o")) {
						System.out.println("Le joueur "+i+" sera une IA aléatoire.");
						System.out.println("");
						this.joueur1.setIsRandomIA(true);
						break;
					}
					else if (stringChoix.equalsIgnoreCase("n")) {
						System.out.println("Le joueur "+i+" sera un vrai joueur.");
						System.out.println("");
						break;
					}
				}
			}
		}
		else if (i==2) {
			this.joueur2 = new Joueur(2,colorInit);
			this.plateau.getCase(12,12).setControleePar(2);
			this.plateau.getCase(12,12).setCouleurCase(colorInit);
			joueur2.ajoutCaseControlee();
			if (withIA) {
				while ((true)) {
					System.out.println("Voulez-vous faire du joueur "+i+" une IA aléatoire ? (o/n) :");
					String stringChoix = Scanneur.scan.nextLine();
					System.out.println("");
					if (stringChoix.equalsIgnoreCase("o")) {
						System.out.println("Le joueur "+i+" sera une IA aléatoire.");
						System.out.println("");
						this.joueur2.setIsRandomIA(true);
						break;
					}
					else if (stringChoix.equalsIgnoreCase("n")) {
						System.out.println("Le joueur "+i+" sera un vrai joueur.");
						System.out.println("");
						break;
					}
				}
			}
		}
		else if (i==3) {
			this.joueur3 = new Joueur(3,colorInit);
			this.plateau.getCase(0,12).setControleePar(3);
			this.plateau.getCase(0,12).setCouleurCase(colorInit);
			joueur3.ajoutCaseControlee();
			if (withIA) {
				while ((true)) {
					System.out.println("Voulez-vous faire du joueur "+i+" une IA aléatoire ? (o/n) :");
					String stringChoix = Scanneur.scan.nextLine();
					System.out.println("");
					if (stringChoix.equalsIgnoreCase("o")) {
						System.out.println("Le joueur "+i+" sera une IA aléatoire.");
						System.out.println("");
						this.joueur3.setIsRandomIA(true);
						break;
					}
					else if (stringChoix.equalsIgnoreCase("n")) {
						System.out.println("Le joueur "+i+" sera un vrai joueur.");
						System.out.println("");
						break;
					}
				}
			}
		}
		else if (i==4) {
			this.joueur4 = new Joueur(4,colorInit);
			this.plateau.getCase(12,0).setControleePar(4);
			this.plateau.getCase(12,0).setCouleurCase(colorInit);
			joueur4.ajoutCaseControlee();
			if (withIA) {
				while ((true)) {
					System.out.println("Voulez-vous faire du joueur "+i+" une IA aléatoire ? (o/n) :");
					String stringChoix = Scanneur.scan.nextLine();
					System.out.println("");
					if (stringChoix.equalsIgnoreCase("o")) {
						System.out.println("Le joueur "+i+" sera une IA aléatoire.");
						System.out.println("");
						this.joueur4.setIsRandomIA(true);
						break;
					}
					else if (stringChoix.equalsIgnoreCase("n")) {
						System.out.println("Le joueur "+i+" sera un vrai joueur.");
						System.out.println("");
						break;
					}
				}
			}
		}
		colorInit = null;
		
		}
	}
	
	public void gameStart() {
		Joueur joueurActuel;
		// Le joueur 1 commence
		joueurActuel = this.joueur1;
		// Boucle de jeu
		while (true) {
			// Affichage de la grille
			if (this.affGraph) {
				AffichageGraphique.drawPlateauGraph(this.plateau);
			}
			else {
				AffichageConsole.drawPlateau(this.plateau);
			}
			// Tests sur les conditions de fin de partie
			if (joueurActuel.getNbCasesControlees() > 84) {
				endGameAbsMaj(joueurActuel);
				break;
			}
			else if (this.plateau.pasDeCasesLibres()) {
				if (this.nbJoueurs == 2) {
					if (joueur1.getNbCasesControlees() > joueur2.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur1.getPlayerName(),this.joueur1.getNbCasesControlees());
					}
					else if (joueur1.getNbCasesControlees() == joueur2.getNbCasesControlees()) {
						endGamePlusLibres("Joueur 1 ou 2",this.joueur1.getNbCasesControlees());
					}
					else {
						endGamePlusLibres(this.joueur2.getPlayerName(),this.joueur2.getNbCasesControlees());
					}
				}
				else if (this.nbJoueurs == 3) {
					if (joueur1.getNbCasesControlees() > joueur2.getNbCasesControlees() && joueur1.getNbCasesControlees() > joueur3.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur1.getPlayerName(),this.joueur1.getNbCasesControlees());
					}
					else if (joueur2.getNbCasesControlees() > joueur1.getNbCasesControlees() && joueur2.getNbCasesControlees() > joueur3.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur2.getPlayerName(),this.joueur2.getNbCasesControlees());
					}
					else if (joueur3.getNbCasesControlees() > joueur1.getNbCasesControlees() && joueur3.getNbCasesControlees() > joueur3.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur3.getPlayerName(),this.joueur3.getNbCasesControlees());
					}
					else if (joueur1.getNbCasesControlees() == joueur2.getNbCasesControlees() && joueur1.getNbCasesControlees() == joueur3.getNbCasesControlees()) {
						endGamePlusLibres("Joueur 1 ou 2 ou 3",this.joueur1.getNbCasesControlees());
					}
					else if (joueur1.getNbCasesControlees() == joueur2.getNbCasesControlees()) {
						endGamePlusLibres("Joueur 1 ou 2",this.joueur1.getNbCasesControlees());
					}
					else if (joueur1.getNbCasesControlees() == joueur3.getNbCasesControlees()) {
						endGamePlusLibres("Joueur 1ou 3",this.joueur1.getNbCasesControlees());
					}
					else if (joueur2.getNbCasesControlees() == joueur3.getNbCasesControlees()) {
						endGamePlusLibres("Joueur 2 ou 3",this.joueur2.getNbCasesControlees());
					}
					else {
						endGamePlusLibres("Joueur ??",this.joueur1.getNbCasesControlees());	
					}
				}
				else if (this.nbJoueurs == 4) {
					if (joueur1.getNbCasesControlees() > joueur2.getNbCasesControlees() && joueur1.getNbCasesControlees() > joueur3.getNbCasesControlees() && joueur1.getNbCasesControlees() > joueur4.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur1.getPlayerName(),this.joueur1.getNbCasesControlees());
					}
					else if (joueur2.getNbCasesControlees() > joueur1.getNbCasesControlees() && joueur2.getNbCasesControlees() > joueur3.getNbCasesControlees() && joueur2.getNbCasesControlees() > joueur4.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur2.getPlayerName(),this.joueur2.getNbCasesControlees());
					}
					else if (joueur3.getNbCasesControlees() > joueur1.getNbCasesControlees() && joueur3.getNbCasesControlees() > joueur2.getNbCasesControlees() && joueur3.getNbCasesControlees() > joueur4.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur3.getPlayerName(),this.joueur3.getNbCasesControlees());
					}
					else if (joueur4.getNbCasesControlees() > joueur1.getNbCasesControlees() && joueur4.getNbCasesControlees() > joueur2.getNbCasesControlees() && joueur4.getNbCasesControlees() > joueur3.getNbCasesControlees()) {
						endGamePlusLibres(this.joueur4.getPlayerName(),this.joueur4.getNbCasesControlees());
					}
					else {
						System.out.println("Il n'y a plus de cases libres ! Partie terminée.");
						System.out.println("En raison d'une égalité dans une partie à 4 joueurs, le gagnant et son nombre de cases ne sera pas affiché.");
						System.out.println("Mon algorithme de choix n'est pas optimisé. Comptez manuellement.");
					}
				}
				break;
			}
			// Tour de jeu
			gameRound(joueurActuel);
			
			// Passage au tour d'un autre joueur
			if (this.nbJoueurs == 2) {
				joueurActuel = (joueurActuel == this.joueur1) ? this.joueur2 : this.joueur1;
			}
			else if (this.nbJoueurs == 3) {
				if (joueurActuel == this.joueur1) {joueurActuel = this.joueur2;}
				else if (joueurActuel == this.joueur2) {joueurActuel = this.joueur3;}
				else {joueurActuel = this.joueur1;}
			}
			else if (this.nbJoueurs == 4) {
				if (joueurActuel == this.joueur1) {joueurActuel = this.joueur2;}
				else if (joueurActuel == this.joueur2) {joueurActuel = this.joueur3;}
				else if (joueurActuel == this.joueur3) {joueurActuel = this.joueur4;}
				else {joueurActuel = this.joueur1;}
			}
		}
	}
	
	// Gestion du tour du joueur
	private void gameRound(Joueur joueurActuel) {
		Couleur newColor = null;
		
		// Stockage des couleurs actuelles des joueurs
		Couleur[] playersColors = new Couleur[4];
		if (this.nbJoueurs == 2) {
			playersColors[0] = this.joueur1.getCouleurJoueur();
			playersColors[1] = this.joueur2.getCouleurJoueur();
			playersColors[2] = null;
			playersColors[3] = null;
		}
		
		else if (this.nbJoueurs == 3) {
			playersColors[0] = this.joueur1.getCouleurJoueur();
			playersColors[1] = this.joueur2.getCouleurJoueur();
			playersColors[2] = this.joueur3.getCouleurJoueur();
			playersColors[3] = null;
		}
		else if (this.nbJoueurs == 4) {
			playersColors[0] = this.joueur1.getCouleurJoueur();
			playersColors[1] = this.joueur2.getCouleurJoueur();
			playersColors[2] = this.joueur3.getCouleurJoueur();
			playersColors[3] = this.joueur4.getCouleurJoueur();
		}
		
		// Test si IA aléatoire
		if (joueurActuel.getIsRandomIA()) {
			while (newColor == null) {
				// Choix couleur aléatoire
				newColor = Couleur.randomCouleur();
				// Test si couleur disponible
				for (int i=0; i<this.nbJoueurs; i++){
					if (playersColors[i] == newColor) {
						newColor = null;
						break;
					}
				}
			}
			
		}
		
		// DEBUT CHOIX COULEUR JOUEUR PAS IA
		else {
			while (newColor == null) {
				System.out.println(joueurActuel.getPlayerName()+", veuillez choisir une nouvelle couleur.");
				System.out.println("Parmi les couleurs suivantes, choisissez une couleur différente de votre couleur actuelle ou de celles de vos adversaires :");
				System.out.println("rouge (r/R), orange (o/O), jaune (j/J), vert (v/V), bleu (b/B) ou magenta (m/M)");
		
				// Reconnaissance de la couleur
				String newString = Scanneur.scan.nextLine();
				System.out.println("");
				if (newString.equalsIgnoreCase("r")) {
					newColor = Couleur.ROUGE;
				}
				else if (newString.equalsIgnoreCase("o")) {
					newColor = Couleur.ORANGE;
				}
				else if (newString.equalsIgnoreCase("j")) {
					newColor = Couleur.JAUNE;
				}
				else if (newString.equalsIgnoreCase("v")) {
					newColor = Couleur.VERT;
				}
				else if (newString.equalsIgnoreCase("b")) {
					newColor = Couleur.BLEU;
				}
				else if (newString.equalsIgnoreCase("m")) {
					newColor = Couleur.MAGENTA;
				}
				// Test si la couleur est disponible
				for (int i=0; i<this.nbJoueurs; i++){
					if (playersColors[i] == newColor) {
						newColor = null;
						System.out.println("Cette couleur est déjà prise !");
						System.out.println("");
						break;
					}
				}
			}
		}
		// FIN CHOIX COULEUR JOUEUR PAS IA
		
		joueurActuel.setCouleurJoueur(newColor);
		// Changement de la couleur de toutes les cases possédées et assimilation des cases proches de même couleur
		Plateau plateau_clone = (Plateau)this.plateau.clone();
		
		/*
		 * Test du bon fonctionnement du clonage :
		if (plateau_clone.equals(this.plateau)) {
			System.out.println("");
			System.out.println("Clonage réussi !");
			System.out.println("");
		}
		*/
		
		for (int e=0; e<10; e++) {
			for (int i=0; i<13; i++) {
				for (int j=0; j<13; j++) {
					if (plateau_clone.getCase(i,j).getControleePar() == joueurActuel.getNumJoueur()) {
						plateau_clone.getCase(i,j).setCouleurCase(newColor);
					}
					else if (i>0 && plateau_clone.getCase(i,j).getControleePar() == 0 && plateau_clone.getCase(i-1,j).getControleePar() == joueurActuel.getNumJoueur() && plateau_clone.getCase(i,j).getCouleurCase() == newColor) {
						plateau_clone.getCase(i,j).setControleePar(joueurActuel.getNumJoueur());
						joueurActuel.ajoutCaseControlee();
					}
					else if (i<12 && plateau_clone.getCase(i,j).getControleePar() == 0 && plateau_clone.getCase(i+1,j).getControleePar() == joueurActuel.getNumJoueur() && plateau_clone.getCase(i,j).getCouleurCase() == newColor) {
						plateau_clone.getCase(i,j).setControleePar(joueurActuel.getNumJoueur());
						joueurActuel.ajoutCaseControlee();
					}
					else if (j>0 && plateau_clone.getCase(i,j).getControleePar() == 0 && plateau_clone.getCase(i,j-1).getControleePar() == joueurActuel.getNumJoueur() && plateau_clone.getCase(i,j).getCouleurCase() == newColor) {
						plateau_clone.getCase(i,j).setControleePar(joueurActuel.getNumJoueur());
						joueurActuel.ajoutCaseControlee();
					}
					else if (j<12 && plateau_clone.getCase(i,j).getControleePar() == 0 && plateau_clone.getCase(i,j+1).getControleePar() == joueurActuel.getNumJoueur() && plateau_clone.getCase(i,j).getCouleurCase() == newColor) {
						plateau_clone.getCase(i,j).setControleePar(joueurActuel.getNumJoueur());
						joueurActuel.ajoutCaseControlee();
					}
				}
			}
		}
		this.plateau = plateau_clone;
	}
	
	// Fin de la partie lorsque contrôle de la majorité des cases par un joueur
	private void endGameAbsMaj(Joueur _joueurActuel) {
		System.out.println("Contrôle de plus de la moitié des cases ! Partie terminée.");
		System.out.println("Victoire du "+_joueurActuel.getPlayerName()+" qui contôle "+_joueurActuel.getNbCasesControlees()+" cases !");
		}

	// Fin de la partie lorsqu'il n'y a plus de cases libres
	private void endGamePlusLibres(String nomWinner,int nbCasesWinner) {
		System.out.println("Il n'y a plus de cases libres ! Partie terminée.");
		System.out.println("Victoire du "+nomWinner+" qui contôle "+nbCasesWinner+" cases !");
		}
}
