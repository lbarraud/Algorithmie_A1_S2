/**
 * cette classe represente une cellule du jeu de la Vie
 * si la cellule est entouree du bon nombre de cellules alors elle vit, 
 * sinon, en cas de sous population ou de sur population, elle meurt...
 */
class Cellule implements Cloneable
{
    /** nature de la cellue*/
    boolean vivante;
    /**coordonnee de la cellule dans la grille*/ 
    int x,y;
    /** referecence a la grille des cellule*/
    Cellule [][]grille;
    /**a change recemment*/
    boolean vientDeChanger;
    
    /** constructeur initialisant la grille, les coordonnees et la nature de la cellule*/
    Cellule(Cellule [][]grille, int x, int y, boolean vivante)
    {
        this.grille = grille;
        this.vivante = vivante;
        this.x = x; this.y = y;
        vientDeChanger = true;
    }
    /** determine le prochain etat de la cellule en fonction des cellules voisines*/
    void evoluer()
    {
        int taille = grille.length;
        int nbVivantes = 0;
        for(int i=-1; i<2; i++)
        {
            int xx = ((x+i)+taille)%taille; // si x+i=-1, xx=taille-1. si x+i=taille, xx=0
            for(int j=-1; j<2; j++)
            {
                if (i==0 && j==0) continue;
                int yy = ((y+j)+taille)%taille;
                if (grille[xx][yy].vivante) nbVivantes++;
            }
        }
        if (nbVivantes<=1 || nbVivantes>=4) {vientDeChanger = (vivante==true); vivante = false;}
        if (nbVivantes==3) {vientDeChanger = (vivante==false); vivante = true;}
    }

    /** retourne une copie de la cellule
     @return une copie de la cellule */
    public Object clone()
    {
        Object o = null;
        try 
        { o = super.clone(); } 
            catch(CloneNotSupportedException e) 
            { System.err.println("Erreur dans le clonage de la cellule..."); }
        return o;
    }

}