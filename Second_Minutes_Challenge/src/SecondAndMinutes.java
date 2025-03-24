public class SecondAndMinutes {


    //Create a method called getDurationString with two parameters, first parameter minutes and 2nd parameter seconds.
    //You should validate that the first parameter minutes is >= 0.
    //You should validate that the 2nd parameter seconds is >= 0 and <= 59.
    //The method should return gInvalid valueh in the method if either of the above are not true.
    //If the parameters are valid then calculate how many hours minutes and seconds equal the minutes and seconds passed to this method and return that value as string in format XXh YYm ZZs h where XX represents a number of hours, YY the minutes and ZZ the seconds.
    //Create a 2nd method of the same name but with only one parameter seconds.
    //Validate that it is >= 0, and return gInvalid valueh if it is not true.
    //If it is valid, then calculate how many minutes are in the seconds value and then call the other overloaded method passing the correct minutes and seconds calculated so that it can calculate correctly.
    //Call both methods to print values to the console.

    //Tips:
    //Use int or long for your number data types is probably a good idea.
	//1 minute = 60 seconds and 1 hour = 60 minutes or 3600 seconds.
    //Methods should be static as we have used previously.

    //Bonus:
    //For the input 61 minutes output should be 01h 01m 00s, but it is ok if it is 1h 1m 0s (Tip: use if-else)
    //Create a new console project and call it SecondsAndMinutesChallenge

    public static String getDurationString(int minutes,int seconds){
        if (minutes>=0 && seconds>=0 && seconds<=59){
            int hour=minutes/60;
            int min=minutes%60;
//from line 27 to 44 the extra string is created for adding 0 before the number which is <10
         String hourString= hour + "h";
         if(hour<10){
             hourString="0"+hourString;
         }

         String minString=min+"m";
         if(min<10){
             minString="0"+minString;
         }

         String secString=seconds+"s";
                 if(seconds<10){
                     secString="0"+secString;
                 }


            return (hourString+" "+minString+ " "+secString+" ");
        }

        return "invalid value";
    }

    public static String getDurationString(int seconds){
        if(seconds>=0){
            int min=seconds/60;
            int remaningsec=seconds%60;
            return getDurationString(min,remaningsec);
        }
        return "invalid value";
    }

}
