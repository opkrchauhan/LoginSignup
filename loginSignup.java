//WAP to create an app for signup and login using my sql the field during the signUp will be name, contact, userid, password and location.
// for login get user id and password if it is match show the name and the contact number 
//else print a message you are not an Authorize person.
package JavaBackend;

import java.util.Scanner;
import java.sql.*;
public class loginSignup {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfuel","root","");
            Statement st = con.createStatement();
            System.out.println("Enter your choice: ");
            int nm=sc.nextInt();
            if(nm==1){
            
               System.out.println("Welcome to Signup");
               System.out.println("Enter your user_id");
               String user_id=sc.next();
               System.out.println("Enter your password");
               String password=sc.next();
               
               //String Qry="SELECT * FROM information";
               ResultSet resultset=st.executeQuery("SELECT * FROM information WHERE user_id='"+user_id+"' AND password='"+password+"'");
                if(resultset.next()){
                    System.out.println("You are login");
                    System.out.println("Name : "+resultset.getString(1));
                    System.out.println("Contact : "+resultset.getString(2));
                }
                else{
                    System.out.println("Enter again your details");
                }

            }

           else if(nm==2){
            String Qry;
            System.out.println("Welcome to signup page");
            System.out.println("Enter your name");
            String name=sc.next();
            System.out.println("Enter your contact");
            String contact=sc.next();
            System.out.println("Enter your user_id");
            String user_id=sc.next();
            System.out.println("Enter your password");
            String password=sc.next();
            System.out.println("Enter your location");
            String loaction=sc.next();

            Qry="INSERT INTO information(name,contact,user_id,password,location) VALUES (" + "'" + name + "'" + "," + "'" + contact + "'"
            + "," + "'" + user_id +"'"+","+"'"+password +"'"+","+"'"+loaction +"')";
              System.out.println(Qry);
              st.execute(Qry);
            }
            else{
                System.out.println("You are an unauthorized user");
            }
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
