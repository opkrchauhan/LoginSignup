// WAP a program to create a table
// whose name is given by user then get 
//number of column to add those all will be of type varchar of length 10 cahracter
package JavaBackend;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateTable {
    public CreateTable(){

    }
    public static void main(String[] args) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String var1 = "jdbc:mysql://localhost:3306";
        String var2 = "root";
        String var3 = "";
        Connection var4 = DriverManager.getConnection(var1, var2, var3);
        String var5="create database db";
        java.beans.Statement var6=(Statement) var4.createStatement();
        var6.execute();
        System.out.println("connection stabilized and data base created");
        var4.close();
    }
    catch(Exception var7) {
        System.out.println(var7);
    }
}
}