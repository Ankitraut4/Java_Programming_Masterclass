package com.company;


public class Main {

    public static void main(String[] args) {


        int result = 1+2;
        System.out.println("1 + 2  = " +result);

        int previousresult = result;
        System.out.println("previous result = " +previousresult);

        previousresult = previousresult -1;
        System.out.println("sub = " +previousresult);

        previousresult =result * 4;
        System.out.println("mul = " +previousresult);

        previousresult=previousresult / 4;
        System.out.println("div = " +previousresult);

        previousresult=previousresult%2;
        System.out.println("reminder = " +previousresult);

        //abrivating operator

       // previousresult=previousresult+1;
        System.out.println(previousresult);

        //we can write the statement on the line number 28 as
        previousresult++;
        System.out.println("1+1 = " +previousresult);

        previousresult--;
        System.out.println("2-1 = " +previousresult);

        //if we want to add/sub/div/mul other than 1 we can use
        previousresult+=3;
        System.out.println("1+3 = " +previousresult);

        previousresult-=2;
        System.out.println("4-2 = " +previousresult);

        previousresult*=3;
        System.out.println("2*3 = " +previousresult);

        previousresult/=3;
        System.out.println("6/3 = " +previousresult);

       boolean ifaliean=false;
        if(ifaliean==false) {
            System.out.println("it is an aliean  ");
        }
            //there many operators such as +,-,*,/,%,>,<,>=(greter than equal),<=(less than equal),!=(not equal),&&(and logic where both the statement is true then it will excecute,||(or operator)

            int topscore = 100;
            if(topscore>=100){
                System.out.println("you got high score ");
            }


            //here on line 65 we use logical and gate/operator(both(left and right operands) statement should br true
            int secondscore =80;
            if((topscore== 100) && (secondscore>=60))
            {
                System.out.println("you got score below 100 and above 60  ");
            }

           //here we use or operator where either any one of the statement is true
            if ((topscore>100) || (secondscore<=80))
            {
                System.out.println("either any of the condition is true ");
            }

            //not operator

            boolean iscar=false;
                    if(iscar)
                    {
                        System.out.println("the condition of is car is false ");
                    }


              //ternary operator
          iscar = true;
            boolean wascar = iscar ? true:false;
                    if(wascar)
            {
                System.out.println("was car is true ");
            }

                    int ageofclient=20;
                    boolean iseighteenorover=(ageofclient==20) ? true:false;
            System.out.println("age of clint =" +iseighteenorover);
                    if(iseighteenorover)
            {
                System.out.println("age is ");
            }

                    //operator challenge

           double firstnumber =20.00d;
           double secondnumber =80.00d;

           double result1 = (firstnumber+secondnumber)*100.00d;
            System.out.println("result after op = " +result1);

            double reminder = result1%41.00d;
            System.out.println("reminder of op = " +reminder);

            boolean output = (reminder==0) ? true:false;
            System.out.println("is no reminder = " +output);//here the reminder is ==0 condition saticfies therefore it give out true
            if (!output)
            {
                System.out.println("there is some reminder = " +reminder);
            }


            






        }

    }

