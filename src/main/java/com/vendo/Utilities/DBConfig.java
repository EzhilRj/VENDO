package Utils;

import org.testng.annotations.Test;

import java.sql.*;

public class DBConfig {


    static String Databaseurl = "jdbc:sqlserver://183.83.187.133\\FIELDLYTICSDEVS:1433;DatabaseName=Redipaetest;encrypt=true;trustServerCertificate=true";
    static String Dbusername = "Fieldlytics2021";
    static String Dbpassword = "PPMSdevserver$2022";


    public static ResultSet ConnectDB(String query, String Columnname, String un) throws ClassNotFoundException, SQLException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(Databaseurl, Dbusername, Dbpassword);


        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(query);



        return rs;

    }
}