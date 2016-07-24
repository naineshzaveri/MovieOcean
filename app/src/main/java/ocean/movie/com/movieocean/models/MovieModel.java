package ocean.movie.com.movieocean.models;

/**
 * Created by naineshzaveri on 23/07/16.
 */
public class MovieModel implements java.io.Serializable{

    private String movieTitle;
    private float movieRating;
    private String moviewPosterUl;
    private String synopsis;
    private String userRating;
    private String releaseDate;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }

    public String getMoviewPosterUl() {
        return moviewPosterUl;
    }

    public void setMoviewPosterUl(String moviewPosterUl) {
        this.moviewPosterUl = moviewPosterUl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
