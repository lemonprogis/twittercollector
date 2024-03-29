package com.lemonpro.tweetcollector;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;

/**
 * Our GUI Class
 * @author lemonprogis
 */
public class TweetCollectorGui extends javax.swing.JFrame {

    private static final String STARTED = "Started";
    private static final String STOPPED = "Stopped";
    private static final String TITLE = "Tweet Collector by Lemon Pro";
    private static double lat,lng,lat1,lng1,lat2,lng2, bb;
    
    TweetCollectorStatusListener mStatusListener;
    /**
     * GUI constructor
     */
    public TweetCollectorGui() {
        initComponents();
        
        
        DbHandler.createTweetTable();
        this.setTitle(TITLE);
        mStatusListener = new TweetCollectorStatusListener();
        keywordFieldsVisible(false);
        locationFieldsVisible(false);
        statusLabel.setForeground(Color.RED);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        keyword = new javax.swing.JRadioButton();
        location = new javax.swing.JRadioButton();
        keywords = new javax.swing.JTextField();
        keywordLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        latitudeLabel = new javax.swing.JLabel();
        longitudeLabel = new javax.swing.JLabel();
        bbPropertyLabel = new javax.swing.JLabel();
        locationInfoLabel = new javax.swing.JLabel();
        latitude = new javax.swing.JTextField();
        longitude = new javax.swing.JTextField();
        bbProperty = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        startAllGeoTaggedBtn = new javax.swing.JButton();
        stopAllGeoTaggedBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        viewTweetsButton = new javax.swing.JButton();
        exportTweetsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        limitValue = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tweetViewArea = new javax.swing.JTextArea();
        viewTweetsStatus = new javax.swing.JLabel();
        sqlStatementField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(keyword);
        keyword.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        keyword.setText("Keyword");
        keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordActionPerformed(evt);
            }
        });

        buttonGroup1.add(location);
        location.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        location.setText("Location");
        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });

        keywords.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        keywords.setText("#arwx, weather, tornadoes");

        keywordLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        keywordLabel.setForeground(new java.awt.Color(51, 51, 51));
        keywordLabel.setText("Keywords (comma delimited):");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Filter:");

        latitudeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        latitudeLabel.setForeground(new java.awt.Color(51, 51, 51));
        latitudeLabel.setText("Latitude:");

        longitudeLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        longitudeLabel.setForeground(new java.awt.Color(51, 51, 51));
        longitudeLabel.setText("Longitude:");

        bbPropertyLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        bbPropertyLabel.setForeground(new java.awt.Color(51, 51, 51));
        bbPropertyLabel.setText("+/- :");

        locationInfoLabel.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        locationInfoLabel.setForeground(new java.awt.Color(51, 51, 51));
        locationInfoLabel.setText("The above will create the bounding box to collect tweets");

        latitude.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        longitude.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        longitude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                longitudeActionPerformed(evt);
            }
        });

        bbProperty.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        startButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Status:");

        statusLabel.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(204, 0, 0));
        statusLabel.setText("Stopped");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("All Geotagged Tweets");

        startAllGeoTaggedBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        startAllGeoTaggedBtn.setText("Start");
        startAllGeoTaggedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startAllGeoTaggedBtnActionPerformed(evt);
            }
        });

        stopAllGeoTaggedBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        stopAllGeoTaggedBtn.setText("Stop");
        stopAllGeoTaggedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopAllGeoTaggedBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(keyword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(location)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keywordLabel)
                            .addComponent(locationInfoLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stopButton))
                            .addComponent(keywords, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(longitudeLabel)
                                    .addComponent(bbPropertyLabel)
                                    .addComponent(latitudeLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(latitude, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(bbProperty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(longitude, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addContainerGap(168, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startAllGeoTaggedBtn)
                                .addGap(18, 18, 18)
                                .addComponent(stopAllGeoTaggedBtn)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyword)
                    .addComponent(location)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(statusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keywordLabel)
                .addGap(4, 4, 4)
                .addComponent(keywords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(latitudeLabel)
                    .addComponent(latitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(longitudeLabel)
                    .addComponent(longitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bbPropertyLabel)
                    .addComponent(bbProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(stopButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startAllGeoTaggedBtn)
                    .addComponent(stopAllGeoTaggedBtn))
                .addGap(25, 25, 25))
        );

        tabbedPane.addTab("Collect Tweets", jPanel1);

        viewTweetsButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        viewTweetsButton.setText("View Tweets");
        viewTweetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTweetsButtonActionPerformed(evt);
            }
        });

        exportTweetsButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        exportTweetsButton.setText("Export Tweets");
        exportTweetsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTweetsButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Num of Rows:");

        limitValue.setText("100");

        tweetViewArea.setColumns(20);
        tweetViewArea.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 13)); // NOI18N
        tweetViewArea.setRows(5);
        jScrollPane2.setViewportView(tweetViewArea);

        viewTweetsStatus.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        viewTweetsStatus.setText("Status...");

        sqlStatementField.setText("WHERE TWEET_LAT > 0");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("SELECT * FROM TWEETS ");

        jLabel3.setFont(new java.awt.Font("Calibri", 2, 12)); // NOI18N
        jLabel3.setText("Fields: ID, TWEETID, USERNAME, PROFILE_LOCATION, TWEET, USER_PROFILE_IMAGE, TWEET_LAT, TWEET_LNG, TWEET_DT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(viewTweetsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportTweetsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewTweetsStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(limitValue, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sqlStatementField, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sqlStatementField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(limitValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportTweetsButton)
                    .addComponent(viewTweetsButton)
                    .addComponent(viewTweetsStatus))
                .addGap(35, 35, 35))
        );

        tabbedPane.addTab("Export Tweets", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane))
        );

        tabbedPane.getAccessibleContext().setAccessibleName("Collect Tweets");
        tabbedPane.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Start Button Event
     * @param evt 
     */
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
       if(location.isSelected()){
           mStatusListener.filterQuery(0, setLocationFields(), null);
       }
       else{
        mStatusListener.filterQuery(1, null, setKeywordFields());
       }
        mStatusListener.startStream();
        statusLabel.setText(STARTED);
        statusLabel.setForeground(Color.GREEN);
    }//GEN-LAST:event_startButtonActionPerformed
    /**
     * Stop Button Event
     * @param evt 
     */
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed

        mStatusListener.endStream();
        statusLabel.setText(STOPPED);
        statusLabel.setForeground(Color.RED);
    }//GEN-LAST:event_stopButtonActionPerformed
    /**
     * View Tweets Button Event
     * @param evt 
     */
    private void viewTweetsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTweetsButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<HashMap<String,String>> data = DbHandler.getData(limitValue.getText(), sqlStatementField.getText());
        String[] columns = {"ID, TWEETID, USERNAME, PROFILE_LOCATION, TWEET, USER_PROFILE_IMAGE, TWEET_LAT, TWEET_LNG, TWEET_DT"};
        viewTweetsStatus.setText("Fetching...");
        writeToTextBox(data, columns);
       
    }//GEN-LAST:event_viewTweetsButtonActionPerformed
    /**
     * Populates our textbox with the returned results from our database
     * @param list
     * @param columnNames 
     */
    public void writeToTextBox(ArrayList<HashMap<String,String>> list, 
            String[] columnNames){
        tweetViewArea.setText("");
        for(String item : columnNames){
            tweetViewArea.append(item+", ");

        }
        tweetViewArea.append("\n");
        for(HashMap<String,String> map : list){
            String line = map.get("ID").toString()+","+
                    map.get("TWEETID").toString()+","+
                    map.get("USERNAME").toString()+","+
                    map.get("PROFILE_LOCATION").toString()+","+
                    map.get("TWEET").toString()+","+
                    map.get("USER_PROFILE_IMAGE").toString()+","+
                    map.get("TWEET_LAT").toString()+","+
                    map.get("TWEET_LNG").toString()+","+
                    map.get("TWEET_DT").toString()+",";
           
            tweetViewArea.append(line);
            tweetViewArea.append("\n");
        }
        viewTweetsStatus.setText("Complete!");
    }
    /**
     * Export Button Event
     * @param evt 
     */
    private void exportTweetsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTweetsButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try{
            File file = new File(selectedFile.getAbsolutePath());
            if(file.exists())
                file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(tweetViewArea.getText());
            bw.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_exportTweetsButtonActionPerformed
    /**
     * Keyword Selected Event
     * @param evt 
     */
    private void keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordActionPerformed
        keywordFieldsVisible(true);
        locationFieldsVisible(false);
    }//GEN-LAST:event_keywordActionPerformed
    /**
     * Location Selected Event
     * @param evt 
     */
    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        keywordFieldsVisible(false);
        locationFieldsVisible(true);
    }//GEN-LAST:event_locationActionPerformed
    /**
     * Longitude Action Event
     * NOT USED
     * @param evt 
     */
    private void longitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_longitudeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_longitudeActionPerformed
    /**
     * Start Button Event
     * For collecting all Geotagged tweets
     * @param evt 
     */
    private void startAllGeoTaggedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startAllGeoTaggedBtnActionPerformed

        mStatusListener.filterQuery(0, setAllGeoTaggedLocations(), null);
        mStatusListener.startStream();
        statusLabel.setText(STARTED);
        statusLabel.setForeground(Color.GREEN);
        
    }//GEN-LAST:event_startAllGeoTaggedBtnActionPerformed
    /**
     * Stop Button Event
     * For stopping collection of all Geotagged tweets
     * @param evt 
     */
    private void stopAllGeoTaggedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopAllGeoTaggedBtnActionPerformed
        mStatusListener.endStream();
        statusLabel.setText(STOPPED);
        statusLabel.setForeground(Color.RED);
    }//GEN-LAST:event_stopAllGeoTaggedBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TweetCollectorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TweetCollectorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TweetCollectorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TweetCollectorGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TweetCollectorGui().setVisible(true);
                
            }
        });
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bbProperty;
    private javax.swing.JLabel bbPropertyLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton exportTweetsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton keyword;
    private javax.swing.JLabel keywordLabel;
    private javax.swing.JTextField keywords;
    private javax.swing.JTextField latitude;
    private javax.swing.JLabel latitudeLabel;
    private javax.swing.JTextField limitValue;
    private javax.swing.JRadioButton location;
    private javax.swing.JLabel locationInfoLabel;
    private javax.swing.JTextField longitude;
    private javax.swing.JLabel longitudeLabel;
    private javax.swing.JTextField sqlStatementField;
    private javax.swing.JButton startAllGeoTaggedBtn;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton stopAllGeoTaggedBtn;
    private javax.swing.JButton stopButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextArea tweetViewArea;
    private javax.swing.JButton viewTweetsButton;
    private javax.swing.JLabel viewTweetsStatus;
    // End of variables declaration//GEN-END:variables
    /**
     * get the latitude and longitude and then creates a bounding box
     * @return a bounding box with two pairs of coordinates
     */
    private double[][] setLocationFields(){
        // get my text box fields and convert to doubles
        lat = Double.parseDouble(latitude.getText());
        lng = Double.parseDouble(longitude.getText());
        bb = Double.parseDouble(bbProperty.getText());
        // create my bounding box lat lngs
        lat1 = lat - bb;
        lng1 = lng - bb;
        lat2 = lat + bb;
        lng2 = lng + bb;
        // package up in a list of coord lists
        double[][] bbLocations = {{lng1,lat1},{lng2,lat2}};
        return bbLocations;
    }
    /**
     * For collecting all geotagged tweets around the world
     * @return a bounding box for the world
     */
    private double[][] setAllGeoTaggedLocations(){
        double lat = 90.0;
        double lng = 180.0;
        double lat2 = lat * -1;
        double lng2 = lng * -1;
        double[][] bbLocations = {{lng2,lat2},{lng,lat}};
        return bbLocations;
    }
    /**
     * Splits keywords by the comma delimiter
     * @return a list of the keywords
     */
    private String[] setKeywordFields(){
        String[] searchKeywords = keywords.getText().split(",");
        return searchKeywords;
    }
    /**
     * Sets keyword fields visibility
     * @param val 
     */
    private void keywordFieldsVisible(boolean val){
        keywordLabel.setVisible(val);
        keywords.setVisible(val);
    }
    /**
     * Sets location fields visibility
     * @param val 
     */
    private void locationFieldsVisible(boolean val){
        
        latitudeLabel.setVisible(val);
        longitudeLabel.setVisible(val);
        bbPropertyLabel.setVisible(val);
        locationInfoLabel.setVisible(val);
        latitude.setVisible(val);
        longitude.setVisible(val);
        bbProperty.setVisible(val);
        
    }
}


