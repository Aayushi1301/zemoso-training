package test;

import org.junit.Test;
import solution.KYCDateRange;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
/**
 * Test class to test the main class.
 */
public class KYCTest {
    private KYCDateRange obj;
    private Date dt = new Date();
    private Date anniv=new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    public void validSignupDateTest()throws ParseException{
        //the format is being checked in the main function so null cases wont occur
        obj = new KYCDateRange("01-01-2001","01-03-2013");
        assertTrue(obj.validSignupDate());
        obj = new KYCDateRange("01-01-2001","01-03-2013");
        assertTrue(obj.validSignupDate());
        obj = new KYCDateRange("01-01-2001","12-03-1013");
        assertFalse(obj.validSignupDate());
        obj = new KYCDateRange("04-13-2001","01-01-2002");
        assertFalse(obj.validSignupDate());
        obj = new KYCDateRange("0-0-0","1-1-1");
        assertTrue(obj.validSignupDate());
        obj = new KYCDateRange("1-1-2001","01-01-2001");
        assertTrue(obj.validSignupDate());
    }

    @Test
    public void anniversaryDateTest()throws ParseException {
        dt=sdf.parse("01-01-2013");
        obj = new KYCDateRange("01-01-2001","01-03-2013");
        assertEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("01-01-2014");
        obj = new KYCDateRange("1-1-2014"," 31-1-2014");
        assertEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("05-01-2018");
        obj = new KYCDateRange("5-1-2012","5-1-2018");
        assertEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("05-01-2018");
        obj = new KYCDateRange("5-1-2012","5-0-2018");
        assertNotEquals(obj.AnniversaryDate(),dt);
        dt=sdf.parse("01-02-2017");
        obj = new KYCDateRange("1-2-2012","1-1-2018");
        assertEquals(obj.AnniversaryDate(),dt);
    }

    @Test
    public void generateFormDateRangeTest() throws ParseException {
        //validation carried out so input dates are valid
        obj=new KYCDateRange("1-1-2014","31-1-2014");
        assertEquals("01-01-2014 to 31-01-2014",obj.generateFormDateRange(obj.AnniversaryDate()));
        obj=new KYCDateRange("5-1-2012","5-1-2018");
        assertEquals("06-12-2017 to 05-01-2018",obj.generateFormDateRange(obj.AnniversaryDate()));
        obj=new KYCDateRange("05-10-1994","05-10-1994");
        assertEquals("05-10-1994 to 05-10-1994",obj.generateFormDateRange(obj.AnniversaryDate()));
        obj=new KYCDateRange("05-10-1994","05-10-2001");
        assertEquals("05-09-2001 to 05-10-2001",obj.generateFormDateRange(obj.AnniversaryDate()));
    }
}
