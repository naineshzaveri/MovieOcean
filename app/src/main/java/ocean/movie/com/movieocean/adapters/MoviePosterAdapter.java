package ocean.movie.com.movieocean.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ocean.movie.com.movieocean.R;
import ocean.movie.com.movieocean.models.MovieModel;

;

/**
 * Created by naineshzaveri on 23/07/16.
 */
public class MoviePosterAdapter extends Adapter<ViewHolder> {

    ArrayList<MovieModel> arrMovies;
    private Context mContext;

    public static class MoviePosterViewHolder extends RecyclerView.ViewHolder {
        public TextView txtMovieName;
        public ImageView ivMoviePoster;
        public CardView cvContent;
        public android.widget.ProgressBar progressBar;
        public MoviePosterViewHolder(android.view.View v) {
            super(v);
            txtMovieName = (TextView) v.findViewById(R.id.txtMovieName);
            ivMoviePoster = (ImageView) v.findViewById(R.id.ivPoster);
            cvContent = (CardView) v.findViewById(R.id.cvMoviePoster);
            progressBar = (android.widget.ProgressBar) v.findViewById(ocean.movie.com.movieocean.R.id.progressBar);
        }
    }

    public MoviePosterAdapter(android.content.Context context, ArrayList<MovieModel> arrMovies) {
        super();
        this.mContext = context;
        this.arrMovies = arrMovies;
    }

    @Override
    public void onBindViewHolder(final android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int position) {

         MoviePosterAdapter.MoviePosterViewHolder holder = (MoviePosterAdapter.MoviePosterViewHolder) viewHolder;
         MovieModel movieModel = arrMovies.get(position);
        holder.txtMovieName.setText(movieModel.getTitle());
       ocean.movie.com.movieocean.utils.BitmapUtils.setUrlImageUsingPicasso(mContext, movieModel.getPoster_path(), holder.ivMoviePoster, holder.progressBar);
        holder.cvContent.setOnClickListener(new NextActivityListener(movieModel));
    }

    @Override
    public int getItemCount() {
        return arrMovies.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_movie_poster, viewGroup, false);
        return new MoviePosterAdapter.MoviePosterViewHolder(view);
    }

    class NextActivityListener implements android.view.View.OnClickListener{
        MovieModel movieModel;

        NextActivityListener(MovieModel movieModel){
            this.movieModel = movieModel;
        }
        @Override
        public void onClick(android.view.View v) {
            android.content.Intent intent = new android.content.Intent(mContext, ocean.movie.com.movieocean.activity.MovieDetailActivity.class);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putSerializable(ocean.movie.com.movieocean.utils.BundleKeys.KEY_MOVIE, movieModel);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
    }
}

