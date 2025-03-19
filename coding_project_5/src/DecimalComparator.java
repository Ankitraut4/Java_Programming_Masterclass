public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double number1,double number2){

       //here on line 7 and 8 we done casting i.e convert double to interger for comparision to number

        int num1 = (int)(number1*1000);//here we multiply by 1000 because we have to compare or move 3 decimal places
        int num2 = (int)(number2*1000);
        if(num1==num2){
            return true;
        }
        return false;
    }

}
