public class Main {
    public static void main(String[] args) {
        boolean res = EqualSumChecker.hasEqualSum(1,1,2);
        System.out.println(res);

        res =EqualSumChecker.hasEqualSum(-1,2,1);
        System.out.println(res);

        res =EqualSumChecker.hasEqualSum(-1,2,2);
        System.out.println(res);

    }
}
