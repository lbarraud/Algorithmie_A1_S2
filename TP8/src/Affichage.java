import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * represente la fenetre affichant la grille des cellules
 */
@SuppressWarnings("serial")
class Affichage extends JFrame implements ActionListener
{

	/**timer qui donne le tempo de la vie....*/
	Timer timer;
    /**matrice liee a cet objet graphique*/
	Matrice matrice;
	/**taille de la matrice*/
	int taille;
	/**taille d'une cellule en pixel*/
	int espace = 10;
    /** zone de dessin*/
    JPanel jpanel;
    /** indicateur permettant d'eviter l'effet de scintillement de la grille */
    boolean repaintFromTimer = false;
    
    /** constructeur par defaut, initialise la taille a 20 ainsi que les grilles a l'instnat t et t-1*/
    Affichage()
    {
        init();
    }
    /** constructeur par defaut, initialise la taille, le nombre de cellules initiales, le tempo, 
     ainsi que les grilles aux instants t et t-1*/
    Affichage(Matrice _matrice, int tempo)
    {
    		matrice = _matrice;
    		taille = matrice.taille;
        init();
        timer = new Timer(tempo, this);
        timer.start();
    }
    
    /** 
     *initialise la fenetre : taille, zone de dessin, gestionnaire de fenetre...
     */
    void init()
    {
        setBounds(10,10,3*espace + taille*espace, 5*espace + taille*espace);
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        setBackground(Color.black);
        getContentPane().add(jpanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    

    
    /** 
     *dessin de la grille et des cellules
     */
    void dessinMatrice(Graphics2D g2d)
    {
        for(int i=0; i<taille; i++)
            for(int j=0; j<taille; j++)
            {
                Cellule cell = matrice.grille[i][j];
                if (cell.vientDeChanger || !repaintFromTimer)
                {
                    if (cell.vivante) g2d.setColor(Color.blue);
                    else g2d.setColor(Color.black);
                    g2d.fillOval((i+1)*espace+1, (j+1)*espace+1, espace-2, espace-2);
                }
            }
        if (!this.repaintFromTimer) // on trace la grille une seule fois, et non a chaque top
        {
            g2d.setColor(Color.darkGray);
            for(int i=0; i<=taille; i++)
            {
                g2d.drawLine((i+1)*espace, espace, (i+1)*espace, (taille+1)*espace);
                g2d.drawLine(espace, (i+1)*espace, (taille+1)*espace, (i+1)*espace);
            }
        }
        repaintFromTimer = false; // on peut retracer le tout si le repaint vient d'une modification de la fenetre par l'utilisateur
    }
    

    
    /** 
     * appel du dessin de dessinGrille, 
     */
    public void paint(Graphics g)
    {
    		Graphics gg = jpanel.getGraphics();
    		Graphics2D g2 = (Graphics2D)gg;
  		// pour un 'rendu' de qualite
  		RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  		qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
  		g2.setRenderingHints(qualityHints);
  		// fin pour un 'rendu' de qualite

  		dessinMatrice(g2);
    }
    
    /** 
     * a chaque top du timer, appel de animGrille, et demande de reaffichage
     */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
	          matrice.copieGrilles();
	          matrice.animGrille();
	          repaintFromTimer = true; //on ne retrace pas la grille si l'ordre du repaint vient du timer
	          repaint();
		}
	}
}
