package ocean.movie.com.movieocean.utils;

/**
 * Created by naineshzaveri on 24/07/16.
 */
public class Utility {

    public static String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
    public static String APP_DATE_FORMAT = "dd MMM yyyy";

    public static String convertDatFormat(String serverdate, String originalFormat, String convertedDateFormat) {
        try {
            java.text.SimpleDateFormat formatOriginal = new java.text.SimpleDateFormat(originalFormat);
            java.text.SimpleDateFormat formatConvert = new java.text.SimpleDateFormat(convertedDateFormat);
            java.util.Date date;

            date = formatOriginal.parse(serverdate);
            return formatConvert.format(date);
        } catch (java.text.ParseException e) {
           return "";
        }
    }
}
