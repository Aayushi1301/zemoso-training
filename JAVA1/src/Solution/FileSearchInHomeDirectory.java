package Solution;
import java.io.File;
import java.util.*;
import java.util.regex.*;
public class FileSearchInHomeDirectory {

    private List<File> mResultArray =new ArrayList<>();

    /**
     * getter function to get the mResultArray that is list of all matching files
     * @return Returns list of all matching files.
     */
    public List<File> getmResultArray(){
        return mResultArray;
    }
    /**
     * Prints the complete path if file matching regex is found. It searches in all directories and
     * subdirectories recursively.
     * @param rgx The regular expression that has to be matched
     * @param directory The home directory where search is carried out
     */
    public boolean findFiles(String rgx, String directory){
        try{
            Pattern.compile(rgx);
        }catch (PatternSyntaxException |NullPointerException e){
            System.out.println("Enter valid Regex");
            return false;
        }
        try {
            File home = new File(directory);
            File[] fileslist = home.listFiles();
            if (fileslist!=null) {
                for (File file : fileslist) {
                    if (file.isFile()) {
                        if (file.getName().matches(rgx)) {
                            mResultArray.add(file);
                        }
                        //System.out.println(file);
                    } else if (file.isDirectory()) {
                        System.out.println("Searching directory ... " + file.getAbsolutePath());
                        findFiles(rgx, file.getAbsolutePath());
                    }
                }
            }
        }catch(NullPointerException e){
            System.out.println("Invalid Directory Name");
        }
        return (mResultArray.size()>0);
    }

    public void clear() {
        mResultArray.clear();
    }
}
