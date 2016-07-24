package ocean.movie.com.movieocean.utils;

/**
 */

public class BitmapUtils {


    public static void setUrlImageUsingPicasso(android.content.Context activity, String imagePath, android.widget.ImageView imgPrescription) {

        try {
            com.squareup.picasso.Picasso.with(activity).load(imagePath).error(android.R.drawable.stat_notify_error).noFade().centerCrop().into(imgPrescription);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
