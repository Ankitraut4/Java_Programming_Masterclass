package com.company;

import java.util.*;

public class Main {

        private static ArrayList<Album> albums=new ArrayList<Album>();
        public static void main(String[] args) {
            Album album=new Album("reputation","taylor swift");
            album.addSong("End Game ",4.04);
            album.addSong("Ready for it? ",4.66);
            album.addSong("I Did Somthing Bad ",9.04);
            album.addSong("Delicate ",5.04);
            album.addSong("Gorgeous ",7.04);
            album.addSong("Gateway Car ",4);
            albums.add(album);

            Album album1=new Album("Red","taylor");//here the name of Album is same(album) because we  asign new array to it in arraylist
            album1.addSong("22",4.55);
            album1.addSong("All Too Well",7.55);
            album1.addSong("The Lucky One ",1.55);
            album1.addSong("Stay Stay Stay",4.75);
            album1.addSong("The Last Time",6.05);
            album1.addSong("Starlight",2.55);
            albums.add(album1);

            LinkedList<Song> playList=new LinkedList<Song>();
            albums.get(0).addToPlayList("Ready for it? ",playList);//get(0) because it is first  album at index 0
            albums.get(0).addToPlayList("Delicate ",playList);
            albums.get(0).addToPlayList(6,playList);
            albums.get(1).addToPlayList(1,playList);
            albums.get(1).addToPlayList(4,playList);
            albums.get(1).addToPlayList(5,playList);
            albums.get(1).addToPlayList(34,playList);


            play(playList);
        }
        private static void play(LinkedList<Song> playlist){
            Scanner scanner=new Scanner(System.in);
            boolean quit=false;
            boolean forward=true;
            ListIterator<Song> i=playlist.listIterator();
            if (playlist.size()==0){
                System.out.println("Playlist is empty");
                return;
            }else {
                System.out.println("Now Playing --> "+i.next().toString());
                info();
            }
            while (!quit){
                System.out.println("enter your choice : ");
                int choice=scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 0:
                        System.out.println("Exiting the Playlist ");
                        quit=true;
                        break;
                    case 1:
                        if (!forward){
                            if (i.hasNext()){
                                i.next();
                            }
                            forward=true;

                        }
                        if (i.hasNext()){
                            System.out.println("Now Playing --> "+i.next().toString());
                        }else {
                            System.out.println("we are at the end of playlist ");
                            forward =false;
                        }
                        break;
                    case 2:
                        if (forward){
                            if (i.hasPrevious()){
                                i.previous();
                            }
                            forward=false;
                        }
                        if (i.hasPrevious()){
                            System.out.println("Now Playing --> "+i.previous());
                        }else {
                            System.out.println("we are at start of list ");
                            forward=true;
                        }
                        break;
                    case 3:
                        if (forward) {
                            if (i.hasPrevious()) {
                                System.out.println("Replaying --> " + i.previous());
                                forward=false;
                            } else {
                                System.out.println("we are at start of playlist ");
                            }
                        }
                        else{
                            if (i.hasNext()) {
                                System.out.println("Replaying --> " + i.next());
                                forward=true;
                            } else {
                                System.out.println("we are at end of playlist");
                            }
                        }

                        break;
                    case 4:
                        Displayplaylist(playlist);
                        break;
                    case 5:
                        info();
                        break;
                    case 6:if (playlist.size()>0) {
                        i.remove();//to remove current element
                        if (i.hasNext()){
                            System.out.println("Now Playing --> "+i.next());
                        }else if (i.hasPrevious()){
                            System.out.println("Now Playing --> "+i.previous());
                        }
                    }
                        break;
                }
            }

        }
        private static void  info(){
            System.out.println("#CHOICE");
            System.out.println("#0 - Quit");
            System.out.println("#1 - Play Next Song");
            System.out.println("#2 - Play Previous Song ");
            System.out.println("#3 - Replay The Song ");
            System.out.println("#4 - Display The PlayList ");
            System.out.println("#5 - Display The Menu");
            System.out.println("#6 - Remove Current Element ");


        }
        private static void Displayplaylist(LinkedList<Song> linkedList){
            Iterator<Song> it=linkedList.iterator();//we goes not use listiterator(double iterator i.e we can go back and front) because here we have go forward as to display list
            System.out.println("=======================================");
            while (it.hasNext()){
                System.out.println(it.next());
            }
            System.out.println("=======================================");
        }
    // Modify the playlist challenge so that the Album class uses an inner class.
    // Instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
    // The inner SongList class will use an ArrayList and will provide a method to add a song.
    // It will also provide findSong() methods which will be used by the containing Album class
    // to add songs to the playlist.
    // Neither the Song class or the Main class should be changed.
    }

