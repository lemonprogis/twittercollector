package com.lemonpro.tweetcollector;

import java.util.Date;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
/**
 * Our tweet status listener class
 * @author lemonprogis
 */
public class TweetCollectorStatusListener implements StatusListener {
    
    TwitterStream mTwitterStream = null;
    FilterQuery mFilterQuery = null;
    TweetCollectorConfig tConfig = null;
    /**
     * Constructor
     */
    public TweetCollectorStatusListener(){
        mTwitterStream = new TwitterStreamFactory(config().build()).getInstance();
        tConfig = new TweetCollectorConfig();
        }
    /**
     * Override method for onStatus
     * This is where statuses come in and we will insert them into our 
     * sqlite database.
     * @param status 
     */
    @Override
    public void onStatus(Status status) {
        double statusLat = 0.0;
	double statusLng = 0.0;
	User user = status.getUser();
	String username = status.getUser().getScreenName();
	String profileLocation = user.getLocation();
	//System.out.println(profileLocation);
	int tweetId = (int) status.getId(); 
	String content = status.getText();
	if(status.isRetweet())
	content = status.getRetweetedStatus().getText();
	GeoLocation geolocation = status.getGeoLocation();
	if(geolocation != null){
            //System.out.println(geolocation);
	    statusLat = geolocation.getLatitude();
            statusLng = geolocation.getLongitude();
        }
	Date createdAt = status.getCreatedAt();
	String userProfileImage = user.getBiggerProfileImageURL();
		        
	DbHandler.insertTweet(tweetId, username, profileLocation, content, userProfileImage, statusLat, statusLng, createdAt);
        
    }
    
    /**
     * Override for onDeletionNotice
     * @param sdn 
     */
    @Override
    public void onDeletionNotice(StatusDeletionNotice sdn) {
       
    }
    /**
     * Override for onTrackLimitationNotice
     * @param i 
     */
    @Override
    public void onTrackLimitationNotice(int i) {
        
    }
    /**
     * Override for onScrubGeo
     * @param l
     * @param l1 
     */
    @Override
    public void onScrubGeo(long l, long l1) {
        
    }
    /**
     * Override for onStallWarning
     * @param sw 
     */
    @Override
    public void onStallWarning(StallWarning sw) {
        
    }
    /**
     * Override for onException
     * @param excptn 
     */
    @Override
    public void onException(Exception excptn) {
        
    }
    
    /**
     * Creates the configuration for starting our listener
     * @return configuration builder instance
     */
    private ConfigurationBuilder config(){
        
        tConfig.setTweetCollectorConfig();
	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true)
	.setOAuthConsumerKey(TweetCollectorConfig.CONSUMER_KEY)
	.setOAuthConsumerSecret(TweetCollectorConfig.CONSUMER_SECRET)
	.setOAuthAccessToken(TweetCollectorConfig.ACCESS_TOKEN)
	.setOAuthAccessTokenSecret(TweetCollectorConfig.ACCESS_TOKEN_SECRET);
	
	return cb;
    }
    /**
     * What determines how we will filter tweets.
     * Either using keywords or by location.
     * @param code
     * @param locations
     * @param track 
     */
    public void filterQuery(int code, double[][] locations, String[] track){
        mFilterQuery = new FilterQuery();
        switch(code){
            case 0:
                mFilterQuery.locations(locations);
                break;
            case 1:
                mFilterQuery.track(track);
                break;
            default:
                break;
        }
    }
    
    /**
     * Used to start our twitter stream
     */
    public void startStream(){
        mTwitterStream.addListener(this);
        mTwitterStream.filter(mFilterQuery);
    }
    /**
     * Used to shutdown our twitter stream
     */
    public void endStream(){
        mTwitterStream.shutdown();
    }
    
}
