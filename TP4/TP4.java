
public class TP4 {

	public static void main(String[] args) {
		Espace zone = new Espace();
		 
		Balle b = new Balle(30.0, 45.0, 0.0,0.0, 3.0);
		Balle b2 = new Balle(45.0, 40.0, 10.0,2.0, 2.5);
		StdDraw.setXscale(0.0,zone.getSpaceX());
		StdDraw.setYscale(0.0,zone.getSpaceY());
		 
		while(true) {
			 
			 StdDraw.clear();
			 StdDraw.setPenColor(StdDraw.CYAN);
			 StdDraw.filledCircle(b.getX(), b.getY(), b.getR());
			 
			 StdDraw.setPenColor(StdDraw.GREEN);
			 StdDraw.filledCircle(b2.getX(), b2.getY(), b2.getR());
			 
			 Boolean col = collision(b, b2);
			 
			 b.MajPosition(zone,col);
			 b2.MajPosition(zone,col);
			 
			 if (collision(b,b2)){
				 
			 }
			 
			 StdDraw.show(30);
			 
		 }

	}
	public static Boolean collision(Balle b, Balle b2){
		double d2 = Math.pow(b.getX()-b2.getX(), 2) + Math.pow(b.getY()-b2.getY(), 2);
					   if (d2 > (b.getR() + b2.getR())*(b.getR() + b2.getR()))
					      return false;
					   else
					      return true;
	}

}
