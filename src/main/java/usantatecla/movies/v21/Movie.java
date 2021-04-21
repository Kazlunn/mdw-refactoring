package usantatecla.movies.v21;

public abstract class Movie {

	private String title;
	
	private Price price;
	
	public Movie(String title, Price price) {
		this.title = title;
		this.price = price;
	}
	
	public abstract double getCharge(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
}
