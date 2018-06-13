package main;
import solution.stringContainsAllLettersOfAlphabet;
import java.util.Scanner;
/**
 * Main class.
 * Program to calculate whether the input by the user contains all letters from a-z
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Main function that takes input
         * @param args not used
         * @throws IOException as using input stream for taking input from user
         */
        String str;
        stringContainsAllLettersOfAlphabet stringObj=new stringContainsAllLettersOfAlphabet();
        System.out.println("enter the string");
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
        if(stringObj.check(str))
            System.out.println("The string contains all letters from a-z case insensitive");
        else
            System.out.println("The string does not contain all letters from a-z");

    }
}
