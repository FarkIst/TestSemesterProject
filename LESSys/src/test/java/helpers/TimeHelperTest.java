package helpers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static helpers.TimeHelper.isTimeBetween;
import static helpers.TimeHelper.getLast6Semesters;

public class TimeHelperTest {

    @Test
    public void isTimeBetweenFunctionality() {
        Calendar before = new GregorianCalendar(2010,1,28,13,24,56);
        Calendar after = new GregorianCalendar(2013,1,28,13,24,56);
        Calendar now = new GregorianCalendar(2011,1,28,13,24,56);

        Assert.assertEquals(isTimeBetween(before, after, now), true);

        Calendar before2 = new GregorianCalendar(2012,1,28,13,24,56);
        Calendar after2 = new GregorianCalendar(2013,1,28,13,24,56);
        Calendar now2 = new GregorianCalendar(2011,1,28,13,24,56);
        Assert.assertEquals(isTimeBetween(before2, after2, now2), false);
    }

    @Test
    public void getLast6SemestersFunctionality() {
        Calendar[][] customList = getLast6Semesters();

        Assert.assertEquals(customList.length, 6);
        Assert.assertEquals(customList[1].length, 2);
    }
}