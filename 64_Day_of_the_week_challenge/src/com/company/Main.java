package com.company;

public class Main {

    public static void main(String[] args) {
//        Write a method with the name printDayOfTheWeek that has one parameter of type int and name it day.
//
//                The method should not return any value (hint: void)
//
//        Using a switch statement print "Sunday", "Monday",.... ,"Saturday" if the int parameter "day" is 0, 1, .... , 6 respectively, otherwise it should print "Invalid day".
//
//        Bonus:
//        Write a second solution using if then else, instead of using switch.
//        Create a new project in IntelliJ with the  name "DayOfTheWeekChallenge"
   DayOfTheWeekChallenge(3);
   DayOfTheWeekChallenge_if_else(3);
    }

    public static void DayOfTheWeekChallenge(int day){
        switch (day){
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thusday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("invalid value");
                break;
        }
    }
    public static void DayOfTheWeekChallenge_if_else(int day) {
        if (day == 0) {
            System.out.println("sunday");
        } else if (day == 1) {
            System.out.println("monday");
        } else if (day == 2) {
            System.out.println("tuesday");
        } else if (day == 3) {
            System.out.println("wednesday");
        } else if (day == 4) {
            System.out.println("thusday");
        } else if (day == 5) {
            System.out.println("friday");
        } else if (day == 6) {
            System.out.println("saturday");
        } else {
            System.out.println("invalid value");
        }
    }
}
