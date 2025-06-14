package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
         ArrayList<Team<FootBallPlayer>> teams=new ArrayList<>();


        HockeyPlayer ankit=new HockeyPlayer("ankit");
	FootBallPlayer ronaldo=new FootBallPlayer("Ronaldo");
	CricketPlayer rohit=new CricketPlayer("Rohit");

	Team<FootBallPlayer> realMadrid=new Team<>("RealMadrid");
realMadrid.addPlayer(ronaldo);
teams.add(realMadrid);
//realMadrid.addPlayer(rohit);//this should not happen so we use <T> to specify certain datatype parameter
        Team<HockeyPlayer> India=new Team<>("India");
        India.addPlayer(ankit);

        Team<CricketPlayer> Mi=new Team<>("Rohit");
        Mi.addPlayer(rohit);
        System.out.println(Mi.getName());

        Team<FootBallPlayer> manchesterCity=new Team<>("Manchester City");
        Team<FootBallPlayer> manchesterUnited=new Team<>("Manchester United");
        Team<FootBallPlayer> liverpool=new Team<>("Liverpool ");
        Team<FootBallPlayer> BVB=new Team<>("BVB DOTMUN");
teams.add(manchesterCity);
teams.add(manchesterUnited);
teams.add(liverpool);
teams.add(BVB);
//teams.add(Mi);//this would not add because on line 9 we specify the type <Team<FootBallPlayer>>
        realMadrid.matchResult(manchesterCity,2,6);
        realMadrid.matchResult(manchesterUnited,1,0);
        manchesterCity.matchResult(manchesterUnited,1,4);
        realMadrid.matchResult(manchesterUnited,0,0);
            realMadrid.matchResult(manchesterCity,1,0);
            realMadrid.matchResult(liverpool,1,3);
            manchesterUnited.matchResult(BVB,1,2);
            manchesterCity.matchResult(liverpool,0,1);
            manchesterUnited.matchResult(liverpool,0,1);
            BVB.matchResult(liverpool,1,0);
            BVB.matchResult(realMadrid,1,1);
            manchesterCity.matchResult(liverpool,1,1);
            manchesterCity.matchResult(manchesterUnited,1,0);

        System.out.println("");
        System.out.println("FootBall Team Standing --> ");
            System.out.println(realMadrid.getName() + ": " + realMadrid.ranking()+" Points");
            System.out.println(manchesterCity.getName() + ": " + manchesterCity.ranking()+" Points");
            System.out.println(manchesterUnited.getName() + ": " + manchesterUnited.ranking()+" Points");

            System.out.println(realMadrid.compareTo(manchesterCity));
            System.out.println(manchesterCity.compareTo(realMadrid));
           // System.out.println(India.compareTo(realMadrid));//this comparision can not happen because different type <T>
        Collections.sort(teams);
print(teams);

    }
    public static void print(ArrayList<Team<FootBallPlayer>> teams){
        for (int i=0;i<teams.size();i++){
            System.out.println(teams.get(i).getName()+" --> " +teams.get(i).ranking()+" POINTS");
        }
    }
}
