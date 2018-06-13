package solution;
import java.util.HashSet;
import java.util.Set;
/**
 * Write a java function that checks if the input string contains all the letters of the
 * alphabet a-z (case-insensitive).
 */
public class stringContainsAllLettersOfAlphabet {
    public boolean check(String str)
    {
        /**
         * Checks whether input string contains all letters of an alphabet.
         * @param str The input string
         * @return true if contains all letters of alphabet, otherwise false
         */
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
