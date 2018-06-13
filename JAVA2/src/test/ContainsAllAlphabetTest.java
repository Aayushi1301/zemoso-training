package test;
import org.junit.Test;
import solution.StringContainsAllLettersOfAlphabet;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Test class to test CheckAlphabets class
 */
public class ContainsAllAlphabetTest {
    private  StringContainsAllLettersOfAlphabet chk = new StringContainsAllLettersOfAlphabet();

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
    @Test
    public void checkerTest4() {
        String s=",,,,,,";
        assertFalse(chk.check(s));
    }
    @Test
    public void checkerTest5() {
        String s="12345";
        assertFalse(chk.check(s));
    }
    @Test
    public void checkerTest6() {
        String s="aaaaaaaaaa";
        assertFalse(chk.check(s));
    }

}
