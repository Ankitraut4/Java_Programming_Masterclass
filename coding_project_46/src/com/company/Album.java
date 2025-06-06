package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<Song>();
    }
    public boolean addSong(String title,double duration){
       if (findSong(title)==null){
           this.songs.add(new Song(title,duration));
           return true;
       }
       return false;
    }
    private Song findSong(String title){
        for (Song checkSong : this.songs){  //for(int i=0;i<songs.size();i++)
            if (checkSong.getTitle().equals(title)){// if (this.songs.get(i).getTitle().equals(title))
             return checkSong;                      //return this.songs.get(i);
         }
        }
        return null;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index=trackNumber-1;
        if (index>=0&&index<=songs.size()) {//trackNumber-1=index number
            playList.add(this.songs.get(index));
            return true;
        }else {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }

    }

    public boolean addToPlayList(String title,LinkedList<Song> playList) {
        Song checkSong = findSong(title);
        if (checkSong != null) {
            playList.add(checkSong);
            return true;
        } else {
            System.out.println("The song " + title + " is not in this album");

            return false;
        }
    }
}
