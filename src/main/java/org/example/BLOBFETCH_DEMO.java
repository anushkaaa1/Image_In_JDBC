package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class BLOBFETCH_DEMO {
    private static final String url = "jdbc:mysql://localhost:3306/spark";
    private final static  String user = "root";
    private final static String password = "amaansalik2004";
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public static void main(String [] args){
        try{
            connection = DriverManager.getConnection(url,user,password);
            preparedStatement = connection.prepareStatement("select image from blobdemo where id= ?");
            preparedStatement.setInt(1,2);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                InputStream ins = resultSet.getBinaryStream("image");
                FileOutputStream fos = new FileOutputStream("C:\\Users\\win10\\OneDrive\\Documents\\anushka\\anushkaa.JPG");
                byte[] buffer = new byte[1024];
                while (ins.read(buffer)>0){
                    fos.write(buffer);
                }
                fos.close();
                ins.close();
                connection.close();
                System.out.println("image found");
            }
            else{
                System.out.println("no image found");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
