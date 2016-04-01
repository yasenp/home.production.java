import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Yassen on 3/4/2016.
 */
public class ComparingFloats {

    public static void main(String[] args) throws IOException{

        float a;
        float b;

        float difference = 0f;

        final float eps = 0.000001f;


        while(true) {


            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the first float number a = ");
            a = Float.parseFloat(input.readLine());


            System.out.println("Enter the second float number b = ");
            b = Float.parseFloat(input.readLine());


            if (a > b) {
                difference = a - b;
            } else if (a < b) {
                difference = b - a;
            }

            if (difference <= eps) {
                System.out.println("Very small difference" + difference + ": Float number a and b are equal");
            } else
                System.out.println("Float number a and b are not equal because the difference" + difference + " is too big");
        }
    }

}
