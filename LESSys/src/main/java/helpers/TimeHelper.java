package helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeHelper {

    public static boolean isTimeBetween(Calendar start, Calendar end, Calendar specified){
        return specified.after(start) && specified.before(end);
    }

    // SEM B: 1.9 - 21.12
    // SEM A: 1.1 - 1.5
    public static Calendar[][] getLast6Semesters() {
        Date today = new Date();
        Calendar timeNow = Calendar.getInstance();
        Calendar[][] semesterList = new Calendar[6][2];
        int startYear = timeNow.get(Calendar.YEAR);
        String semType = "a";
        timeNow.setTime(today);
        int currMonthDay = timeNow.get(Calendar.DAY_OF_MONTH);
        int currMonth = timeNow.get(Calendar.MONTH);
        int currYear = timeNow.get(Calendar.YEAR);
        if (currMonth < 4 || (currMonth == 4 && currMonthDay < 2) || (currMonth == 11 && currMonthDay > 21)) {
            startYear = currYear - 1;
            semType = "b";
        }
        for (int i = 0; i < 6; i++) {
            Calendar semFrom = GregorianCalendar.getInstance();
            Calendar semTo = GregorianCalendar.getInstance();
            if (semType == "a") {
                semFrom.set(currYear, 0, 1);
                semTo.set(currYear, 4, 1);
                currYear--;
                semType = "b";
            } else {
                semFrom.set(currYear, 8, 1);
                semTo.set(currYear, 11, 21);
                semType = "a";
            }
            semesterList[i][0] = semFrom;
            semesterList[i][1] = semTo;
        }
        return semesterList;
    }
}
