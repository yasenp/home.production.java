/**
 * Created by Yassen on 2/21/2016.
 */
public class IsoscalesTriangle {

    public static void main(String[] args) {

        String copyRights = "©";
        String temp = "";
        String temp1 = "";
        int loopSize = 50;
        String lastLine = " " + copyRights;
        String space1 = "";


        for (int i = 0; i < loopSize; i++) {

            if(i<=loopSize-2){
            lastLine += "   " + copyRights;
            } else {
                lastLine +="  " + copyRights;
            }

            String space = "";


            for (int j = i; j < loopSize; j++) {

                space += "  ";
            }

            if (i == 0) {

                temp = space + copyRights;
                System.out.println(temp);

            } else if (i <= loopSize-2) {
                if(i<=loopSize){

                    space1 +=  "    ";
                }
                temp = space + copyRights;
                temp1 = space1 + copyRights;
                System.out.println(temp + temp1);

            } else {
                System.out.println(lastLine);
            }

        }
    }
}
