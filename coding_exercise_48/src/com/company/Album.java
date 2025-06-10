package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
this.songs=new SongList();
    }
    public boolean addSong(String title,double duration){

            this.songs.add(new Song(title,duration));
            return true;


    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song chec= songs.findSong(trackNumber);
        if (chec!=null) {
            playList.add(chec);
            return true;
        }else {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }

    }

    public boolean addToPlayList(String title,LinkedList<Song> playList) {
        Song checkSong = songs.findSong(title);
        if (checkSong != null) {
            playList.add(checkSong);
            return true;
        } else {
            System.out.println("The song " + title + " is not in this album");

            return false;
        }
    }
    public static class SongList{//this inner class is define public because(udemy) it is given in exercise 48
        private ArrayList<Song> songs;


        private SongList() {//this constructor is private because of udemy constructor
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song){
            if (this.songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }
        private Song findSong(String title ){
            for (int i=0;i<songs.size();i++){//for(Song c : this.title)
                if (this.songs.get(i).getTitle().equals(title)){//c=this.songs.get(i);
                    return this.songs.get(i);
                }
            }
            return null;
        }
        private Song findSong(int trackNumber){
            int index=trackNumber-1;
            if (index>=0 && index<songs.size()){
                return this.songs.get(index);
            }
            return null;
        }



    }
}
