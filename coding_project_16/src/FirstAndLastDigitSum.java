public class FirstAndLastDigitSum {

    public static int sumFirstAndLastDigit(int number){
        int num=number;
        int reverse=0;

        if(num<0){
            return -1;
        }
        while (num!=0){
            int lastnumber=num%10;
            reverse=(reverse*10)+lastnumber;
            num/=10;
        }
            return (reverse%10)+(number%10);


        }


    }

