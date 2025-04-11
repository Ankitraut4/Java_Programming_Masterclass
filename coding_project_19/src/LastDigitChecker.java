public class LastDigitChecker {

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if(isValid(num1) && isValid(num2) && isValid(num3)) {
            int lastofnum1 = num1 % 10;
            int lastofnum2 = num2 % 10;
            int lastofnum3 = num3 % 10;

            if (lastofnum1 == lastofnum2 || lastofnum2 == lastofnum3 || lastofnum3 == lastofnum1) {
                return true;
            }

        }
        return false;
    }

    public static boolean isValid(int x){
        if(x>9 && x<1001){
            return true;
        }
        return false;
    }
}

