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

        Set<Character> set = new HashSet<Character>();//a hashset to store all the characters in the string
        if(str==null)
            System.out.println("Empty string not allowed");
        else {

            for (char c : str.toUpperCase().toCharArray()) {
                if (Character.isLetter(c))
                    set.add(c);
            }

        }
        return (set.size() == 26);
    }

}
