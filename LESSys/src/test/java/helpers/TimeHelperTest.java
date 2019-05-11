package helpers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static helpers.TimeHelper.getCurrentSemester;
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

    @Test
    public void getCurrentSemesterFunctionality() {
        Calendar timeNow = Calendar.getInstance();
        timeNow.set(Calendar.YEAR, 1991);
        timeNow.set(Calendar.DAY_OF_MONTH, 15);
        timeNow.set(Calendar.MONTH, 2);
        Calendar[] relSemester = getCurrentSemester(timeNow);

        Calendar firstDate = relSemester[0];
        Calendar secondDate = relSemester[1];

        Assert.assertEquals(firstDate.get(Calendar.MONTH), 8);
        Assert.assertEquals(firstDate.get(Calendar.DAY_OF_MONTH), 1);
        Assert.assertEquals(firstDate.get(Calendar.YEAR), 1991);

        Assert.assertEquals(secondDate.get(Calendar.MONTH), 11);
        Assert.assertEquals(secondDate.get(Calendar.DAY_OF_MONTH), 21);

        Calendar timeNow2 = Calendar.getInstance();
        timeNow2.set(Calendar.YEAR, 1991);
        timeNow2.set(Calendar.DAY_OF_MONTH, 15);
        timeNow2.set(Calendar.MONTH, 10);

        Calendar[] relSemester2 = getCurrentSemester(timeNow2);
        Calendar firstDate2 = relSemester2[0];
        Calendar secondDate2 = relSemester2[1];

        System.out.println(firstDate2.get(Calendar.MONTH));

        Assert.assertEquals(firstDate2.get(Calendar.MONTH), 0);
        Assert.assertEquals(firstDate2.get(Calendar.DAY_OF_MONTH), 1);
        Assert.assertEquals(firstDate2.get(Calendar.YEAR), 1992);

        Assert.assertEquals(secondDate2.get(Calendar.MONTH), 4);
        Assert.assertEquals(secondDate2.get(Calendar.DAY_OF_MONTH), 1);
    }

    @Test
    public void getCurrentDateFunctionality() {
        Date today = new Date();
        Calendar timeNow = Calendar.getInstance();
        timeNow.setTime(today);

        Calendar currDate = TimeHelper.getCurrentDate();

        Assert.assertEquals(currDate.get(Calendar.YEAR), timeNow.get(Calendar.YEAR));
        Assert.assertEquals(currDate.get(Calendar.DAY_OF_MONTH), timeNow.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(currDate.get(Calendar.MONTH), timeNow.get(Calendar.MONTH));
    }
}