public class Main {
    public static void main(String[] args) {
        calculatescore("ankit",22);
        int newscore = calculatescore("ankit",22);
        System.out.println("newscore is " +newscore);//here from 4 to 5 by giving our method to any int type(as our return type for method is int) we can use the "return score*100"

        calculatescore(55);
         newscore = calculatescore(55);
        System.out.println("newscore is " +newscore);

        calculatescore();








    }
        public static int calculatescore(String playername,int score){
            System.out.println("player " +playername+ " scored "+score+ " points");
            return score*100;



    }

    public static int calculatescore(int score){
        System.out.println("unnamed player  scored "+score+ " points");
        return score*100;



    }

    public static int calculatescore(){
        System.out.println("no player no score");
        return 0;



    }

}
