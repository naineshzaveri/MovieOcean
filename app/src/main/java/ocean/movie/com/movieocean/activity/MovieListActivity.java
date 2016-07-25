package ocean.movie.com.movieocean.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import ocean.movie.com.movieocean.R;
import ocean.movie.com.movieocean.adapters.MoviePosterAdapter;
import ocean.movie.com.movieocean.models.MovieModel;

;

public class MovieListActivity extends ocean.movie.com.movieocean.base.BaseActivity implements ocean.movie.com.movieocean.MovieManager.MovieValueListener {

    private android.support.v7.widget.RecyclerView.Adapter mAdapter;
    private android.support.v7.widget.RecyclerView mRecyclerView;
    private final int NO_OF_COLUMNS = 2;
    private android.widget.ProgressBar mProgress;
    private android.widget.TextView txtEmptyView;
    private java.util.ArrayList<MovieModel> modelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ocean.movie.com.movieocean.R.layout.activity_home);
        setTitle(getResources().getString(ocean.movie.com.movieocean.R.string.movie_list));

        init();

        getMovieList();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rclPatientDetails);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        txtEmptyView = (TextView) findViewById(R.id.txtEmptyView);
    }

    private void setMoviePosterAdapter() {

        if (modelArrayList != null && modelArrayList.size() > 0) {
            if (mAdapter == null) {
                mAdapter = new MoviePosterAdapter(MovieListActivity.this, modelArrayList);
                mRecyclerView.setAdapter(mAdapter);
            } else {
                mAdapter.notifyDataSetChanged();
            }
            mRecyclerView.setVisibility(android.view.View.VISIBLE);
            txtEmptyView.setVisibility(android.view.View.GONE);
        } else {
            mRecyclerView.setVisibility(android.view.View.GONE);
            txtEmptyView.setVisibility(android.view.View.VISIBLE);
        }

        setGridProperties();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == ocean.movie.com.movieocean.R.id.action_high_rate) {
            getHighestRatedMovies();
        } else if (id == ocean.movie.com.movieocean.R.id.action_popluar) {
            getPopularMovies();
        }

        return true;
    }

    private void setGridProperties() {
        mRecyclerView.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this,
                NO_OF_COLUMNS, //The number of Columns in the grid
                android.support.v7.widget.LinearLayoutManager.VERTICAL,
                false));
        int spanCount = NO_OF_COLUMNS; // 2 columns
        int spacing = 15; // 5px
        boolean includeEdge = true;
        mRecyclerView.addItemDecoration(new ocean.movie.com.movieocean.utils.GridSpacingItemDecoration(spanCount, spacing, includeEdge));
    }

    @Override
    public void onReturnMovieList(java.util.List<ocean.movie.com.movieocean.models.MovieModel> movieModels) {

        this.modelArrayList.clear();
        this.modelArrayList.addAll(movieModels);
        showProgress(false);
        setMoviePosterAdapter();
    }

    @Override
    public void onReturnError(com.android.volley.VolleyError error) {

        showProgress(false);
        android.widget.Toast.makeText(this, getResources().getString(R.string.error_fetching_data), android.widget.Toast.LENGTH_SHORT).show();
        setMoviePosterAdapter();

    }

    private void showProgress(boolean show) {
        if (show) {
            mProgress.setVisibility(android.view.View.VISIBLE);
            mRecyclerView.setVisibility(android.view.View.GONE);

        } else {
            mProgress.setVisibility(android.view.View.GONE);
            mRecyclerView.setVisibility(android.view.View.VISIBLE);
        }
    }

    private void getMovieList() {
        if (ocean.movie.com.movieocean.utils.NetworkUtil.checkNetworkAvailable(this)) {
            showProgress(true);
            ocean.movie.com.movieocean.MovieManager.getInstance().getMovieList(this);

        } else {
            showProgress(false);
            android.widget.Toast.makeText(this, getResources().getString(R.string.error_no_internet), android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private void getPopularMovies() {
        if (ocean.movie.com.movieocean.utils.NetworkUtil.checkNetworkAvailable(this)) {
            showProgress(true);
            ocean.movie.com.movieocean.MovieManager.getInstance().getMostPopularMovies(this);

        } else {
            showProgress(false);
            android.widget.Toast.makeText(this, getResources().getString(R.string.error_no_internet), android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private void getHighestRatedMovies() {
        if (ocean.movie.com.movieocean.utils.NetworkUtil.checkNetworkAvailable(this)) {
            showProgress(true);
            ocean.movie.com.movieocean.MovieManager.getInstance().getHighestRatedMovies(this);

        } else {
            showProgress(false);
            android.widget.Toast.makeText(this, getResources().getString(R.string.error_no_internet), android.widget.Toast.LENGTH_SHORT).show();
        }
    }
}
