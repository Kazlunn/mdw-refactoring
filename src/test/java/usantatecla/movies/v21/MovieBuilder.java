package usantatecla.movies.v21;

public class MovieBuilder {

	private String title;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public ChildrenMovie buildChildrenMovie() {
		return new ChildrenMovie(title);
	}
	
	public RegularMovie buildRegularMovie() {
		return new RegularMovie(title);
	}
	
	public NewReleaseMovie buildNewReleaseMovie() {
		return new NewReleaseMovie(title);
	}

}
