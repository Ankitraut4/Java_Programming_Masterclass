package com.company;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {//to add a certain player like football player to football team not another player so we use <t> and we extend parent because only the class contain parent should only be use
    private String name;
    private int win=0;
    private int loss=0;
    private int draw=0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    ArrayList<T> teamName=new ArrayList<>();


    public int numPlayers() {
        return this.teamName.size();
    }

    public void matchResult(Team<T> opponent,int ourScore,int opponentScore){
      String message;
        if (ourScore>opponentScore){
            message="WIN";
            win++;

        }else if (ourScore<opponentScore){
            message="LOSS";
            loss++;

        }else {
            message="DRAW";
            draw++;

        }
        if (opponent!=null){
            System.out.println(this.getName()+" "+message+" aginst --> "+opponent.getName());
            opponent.matchResult(null,opponentScore,ourScore);
        }
    }
    public int ranking(){
        return (win * 2)+draw;
    }
    public boolean addPlayer(T player){
        if (teamName.contains(player)){
            System.out.println(player.getName()+" already exist");//here for get name we requires casting but we avoid it by  extent Player class in <T>
        return false;
        }
        teamName.add(player);
        return true;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking()>team.ranking()){
            return -1;
        }else if (this.ranking()<team.ranking()){
            return 1;
        }else {
            return 0;
        }
    }
}
