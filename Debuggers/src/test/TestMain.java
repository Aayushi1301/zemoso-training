package test;
import org.junit.Test;
import solution.Dog;
import solution.Human;
import static junit.framework.Assert.assertEquals;

public class TestMain {
    @Test
    public  void testDogspeaks(){
        Dog d=new Dog("tuffy");
        assertEquals("Dog speaks  method failed",d.speak(),5);


    }
    @Test
    public void  testHumanCurrentDogs(){
        Human h=new Human("Jim");
        Dog d=new Dog("Doofy");
        h.adoptDog(d);
        assertEquals("Testing number of dogs failed",h.currentNumOfDogs(),1);
    }
}
