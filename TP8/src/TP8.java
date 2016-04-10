import javax.swing.JOptionPane;

/* Note : fonctionne avec un timer et sans StdDraw */

public class TP8 
{
    /** cree un objet Affichage */
    public static void main(String args[])
    {
        String rep = JOptionPane.showInputDialog("Taille de la grille ? (ex : 50) ");
        int taille = Integer.parseInt(rep);
        rep = JOptionPane.showInputDialog("Nombre initial de cellules vivantes ? (ex : 500) ");
        int nbCells = Integer.parseInt(rep);
        rep = JOptionPane.showInputDialog("Temps d'attente entre 2 steps (ex : 100 (ms)) :  ");
        int tempo = Integer.parseInt(rep);
        Matrice matrice = new Matrice(taille, nbCells);
        new Affichage(matrice, tempo);
        
    }
    
    
}
