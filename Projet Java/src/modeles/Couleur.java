package modeles;

import java.awt.Color;
import java.util.Random;

public enum Couleur {
	ROUGE, ORANGE, JAUNE, VERT, BLEU, MAGENTA;
  
	// Méthode qui choisit une couleur au hasard
	private static final Couleur[] couleursPossibles = {ROUGE, ORANGE, JAUNE, VERT, BLEU, MAGENTA};
	private static final Random RANDOM = new Random();
	public static Couleur randomCouleur()  {
		return couleursPossibles[RANDOM.nextInt(6)];
	}
	
	// Note : les deux fonctions suivantes ne sont pas utilisées
	public static String getColorName(Couleur c) {
		if(c == ROUGE) return "rouge";
		else if(c == ORANGE) return "orange";
		else if(c == JAUNE) return "jaune";
		else if(c == VERT) return "vert";
		else if(c == BLEU) return "bleu";
		else if(c == MAGENTA) return "indigo";
		else return "noir";
	}
  
	public static Color getDrawColor(Couleur c) {
		if(c == ROUGE) return Color.RED;
		else if(c == ORANGE) return Color.ORANGE;
		else if(c == JAUNE) return Color.YELLOW;
		else if(c == VERT) return Color.GREEN;
		else if(c == BLEU) return Color.BLUE;
		else if(c == MAGENTA) return Color.MAGENTA;
		else return Color.BLACK;
	}
}
