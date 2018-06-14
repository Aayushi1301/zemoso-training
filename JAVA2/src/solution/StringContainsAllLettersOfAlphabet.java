package solution;
import java.util.HashSet;
import java.util.Set;
/**
 * Write a java function that checks if the input string contains all the letters of the
 * alphabet a-z (case-insensitive).
 * Time Complexity:
 * Worst Case-If all the elements in the HashSet have the same hash code (or a hash code leading to the same bucket)
 * the lookup for each letter will be O(n) and for n letters it will be O(n^2)
 * Best Case-With a correctly written hashCode and a normally distributed key sample, a lookup is O(1).
 * Space Complexity:O(n) where n is size of input
 */
public class StringContainsAllLettersOfAlphabet {
    /**
     * Checks whether input string contains all letters of an alphabet.
     * @param str The input string
     * @return true if contains all letters of alphabet, otherwise false
     */
    public boolean check(String str)
    {

        int count=0;
        int arr[] = new int[26];
        int i;
        boolean flag=false;
        str = str.replaceAll("[^a-zA-Z]", "");
        str.toLowerCase();
        if(str==null) {
            System.out.println("string can't be null");
        }
        else
            {
              if(str.length()==26) {
                for (i = 0; i < str.length(); i++) {
                    if (count == 26) {
                        flag = true;
                        break;
                    }
                    char k = str.charAt(i);
                    int j = (int) k - 'a';
                    if (arr[j] == 0) {
                        count++;
                        arr[j] = 1;
                    }
                }
              }
            else
                break;

        }
        return flag;
    }

}
