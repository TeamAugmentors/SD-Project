/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.project;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author AST
 */
public class MyConnection {
    //function to connect with mysql database
    public static Connection getConnection(){
        Connection connection = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","");
            
        }catch(Exception e){
            //message if the connection to the database is unsusccessful
            JOptionPane.showMessageDialog(null, "Not Connected");
        }
        
        return connection;
    }
}
