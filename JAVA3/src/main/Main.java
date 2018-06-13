/**Write a java function that will ping any host ( given as input ) and computes the median of
 * the time taken to ping. Use the system ping utility, do not use any deprecated methods.
 */
package main;
import solution.PingHost;
import java.io.IOException;
import java.util.Scanner;
/**
 * Main class
 */
public class  Main{
    /**
     * Main function that takes hostname and number of pings from user and print the median time.
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Host address");
        String ip=input.next();
        System.out.println("Enter number of times to ping");
        int num;
        num = Integer.parseInt(input.next());
        System.out.printf("Pinging %s%n", ip);
        PingHost p=new PingHost();
        p.ping(ip,num);
    }
}