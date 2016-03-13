// TP5 de Loann BARRAUD

import java.util.Arrays;
import java.util.Scanner;

public class TP5 {
	private static Scanner scan;
	private static Scanner scan2;

	// Main
	public static void main(String[] args) {
		palindrome();
		int[] tableau = new int[60];
		eratosthene(tableau);
		eratostheneR(tableau);
		System.out.println(Arrays.toString(tableau));
		/* Code pour print le contenu des tableaux eratosthene au besoin :
		for (int i = 0; i<tableau.length; i++) {
			System.out.print(tableau[i]+" ");
		}
		*/
	}
	
	// 1) Palindrome
	public static boolean isPalindrome(String phrase) {
		int n = phrase.length();
		if (n==0 || n==1 || (n==2 && phrase.charAt(0)==phrase.charAt(1))) {
			return true;
		}
		else if (phrase.charAt(0)!=phrase.charAt(n-1)){
			return false;
		}
		else {
			return isPalindrome(phrase.substring(1,n-1));
		}
	}
	
	public static void palindrome() {
		scan = new Scanner(System.in);
		System.out.println("Veuillez entrer une phrase (sans les espaces) :");
		String phrase = scan.nextLine();
		boolean est_palindrome = isPalindrome(phrase);
		if (est_palindrome) {
			System.out.println("C'est un palindrome");
		}
		else {
			System.out.println("Ce n'est pas un palindrome");
		}
	}
	
	// 2) Crible d'Érastothène
	public static void eratosthene(int[] tableau) {
		int n = tableau.length;
		for (int i = 0; i<n; i++){
			tableau[i] = i;
		}
		tableau[1] = 0;
		for (int i = 2; i<n; i++){
			if (tableau[i]!=0){
				for (int k = 2; i*k<n; k++){
					tableau[i*k] = 0;
				}
			}
		}
	}
	
	public static void premiers() {
		scan2 = new Scanner(System.in);
		System.out.println("Veuillez entrer un entier :");
		int n = scan2.nextInt();
		int[] tableau = new int[n];
		if (n>1) {
			eratosthene(tableau);
			System.out.println("");
		}
		for (int i = 2; i<n; i++) {
			if (tableau[i]!=0) {
				System.out.print(tableau[i]+" ");
			}
		}
	}
	
	public static void eratostheneR(int[] tableau) {
		int n = tableau.length;
		if (n>1 && tableau[2]!=2) { // Initialisation du crible (première boucle seulement)
			for (int i = 0; i<n; i++){
				tableau[i] = i;
			}
			// Pour mémoriser la position i (de 2 à n) au fil des appels, on stocke
			// i dans tableau[0] et on remet le 0 à la fin
			tableau[0] = 2;
			tableau[1] = 0;
		}
		int i = tableau[0];
		while(i<n/2 && tableau[i]==0) {
			i++;
		}
		tableau[0] = i+1;
		if (tableau[i]!=0){
			for (int k = 2; i*k<n; k++) {
				tableau[i*k] = 0;
			}
		}
		if (i>=n-1) { // fin des appels récursifs
			tableau[0] = 0;
		}
		else {
			eratostheneR(tableau);
		}
	}
	
}
