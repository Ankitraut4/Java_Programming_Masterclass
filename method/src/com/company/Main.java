package com.company;

public class Main {

    public static void main(String[] args) {
        boolean gameover = true;
        int score = 800;
        int levelcomplete = 5;
        int bonus = 100;

        int highscore= calculatescore(gameover, score, levelcomplete, bonus);
        System.out.println("your final score = "+highscore);

        score = 500;
        levelcomplete = 6;
        bonus = 200;

       highscore =  calculatescore(gameover, score, levelcomplete, bonus);
      System.out.println("your final score = " +highscore);

    }
    // public static void calculatescore(boolean gameover,int score,int levelcomplete,int bonus) {
    //if (gameover) {
    //   int finalscore = score + (levelcomplete * bonus);
    // finalscore += 2000;
    //   System.out.println("your final score was " + finalscore);

    //}

    //}
//}



//similarly we can use return type int or other to return the value to method i.e from 19 to 28

    public static int calculatescore(boolean gameover,int score,int levelcomplete,int bonus) {
        if (gameover) {
            int finalscore = score + (levelcomplete * bonus);
            finalscore += 2000;
            return finalscore;

        }
        return -1;

    }


}
