package test;
import org.junit.Before;
import org.junit.Test;
import solution.PingHost;
import static org.junit.Assert.*;
/**
 * Test class to test Main class
 */
public class PingTest {
    private PingHost p;
    @Before
    public void init(){
        p=new PingHost();
    }
    @Test
    public void pingTest12(){
        assertFalse(p.ping("AAAABBBBB",1));
    }
    @Test
    public void pingTest3(){
        assertTrue(p.ping("google.com",1));
    }
    @Test
    public void pingTest4(){
        assertTrue(p.ping("facebook.com",5));
    }
    @Test
    public void pingTest5(){
        assertFalse(p.ping("",1));
    }
    @Test
    public void pingTest6(){
        assertFalse(p.ping(null,1));
    }



}