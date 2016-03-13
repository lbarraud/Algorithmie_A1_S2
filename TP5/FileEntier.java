import java.util.LinkedList;
import java.util.Queue;

public class FileEntier {
	static Queue<Integer> fifo = new LinkedList<Integer>();
	private static FileEntier instanceFile = null;
	
	public static FileEntier creation_fifo() {
		if (instanceFile==null) {
			instanceFile = new FileEntier();
		}
		return instanceFile;
	}
	
	public Queue<Integer> affichage() {
		return fifo;
	}
	
	public void add(int n) {
		fifo.offer(n);
	}
	
	public int take() {
		int element = fifo.poll();
		return element;
	}
	
	public static void main(String args[]) {
		FileEntier file = FileEntier.creation_fifo();
		// On remplit la File d'attente :
		file.add(77);
		file.add(2);
		file.add(4);
		file.add(1);
		file.add(10);
		file.add(636);
		// Test du fonctionnement :
		System.out.println("La file d'attente contient : " + file.affichage());
		System.out.println("On enlève : " + file.take());
		System.out.println("Il reste alors : " + file.affichage());
	}
}
