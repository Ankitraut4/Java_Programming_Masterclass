package com.company;

public class Main {

    public static void main(String[] args) {
        //create a method called displayhighscoreposition
        //it should a players name as a parameter,and a 2nd parameter as a position in thee high score table
        //you should display the player the players name along with a message like "managed to get into position" and the positio they get ana a further message "on the high score table"
        //create a 2nd method called calculatehighscoreposition
        //it should be sent one argument only,the player score
        //it should return an int
        //the return data should be
        //1 if the score is >=1000
        //2 if the score is >=500 and <1000
        //3 if the score is >=100 and <500
        //4 in all other cases
        //call both method and display the result of the following
        //a score of 1500,900,400,50

        int highscoreposition = calculatehighscoreposition(1500);
        displayhighscoreposition("betty", highscoreposition);

        highscoreposition = calculatehighscoreposition(900);
        displayhighscoreposition("jughead", highscoreposition);

        highscoreposition = calculatehighscoreposition(400);
        displayhighscoreposition("archi", highscoreposition);

        highscoreposition = calculatehighscoreposition(50);
        displayhighscoreposition("ronnie", highscoreposition);

        highscoreposition= calculatehighscoreposition(100);
        displayhighscoreposition("cheryl", highscoreposition);
    }
        public static void displayhighscoreposition(String playername,int highscoreposition)
        {
            System.out.println(playername+ " manged to get into position " +highscoreposition+ " on the high score table");

        }
        public static  int calculatehighscoreposition(int playerscore){
        //    if(playerscore>=1000){
        //        return 1;
        //    }else if(playerscore>=500 && playerscore<1000){ //here on line 43 the condition of <1000 is always true as we mention in above line 41 as >=1000 means the score fore return 2 has number less than 1000 so there is no need for writting that condition
        //        return 2;
        //    }else if (playerscore>=100 && playerscore<500){ //similary <500 conditon is not required simply (playerscore>=100)
        //        return 3;
        //    }else {      //here on line 47 else statement is not required simply we can give return 4 by removing else and "{}" of else
        //        return 4;
        //    }



            //we can modifiy our lines from 41 to 49

            int position = 4; //assuming position 4 will be return
            if(playerscore>=1000){
                position = 1;
            }else if (playerscore>=500){
                position = 2;
            }else if (playerscore>=100){
                position = 3;
            }
            return  position;
        }
    }

