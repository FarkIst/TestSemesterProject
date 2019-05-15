package ParameterTests;

import helpers.TimeHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Calendar;

@RunWith(Parameterized.class)
public class CurrentSemesterParameterTest {
    private Calendar input;
    private Calendar expectedFrom;
    private Calendar expectedTo;

    @Parameterized.Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { setDate(1992,11,25), setDate(1993,0,1), setDate(1993, 4, 1) },
                { setDate(1995, 11, 22), setDate(1996, 0, 1 ), setDate(1996, 4, 1) },
                { setDate(2005, 3, 5), setDate(2005, 8,1), setDate(2005, 11, 21) },
                { setDate(2015, 6, 11), setDate(2015, 8,1), setDate(2015, 11,21) },
                { setDate(2020, 8, 1), setDate(2020, 8,1), setDate(2020, 11,21) },
                { setDate(2018, 7, 12), setDate(2018, 8, 1), setDate(2018,11,21) },
                { setDate(2011, 1,1), setDate(2011, 8, 1), setDate(2011, 11, 21) }
        });
    }

    public CurrentSemesterParameterTest(Calendar input, Calendar expectedFrom, Calendar expectedTo) {
        this.input = input;
        this.expectedFrom = expectedFrom;
        this.expectedTo = expectedTo;
    }

    private static Calendar setDate(int year, int month, int date){
        Calendar time = Calendar.getInstance();
        time.clear();
        time.set(year, month, date);
        return time;
    }

    @Test
    public void test() {
        Calendar[] testDate = TimeHelper.getCurrentSemester(input);
        Assert.assertEquals(expectedFrom, testDate[0]);
        Assert.assertEquals(expectedTo, testDate[1]);
    }

}
