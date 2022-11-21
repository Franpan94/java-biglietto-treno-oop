package CalcolaBigliettoTrenoOop;

import java.util.Scanner;

public class Biglietteria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	System.out.println("Start");
    	
    	System.out.print("Inserisci età: ");
    	int age = sc.nextInt();
    	
    	System.out.print("Inserisci Km: ");
    	int km = sc.nextInt();
    	
		try {
			Biglietto b = new Biglietto(age, km);
			System.out.println(b);
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("End");
	}
	   
}
