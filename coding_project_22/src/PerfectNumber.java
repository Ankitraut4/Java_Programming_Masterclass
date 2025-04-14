public class PerfectNumber {

    public static boolean isPerfectNumber(int x){
        int sum=0;
        if(x<1){
            return false;
        }
        for(int i=1;i<x;i++){
            if(x%i==0){
                sum+=i;
            }
        }
        if(sum==x){
            return true;
        }
        return false;
    }
}
