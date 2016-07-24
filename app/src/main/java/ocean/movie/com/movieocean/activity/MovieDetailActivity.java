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
        setMovieData();

    }

    private void init(){

    }

    private void getBundleValues(){
        movieModel = (ocean.movie.com.movieocean.models.MovieModel) getIntent().getExtras().getSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE);
        setTitle(movieModel.getTitle());
    }

    private void setMovieData(){

        if(movieModel != null){
            ((android.widget.TextView)findViewById(ocean.movie.com.movieocean.R.id.txtReleaseDate)).setText(ocean.movie.com.movieocean.utils.Utility.convertDatFormat(movieModel.getRelease_date(), ocean.movie.com.movieocean.utils.Utility.YYYY_MM_DD_FORMAT, ocean.movie.com.movieocean.utils.Utility.APP_DATE_FORMAT));
            ((android.widget.TextView)findViewById(ocean.movie.com.movieocean.R.id.txtUserRatings)).setText(""+movieModel.getPopularity());
            ((android.widget.TextView)findViewById(ocean.movie.com.movieocean.R.id.txtSynopsis)).setText(""+movieModel.getOverview());
            ocean.movie.com.movieocean.utils.BitmapUtils.setMovieThumbail(this, movieModel.getPoster_path(), (android.widget.ImageView) findViewById(ocean.movie.com.movieocean.R.id.ivMovieImage));
        }
    }
}
