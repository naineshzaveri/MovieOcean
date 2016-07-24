package ocean.movie.com.movieocean.models;
/**
 * Created by naineshzaveri on 24/07/16.
 */
public class MovieResponseModel {

    private int page;
    private java.util.ArrayList<MovieModel> results;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public java.util.ArrayList<MovieModel> getResults() {
        return results;
    }

    public void setResults(java.util.ArrayList<MovieModel> results) {
        this.results = results;
    }
}
