package solution;

import java.util.ArrayList;
import java.util.Iterator;

public class Human {
    private String name;
    private ArrayList<Dog> myDogs = new ArrayList<Dog>();

    public Human(String name) {
        this.name = name;
    }

    public void adoptDog(Dog dog) {
        myDogs.add(dog);
    }

    public int currentNumOfDogs() {
        return myDogs.size();
    }

    public void listmydogs() {
        Iterator it = myDogs.iterator();

        while (it.hasNext()) {

            Dog currentDog = (Dog) it.next();

            System.out.println(currentDog.getName());
        }
    }
    public void OrderDogsTospeak(){
        Iterator it = myDogs.iterator();

        while (it.hasNext()){

            Dog currentDog = (Dog)it.next();

            System.out.println(currentDog.getName() + ": " );
            currentDog.speak();
        }
    }
}
