
public class Balle {
	
	private double x,y,Vx,Vy,r;
	
	public Balle(double x, double y, double v_X, double v_Y, double r){
		this.x = x;
		this.y = y;
		this.Vx = v_X;
		this.Vy = v_Y;
		this.r = r;
	}
	
	public void MajPosition(Espace esp, Boolean col) {
		
		col = col != null ? col : false;
		
		Vx = (esp.getFrottement() * esp.getTemps()) + Vx;
		Vy = (esp.getG() * esp.getTemps()) + Vy;
		
		if (col){
			Vy = -Vy;
			Vx = -Vx;
			
			y = y + (Vy * esp.getTemps());
			x = x + (Vx * esp.getTemps());
		}
		
		else {
			
			y = y + (Vy * esp.getTemps());
			x = x + (Vx * esp.getTemps());
			
			if ((y - r) <= 0 || (y + r) >= esp.getSpaceY()) {
				
				if((y - r) <=0)
					y = r; 
				else
					y = esp.getSpaceY() - r;
				
				Vy = -Vy;
			}
			if ((x - r) <= 0.0 || (x + r) >= esp.getSpaceX()) {
				if(x-r <= 0)
					x = r;
				else
					x = esp.getSpaceX() - r;	
				Vx = -Vx;
			}
		}
	} 

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double getR() {
		return r;
	}

}
