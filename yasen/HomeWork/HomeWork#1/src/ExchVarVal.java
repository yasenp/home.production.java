/**
 * Created by Yassen on 2/23/2016.
 */
public class ExchVarVal {



    public static void main(String[] args){
        int a = 5;
        int b = 10;
        System.out.println("Variable a = " + a);
        System.out.println("Variable b = " + b);

        if(a==5 && b==10){
            a = 10;
            b= 5;
        }

        System.out.println("Variable a = " + a);
        System.out.println("Variable b = " +  b);
    }

}
