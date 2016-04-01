package staticTests;

import geometry.Rectangle;

/**
 * Created by xworks.admin on 2/24/2016.
 */
public class StaticTests {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10,10);

        System.out.println(StaticMembers.getArea(rectangle));

        System.out.println(StaticMembers.name);

        StaticMembers testStatic1 = new StaticMembers();

        StaticMembers testStatic2 = new StaticMembers();

        System.out.println(testStatic1.name + " + "+ testStatic2.name);

        testStatic1.name = "changed";

        System.out.println(testStatic1.name + " + "+ testStatic2.name);
        






    }
}
