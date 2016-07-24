package ocean.movie.com.movieocean.base;

/**
 * Created by sumeet on 12/10/15.
 */
public class BaseFragment extends android.support.v4.app.Fragment {

    public android.widget.ProgressBar mProgressbar;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showProgress(boolean show) {
        if (show) {
            mProgressbar.setVisibility(android.view.View.VISIBLE);
        } else {
            mProgressbar.setVisibility(android.view.View.GONE);
        }
    }
}
