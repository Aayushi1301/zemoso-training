package test;
import solution.FileSearchInDirectory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FindPathTest {

    public FileSearchInDirectory p;
    @Before
    public void init(){
        p = new FileSearchInDirectory();
    }
    @After
    public void print(){
        System.out.println(p.getmResultArray());
    }
    //Multiple tests as new object required for every search.
    @Test
    public void findFilesTest1(){

        assertTrue("Check file path",p.findFiles(".*\\.java","/home"));
        assertFalse("Check file path",p.findFiles("\tr]esD..","/home"));
        assertFalse("Check file path",p.findFiles("tr]esD..","/home"));
        assertFalse("Check file path",p.findFiles(null,null));
        assertFalse("Check file path",p.findFiles("","/home/zemoso"));
        assertTrue("Check file path",p.findFiles("[tr]esD..","/home"));
        assertFalse("Check file path",p.findFiles("...",null));

    }




}
