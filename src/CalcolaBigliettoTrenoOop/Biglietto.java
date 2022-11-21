package CalcolaBigliettoTrenoOop;

import java.math.BigDecimal;

public class Biglietto {
    private int km;
	private int age;
	private final static BigDecimal COSTO_KM = new BigDecimal(0.21);
	private final static BigDecimal DISCOUNT_OVER_65 = new BigDecimal (0.04);
	private final static BigDecimal DISCOUNT_UNDER_18 = new BigDecimal (0.02);
	
	public Biglietto(int age, int km) throws Exception {
		this.km = km;
		this.age = age;
		setAge(age);
		setKm(km);
		
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) throws Exception {
		if(km <= 0) {
			throw new Exception("Il numero di Km deve essere maggiore di 0");
		}
		this.km = km;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		if(age <= 0) {
			throw new Exception("L'età deve essere maggiore di 0");
		}
		this.age = age;
	}
	
	public BigDecimal calculatePrice() {
		BigDecimal price = new BigDecimal(0.00);
		price = COSTO_KM.multiply(BigDecimal.valueOf(km));
		return calculateDiscount(price);
	}
	
	private BigDecimal calculateDiscount(BigDecimal priceDiscount) {
		if(age < 18) {
			priceDiscount = priceDiscount.subtract(priceDiscount.multiply(DISCOUNT_UNDER_18));
			return priceDiscount;
		}
			
		else if(age > 65) {
			priceDiscount = priceDiscount.subtract(priceDiscount.multiply(DISCOUNT_OVER_65));
			return priceDiscount;
		}
			
		else 
			return priceDiscount;
	}
	
	
	@Override
	public String toString() {
		return "Età del passeggero: " + age +  "\nKm inseriti: " + km 
				+ "\nPrezzo biglietto: " + calculatePrice() + " €";
	}
}
