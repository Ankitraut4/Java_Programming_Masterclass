public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int num=number;

        while (num != 0) {
            int lastDigit = num % 10;
            reverse = (reverse * 10) + lastDigit;
            num /= 10;


        }

        if (number == reverse) {
            return true;
        }
        return false;
    }
}
