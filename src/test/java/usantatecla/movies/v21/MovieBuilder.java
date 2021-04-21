package usantatecla.movies.v21;

public class MovieBuilder {

	private String title;
	
	private Price price;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public ChildrenMovie buildChildrenMovie() {
		this.price = new ChildrenPrice();
		return new ChildrenMovie(title, price);
	}
	
	public RegularMovie buildRegularMovie() {
		this.price = new RegularPrice();
		return new RegularMovie(title, price);
	}
	
	public NewReleaseMovie buildNewReleaseMovie() {
		this.price = new NewReleasePrice();
		return new NewReleaseMovie(title, price);
	}

}
