package test;
import org.junit.Test;
import solution.stringContainsAllLettersOfAlphabet;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Test class to test CheckAlphabets class
 */
public class ContainsAllAlphabetTest {
    private  stringContainsAllLettersOfAlphabet chk = new stringContainsAllLettersOfAlphabet();

    @Test
    public void checkerTest1() {
        String s="QWERT7890YUIOPLKJHGF78,,,,DSAzxcvb,,n.'m    ..!@#$%^&*";
        assertTrue(chk.check(s));
    }
    @Test
    public void checkerTest2(){
        String s= "shfjfigk";
        assertFalse(chk.check(s));
    }
    @Test
    public void checkerTest3(){
        assertFalse(chk.check(null));
    }
}
