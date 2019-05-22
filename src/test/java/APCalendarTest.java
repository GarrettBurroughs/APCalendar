import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.JUnit4;

public class APCalendarTest {
    @Test
    public void testCalendar(){
        Assert.assertEquals(APCalendar.dayOfWeek(3, 1, 2017), 3);
        Assert.assertEquals(APCalendar.dayOfWeek(3, 1, 1920), 1);
        Assert.assertEquals(APCalendar.numberOfLeapYears(1000, 2000), 243);
    }
}
