package CalcolaBigliettoTrenoOop;

import java.io.File;
import java.io.FileWriter;
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
    	
    	System.out.print("Inserisci opzione se flessibile o meno(rispondi si o no): ");
    	String isFlexibleStr = sc.nextLine();
    	boolean isFlexible = isFlexibleStr.equals("si");
    	
    	LocalDate dateOfDay = LocalDate.now();
    	
    	sc.close();
    	
    	System.out.println("--------------------------------------------------");
    	
    	FileWriter writer = null;
    	
    	try {
			Biglietto b = new Biglietto(age, km, dateOfDay, isFlexible);
			System.out.println(b);
			writer = new FileWriter("./Biglietti.txt", true);
			writer.append(b.toString());
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			
		}finally {
			try {
				writer.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Scanner fileSc = null;
		
		try {
			File f = new File("./Biglietti.txt");
			fileSc = new Scanner(f);
			
			while(fileSc.hasNextLine()) {
				String ln = fileSc.nextLine();
				System.out.println(ln);
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		
		}finally {
			fileSc.close();
		}
		
	}
	   
}
