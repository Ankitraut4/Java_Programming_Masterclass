package com.company;

import modul.Artists;
import modul.Database;
import modul.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Database database=new Database();
        if (!database.open()){
            System.out.println("can not open database");
        }

        List<Artists> artists=database.artistQuery(Database.ORDER_BY_DESC);
        if (artists==null){
            System.out.println("no artist is present in list");
        }else {
            for (Artists artists1: artists){
                System.out.println("ID : "+artists1.get_id()+" : "+artists1.getName());
            }
        }
        System.out.println("-------------");

        List<String> albums=database.queryOf_Albums_BY_Artist("Pink Floyd",Database.ORDER_BY_DESC);
        if (albums==null){
            System.out.println("there is no album for this artist ");
        }else {
            for (String album: albums){
                System.out.println(album);
            }
        }
        System.out.println("-----------");
        List<SongArtist> songArtists=database.Qwery_Song_BY_Artist("Hello Earth",Database.ORDER_BY_DESC);
            if (songArtists==null){
                System.out.println("there is no artist of this song name");
            }
            for (SongArtist songArtist: songArtists){
                System.out.println("ARTIST NAME :- "+songArtist.getArtistName()+" | ALBUM NAME :- "+songArtist.getAlbumName()+
                        " | SONG TRACK :- "+songArtist.getSongtrack());
            }

        System.out.println("---------------");
            database.songSchema();

            int count=database.getCount(Database.TABLE_SONGS);
        System.out.println("number  of songs = "+count);
        System.out.println("------------------------");
        database.creating_view_for_artist_list();
        System.out.println("_______________");

//      Scanner scanner=new Scanner(System.in);
//        System.out.println("Enter song name :- ");
//        String songName=scanner.nextLine();
//
//        songArtists=database.queryFor_Artist_BY_SONG_using_view(songName);
//        if (songArtists.isEmpty()){
//            System.out.println("there is no artist for this song");
//        }else {
//            for (SongArtist songArtist: songArtists){
//                System.out.println("ARTIST NAME :- "+songArtist.getArtistName()+"  || ALBUM NAME :- "+songArtist.getAlbumName()+
//                        " || SONG TRACK :- "+songArtist.getSongtrack() );
//            }
//        }
        System.out.println("--------------------------");

//        database.insertSong("Hello","Adele","Hello",4);
//        database.insertSong("Dust Till Down","Zyan","D",1); //we are not add qwery for songs to check where the song is present or not
        database.insertSong("Sorry","Justin ","Apology",4);

        database.close();
    }


}
