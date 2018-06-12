package test;
import Solution.FileSearchInHomeDirectory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SampleTest {

    public FileSearchInHomeDirectory p;
    @Before
    public void init(){
        p = new FileSearchInHomeDirectory();
    }
    @After
    public void print(){
        System.out.println(p.getmResultArray());
    }
    //Multiple tests as new object required for every search.
    @Test
    public void findFilesTest1(){
        assertTrue("Check file path",p.findFiles(".*\\.java","/home"));
    }
    @Test
    public void findFilesTest2(){
        assertFalse("Check file path",p.findFiles("\tr]esD..","/home"));

    }
    @Test
    public void findFilesTest3(){
        assertFalse("Check file path",p.findFiles("tr]esD..","/home"));
    }
    @Test
    public void findFilesTest4()throws Exception{
        assertFalse("Check file path",p.findFiles(null,null));
    }
    @Test
    public void findFilesTest5(){
        assertFalse("Check file path",p.findFiles("","/home/zemoso"));
    }

    @Test
    public void findFilesTest6(){
        assertTrue("Check file path",p.findFiles("[tr]esD..","/home"));
    }
    @Test
    public void findFilesTest7() throws Exception {
        assertFalse("Check file path",p.findFiles("...",null));
    }

}
