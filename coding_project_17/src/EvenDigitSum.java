public class EvenDigitSum {

    public static int getEvenDigitSum(int number){

        int sum=0;
        if(number<0){
            return -1;
        }
        int num=number;
        while (num!=0){
            int lastdigit=num%10;
            if(lastdigit%2==0){
                 sum+= lastdigit;

            }
            num=num/10;
        }
        return sum;
    }
}
