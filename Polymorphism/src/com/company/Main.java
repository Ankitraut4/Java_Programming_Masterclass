package com.company;

//here we can create the different class in main class if the class are small and compact(i.e another way of inheritance)

 class Movie{
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot(){
        return "no plot";
    }

    public String getName() {
        return name;
    }
}

class Spiderman extends Movie{
    public Spiderman() {
        super("spiderman");
    }

    @Override
    public String plot() {
        return "child hero drama";
    }
}
class Ironman extends Movie{
    public Ironman() {
        super("ironman");
    }

    @Override
    public String plot() {
        return "A man with super creative mind";
    }
}
class Thor extends Movie{
    public Thor() {
        super("thor");
    }

    @Override
    public String plot() {
        return "person from anathor planet";
    }
}
class Superman extends Movie{
    public Superman() {
        super("superman");
    }

    @Override
    public String plot() {
        return "A human with superhuman power";
    }
}

class noMovie extends  Movie{
    public noMovie() {
        super("noMovie");
    }

    //here we do not use plot overriden method because there is no plot in move or we forgot the plot
    //so polymorphism check the parent class (Movie) and give the plot value automatically
}



public class Main {

    public static void main(String[] args) {
	for (int i=1;i<11;i++){
        Movie movie=randommovie();//here whwn randomnumber is 5 so when we call plot for what there is no plot written in no movie class so here polymorphism came into play and give value from parent class Movie with plot "no plot" when we take output
        System.out.println("Movie #"+i+" (out of 10 movies) :"+movie.getName()+
                                             "\n"
        +"plot : "+movie.plot()+"\n");
    }
    }

    public static Movie randommovie(){//here Movie is return type i.e Movie class we create as a parent class to return the object or method of Movie class
        int randomNumber=(int)(Math.random()*5)+1;//here  math.random return/generate random number between 0 and 1 so we multiplt it by 5 for 5 class we have (i.e 0,1,2,3,4,) and add it by 1 so the first number should start from 1(i.e 1,2,3,4,5)
        System.out.println("random number generated is " +randomNumber);
        switch (randomNumber){
            case 1:
                return new Superman();//here we does not required break; because wwe are using class
            case 2:
                return new Ironman();
            case 3:
                return new Thor();
            case 4:
                return new Spiderman();
            case 5:
                return new noMovie();
        }
    return null;
    }


}
