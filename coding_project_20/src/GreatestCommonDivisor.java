public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int x,int y) {
        int commonnum = 0;

        if (x < 10 || y < 10) {
            return -1;
        } else {
            if (x >= y) {
                for (int i = 1; i <= y; i++) {
                    if (x % i == 0 && y % i == 0) {
                        commonnum = i;
                        System.out.println("the common divisor are " + i);

                    }
                }
            } else {
                if (x <= y) {
                    for (int j = 1; j <= x; j++) {
                        if (x % j == 0 && y % j == 0) {
                            commonnum = j;
                            System.out.println("the common divisor are " + j);
                        }
                    }
                }
            }
            return commonnum;
        }
    }
}
