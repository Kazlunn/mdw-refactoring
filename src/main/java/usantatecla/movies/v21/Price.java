package usantatecla.movies.v21;

public abstract class Price {

	private static final int FREQUENT_RENTER_POINTS = 1;
	
	public int getFrequentRenterPoints(int daysRented) {
		return Price.FREQUENT_RENTER_POINTS;
	}
}
