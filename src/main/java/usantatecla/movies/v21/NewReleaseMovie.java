package usantatecla.movies.v21;

public class NewReleaseMovie extends Movie {

    private static final double CHARGE = 3;
    private static final int DAYS_RENTED_THRESHOLD = 1;
    private static final int FREQUENT_RENTER_POINTS = 2;

    public NewReleaseMovie(String title, Price price) {
        super(title, price);
    }

    @Override
    public double getCharge(int daysRented) {
        return NewReleaseMovie.CHARGE;
    }

}
