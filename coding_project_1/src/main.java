public class main {
    public static void main(String[] args) {

        long milesperhour = speedconverter.toMilesPerHour(10.5);
        System.out.println("miles = " +milesperhour+ " mi/h");

        speedconverter.printConversion(10.5);
    }
}
