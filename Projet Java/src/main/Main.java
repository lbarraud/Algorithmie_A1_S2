package main;

import moteur.Moteur;

public class Main {

	public static void main(String[] args) {
		System.out.println("###\t\tProjet Algorithmie ISEP\t\t###");
		System.out.println("###\t\tAuteur : Loann BARRAUD\t\t###");		
		System.out.println("###\t\tJeu des six couleurs\t\t###");
		System.out.println("");
		
		Moteur m = new Moteur();
		
		m.gameStart();
		
		Scanneur.scan.close();
	}

}
