package CalcolaBigliettoTrenoOop;

public class Main {
      public static void main(String[] args) {
    	System.out.println("Start");
		try {
			Biglietto b = new Biglietto(1, 0);
			System.out.println(b);
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("End");
	}
}
