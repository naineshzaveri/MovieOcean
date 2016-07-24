package ocean.movie.com.movieocean.helper;

/**
 * Web-service related constants
 */
public interface WebHelper {

    String API_KEY = "5a03ac7353951b9d36360e3609c0d176";

    public interface RequestUrl {

        String BASE_URL = "http://private-a5ac3-themoviedb.apiary-proxy.com/3/";
        String IMAGE_URL = "http://image.tmdb.org/t/p/w500/";
        String MOVIE_LIST = BASE_URL + "discover/movie?";
    }

    /**
     * Web-service Params fields
     */
    public interface Params {
        String API_KEY = "api_key";
    }

    public interface HeaderParams {
        String ACCEPT = "accept";
    }
}
