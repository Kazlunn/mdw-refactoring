package usantatecla.movies.v21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void regularMovieChargeDaysRentedBelowThresholdTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).buildRegularMovie();
		Rental rental = new RentalBuilder().movie(movie).daysRented(0).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		assertEquals(customer.getRentals().get(0).getCharge(), 2.0, 0);
	}

	@Test
	public void regularMovieChargeDaysRentedAboveThresholdTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).buildRegularMovie();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		assertEquals(customer.getRentals().get(0).getCharge(), 3.5, 0);
	}

	@Test
	public void childrenMovieChargeBelowThresholdTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).buildChildrenMovie();
		Rental rental = new RentalBuilder().movie(movie).daysRented(0).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		assertEquals(customer.getRentals().get(0).getCharge(), 1.5, 0);
	}

	@Test
	public void childrenMovieChargeAboveThresholdTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).buildChildrenMovie();
		Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		assertEquals(customer.getRentals().get(0).getCharge(), 6.0, 0);
	}

	@Test
	public void newReleaseMovieFrequentPointsBelowThresholdTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).buildNewReleaseMovie();
		Rental rental = new RentalBuilder().movie(movie).daysRented(0).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		assertEquals(customer.getRentals().get(0).getFrequentRenterPoints(), 1);
	}

	@Test
	public void newReleaseMovieFrequentPointsAboveThresholdTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).buildNewReleaseMovie();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		assertEquals(customer.getRentals().get(0).getFrequentRenterPoints(), 2);
	}
	
	@Test
	public void formatStatementTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).buildRegularMovie();
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();
		
		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).buildNewReleaseMovie();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();
		
		String childrenMovieName = "childrensMovieName";
		Movie childrenMovie = new MovieBuilder().title(childrenMovieName).buildChildrenMovie();
		Rental childrenRental = new RentalBuilder().movie(childrenMovie).daysRented(10).build();
		
		String customerName = "customerName";
		Customer customer = new CustomerBuilder()
				.name(customerName)
				.rental(regularRental)
				.rental(newReleaseRental)
				.rental(childrenRental)
				.build();

		String statement = customer.statement();

		String result = new StatementBuilder()
				.customerName(customerName)
				.movie(regularMovieName, 14)
				.movie(newReleaseMovieName, 3)
				.movie(childrenMovieName, 15)
				.totalAmount(32)
				.frequentRenterPoints(4)
				.build();
		assertEquals(result, statement);
	}
	
	
}
