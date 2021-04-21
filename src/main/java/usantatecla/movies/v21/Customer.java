package usantatecla.movies.v21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Iterator<Rental> rentals = this.rentals.iterator();
		String result = "Rental Record for " + this.getName() + "\n";
		double totalCharge = 0;
		int totalFrequentRenterPoints = 0;
		while (rentals.hasNext()) {
			Rental rental = rentals.next();
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
			totalCharge += rental.getCharge();
			totalFrequentRenterPoints += rental.getFrequentRenterPoints();
		}
		result += "Amount owed is " + totalCharge + "\n";
		result += "You earned " + totalFrequentRenterPoints + " frequent renter points";
		return result;
	}

}
