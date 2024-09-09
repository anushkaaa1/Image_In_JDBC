package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Hello world!
 *
 */
public class BLOBWRITE_DEMO
{
    private static final String URL = "jdbc:mysql://localhost:3306/spark";
    private static final  String username = "root";
    private static final String password = "amaansalik2004";
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main( String[] args ) {
        try {
            connection = DriverManager.getConnection(URL,username,password);
            File file = new File("C:\\Users\\win10\\OneDrive\\Documents\\anushka\\Capture1.JPG");
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement = connection.prepareStatement("insert into blobdemo values(?,?)");
            preparedStatement.setInt(1,2);
            preparedStatement.setBinaryStream(2,fileInputStream,(int)file.length());
            preparedStatement.executeUpdate();
            System.out.println("Data inserted");
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
