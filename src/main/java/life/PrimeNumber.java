package life;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * 质数乘积是707829217
 * NY大质数在前,小质数在后
 * tzcccdgwthbh
 * @author sunjian.
 */
public class PrimeNumber {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        long ulDataInput = sc.nextLong();
        String result = getResult(ulDataInput);
        System.out.print(result.toString());
    }


    public static Boolean isSuShu(long ulDataInput){
        for(int i=2;i<ulDataInput/2;i++){
            if(ulDataInput%i==0){
                return false;
            }
        }
        return true;
    }
    public static String getResult(long ulDataInput){
        String s = new String();
        long number = ulDataInput;
        while(number != 1)
        {
            for(int i = 2; i <= number ;i++)
            {
                if(number % i == 0)
                {
                    number /= i;
                    s=s+i+" ";
                    break;
                }
            }
        }
        return s;
    }
    //基数中3的个数
    /*public void get3(){
        long a = 866278171;
        char target = 3;
        for (int i=1;i<=a;i=i+2){
            final String s = String.valueOf(i);
            getCount
        }

    }

    public int getCount(String s,char target){

        int result = 0;
        for (char a : chars) {
            if (a==target){
                result++;
            }
        }
        return result;
    }*/
}
