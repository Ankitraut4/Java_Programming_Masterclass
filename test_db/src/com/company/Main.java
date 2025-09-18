package com.company;

import java.sql.*;

public class Main {
    //constant
    public static final String DB="testjava.db";
    public static final String CONNECTION_SRTRING="jdbc:sqlite:A:\\java\\test_db\\"+DB;

    public static final String TABLE_CONTACTS="contacts";
    public static final String COLOUMN_NAME="name";
    public static final String COLOUMN_PHONE="phone";
    public static final String COLOUMN_EMAIL="email";


    public static void main(String[] args) {0

        try {
            Connection conn=DriverManager.getConnection(CONNECTION_SRTRING);
            Statement statement=conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS "+TABLE_CONTACTS);


            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "( "+ COLOUMN_NAME + " text, "
                    + COLOUMN_PHONE + " integer, "
                    + COLOUMN_EMAIL +" text"
                    + ")" );

            insert(statement,"Ankit",888,"ankit@gmail");
            insert(statement,"mohit",999,"mohit@");
            insert(statement,"suresh",9421,"suresh@");

            //using method for INSERT
//            statement.execute("INSERT INTO " + TABLE_CONTACTS + " ( " +
//                    COLOUMN_NAME + "," +
//                    COLOUMN_PHONE + "," +
//                    COLOUMN_EMAIL + ")" +
//                    " VALUES('Ankit',888,'ankit@gmail.com')" );
//
//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    "(" + COLOUMN_NAME + "," +
//                     COLOUMN_PHONE + "," +
//                    COLOUMN_EMAIL + " )" +
//                    "VALUES('mohit',862,'mohit@')" );
//
//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    "(" + COLOUMN_NAME + "," +
//                    COLOUMN_PHONE + "," +
//                    COLOUMN_EMAIL + " )" +
//                    "VALUES('suresh',9421,'suresh@')" );
//
//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    "(" + COLOUMN_NAME + "," +
//                    COLOUMN_PHONE + "," +
//                    COLOUMN_EMAIL + " )" +
//                    "VALUES('sangita',111,'sangita@')" );

            statement.execute(" UPDATE "+TABLE_CONTACTS+" SET "+COLOUMN_PHONE+"=9999"+" WHERE " +COLOUMN_NAME+" = 'mohit'");

            statement.execute("DELETE FROM "+TABLE_CONTACTS+ " WHERE " +COLOUMN_NAME+" ='sangita'");
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("some thing went wrong"+e.getMessage());
            e.printStackTrace();
        }











        //without constants (below code)
        //	try{
//        Connection conn= DriverManager.getConnection("jdbc:sqlite:A:\\java\\test_db\\testjava.db");//this is use to connect jdbc to th database
//        Statement statement=conn.createStatement();
//        statement.execute("CREATE TABLE IF NOT EXISTS contacts(name TEXT,phone INTEGER,email TEXT)");
////        statement.execute("INSERT INTO contacts (name,phone,email) VALUES ('ANkit',656,'ankit@gmail.com')");//we can write this in below way
////        statement.execute("INSERT INTO contacts (name,phone,email)"+
////                "VALUES ('Ankit',656,'ankit@gmail.com')");
//
////        statement.execute("INSERT INTO contacts (name,phone,email)"+
////                "VALUES ('mohit',1234,'mohit@gmail.com')");
////
////        statement.execute("INSERT INTO contacts (name,phone,email)"+
////                "VALUES ('suresh',942312,'suresh@gmail.com')");
////
////        statement.execute("INSERT INTO contacts (name,phone,email)"+
////                "VALUES ('sangita',768,'sangita@gmail.com')");
//
//       // statement.execute("UPDATE contacts SET phone=444 WHERE name='mohit'");
//
//      //  statement.execute("DELETE FROM contacts WHERE name='sangita'");
//
////@1//        statement.execute("SELECT *FROM contacts");
////        ResultSet result= statement.getResultSet();//exceuting query and return resultSet
////        while (result.next()){
////            System.out.println(result.getString("name")+" "
////                                +result.getInt("phone")+" "
////                                 +result.getString("email"));
////        }
////@1//        result.close();
//
//      //another way of exceution query for code @1
//      ResultSet result= statement.executeQuery("SELECT * FROM contacts");
//      while (result.next()){
//          System.out.println(result.getString("name")+" "
//                               +result.getInt("phone")+" "
//                                 +result.getString("email"));
//      }
//       result.close();
//
//        statement.cancel();
//        conn.close();  //the statement.close(); conn.close(); is order sensitive so we have to close statement first then connecton
//    }catch (SQLException e){
//        System.out.println("SOMEthing went wrong: "+e.getMessage());
//    }
    }


//method
    public static void insert(Statement statement,String name,int phone,String email) throws SQLException{
        statement.execute("INSERT INTO  "+ TABLE_CONTACTS + " ( " +
                COLOUMN_NAME + ", " +
                COLOUMN_PHONE + ", " +
                COLOUMN_EMAIL + " ) " +
                "VALUES( ' " +name+ "'," +phone+ ",'" +email+ " ') ");
    }



}

