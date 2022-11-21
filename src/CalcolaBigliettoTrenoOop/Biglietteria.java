package CalcolaBigliettoTrenoOop;

import java.time.LocalDate;
import java.util.Scanner;

public class Biglietteria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Inserisci età: ");
    	String ageStr = sc.nextLine();
    	int age = Integer.parseInt(ageStr);
    	
    	System.out.print("Inserisci Km: ");
    	String kmStr = sc.nextLine();
    	int km = Integer.parseInt(kmStr);
    	
    	System.out.print("Inserisci opzione se flessibile o meno(rispondi con si o no): ");
    	String isFlexibleStr = sc.nextLine();
    	boolean isFlexible = isFlexibleStr.equals("si");
    	
    	LocalDate dateOfDay = LocalDate.now();
    	
    	System.out.println("--------------------------------------------------");
    	
    	try {
			Biglietto b = new Biglietto(age, km, dateOfDay, isFlexible);
			System.out.println(b);
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	   
}
