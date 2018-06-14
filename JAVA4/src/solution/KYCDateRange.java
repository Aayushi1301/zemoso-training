package solution;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Carries out all calculation for range of form date filling.
 */
public class KYCDateRange{
    private final SimpleDateFormat dateform =new SimpleDateFormat("dd-MM-yyyy");
    private Date signup;
    private Date current;
    /**
     * Parameterised constructor
     * @param signupdate signup date of customer
     * @param currdate the current date when customer if filling the form
     */
    public KYCDateRange(String signupdate,String currdate)  {
        try {
            signup= dateform.parse(signupdate);
            current = dateform.parse(currdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * Checks whether the signup and current date entry is valid
     * @return true if signup date is before current date else false
     */
    public boolean validSignupDate() {
        return signup.compareTo(current) <= 0;
    }

    /**
     * Calculates the relevent anniversary date for finding the form date range.
     * @return Date of closest anniversary
     */
    public Date AnniversaryDate() {

        Calendar ani = Calendar.getInstance();
        ani.setTime(signup);

        Calendar cur = Calendar.getInstance();
        cur.setTime(current);
        cur.add(Calendar.DATE,30);
        Date i1=cur.getTime();
        Date i2=ani.getTime();
        //System.out.println(i1+""+i2);
        ani.set(Calendar.YEAR,cur.get(Calendar.YEAR));
        if(ani.after(cur)){
            ani.add(Calendar.YEAR,-1);
        }
        Date anniversary=ani.getTime();
        return anniversary;//anni is used to convert calender to Date which is return type

    }

    /**
     * Generates the range in which form date can lie
     * @param anniv Closest anniversary
     */
    public String generateFormDateRange(Date anniv) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(anniv);
        cal.add(Calendar.DATE, -30);
        Date startani = cal.getTime();
        cal.add(Calendar.DATE, 60);
        Date endani = cal.getTime();
        if(endani.after(current)) {
            endani=current;
        }
        if(startani.before(signup)){
            startani=signup;
        }
        return (dateform.format(startani)+" to "+dateform.format(endani));
    }
}