package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create a generic class to implement a league table for a sport.
        // The class should allow teams to be added to the list, and store
        // a list of teams that belong to the league.
        //
        // Your class should have a method to print out the teams in order,
        // with the team at the top of the league printed first.
        //
        // Only teams of the same type should be added to any particular
        // instance of the league class - the program should fail to compile
        // if an attempt is made to add an incompatible team.



        League<Team<FootBallPlayers>> league=new League<>("LA LiGA");
        Team<FootBallPlayers> realMadrid=new Team<>("Real Madrid");
        Team<FootBallPlayers> liverPool=new Team<>("Liverpool");
        Team<FootBallPlayers> mancity=new Team<>("Manchester City");
        league.addTeam(realMadrid);
        league.addTeam(liverPool);
        league.addTeam(mancity);

        realMadrid.matchResult(liverPool,1,0);
        liverPool.matchResult(mancity,1,1);

        FootBallPlayers tim=new FootBallPlayers("tim");
        BaseBallPlayer so=new BaseBallPlayer("soo");
        realMadrid.addPlayer(tim);

        league.print();

    }
}
