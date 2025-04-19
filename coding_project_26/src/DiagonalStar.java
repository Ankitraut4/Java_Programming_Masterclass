public class DiagonalStar {

    public static void printSquareStar(int number){
        int row,column;
        if(number<5){
            System.out.println("invalid value");

        }
        for( row=0;row<number;row++){
            for (column=0;column<number;column++) {
                if (row==0 || row==number ) {
                    System.out.print("*");
                }else {
                    System.out.print("");
                }
            }
            System.out.println("");
        }
    }
}
