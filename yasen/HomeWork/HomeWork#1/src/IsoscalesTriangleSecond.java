/**
 * Created by Yassen on 2/21/2016.
 */
public class IsoscalesTriangleSecond {

    public static void main(String[] args){


        String copyRight = "©";


int size = 10;
        int k = 0;
        int sizeSecond = size-1;
        for(int i=0; i<size; i++){

            for(int j=0; j<sizeSecond; j++){

                System.out.print(" ");
            }
            for(int j=0; j<k; j++){
                System.out.print(copyRight);
            }

            System.out.println();

            sizeSecond = sizeSecond-1;
            k = k+2;
        }


    }


}
