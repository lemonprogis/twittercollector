package com.lemonpro.tweetcollector;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;

/**
* Used for handling all transactions with our sqlite database
* @author lemonprogis
*/
public class DbHandler {
    public static Connection mConn = null;
    public static Statement  mStatement = null;
    
    /**
     * Creates our tweet table with fields
     * ID, TWEETID, USERNAME, PROFILE_LOCATION, TWEET, USER_PROFILE_IMAGE
     * TWEET_LAT, TWEET_LNG, TWEET_DT
     */
    public static void createTweetTable(){        
                try {
                    Class.forName("org.sqlite.JDBC");
                    mConn = DriverManager.getConnection("jdbc:sqlite:tweets.db");
                    String sql = "CREATE TABLE IF NOT EXISTS TWEETS " +
                    	"(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "TWEETID INT, " +
                        "USERNAME TEXT, " +
                        "PROFILE_LOCATION TEXT," +
                        "TWEET TEXT, " +
                        "USER_PROFILE_IMAGE TEXT, " + 
                        "TWEET_LAT REAL, " +
                        "TWEET_LNG REAL," + 
                        "TWEET_DT TEXT)";
                    mStatement = mConn.createStatement();
                    mStatement.executeUpdate(sql);
                    mStatement.close();
                    mConn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    /**
     * Used for inserting into our database.
     * @param id
     * @param username
     * @param profileLocation
     * @param tweet
     * @param userProfileImage
     * @param tweetLat
     * @param tweetLng
     * @param tweetDateTime 
     */
    public static void insertTweet(int id, String username, String profileLocation, String tweet, String userProfileImage, 
            double tweetLat, double tweetLng, java.util.Date tweetDateTime){
                try {
                    Class.forName("org.sqlite.JDBC");
                    mConn = DriverManager.getConnection("jdbc:sqlite:tweets.db");
                    String sql = "INSERT INTO TWEETS (TWEETID, USERNAME, PROFILE_LOCATION, TWEET, USER_PROFILE_IMAGE, TWEET_LAT, TWEET_LNG, TWEET_DT) " +
                                  "VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement pStatement = mConn.prepareStatement(sql);
                    int index = 1;
                    pStatement.setInt(index++, id);
                    pStatement.setString(index++, username);
                    pStatement.setString(index++, profileLocation);
                    pStatement.setString(index++, tweet);
                    pStatement.setString(index++, userProfileImage);
                    pStatement.setDouble(index++, tweetLat);
                    pStatement.setDouble(index++, tweetLng);
                    pStatement.setString(index++, tweetDateTime.toString());
                    pStatement.addBatch();
                    
                    mConn.setAutoCommit(false);
                    pStatement.executeBatch();
                    mConn.setAutoCommit(true);
                    mConn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    /**
     * for deleting our table and all data
     */
    public static void dropTable(){
                try {
                    Class.forName("org.sqlite.JDBC");
                    mConn = DriverManager.getConnection("jdbc:sqlite:tweets.db");
                    String sql = "DROP TABLE IF EXISTS TWEETS;";
                    
                    mStatement = mConn.createStatement();
                    mStatement.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    /**
     * This is how we can query our tweets table. Uses a where clause and limit to 
     * return data as an array list
     * @param limit
     * @param whereClause
     * @return array list of hashmaps 
     */
    public static ArrayList<HashMap<String,String>> getData(String limit, String whereClause){
        if(limit == null)
            limit = "100";
        if(whereClause == null)
            whereClause = "ORDER BY ID ASC";
        
        try {	
                Class.forName("org.sqlite.JDBC");
                mConn = DriverManager.getConnection("jdbc:sqlite:tweets.db");
                String sql = "select * from TWEETS " + whereClause + " LIMIT " + limit+";";
                System.out.println(sql);
                mStatement = mConn.createStatement();
                ResultSet rs = mStatement.executeQuery(sql);
                //List<HashMap> data = new ArrayList<HashMap>();
                ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
                while(rs.next()){
                	HashMap<String,String> hm = new HashMap<String,String>();
                        
                	int index = 1;
                	//ID, TWEETID, USERNAME, PROFILE_LOCATION, TWEET, USER_PROFILE_IMAGE, TWEET_LAT, TWEET_LNG, TWEET_DT
                        
                	hm.put("ID", rs.getString(index++));
                	hm.put("TWEETID", rs.getString(index++));
                	hm.put("USERNAME", rs.getString(index++));
                	hm.put("PROFILE_LOCATION", rs.getString(index++));
                	hm.put("TWEET", rs.getString(index++));
                	hm.put("USER_PROFILE_IMAGE", rs.getString(index++));
                	hm.put("TWEET_LAT", rs.getString(index++));
                	hm.put("TWEET_LNG", rs.getString(index++));
                	hm.put("TWEET_DT", rs.getString(index++));
                	data.add(hm);
                       
                }
                rs.close();
                mStatement.close();
                mConn.close();
                return data;
            } catch (SQLException ex) {
                Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        	
    }
    
}
