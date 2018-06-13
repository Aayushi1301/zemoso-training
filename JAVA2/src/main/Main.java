package main;
import solution.StringContainsAllLettersOfAlphabet;
import java.util.Scanner;
/**
 * Main class.
 * Program to calculate whether the input by the user contains all letters from a-z
 */
public class Main {
    /**
     * Main function that takes input
     * @param args not used
     */
    public static void main(String[] args) {


        String str;
        StringContainsAllLettersOfAlphabet stringObj=new StringContainsAllLettersOfAlphabet();
        System.out.println("enter the string");
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
        if(stringObj.check(str))
            System.out.println("The string contains all letters from a-z case insensitive");
        else
            System.out.println("The string does not contain all letters from a-z");

    }
}
