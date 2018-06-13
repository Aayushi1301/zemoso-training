package main;
import utils.Utils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * Continuously asks user to enter a regex pattern and prints matching files in home directory
     * @param args not used
     * @throws IOException can throw this exception
     */
    public static void main(String args[])throws IOException {

        String s;
        Scanner input = new Scanner(System.in);
        solution.FileSearchInDirectory fileojbect = new solution.FileSearchInDirectory();
        do{
            boolean found;
            System.out.println("Enter java regular expression to be matched with file name");
            System.out.println("Enter \"exit\" to exit");
            s=input.next();
            String directory=File.separatorChar+System.getProperty("user.home");
            found=fileojbect.findFiles(s, directory);
            List<File> filesearches;
            filesearches=fileojbect.getmResultArray();
            if(!found){
                System.out.println("No result found!");
            }
            else{
                for(File file:filesearches){
                    System.out.println("Found:  "+file);
                }
            }
            fileojbect.clear();
        }while(!Utils.shouldExit(s));
    }
}
