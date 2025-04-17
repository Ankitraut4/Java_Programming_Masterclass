public class FlourPackProblem {

    public static boolean canPack(int bigCount,int smallCount,int goal) {
        int big = bigCount * 5;


        if (big + smallCount < goal || big < 0 || smallCount < 0 || goal<0) {
            return false;
        } else {
            if (big + smallCount >= goal && goal%5<=smallCount) {
                return true;

            }
//            else if (goal%5<=smallCount){
//                return true;
//            }

        }
        return false;
    }
}
