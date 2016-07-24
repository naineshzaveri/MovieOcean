package ocean.movie.com.movieocean;
import ocean.movie.com.movieocean.models.MovieModel;
/**
 * Created by naineshzaveri on 24/07/16.
 */
public class MovieManager {

    public interface MovieValueListener {

        void onReturnMovieList(java.util.List<MovieModel> movieModels, int type);

        //void onReturnError(VolleyError error, int type);
    }


    private android.content.Context mContext;
    private MovieValueListener movieValueListener;
    private java.util.List<MovieModel> arrAddressDetails = new java.util.ArrayList<>();

    private static MovieManager mMovieManager;

    public static MovieManager getInstance() {
        if (null == mMovieManager) {
            mMovieManager = new MovieManager();
            return mMovieManager;
        }
        return mMovieManager;
    }
}
