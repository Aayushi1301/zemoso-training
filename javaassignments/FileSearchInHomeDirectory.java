/* Create an java program to search through the home directory and look for files that match
 * a regular expression. The program should be able to take inputs repeatedly and should print
 * out full absolute path of the matching files found.
 */
import java.io.File;
import java.util.*;
import java.util.regex.*;

public class FileSearchInHomeDirectory{
   private String fileName; //file to search for
   static private ArrayList<String> result = new ArrayList<String>(); //Create an ArrayList of type string to store the final path 
   
   //getter function for filename
   public String getFileName() {
      return fileName;
   }
   //setter function for filename
   public void setFileName(String fileName) {
      this.fileName = fileName;
   }
   /**
   * getter function to get the result that is list of all matching files
   * @return Returns list of all matching files.
   */
   public List<String> getResult() {
      return result;
   }

   public static void main(String[] args) {

      //create an obect of this class  
      FileSearchInHomeDirectory fileSearch = new FileSearchInHomeDirectory();
      
      //we create an object of a Scanner class which is define in import java.util.scanner package. scanner class allows user to take input form console.
      //System.in is passed as parameter in scanner class will tell to java compiler system input will be provided through console(keyboard).
      Scanner input = new Scanner(System.in);

      while(true){ // user input
      	 System.out.println("Enter java regular expression to be matched with file name");
         System.out.println("Enter \"exit\" to exit");
         //uses the nextInt Method of "input" object, which allows you to enter some text and it will be parsed into an integer. 
         String name=input.next();
         //if user wishes to exit from terminal
         if (name.equals("exit"))break;
         result.clear(); //clear out previously filled out results for previous inputs
         int count = 0;  //to count the number of occurences of the file
         String homeDir = System.getProperty("user.home");
         fileSearch.searchDirectory(new File(homeDir), name);

         count = fileSearch.getResult().size();

         if(count == 0){
            System.out.println("\nNo result found!");
         }
         else{
            System.out.println("\nFound " + count + " result!\n");
            for(String matched : fileSearch.getResult()){
               System.out.println("Found : " + matched);
            }
         }
      }//end of while
   }

   //checks whether directory is legal or not
   public void searchDirectory(File directory, String fileName){
      setFileName(fileName);
      if (directory.isDirectory()) {
         search(directory);
      }
      else{
         System.out.println(directory.getAbsoluteFile() + " is not a directory!");
      }
   }

   /**
     * Prints the complete path if file matching regex is found. It searches in all directories and
     * subdirectories recursively.
     * @param file The regular expression that has to be matched
     */
   private void search(File file){
      if (file.isDirectory()){
         if (file.canRead()){
            for (File temp : file.listFiles()){
               if (temp.isDirectory()) {
                  search(temp);
               }
               //if it's a file and not a directory
               else {
                  //check regex, if true, then add it to results
                  String g = getFileName();
                  Pattern p = Pattern.compile(g);
                  Matcher m = p.matcher(temp.getName());  
                  boolean b = m.matches();  
                  if (b){
                     result.add(temp.getAbsolutePath());
                  }
               }
            }
         }
         else{
            System.out.println(file.getAbsoluteFile() + "Permission Denied");
         }
      }
   }
}