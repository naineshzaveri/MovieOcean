package ocean.movie.com.movieocean.activity;
/**
 * Created by naineshzaveri on 24/07/16.
 */
public class MovieDetailActivity extends ocean.movie.com.movieocean.base.BaseActivity {
private ocean.movie.com.movieocean.models.MovieModel movieModel;
    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ocean.movie.com.movieocean.R.layout.activity_moiewdetail);

        init();
        getBundleValues();
    }

    private void init(){

    }

    private void getBundleValues(){
        movieModel = (ocean.movie.com.movieocean.models.MovieModel) getIntent().getExtras().getSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE);
        setTitle(movieModel.getMovieTitle());
    }
}
