import java.util.Random;


/* matrice des cellules du jeu de la vie */

public class Matrice {
	/** grille a l'instant t*/
	Cellule [][] grille;
	/** grille a l'instant t-1*/
	Cellule [][] grilleAncienne;
	/** taille de la grille*/
	int taille;
	/** nombre de cellules vivantes initialement*/
	int nbCellulesInitiales = 10;

	Matrice()
	{
		grille = new  Cellule[20][20];
		grilleAncienne = new  Cellule[20][20];
		taille = 20;
	}

	/** constructeur par defaut, initialise la taille, le nombre de cellules initiales,  
    ainsi que les grilles aux instants t et t-1*/
	Matrice(int taille, int nbCellulesInitiales)
	{
		this.taille= taille;
		grille = new Cellule[taille][taille];
		grilleAncienne = new Cellule[taille][taille];
		this.nbCellulesInitiales = nbCellulesInitiales ;
		init();
	}


	/** 
	 * initialise les grilles aux instants t et t-1 : ajout de cellules mortes et appel de initHasard
	 */
	void init()
	{
		for(int i=0; i<taille; i++)
			for(int j=0; j<taille; j++)
			{
				grille[i][j] = new Cellule(grilleAncienne, i, j, false);
				grilleAncienne[i][j] = (Cellule) grille[i][j].clone();
			}
		initHasard();
	}

	/** 
	 * place au hasard des cellules vivantes dans les grilles aux instants t et t-1
	 */
	void initHasard()
	{
		Random r = new Random();
		for(int i=0; i<nbCellulesInitiales; i++)
		{
			int x = r.nextInt(taille);
			int y = r.nextInt(taille);
			grille[x][y] = new Cellule(grilleAncienne, x, y, true);
			grilleAncienne[x][y] = (Cellule)grille[x][y] .clone();
		}
	}

	/** 
	 * copie la grille a l'instant t dans la grille a l'instant t-1
	 */
	void copieGrilles()
	{
		for(int i=0; i<taille; i++) 
			for(int j=0; j<taille; j++)
				grilleAncienne[i][j] = (Cellule)(grille[i][j]).clone();
	}

	/**  
	 * demande a toutes les cellules de la grille a l'instant t d'evoluer
	 */
	void animGrille()
	{
		for(int i=0; i<taille; i++)
			for(int j=0; j<taille; j++)
				grille[i][j].evoluer();
	}
}
