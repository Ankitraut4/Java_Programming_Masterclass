import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage(){
        int count=0;
        int sum=0;
        //long avg=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the number ");
        while (true){


            boolean hasnextint =scanner.hasNextInt();
            if (hasnextint){
                int number=scanner.nextInt();
                count++;
                sum+=number;

               //avg = Math.round((double)sum/count);
            }
            else {
                break;
            }
        }
        scanner.nextLine();
        System.out.println("SUM = " +sum+ " AVG = " +Math.round((double)sum/count ));

    }
}
