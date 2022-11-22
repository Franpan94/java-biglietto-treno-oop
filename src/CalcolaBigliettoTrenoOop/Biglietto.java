package CalcolaBigliettoTrenoOop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
    private int km;
	private int age;
	private final static BigDecimal COSTO_KM = new BigDecimal(.21);
	private final static BigDecimal DISCOUNT_OVER_65 = new BigDecimal (.4);
	private final static BigDecimal DISCOUNT_UNDER_18 = new BigDecimal (.2);
	private LocalDate localDate;
	private boolean isFlexible;
	private final static int NORMAL_DURATION = 30;
	private final static int FLEXIBLE_DURATION = 90;
	
	public Biglietto(int age, int km, LocalDate localDate, boolean isFlexible) throws Exception {
		isValidAge(age);
		isValidKm(km);
		setFlexible(isFlexible);
		setLocalDate(localDate);
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km){
		this.km = km;
	}
	
	public void isValidKm(int km) throws Exception{
		if(km <= 0) {
			throw new Exception("I km devono essere di un numero maggiore di 0");
		}
		setKm(km);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		this.age = age;
	}
	
	public void isValidAge(int age) throws Exception {
		if(age <= 0) {
			throw new Exception("L'età deve essere maggiore di 0");
		}
		setAge(age);
	}
	
	public BigDecimal calculatePrice() {
		BigDecimal price = new BigDecimal(0.00);
		price = COSTO_KM.multiply(BigDecimal.valueOf(km));
		return calculateDiscount(price);
	}
	
	private BigDecimal calculateDiscount(BigDecimal priceDiscount) {
		if(age < 18) {
			priceDiscount = priceDiscount.subtract(priceDiscount.multiply(DISCOUNT_UNDER_18));
			if(isFlexible) {
				return priceDiscount = priceDiscount.add(priceDiscount.multiply(BigDecimal.valueOf(.1)));
            }
			return priceDiscount;
		}
			
		else if(age > 65) {
			priceDiscount = priceDiscount.subtract(priceDiscount.multiply(DISCOUNT_OVER_65));
			if(isFlexible) {
				return priceDiscount = priceDiscount.add( priceDiscount.multiply(BigDecimal.valueOf(.1)));
            }
			return priceDiscount;
		}
			
		else 
			return priceDiscount;
	}
	
	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	
	public LocalDate calculateExpiryDate() {
		if(isFlexible) {
			return localDate.plusDays(FLEXIBLE_DURATION);
		} else {
			return localDate.plusDays(NORMAL_DURATION);
		}
	}

	public boolean isFlexible() {
		return isFlexible;
	}

	public void setFlexible(boolean isFlexible) {
		this.isFlexible = isFlexible;
	}

	public static BigDecimal getCostoKm() {
		return COSTO_KM;
	}

	public static BigDecimal getDiscountOver65() {
		return DISCOUNT_OVER_65;
	}

	public static BigDecimal getDiscountUnder18() {
		return DISCOUNT_UNDER_18;
	}

	public static int getNormalDuration() {
		return NORMAL_DURATION;
	}

	public static int getFlexibleDuration() {
		return FLEXIBLE_DURATION;
	}

	@Override
	public String toString() {
		return  "\n-----------------------------------------------" 
				+ "\nEtà del passeggero: " + age +  "\nKm inseriti: " + km 
				+ "\nPrezzo biglietto: " + String.format("%.2f", calculatePrice()) + " €" 
				+ "\nData odierna: " + getLocalDate() + "\nBiglietto flessibile: " + (isFlexible() ? "si" : "no")
				+ "\nData di scadenza: " + calculateExpiryDate();
	}
}
