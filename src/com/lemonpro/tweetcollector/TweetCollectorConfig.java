package com.lemonpro.tweetcollector;

import java.io.File;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Our Configuration Class
 * @author lemonprogis
 */
public class TweetCollectorConfig {
    private static final String CONFIG_PATH = "TweetCollectorConfig.xml";
    
    public static String CONSUMER_KEY = null;
    public static String CONSUMER_SECRET = null;
    public static String ACCESS_TOKEN = null;
    public static String ACCESS_TOKEN_SECRET = null;
    /**
     * Constructor
     */
    public TweetCollectorConfig(){
        
    }
    /**
     * Sets our configuration slots by reading our TweetCollectorConfig.xml file
     */
    public void setTweetCollectorConfig(){
        try {
            
            File mConfigFile = new File(getClass().getClassLoader().getResource(CONFIG_PATH).getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(mConfigFile);
            
            doc.getDocumentElement().normalize();
            
            NodeList nodes = doc.getElementsByTagName("configuration");
            
            for (int i = 0; i < nodes.getLength(); i++){
                Node node = nodes.item(i);
              
                Element element = (Element)node;
                
                CONSUMER_KEY = element.getElementsByTagName("consumer_key").item(0).getTextContent();
                CONSUMER_SECRET = element.getElementsByTagName("consumer_secret").item(0).getTextContent();
                ACCESS_TOKEN = element.getElementsByTagName("access_token").item(0).getTextContent();
                ACCESS_TOKEN_SECRET = element.getElementsByTagName("access_token_secret").item(0).getTextContent();
            }
        } 
        catch(Exception e){
            // config not picking up!
        }
    
    
    
    }
}
