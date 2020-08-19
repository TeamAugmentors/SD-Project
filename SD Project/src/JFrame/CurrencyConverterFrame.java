/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Libs.HintTextField;
import com.posadskiy.currencyconverter.CurrencyConverter;
import com.posadskiy.currencyconverter.config.ConfigBuilder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Lassassin
 */
public class CurrencyConverterFrame extends javax.swing.JFrame implements Runnable {
    
    /** API KEY (It is by convention to not put your API_KEY in the client side code. 
    * It is best handled in the server side code, as there is a chance it can get hijacked by someone
    * who has reverse engineered your application.
    * Current API_KEY is for https://free.currconv.com/ (Free plan, 100 req/hour).
    **/
    public static final String API_KEY = "236e97c1ec2e7c5acb76";
    /*---------*/

    //Currency lists
    private static ArrayList<String> currencyNames = new ArrayList<String>();
    private static HashMap<String, String> map = new HashMap<String, String>();
    //--------------

    //Converter-----
    CurrencyConverter converter;
    //--------------

    //Init
    private HintTextField enterAmountTextField;
    private HintTextField resultTextField;
    private double rate;
    //----

    public CurrencyConverterFrame() {

        initComponents();

        initCustomComponents();

    }

    private void initCustomComponents() {
        initializeConverter();
        initializeHintBox();

        //Is not a blocking call
        try {
            retrieveCurrencyNames();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //---------------------

        addCurrencyNames();
        setProgressBarAttributes();
        setCurrencyBoxAttributes();
        setLabelAttributes();
        spinnerOnSelected();
    }

    private void initializeConverter() {
        converter = new CurrencyConverter(
                new ConfigBuilder()
                        .currencyConverterApiApiKey(API_KEY)
                        .build()
        );
    }

    private void initializeHintBox() {

        enterAmountTextField = new HintTextField("Enter amount");
        resultTextField = new HintTextField("Result");

        jLabel1.setVisible(false);
        jLabel2.setVisible(false);

        enterAmountTextField.setSize(250, 30);
        enterAmountTextField.setLocation(jLabel1.getLocation());

        resultTextField.setSize(250, 30);
        resultTextField.setLocation(jLabel2.getLocation());
        resultTextField.setFocusable(false);

        add(enterAmountTextField);
        add(resultTextField);

        convertButton.requestFocus();

        pack();

    }

    void retrieveCurrencyNames() throws IOException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("https://free.currconv.com/api/v7/currencies?apiKey=" + API_KEY)).build();
        //Async request does not block, sends a worker thread to retrieve data
        httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(CurrencyConverterFrame::parseObject)
                .join();

    }

    public static void parseObject(String responseBody) {

        JSONObject responseJSONObject = new JSONObject(responseBody);

        JSONObject jsonObject = responseJSONObject.getJSONObject("results");

        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONObject) {
                JSONObject temp = (JSONObject) jsonObject.get(key);
                currencyNames.add(temp.getString("currencyName"));
                map.put(temp.getString("currencyName"), temp.getString("id").toString());
            }
        }

        Collections.sort(currencyNames);

    }

    private void addCurrencyNames() {

        for (int i = 0; i < currencyNames.size(); i++) {
            fromCurrenciesBox.addItem(currencyNames.get(i));
        }

        if (fromCurrenciesBox.getItemAt(0) == null) {
        } else {
            fromCurrenciesBox.setSelectedIndex(0);
        }

        for (int i = 0; i < currencyNames.size(); i++) {
            toCurrenciesBox.addItem(currencyNames.get(i));
        }

        if (toCurrenciesBox.getItemAt(0) == null) {
        } else {
            toCurrenciesBox.setSelectedIndex(0);
        }

    }

    private void setProgressBarAttributes() {
        jProgressBar1.setMinimum(0);
        jProgressBar1.setMaximum(100);
        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setForeground(Color.blue);
    }

    private void setCurrencyBoxAttributes() {
        fromCurrenciesBox.setSize(140, 30);
        toCurrenciesBox.setSize(140, 30);
    }

    private void setLabelAttributes() {
        fromCurrencyLabel.setText(map.get(fromCurrenciesBox.getSelectedItem()));
        toCurrencyLabel.setText(map.get(toCurrenciesBox.getSelectedItem()));
    }
    
    private void spinnerOnSelected() {
        fromCurrenciesBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ID = map.get(fromCurrenciesBox.getSelectedItem().toString());
                fromCurrencyLabel.setText(ID);
            }

        });

        toCurrenciesBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ID = map.get(toCurrenciesBox.getSelectedItem().toString());
                toCurrencyLabel.setText(ID);
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        convertButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fromCurrenciesBox = new javax.swing.JComboBox<>();
        toCurrenciesBox = new javax.swing.JComboBox<>();
        jProgressBar1 = new javax.swing.JProgressBar();
        swapButton = new javax.swing.JButton();
        progressLabel = new javax.swing.JLabel();
        fromCurrencyLabel = new javax.swing.JLabel();
        toCurrencyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(1000, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 400));
        getContentPane().setLayout(null);

        convertButton.setText("Convert!");
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });
        getContentPane().add(convertButton);
        convertButton.setBounds(470, 300, 75, 23);

        jLabel1.setText("nullPosition");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 90, 53, 14);

        jLabel2.setText("nullPosition");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 160, 53, 14);

        fromCurrenciesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromCurrenciesBoxActionPerformed(evt);
            }
        });
        getContentPane().add(fromCurrenciesBox);
        fromCurrenciesBox.setBounds(710, 90, 30, 22);

        toCurrenciesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCurrenciesBoxActionPerformed(evt);
            }
        });
        getContentPane().add(toCurrenciesBox);
        toCurrenciesBox.setBounds(710, 160, 30, 22);

        jProgressBar1.setOpaque(true);
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(130, 250, 750, 30);

        swapButton.setText("swap");
        swapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swapButtonActionPerformed(evt);
            }
        });
        getContentPane().add(swapButton);
        swapButton.setBounds(890, 130, 57, 23);

        progressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        progressLabel.setText("Ready!");
        progressLabel.setPreferredSize(new java.awt.Dimension(350, 20));
        getContentPane().add(progressLabel);
        progressLabel.setBounds(10, 200, 990, 50);

        fromCurrencyLabel.setText("jLabel3");
        getContentPane().add(fromCurrencyLabel);
        fromCurrencyLabel.setBounds(760, 70, 34, 14);

        toCurrencyLabel.setText("jLabel4");
        getContentPane().add(toCurrencyLabel);
        toCurrencyLabel.setBounds(760, 140, 34, 14);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        // TODO add your handling code here:
        convert();
    }//GEN-LAST:event_convertButtonActionPerformed

    private void fromCurrenciesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromCurrenciesBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_fromCurrenciesBoxActionPerformed

    private void toCurrenciesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCurrenciesBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toCurrenciesBoxActionPerformed

    private void swapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapButtonActionPerformed
        // TODO add your handling code here:
        int temp = fromCurrenciesBox.getSelectedIndex();
        fromCurrenciesBox.setSelectedIndex(toCurrenciesBox.getSelectedIndex());
        toCurrenciesBox.setSelectedIndex(temp);
    }//GEN-LAST:event_swapButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CurrencyConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrencyConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrencyConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrencyConverterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverterFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton convertButton;
    private javax.swing.JComboBox<String> fromCurrenciesBox;
    private javax.swing.JLabel fromCurrencyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JButton swapButton;
    private javax.swing.JComboBox<String> toCurrenciesBox;
    private javax.swing.JLabel toCurrencyLabel;
    // End of variables declaration//GEN-END:variables

    

    private void convert() {

        try {
            double temp = Double.parseDouble(enterAmountTextField.getText().toString());
            Thread t = new Thread(this, "Converting!");
            t.start();
        } catch (Exception exception) {
            progressLabel.setText("Please enter a valid amount!");
        }

    }

    @Override
    public void run() {

        progressLabel.setText("Fetching [LIVE] exchange rate data from https://free.currconv.com/...");

        rate = converter.rate(map.get(fromCurrenciesBox.getSelectedItem().toString()),
                map.get(toCurrenciesBox.getSelectedItem().toString()));

        for (int i = 0; i < 101; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(CurrencyConverterFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            progressLabel.setText("Converting...");

            jProgressBar1.setValue(i);
        }
        resultTextField.setText("" + String.format("%.2f", (rate * Double.parseDouble(enterAmountTextField.getText()))));
        progressLabel.setText("Done! Current rate of " + fromCurrenciesBox.getSelectedItem().toString() + " to "
                + toCurrenciesBox.getSelectedItem().toString() + " is " + String.format("%.2f", rate));

        System.out.println(currencyNames.toString());
    }

    

}
