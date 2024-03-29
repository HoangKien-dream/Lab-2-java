package hashMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateTimeUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parseDateString(String strDateTime){
        try {
            return simpleDateFormat.parse(strDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Calendar.getInstance().getTime();
    }

    public static String formatDateToString(Date date){
        return simpleDateFormat.format(date);
    }

}
