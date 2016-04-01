/**
 * Created by Yassen on 3/4/2016.
 */
public class PrintAsciiTable {

    public static void main(String[] args) {

        for (int c=32; c<128; c++) {
            System.out.println(c + ": " + (char)c);
        }

    }
}
