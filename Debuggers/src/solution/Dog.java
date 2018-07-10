package solution;

public class Dog {
    public String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int speak() {
        int i,times = 0;

        System.out.print("~>");

        for (i = 0; i < name.length(); i++) {
            System.out.print("woof");
            times++;

            if (i < name.length() - 1) {
                System.out.print(",");
            }
        }
        return (times);
    }
}
