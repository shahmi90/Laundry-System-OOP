/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laundrysystem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;
/**
 *
 * @author shahm
 */
public class Alarm_Clock extends javax.swing.JFrame implements Runnable{
String sound,title;
    FileInputStream fileInputStream;
    BufferedInputStream bufferedInputStream;
    Player player;
    long all;
    String hours, hh, mm;
    String hourAlarm, minuteAlarm;




    /**
     * Creates new form Alarm_Clock
     */
    public Alarm_Clock() {
        initComponents();
        Thread t = new Thread(this);
        t.start();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("mm");
        Date date = c.getTime();
        hh = simpleDateFormat1.format(date);
        mm = simpleDateFormat2.format(date);
        jComboBox1.setSelectedItem(hh);
        jComboBox2.setSelectedItem(mm);
        this.setLocationRelativeTo(null);
    }
    
    public void chooseSong(){
        JFileChooser jfc = new JFileChooser();
        int soundINT = jfc.showOpenDialog(null);
        if (soundINT == JFileChooser.APPROVE_OPTION){
            File alarmMusic = jfc.getSelectedFile();
            sound = alarmMusic.getAbsolutePath();
            title = jfc.getSelectedFile().getName();
            System.out.println(title);
        }
        else if (soundINT == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog (null, "You dont't choose alarm music yet...");
        }
    }
    
    public void startAlarm(){
        try{
            fileInputStream = new FileInputStream(sound);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            player = new Player(bufferedInputStream);
            all = fileInputStream.available();
            new Thread(){
                public void run(){
                    try {
                        player.play();
                    }catch (Exception e){
                        
                    }
                }
            }.start();
        }catch (Exception e){
            
        }
    }

    public void alarmTime (final int hour, final int minute){
        Thread t = new Thread(){
          public void run (){
              int time = 0;
              while (time == 0){
                  Calendar c = Calendar.getInstance();
                  int h = c.get(Calendar.HOUR);
                  int m = c.get(Calendar.MINUTE);
                  if (hour == h && minute == m) {
                      startAlarm();
                      JOptionPane.showMessageDialog(null,"ALARM");
                      JOptionPane.showConfirmDialog(null,"STOP ALARM","",JOptionPane.CLOSED_OPTION);
                          stopAlarm();
                          break;
                 }
              }
          }  
        }; t.start();
}   
    
    public void stopAlarm(){
        if (player !=null){
            player.close();
        }
    }
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jBRingtone = new javax.swing.JButton();
        jBSetAlarm = new javax.swing.JButton();
        jBBackToDashboard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 8));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setText("ALARM CLOCK");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("SimSun-ExtB", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel3.setText("TIMER");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel5.setText("HOUR");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jLabel6.setText("MINUTE");

        jComboBox1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        jComboBox2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel7.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jBRingtone.setBackground(new java.awt.Color(51, 255, 204));
        jBRingtone.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jBRingtone.setText("RINGTONE");
        jBRingtone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRingtoneActionPerformed(evt);
            }
        });

        jBSetAlarm.setBackground(new java.awt.Color(51, 255, 204));
        jBSetAlarm.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jBSetAlarm.setText("SET ALARM");
        jBSetAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSetAlarmActionPerformed(evt);
            }
        });

        jBBackToDashboard.setBackground(new java.awt.Color(51, 255, 204));
        jBBackToDashboard.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jBBackToDashboard.setText("BACK TO DASHBOARD");
        jBBackToDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBackToDashboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel3)
                        .addGap(69, 69, 69)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(159, 159, 159)
                .addComponent(jLabel6)
                .addGap(273, 273, 273))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jBRingtone, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jBSetAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jBBackToDashboard)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBRingtone)
                    .addComponent(jBSetAlarm))
                .addGap(41, 41, 41)
                .addComponent(jBBackToDashboard)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBRingtoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRingtoneActionPerformed
        // TODO add your handling code here:
        chooseSong();
        if (!sound.equals(null)){
            jLabel7.setText("Alarm Music :"+title);
        }
    }//GEN-LAST:event_jBRingtoneActionPerformed

    private void jBSetAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSetAlarmActionPerformed
        // TODO add your handling code here:
        hourAlarm = jComboBox1.getSelectedItem().toString();
        minuteAlarm = jComboBox2.getSelectedItem().toString();
        if(jLabel7.getText() != ""){
            String alarmClock = hourAlarm +":"+ minuteAlarm;
            System.out.println(alarmClock);
            alarmTime(Integer.valueOf(hourAlarm), Integer.valueOf(minuteAlarm));
            
        }
        else{
            JOptionPane.showMessageDialog(null, "You don't choose alarm music yet...","Warning",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBSetAlarmActionPerformed

    private void jBBackToDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBackToDashboardActionPerformed
        // TODO add your handling code here:
                dispose ();
        Dashboard d = new Dashboard();
        d.setTitle("Register a user");
        d.setVisible(true);
    }//GEN-LAST:event_jBBackToDashboardActionPerformed

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
            java.util.logging.Logger.getLogger(Alarm_Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alarm_Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alarm_Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alarm_Clock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alarm_Clock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBackToDashboard;
    private javax.swing.JButton jBRingtone;
    private javax.swing.JButton jBSetAlarm;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
public void run(){
    while (true){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("hh:mm:ss");
        Date date = c.getTime();
        hours = simpleDateFormat.format(date);
        jLabel2.setText(hours);
    }
}


}
