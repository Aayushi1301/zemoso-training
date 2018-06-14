package main;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import solution.KYCDateRange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
/**
 * Main Class
 * Prints the allowable form date to fill the KYC form
 */
public class Main {
    /**
     * Main Method that takes input from user which is the signup date and the current date in a particular format.
     * It prints the range of form date for filling the KYC form
     * @param args no use
     */
    public static void main(String[] args) throws ParseException, java.text.ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));Scanner input=new Scanner(System.in);
        String s=null;
        System.out.println("Enter signup date and current date in \'dd-mm-yyyy\' dateform separated by space");
        if(args.length==2)
        {
               s=args[0]+" "+args[1];
        }
        else {
            s = br.readLine();
        }
        if(s.matches("^\\d+\\-\\d+\\-\\d+[ ]+\\d+\\-\\d+\\-\\d+$")) {
            String[] dates = s.split(" ");
            KYCDateRange form = new KYCDateRange(dates[0], dates[1]);

            if (form.validSignupDate()) {
                Date anniv = form.AnniversaryDate();
                System.out.println("You can file your KYC for dates: " + form.generateFormDateRange(anniv));
            } else {
                System.out.println("You cannot file the KYC for the given dates");
            }
        }
        else
            System.out.println("Enter date in correct format.");
    }
}
