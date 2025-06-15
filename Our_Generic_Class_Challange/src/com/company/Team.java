package com.company;

import java.util.ArrayList;

public class Team<T extends  Players>  implements Comparable<Team<T>>{
    private String name;
    private int win=0;
    private int loss=0;
    private int draw=0;


    public Team(String name) {
        this.name = name;
    }
ArrayList<T> players=new ArrayList<>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean addPlayer( T player){
        if (players.contains(player)){
            System.out.println(player.getName()+" already exist ");
            return false;
        }
        players.add(player);
        return true;
    }
    public void matchResult(Team<T> opponentTeam,int ourScore,int opponentScore){
        String Message;
        if (ourScore>opponentScore){
            Message="WIN";
            win++;
        }else if (ourScore<opponentScore){
            Message="LOSS";
            loss++;
        }else {
            Message="Draw";
            draw++;
        }if (opponentTeam!=null){
           // System.out.println(this.getName()+" "+Message+" "+opponentTeam.getName());
            opponentTeam.matchResult(null,opponentScore,ourScore);
        }
    }
    public int numOfPlayers(){
        return players.size();
    }
    public int rating(){
        return (win*2)+draw;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.rating()>team.rating()){
            return -1;
        }else if (this.rating()<team.rating()){
            return 1;
        }else {
            return 0;
        }

    }
}
