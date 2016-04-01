import animals.*;
import geometry.*;
import utility.SqrtPrecalculated;

import java.time.LocalDateTime;

public class Startup {

  public static void main(String[] args) {
    //Dog.LUCKY_NUMBER;

    Cat gruicho = new Cat("Gruicho");
    Cat prokopi = new Cat("Prokopi");

    System.out.println(gruicho.getName());
    System.out.println(prokopi.getName());

    Dog[] dogs = { new Dog("Sharo"), new Dog("Rex"), new Dog() };

    Tail tail = null;
    dogs[1].play(tail);

    for (int i=0;i<dogs.length;i++) {
      System.out.println(dogs[i].bark());
    }

    Cat gruicho2 = new Cat("Gruicho", LocalDateTime.of(2012, 6, 12, 10, 30));
    System.out.println(gruicho2.getAge());

    Cat kitten = new Cat("baby");
    System.out.println(kitten.getAge());

    SqrtPrecalculated sqrtPrecalculated = null;
    final double square = SqrtPrecalculated.squares[100];
    System.out.println(sqrtPrecalculated.getSqrt(1000));

    Point3D p1 = new Point3D(1,1,1);
    Point3D p2 = new Point3D(11,11,11);
    p1.setX(11);
    System.out.println(p1.calcDistance(p2));



  }
}