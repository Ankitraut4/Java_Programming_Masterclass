public class SharedDigit {

    public static boolean hasSharedDigit(int num1,int num2){

        if(num1<10 || num1>99 || num2<10 || num2>99){
            return false;
        }
       int firstofnum1=num1/10;
        int lastofnum1=num1%10;
        int firstofnum2=num2/10;
        int lastofnum2=num2%10;

        if(firstofnum1==firstofnum2  || firstofnum1==lastofnum2){
            return true;
        }else if (lastofnum1==firstofnum2 || lastofnum1==lastofnum2){
            return true;
        }
        return false;
    }
}
