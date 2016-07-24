package ocean.movie.com.movieocean.utils;

/**
 */

public class BitmapUtils {


    public static void setUrlImageUsingPicasso(android.content.Context context, String imagePath, android.widget.ImageView imageView, final android.widget.ProgressBar progressBar) {
        progressBar.setVisibility(android.view.View.VISIBLE);
        String imageUrl = ocean.movie.com.movieocean.helper.WebHelper.RequestUrl.IMAGE_URL + imagePath;
        try {
            com.squareup.picasso.Picasso.with(context).load(imageUrl).error(android.R.drawable.stat_notify_error).into(imageView, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(android.view.View.GONE);
                }
                @Override
                public void onError() {
                    progressBar.setVisibility(android.view.View.GONE);
                }
            });;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMovieThumbail(final android.content.Context context, String imagePath, final android.widget.ImageView imageView){
        String imageUrl = ocean.movie.com.movieocean.helper.WebHelper.RequestUrl.IMAGE_URL+imagePath;
        com.squareup.picasso.Picasso.with(context).load(imageUrl).into(new com.squareup.picasso.Target(){

            @android.annotation.TargetApi(android.os.Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onBitmapLoaded(android.graphics.Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom from) {
                imageView.setBackground(new android.graphics.drawable.BitmapDrawable(imageView.getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(final android.graphics.drawable.Drawable errorDrawable) {
                android.util.Log.d("TAG", "FAILED");
            }

            @Override
            public void onPrepareLoad(final android.graphics.drawable.Drawable placeHolderDrawable) {
                android.util.Log.d("TAG", "Prepare Load");
            }
        });
    }

}
