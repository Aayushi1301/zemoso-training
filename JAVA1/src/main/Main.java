package main;
import Solution.FileSearchInHomeDirectory;
import Utils.utils;
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
        FileSearchInHomeDirectory path = new FileSearchInHomeDirectory();
        do{
            boolean found;
            System.out.println("Enter java regular expression to be matched with file name");
            System.out.println("Enter \"exit\" to exit");
            s=input.next();
            if (s.equals("exit"))break;
            char separator = File.separatorChar;
            String directory=separator+System.getProperty("user.home");
            found=path.findFiles(s, directory);
            List<File> filesearches;
            filesearches=path.getmResultArray();
            if(!found){
                System.out.println("No result found!");
            }
            else{
                for(File file:filesearches){
                    System.out.println("Found:  "+file);
                }
            }
            path.clear();
        }while(!utils.shouldExit(s));
    }
}
