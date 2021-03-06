import java.util.Scanner;

/*
    Name: Any Base To Any Base
    Source: PepCoding
    Link: https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/any-base-to-any-base-official/ojquestion

    Statement:  You are required to convert the number n of base b1 to a number in base b2.
*/

public class BaseToBaseConversion {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int  destBase= scn.nextInt();
        int midNum = getValueInBase(n, sourceBase,10);
        int res = getValueInBase(midNum, 10,destBase);
        System.out.println("Result: "+res);
    }

    public static int getValueInBase(int n, int source, int dest){
        // write code here
        int a =0;
        int result =0;
        while(n!=0)
        {
            if(source>dest)
            {
                result += n%dest * (int) Math.pow(10,a++);
                n =n/dest;
            }
            else
            {
                result += n%10 * (int) Math.pow(source,a++);
                n =n/10;
            }
        }

        return result;
    }

}
