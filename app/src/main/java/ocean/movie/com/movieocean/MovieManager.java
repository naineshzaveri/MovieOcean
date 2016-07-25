package ocean.movie.com.movieocean;

import ocean.movie.com.movieocean.models.MovieModel;

/**
 * Created by naineshzaveri on 24/07/16.
 */
public class MovieManager {
    private static String TAG = MovieManager.class.getName();
    com.android.volley.Request.Priority priority = com.android.volley.Request.Priority.HIGH;

    public interface MovieValueListener {

        void onReturnMovieList(java.util.List<MovieModel> movieModels);

        void onReturnError(com.android.volley.VolleyError error);
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

    public void getMovieList(final MovieValueListener movieValueListener) {

        this.movieValueListener = movieValueListener;
        final String MOVIEW_URL = ocean.movie.com.movieocean.helper.WebHelper.RequestUrl.MOVIE_LIST + ocean.movie.com.movieocean.helper.WebHelper.Params.API_KEY + "=" + ocean.movie.com.movieocean.helper.WebHelper.API_KEY;

        com.android.volley.toolbox.StringRequest strReq = new com.android.volley.toolbox.StringRequest(com.android.volley.Request.Method.GET,
                MOVIEW_URL, new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                android.util.Log.d(TAG, response.toString());
                 com.google.gson.Gson gson = new com.google.gson.Gson();
                if(movieValueListener != null){
                    movieValueListener.onReturnMovieList(gson.fromJson(response, ocean.movie.com.movieocean.models.MovieResponseModel.class).getResults());
                }
            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(com.android.volley.VolleyError error) {
                if(movieValueListener != null){
                    movieValueListener.onReturnError(error);
                }

            }
        }) {
            @Override
            public Priority getPriority() {
                return priority;
            }

        };
        // Adding request to request queue
        ocean.movie.com.movieocean.MovieOcean.getInstance().addToRequestQueue(strReq, TAG);
    }

    public void getHighestRatedMovies(final MovieValueListener movieValueListener) {

        this.movieValueListener = movieValueListener;
        final String MOVIEW_URL = ocean.movie.com.movieocean.helper.WebHelper.RequestUrl.MOVIE_LIST + ocean.movie.com.movieocean.helper.WebHelper.Params.API_KEY + "=" + ocean.movie.com.movieocean.helper.WebHelper.API_KEY +
                "&"+ ocean.movie.com.movieocean.helper.WebHelper.HeaderParams.SORT_BY + "="+ocean.movie.com.movieocean.helper.WebHelper.PARAMS_VALUE.SORT_BY_HIGEST_RATING;

        com.android.volley.toolbox.StringRequest strReq = new com.android.volley.toolbox.StringRequest(com.android.volley.Request.Method.GET,
                MOVIEW_URL, new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                android.util.Log.d(TAG, response.toString());
                com.google.gson.Gson gson = new com.google.gson.Gson();
                if(movieValueListener != null){
                    movieValueListener.onReturnMovieList(gson.fromJson(response, ocean.movie.com.movieocean.models.MovieResponseModel.class).getResults());
                }
            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(com.android.volley.VolleyError error) {
                if(movieValueListener != null){
                    movieValueListener.onReturnError(error);
                }

            }
        }) {
            @Override
            public Priority getPriority() {
                return priority;
            }

        };
        // Adding request to request queue
        ocean.movie.com.movieocean.MovieOcean.getInstance().addToRequestQueue(strReq, TAG);
    }


    public void getMostPopularMovies(final MovieValueListener movieValueListener) {

        this.movieValueListener = movieValueListener;
        final String MOVIEW_URL = ocean.movie.com.movieocean.helper.WebHelper.RequestUrl.MOVIE_LIST + ocean.movie.com.movieocean.helper.WebHelper.Params.API_KEY + "=" + ocean.movie.com.movieocean.helper.WebHelper.API_KEY +
                "&"+ ocean.movie.com.movieocean.helper.WebHelper.HeaderParams.SORT_BY + "="+ocean.movie.com.movieocean.helper.WebHelper.PARAMS_VALUE.SORT_BY_POPULARITY;

        com.android.volley.toolbox.StringRequest strReq = new com.android.volley.toolbox.StringRequest(com.android.volley.Request.Method.GET,
                MOVIEW_URL, new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                android.util.Log.d(TAG, response.toString());
                com.google.gson.Gson gson = new com.google.gson.Gson();
                if(movieValueListener != null){
                    movieValueListener.onReturnMovieList(gson.fromJson(response, ocean.movie.com.movieocean.models.MovieResponseModel.class).getResults());
                }
            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(com.android.volley.VolleyError error) {

                if(movieValueListener != null){
                    movieValueListener.onReturnError(error);
                }
            }
        }) {
            @Override
            public Priority getPriority() {
                return priority;
            }

        };
        // Adding request to request queue
        ocean.movie.com.movieocean.MovieOcean.getInstance().addToRequestQueue(strReq, TAG);
    }



}
