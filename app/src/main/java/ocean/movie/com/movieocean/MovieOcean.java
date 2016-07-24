package ocean.movie.com.movieocean;

/**
 * Created by naineshzaveri on 24/07/16.
 */
public class MovieOcean extends android.app.Application {

    public static final String TAG = MovieOcean.class.getSimpleName();

    private static MovieOcean movieOcean;

    private com.android.volley.RequestQueue mRequestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        movieOcean = this;
    }
    public static synchronized MovieOcean getInstance() {
        return movieOcean;
    }

    public com.android.volley.RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(com.android.volley.Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(android.text.TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(com.android.volley.Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
