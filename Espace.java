
public class Espace {
	
	private double x, y, g, frottement, temps;
	
	public Espace() {
		// Murs d'enceinte :
		x = 50;
		y = 50;
		// Gravité :
		g = -9.81;
		// Paramètres supplémentaires :
		temps= 0.1;
		frottement = -0.5;
	}
	
	public Espace(double x, double y, double g, double frottement, double temps){
		this.x = x;
		this.y = y;
		this.g = g;
		this.frottement = frottement;
		this.temps = temps;
	}
	
	public double getSpaceX() {
		return x;
	}
	public double getSpaceY() {
		return y;
	}
	public double getG() {
		return g;
	}
	public double getFrottement() {
		return frottement;
	}
	public double getTemps() {
		return temps;
	}
}
