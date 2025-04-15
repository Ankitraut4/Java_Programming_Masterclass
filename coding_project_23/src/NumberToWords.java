public class NumberToWords {

    public static  void numberToWords(int number){
        int num=reverse(number);
        int last=0;

        if(number<0){
            System.out.println("Invalid Value");
        }
        for(int i=0;i<getDigitCount(number);i++){

               last=num%10;
            switch (last) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
                num/=10;


        }


    }

    public static int reverse(int x){
        int num=x;
        int reverse=0;
        while (num!=0){
            int reversedigit=num%10;
            reverse=(reverse*10)+reversedigit;
            num/=10;
        }

        return reverse;
    }


    public static int getDigitCount(int number) {
        int count = 1;
        if (number <0) {
            return -1;
        }
            while (number>9){
                number /= 10;
                count++;



            }
            return count;
        }


}
