package JavaBackend;

import java.util.Scanner;


import java.sql.*;

public class DataEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfuel","root","");
            Statement st = con.createStatement();
            String Qry = "CREATE TABLE info(Name varchar(10)),"
                    + "Contact varchar(10), Location varchar(10))";

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter your Name: " + i);
                String name = sc.next();
                System.out.println("Enter your Contact: " + i);
                String contact = sc.next();
                System.out.println("Enter your Loaction: " + i);
                String location = sc.next();

                Qry = "INSERT INTO Info(Name,Contact,Location) VALUES (" + "'" + name + "'" + "," + "'" + contact + "'"
                        + "," + "'" + location + "')";
                System.out.println(Qry);

                st.execute(Qry);

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

