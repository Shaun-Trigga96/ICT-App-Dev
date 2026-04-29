
package za.ac.cput;

/**
 * This is my movie.java class
 * @author  Thabiso Matsaba (220296006)
 */
public class Movie {
	
	private int movieId;
	private String movieTitle;
	private String movieDirector;
	private String movieGenre;

	public Movie(int movieId, String movieTitle, String movieDirector, String movieGenre) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieDirector = movieDirector;
		this.movieGenre = movieGenre;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	@Override
	public String toString() {
		return "Movie{" + "movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieDirector=" + movieDirector + ", movieGenre=" + movieGenre + '}';
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
