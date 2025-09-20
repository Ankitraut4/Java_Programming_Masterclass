package sample.modul;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static final String MUSIC_DB="music.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:A:\\java\\MusicUI\\"+MUSIC_DB;

    public static final String TABLE_SONGS="songs";
    public static final String COLOUMN_SONG_ID="_id";
    public static final String COLOUMN_SONG_TRACK="track";
    public static final String COLOUMN_SONG_TITLE="title";
    public static final String COLOUMN_SONG_ALBUMID="album";
    public static final int INDEX_COLOUMN_SONGS_ID=1;//indices/index for coloumn start from 1 if we start from 0 it will throw exception
    public static final int INDEX_COLOUMN_SONGS_TRACK=2;
    public static final int INDEX_COLOUMN_SONGS_TITLE=3;



    public static final String TABLE_ALBUMS="albums";
    public static final String COLOUMN_ALBUM_ID="_id";
    public static final String COLOUMN_ALBUM_NAME="name";
    public static final String COLOUMN_ALBUM_ARTISTID="artist";
    public static final int INDEX_COLOUMN_ALBUMS_ID=1;
    public static final int INDEX_COLOUMN_ALBUMS_NAME=2;
    public static final int INDEX_COLOUMN_ALBUMS_ARTISTID=3;



    public static final String TABLE_ARTISTS="artists";
    public static final String COLOUMN_ARTIST_ID="_id";
    public static final String COLOUMN_ARTIST_name="name";
    public static final int INDEX_COLOUMN_ARTISTS_ID=1;
    public static final int INDEX_COLOUMN_ARTISTS_NAME=2;

    public static final int ORDER_BY_NONE=1;
    public static final int ORDER_BY_DESC=2;
    public static final int ORDER_BY_ASC=3;

    public static final String QWERY_OF_ALBLUM_BY_ARTIST="SELECT "+TABLE_ALBUMS+"."+COLOUMN_ALBUM_NAME+" FROM "+TABLE_ALBUMS+
            " INNER JOIN "+TABLE_ARTISTS+" ON "+TABLE_ALBUMS+"."+COLOUMN_ALBUM_ARTISTID+" = "+TABLE_ARTISTS+"."+COLOUMN_ARTIST_ID+
            " WHERE "+TABLE_ARTISTS+"."+COLOUMN_ALBUM_NAME+" =\"";

    public static final String ORDER_FOR_QWERY_OF_ALBLUM_BY_ARTIST_SORT=" ORDER BY "+TABLE_ALBUMS+"."+COLOUMN_ALBUM_NAME+
            " COLLATE NOCASE ";

    //SELECT artists.name,albums.name,songs.track FROM songs INNER JOIN albums ON songs.album=albums._id
    //INNER JOIN artists ON albums.artist=artists._id WHERE songs.title="
    // Hello Earth"//this line will be in method as we want  user to enter songNmae

    public static final String QWERY_FOR_SONG_ARTIST="SELECT "+TABLE_ARTISTS+"."+COLOUMN_ARTIST_name+","+TABLE_ALBUMS+"."+COLOUMN_ALBUM_NAME+","+TABLE_SONGS+"."+COLOUMN_SONG_TRACK+
            " FROM "+TABLE_SONGS+" INNER JOIN "+TABLE_ALBUMS+" ON "+TABLE_SONGS+"."+COLOUMN_SONG_ALBUMID+"="+TABLE_ALBUMS+"."+COLOUMN_ALBUM_ID+
            " INNER JOIN "+TABLE_ARTISTS+" ON "+TABLE_ALBUMS+"."+COLOUMN_ALBUM_ARTISTID+"="+TABLE_ARTISTS+"."+COLOUMN_ARTIST_ID+
            " WHERE "+TABLE_SONGS+"."+COLOUMN_SONG_TITLE+"=\"";

    //ORDER BY artists.name,albums.name COLLATE NOCASE
    public static final String QWERY_SONG_ARTIST_SORT=" ORDER BY "+TABLE_ARTISTS+"."+COLOUMN_ARTIST_name+","+TABLE_ALBUMS+"."+COLOUMN_ALBUM_NAME+
            " COLLATE NOCASE ";

    //creating view as artist_list
    //"CREATE VIEWS IF NOT EXISTS artist_list AS SELECT artists.name,albums.name AS album, songs.track.songs.title FROM songs
    //INNER JOIN albums ON songs.album=albums._id
    //INNER JOIN artists ON albums.artist=artists._id
    //ORDER BY artists.name,albums.name,songs.track

    public static final String TABLE_FOR_ARTIST_LIST_VIEW="artist_list";

    public static final String CREATE_VIEW_FOR_ARTIST_LIST="CREATE VIEW IF NOT EXISTS "+TABLE_FOR_ARTIST_LIST_VIEW+" AS "+
            " SELECT "+TABLE_ARTISTS+"."+COLOUMN_ARTIST_name+","+TABLE_ALBUMS+"."+COLOUMN_ALBUM_NAME+" AS album,"+TABLE_SONGS+"."+COLOUMN_SONG_TRACK+","+
            TABLE_SONGS+"."+COLOUMN_SONG_TITLE+" FROM "+TABLE_SONGS+" INNER JOIN "+TABLE_ALBUMS+" ON "+TABLE_SONGS+"."+COLOUMN_SONG_ALBUMID+"="+TABLE_ALBUMS+"."+COLOUMN_ALBUM_ID+
            " INNER JOIN "+TABLE_ARTISTS+" ON "+TABLE_ALBUMS+"."+COLOUMN_ALBUM_ARTISTID+"="+TABLE_ARTISTS+"."+COLOUMN_ARTIST_ID+
            " ORDER BY "+TABLE_ARTISTS+"."+COLOUMN_ARTIST_name+","+TABLE_ALBUMS+"."+COLOUMN_ALBUM_NAME+","+TABLE_SONGS+"."+COLOUMN_SONG_TRACK;

    public static final String QWERY_FOR_SONG_ARTIST_USING_VIEW="SELECT "+COLOUMN_ARTIST_name+","+COLOUMN_SONG_ALBUMID+","+COLOUMN_SONG_TRACK+
            " FROM "+TABLE_FOR_ARTIST_LIST_VIEW+" WHERE "+COLOUMN_SONG_TITLE+" =\"";

    //instead of hard coding of concatinate of string for songName we use Prepared Statement for QWERY_FOR_SONG_ARTIST_USING_VIEW
    public static final String QWERY_FOR_SONG_ARTIST_USING_VIEW_PREP="SELECT "+ COLOUMN_ARTIST_name +","+ COLOUMN_SONG_ALBUMID +","+ COLOUMN_SONG_TRACK +
            " FROM "+ TABLE_FOR_ARTIST_LIST_VIEW +" WHERE "+ COLOUMN_SONG_TITLE +" = ?";


    public static final String INSERT_ARTIST="INSERT INTO "+ TABLE_ARTISTS + '(' + COLOUMN_ARTIST_name +
            " ) VALUES(?)";


    public static final String INSERT_ALBUM="INSERT INTO "+ TABLE_ALBUMS + '(' + COLOUMN_ALBUM_NAME +" , "+ COLOUMN_ALBUM_ARTISTID +
            " ) VALUES(?,?)";


    public static final String INSERT_SONG="INSERT INTO "+ TABLE_SONGS + '(' +COLOUMN_SONG_TRACK+","+ COLOUMN_SONG_TITLE +","+ COLOUMN_SONG_ALBUMID +
            " ) VALUES(?,?,?)";




    public static final String QWERY_ALBUM="SELECT "+COLOUMN_ALBUM_ID+" FROM "+ TABLE_ALBUMS +
            " WHERE "+ COLOUMN_ALBUM_NAME +" = ?";

    public static final String QWERY_ARTIST="SELECT "+COLOUMN_ARTIST_ID+" FROM "+ TABLE_ARTISTS +
            " WHERE "+ COLOUMN_ARTIST_name +" = ?";

    public static final String QWERY_SONG="SELECT "+COLOUMN_SONG_ID+" FROM "+TABLE_SONGS+
            " WHERE "+COLOUMN_SONG_TITLE+" = ?";

    public static final String QWERY_ALBUMS_BY_ARTISTID="SELECT * FROM "+TABLE_ALBUMS+" WHERE "+
            COLOUMN_ALBUM_ARTISTID+" = ? ORDER BY "+COLOUMN_ALBUM_NAME+","+COLOUMN_ALBUM_ID;

    public static final String UPDATE_ARTIST="UPDATE "+TABLE_ARTISTS+" SET "+COLOUMN_ARTIST_name+" =? "+" WHERE "+COLOUMN_ARTIST_ID+" = ? ";


    private  PreparedStatement preparedStatementForSongArtist_View;//we are creating preapred Statement instance as we want it to initilised it once


    private PreparedStatement insert_INTO_Artist;
    private PreparedStatement insert_INTO_Album;
    private PreparedStatement insert_INTO_Song;

    private PreparedStatement qweryArtist;
    private PreparedStatement qweryAlbum;
    private PreparedStatement qwerySong;
    private PreparedStatement qweryAlbumByArtistID;
    public PreparedStatement updateAtist;

    private static Database instance=new Database();

    public Database() {
    }

    public static Database getInstance(){
        return instance;
    }



    private Connection connection;
    public boolean open(){
        try {
              connection= DriverManager.getConnection(CONNECTION_STRING);
            preparedStatementForSongArtist_View=connection.prepareStatement(QWERY_FOR_SONG_ARTIST_USING_VIEW_PREP);
            insert_INTO_Artist =connection.prepareStatement(INSERT_ARTIST,Statement.RETURN_GENERATED_KEYS);
            insert_INTO_Album =connection.prepareStatement(INSERT_ALBUM,Statement.RETURN_GENERATED_KEYS);
            insert_INTO_Song =connection.prepareStatement(INSERT_SONG);
            qweryArtist=connection.prepareStatement(QWERY_ARTIST);
            qweryAlbum=connection.prepareStatement(QWERY_ALBUM);
            qwerySong=connection.prepareStatement(QWERY_SONG);
            qweryAlbumByArtistID=connection.prepareStatement(QWERY_ALBUMS_BY_ARTISTID);
            updateAtist=connection.prepareStatement(UPDATE_ARTIST);
            return true;
          }catch (SQLException e){
                  System.out.println("not able to connect"+e.getMessage());
                  return false;
              }


    }

public void close(){

            try {
                if (preparedStatementForSongArtist_View!=null){
                    preparedStatementForSongArtist_View.close();
                }
                if (insert_INTO_Artist !=null){
                    insert_INTO_Artist.close();
                }
                if (insert_INTO_Album !=null){
                    insert_INTO_Album.close();
                }
                if (insert_INTO_Song !=null){
                    insert_INTO_Song.close();
                }
                if (qweryArtist!=null){
                    qweryArtist.close();
                }

                if (qweryAlbum!=null){
                    qweryAlbum.close();
                }
                if (qweryAlbumByArtistID!=null){
                    qweryAlbumByArtistID.close();
                }
                if (updateAtist!=null){
                    updateAtist.close();
                }

                if (connection!=null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println("not able to close"+e.getMessage());
            }
        }


        public List<Artists> artistQuery(int sortOrder){
        StringBuilder sb=new StringBuilder("SELECT *FROM artists");
        if (sortOrder!=ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLOUMN_ARTIST_name);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder==ORDER_BY_DESC){
                sb.append(" DESC ");
            }else {
                sb.append(" ASC ");
            }
        }
            System.out.println(sb.toString());
        try(Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(sb.toString())) {

            List<Artists> artists=new ArrayList<>();
            while (result.next()){
              try {
                  Thread.sleep(7);
              }catch (InterruptedException e){
                  System.out.println(e.getMessage());
              }
                Artists artist=new Artists();
                artist.set_id(result.getInt(INDEX_COLOUMN_ARTISTS_ID));
                artist.setName(result.getString(INDEX_COLOUMN_ALBUMS_NAME));
                artists.add(artist);
            }
            return artists;
        }catch (SQLException e){
            System.out.println("Query failed : "+e.getMessage());
            return null;
        }
    }

    public Boolean updateArtist(String name,int id){
        try {
            updateAtist.setString(1,name);
            updateAtist.setInt(2,id);
            int recordUpdate = updateAtist.executeUpdate();

            return recordUpdate==1;

        }catch (SQLException e){
            System.out.println("update failed "+e.getMessage());
            return false;
        }
    }

    public List<Albums> qweryAlbum_by_ArtistID(int id){
       try {
           qweryAlbumByArtistID.setInt(1,id);
           ResultSet resultSet=qweryAlbumByArtistID.executeQuery();

           List<Albums> albums=new ArrayList<>();
           while (resultSet.next()){
               Albums albums1=new Albums();
               albums1.set_id(resultSet.getInt(1));
               albums1.setName(resultSet.getString(2));
               albums1.setArtistId(id);
               albums.add(albums1);
           }
           return albums;
       }catch (SQLException e){
           System.out.println(e.getMessage());
           return null;
       }

    }

    public List<String> queryOf_Albums_BY_Artist(String artistName,int sortOrder){
        StringBuilder sb=new StringBuilder(QWERY_OF_ALBLUM_BY_ARTIST);

        sb.append(artistName);
        sb.append("\"");
        if (sortOrder!=ORDER_BY_NONE){
            sb.append(ORDER_FOR_QWERY_OF_ALBLUM_BY_ARTIST_SORT);
        sb.append(" COLLATE NOCASE ");
            if (sortOrder==ORDER_BY_DESC){
                sb.append(" DESC ");
            }else {
                sb.append(" ASC ");
            }
        }
        System.out.println(sb.toString());

        try(Statement statement=connection.createStatement();
        ResultSet result=statement.executeQuery(sb.toString())) {
            List<String> albums=new ArrayList<>();
            while (result.next()){
                albums.add(result.getString(1));
            }
            return albums;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }


    }




    public void songSchema(){
        try(Statement statement=connection.createStatement();
        ResultSet result=statement.executeQuery("SELECT *FROM songs")) {

            ResultSetMetaData metaData=result.getMetaData();
            int coloumCount=metaData.getColumnCount();
            for(int i=1;i<=coloumCount;i++){//here i=1 because coloumn indices start from 1
                System.out.println("Coloumn no "+i+" Coloumn name = "+metaData.getColumnName(i));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public int getCount(String table){
        String sql="SELECT COUNT(*) AS COUNT  FROM "+table;
        try(Statement statement=connection.createStatement();
        ResultSet result=statement.executeQuery(sql)) {

            int count=result.getInt("COUNT");
            System.out.println("count = "+count);

            return count;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public boolean creating_view_for_artist_list(){
        try(Statement statement=connection.createStatement()) {
            statement.execute(CREATE_VIEW_FOR_ARTIST_LIST);
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }



    private int insertArtist(String name) throws SQLException{

            qweryArtist.setString(1,name);
            ResultSet result=qweryArtist.executeQuery();
            if (result.next()){//result.next is present means the artist is present in artist table so we return artist id
                return result.getInt(1);
            }else {
                //the artist is not pressent we add new artist to artists table
                insert_INTO_Artist.setString(1,name);
                int recordUpdate=insert_INTO_Artist.executeUpdate();//here we use executeUpdate() instead of exceute execute() because we required int value which is given by executeUpdate() where boolean by execute()

                if (recordUpdate!=1){
                    throw new SQLException("can't able to add in artist");
                }

                ResultSet generateKey=insert_INTO_Artist.getGeneratedKeys();
                if (generateKey.next()){
                    return generateKey.getInt(1);
                }else {
                    throw  new SQLException("could not generate _id");
                }
            }

    }

    private int insertAlbum(String name,int artistId) throws SQLException{

        qweryAlbum.setString(1,name);
        ResultSet resultSet=qweryAlbum.executeQuery();
        if (resultSet.next()){//result.next is present means the album(name) is present in album table so we return album id
            return resultSet.getInt(1);
        }else {
            insert_INTO_Album.setString(1,name);
            insert_INTO_Album.setInt(2,artistId);
            int recordUpdated=insert_INTO_Album.executeUpdate();
            if (recordUpdated!=1){
                throw new SQLException(" not able to add  album");
            }

            ResultSet generatedKey=insert_INTO_Album.getGeneratedKeys();
            if (generatedKey.next()){
                return generatedKey.getInt(1);
            }else {
                throw new SQLException("not able to get _id for album");
            }
        }
    }

    public void insertSong(String title,String artist,String album,int track) {
        try {
            connection.setAutoCommit(false);

            int artistID = insertArtist(artist);
            int albumId = insertAlbum(album, artistID);

            insert_INTO_Song.setInt(1, track);
            insert_INTO_Song.setString(2, title);
            insert_INTO_Song.setInt(3, albumId);

            int recordChange = insert_INTO_Song.executeUpdate();
            if (recordChange == 1) {
                connection.commit();
            }else {
                throw new SQLException("the song insert failed");
            }


        } catch (Exception e) {
            System.out.println("Could't insert song" + e.getMessage());
            try {
                System.out.println("performing rollback");
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("some thing went wrong " + e1.getMessage());
            }
        } finally {
            try {
                System.out.println("reset to default Behaviour ");
                connection.setAutoCommit(true);
            } catch (SQLException e2) {
                System.out.println("could not able to reset" + e2.getMessage());
            }
        }

    }
}


