package com.company;

public class Main {

    public static void main(String[] args) {
      boolean gameover=true;
      int score = 5000;
      int levelcomplete = 5;
      int bonus = 100;

//      if(score<=5000 && score>=1000){
//          System.out.println(" score is greater than 1000 and score is less than 5000(or equal to 5000) ");
//      }else if (score<1000)
//      {
//          System.out.println("score is less thsn 1000 ");
//      }else{
//          System.out.println("score is greater than 5000");
//      }

        if(gameover){
            int finalscore = score + (levelcomplete*bonus);
            System.out.println("your final score is " +finalscore);
        }
//       int score1=10000;
//        int levelcompleted1 = 8;
//        int bonus1=200;
//
//        if (gameover) {
//            int finalscore= score1+(levelcompleted1*bonus1);
//            System.out.println("your final score is " +finalscore);
//        }
//        //here on line 21 and 29 we use same variable name AS finalscore but there is no error because the variable is present in if codeblock which automatically delete the code insie the code block this property is known as scope

         score = 10000;
         levelcomplete = 8;
         bonus = 200;
        if(gameover){
            int finalscore = score + (levelcomplete*bonus);
            System.out.println("your final score is " +finalscore);
            //here on line 34 to 39 is duplication of code  24 to 31 without changing a name of variable and reduce space but there are many dissadvantage of duplication





        }
    }
}
