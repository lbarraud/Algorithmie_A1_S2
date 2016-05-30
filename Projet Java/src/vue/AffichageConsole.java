package vue;

import modeles.Couleur;
import modeles.Plateau;

public class AffichageConsole {
	// Permet l'affichage du plateau de jeu en console
	public static void drawPlateau(Plateau plateau) {
		System.out.println("Etat du plateau de jeu :");
		for (int i=0; i<13; i++) {
			System.out.println("");
			for (int j=0; j<13; j++) {
				if (plateau.getCase(i,j).getCouleurCase() == Couleur.ROUGE) {
					if (plateau.getCase(i,j).getControleePar() == 0) {
						System.out.print("r ");
					}
					else {
						System.out.print("R ");
					}
				}
				else if (plateau.getCase(i,j).getCouleurCase() == Couleur.ORANGE) {
					if (plateau.getCase(i,j).getControleePar() == 0) {
						System.out.print("o ");
					}
					else {
						System.out.print("O ");
					}
				}
				else if (plateau.getCase(i,j).getCouleurCase() == Couleur.JAUNE) {
					if (plateau.getCase(i,j).getControleePar() == 0) {
						System.out.print("j ");
					}
					else {
						System.out.print("J ");
					}
				}
				else if (plateau.getCase(i,j).getCouleurCase() == Couleur.VERT) {
					if (plateau.getCase(i,j).getControleePar() == 0) {
						System.out.print("v ");
					}
					else {
						System.out.print("V ");
					}
				}
				else if (plateau.getCase(i,j).getCouleurCase() == Couleur.BLEU) {
					if (plateau.getCase(i,j).getControleePar() == 0) {
						System.out.print("b ");
					}
					else {
						System.out.print("B ");
					}
				}
				else if (plateau.getCase(i,j).getCouleurCase() == Couleur.MAGENTA) {
					if (plateau.getCase(i,j).getControleePar() == 0) {
						System.out.print("m ");
					}
					else {
						System.out.print("M ");
					}
				}
				else {
					System.out.print("X ");
				}
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Rappel zones de départ :");
		System.out.println("1 : haut à gauche // 2 : bas à droite // 3 : haut à droite // 4 : bas à gauche");
		System.out.println("");
	}
}
