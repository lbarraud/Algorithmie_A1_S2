package vue;

import edu.princeton.cs.introcs.StdDraw;
import modeles.Plateau;
import modeles.Couleur;

public class AffichageGraphique {
	  public static void drawPlateauGraph(Plateau plateau) {
		    
		    StdDraw.setXscale(-1,14);
		    StdDraw.setYscale(-1,14);

		    StdDraw.clear(StdDraw.WHITE);
		    
		    StdDraw.setPenColor(StdDraw.BLACK);	    
		    // Dessine le quadrillage de la grille
		    for(int i = 0; i < 13; i++) {
		      for(int j = 0; j < 13; j++) {
		        StdDraw.square(i, j, 0.5);
		      }
		    }
		    
		    // Remplit les couleurs de la grille
			for (int i=0; i<13; i++) {
				for (int j=0; j<13; j++) {
					if (plateau.getCase(i,j).getCouleurCase() == Couleur.ROUGE) {
						StdDraw.setPenColor(StdDraw.RED);
				        StdDraw.filledSquare(j,12-i,0.5);
						if (plateau.getCase(i,j).getControleePar() != 0) {
							  StdDraw.setPenColor(StdDraw.BLACK);
					          StdDraw.text(j,12-i,String.valueOf(plateau.getCase(i,j).getControleePar()));
						}
					}
					else if (plateau.getCase(i,j).getCouleurCase() == Couleur.ORANGE) {
					    StdDraw.setPenColor(StdDraw.ORANGE);
				        StdDraw.filledSquare(j,12-i,0.5);
						if (plateau.getCase(i,j).getControleePar() != 0) {
							  StdDraw.setPenColor(StdDraw.BLACK);
					          StdDraw.text(j,12-i,String.valueOf(plateau.getCase(i,j).getControleePar()));
						}
					}
					else if (plateau.getCase(i,j).getCouleurCase() == Couleur.JAUNE) {
					    StdDraw.setPenColor(StdDraw.YELLOW);
				        StdDraw.filledSquare(j,12-i,0.5);
						if (plateau.getCase(i,j).getControleePar() != 0) {
							  StdDraw.setPenColor(StdDraw.BLACK);
					          StdDraw.text(j,12-i,String.valueOf(plateau.getCase(i,j).getControleePar()));
						}
					}
					else if (plateau.getCase(i,j).getCouleurCase() == Couleur.VERT) {
					    StdDraw.setPenColor(StdDraw.GREEN);
				        StdDraw.filledSquare(j,12-i,0.5);
						if (plateau.getCase(i,j).getControleePar() != 0) {
							  StdDraw.setPenColor(StdDraw.BLACK);
					          StdDraw.text(j,12-i,String.valueOf(plateau.getCase(i,j).getControleePar()));
						}
					}
					else if (plateau.getCase(i,j).getCouleurCase() == Couleur.BLEU) {
					    StdDraw.setPenColor(StdDraw.BLUE);
				        StdDraw.filledSquare(j,12-i,0.5);
						if (plateau.getCase(i,j).getControleePar() != 0) {
							  StdDraw.setPenColor(StdDraw.BLACK);
					          StdDraw.text(j,12-i,String.valueOf(plateau.getCase(i,j).getControleePar()));
						}
					}
					else if (plateau.getCase(i,j).getCouleurCase() == Couleur.MAGENTA) {
					    StdDraw.setPenColor(StdDraw.MAGENTA);
				        StdDraw.filledSquare(j,12-i,0.5);
						if (plateau.getCase(i,j).getControleePar() != 0) {
							  StdDraw.setPenColor(StdDraw.BLACK);
					          StdDraw.text(j,12-i,String.valueOf(plateau.getCase(i,j).getControleePar()));
						}
					}
					else {
					    StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.filledSquare(13-j,i,0.5);
					}
				}
			}

		  }
}
