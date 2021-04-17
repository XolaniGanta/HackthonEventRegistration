
package hackathoneventregistration;

import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author xolan
 */
public class HackDb {
   
   static final String DATABASE_URL="jdbc:derby://localhost:1527/HackDb";
   private final String username="administrator";
   private final String password="Password";
   
   private int StudentNumber;
   private String FirstName;
   private String LastName;
   private String Programme;
   private String Connection;
   private String Device;

    public HackDb(int StudentNumber, String FirstName, String LastName, String Programme, String Connection, String Device) {
        this.StudentNumber = StudentNumber;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Programme = Programme;
        this.Connection = Connection;
        this.Device = Device;
        
    }

   // HackDb(int StudentNumber, String FirstName, String LastName, String Programme, ButtonGroup Connection, ButtonGroup Device) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

    public int getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(int StudentNumber) {
        this.StudentNumber = StudentNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getProgramme() {
        return Programme;
    }

    public void setProgramme(String Programme) {
        this.Programme = Programme;
    }

    public String getConnection() {
        return Connection;
    }

    public void setConnection(String Connection) {
        this.Connection = Connection;
    }

    public String getDevice() {
        return Device;
    }

    public void setDevice(String Device) {
        this.Device = Device;
    }
    
    public void test(){
        Connection connection=null;
        PreparedStatement statement=null;
        int mn=0;
        String sqls="INSERT INTO STUDENTS VALUES(?,?,?,?,?,?)";
        try{
        connection=DriverManager.getConnection(DATABASE_URL,username,password);
        statement=connection.prepareStatement(sqls);
        statement.setInt(1,StudentNumber);
        statement.setString(2,FirstName);
        statement.setString(3,LastName);
        statement.setString(4,Programme);
        statement.setString(5,Connection);
        statement.setString(6,Device);
        mn=statement.executeUpdate();
        if(mn>0){
            JOptionPane.showMessageDialog(null,"Success! Its about time");
            System.exit(0);
        }
        else{
            JOptionPane.showMessageDialog(null,"Failure!");
        }
        }
        catch(SQLException exc){
            exc.printStackTrace();
        }
        
       finally{
            try{
                if(statement!=null){
                   statement.close();
                }
            }
            catch(SQLException mns){
                JOptionPane.showMessageDialog(null,"error!");
            }
            try{
                if(connection!=null){
                    connection.close();
                } 
            }
            catch(SQLException mik){
                JOptionPane.showMessageDialog(null,"Errors!");
            }
        }
        }
}
