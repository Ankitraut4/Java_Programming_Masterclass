public class Main {
    public static void main(String[] args) {
        Boolean res = DecimalComparator.areEqualByThreeDecimalPlaces(3.5677,3.567);
        System.out.println(res);

        res = DecimalComparator.areEqualByThreeDecimalPlaces(3.5617,3.567);
        System.out.println(res);

         res = DecimalComparator.areEqualByThreeDecimalPlaces(2.5677,3.567);
        System.out.println(res);

         res = DecimalComparator.areEqualByThreeDecimalPlaces(3.5677,-3.567);
        System.out.println(res);
    }
}
