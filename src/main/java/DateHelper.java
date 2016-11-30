package main.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Vo4ik on 26.11.2016.
 */
public class DateHelper {

    private Calendar cur = new GregorianCalendar();
    private SimpleDateFormat formatStart = new SimpleDateFormat("dd.MM.YYYY HH:mm");
    private SimpleDateFormat formatEnd = new SimpleDateFormat("dd HH:mm");

    private long start = 0, end = 0;

    public String getFormattedStartDate(){
        cur.add(Calendar.YEAR, -1500);
        start = cur.getTimeInMillis();
        return formatStart.format(cur.getTime());
    }

    public void skipTime(){
        cur.add(Calendar.MINUTE, +45);
    }

    public String getFormattedDiff(){ //это вообще неправильно, проверь
        //Почему неправильно явроде протестировал выводит все корректно в ручном режиме проверял
        end = cur.getTimeInMillis();
        cur.clear();
        cur.add(Calendar.MILLISECOND, (int)(end - start));
        return formatEnd.format(cur.getTime());
    }
}
