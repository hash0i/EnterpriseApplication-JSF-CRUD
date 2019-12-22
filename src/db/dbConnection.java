package db;
import java.sql.*;

public class dbConnection {
    private String dbURL = "jdbc:mysql://localhost:3306/lab09";
    private String username = "root";
    private String password = "";
    private Connection connection;

    public dbConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL,username,password);
            if(connection!=null){
                System.out.println("Success");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createRecord(String Arrival_date, int nights, int adults, int Children, String Room_type, String Bed_type, String Smoking, String Name, String Email, int phoneNumber){
        try {
            String sqlQuery = "INSERT INTO reservation( Arrival_date, nights, adults, Children, Room_type, bed_type, Smoking, Name, Email, PhoneNumber ) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, Arrival_date);
            preparedStatement.setInt(2, nights);
            preparedStatement.setInt(3, adults);
            preparedStatement.setInt(4, Children);
            preparedStatement.setString(5, Room_type);
            preparedStatement.setString(6, Bed_type);
            preparedStatement.setString(7, Smoking);
            preparedStatement.setString(8, Name);
            preparedStatement.setString(9, Email);
            preparedStatement.setInt(10, phoneNumber);


            int noOfRowsInserted = preparedStatement.executeUpdate();
            if(noOfRowsInserted>0){
                System.out.println(noOfRowsInserted + " rows inserted!");

            }
            else
            {
                System.out.println("issue in insertion function");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeRecord(int id){
        try {
            String sqlQuery = "DELETE from reservation WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


        public void updateRecord(int id,String Arrival_date, int nights, int adults, int Children, String Room_type, String Bed_type, String Smoking, String Name, String Email, int PhoneNumber){
        try {
            String sqlQuery = "UPDATE reservation SET Arrival_date=?,nights=?,adults=?,Children=?,Room_type=?,Bed_type=?,Smoking=?,Name=?,Email=?,PhoneNumber=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,Arrival_date);
            preparedStatement.setInt(2,nights);
            preparedStatement.setInt(3,adults);
            preparedStatement.setInt(4,Children);
            preparedStatement.setString(5,Room_type);
            preparedStatement.setString(6,Bed_type);
            preparedStatement.setString(7,Smoking);
            preparedStatement.setString(8,Name);
            preparedStatement.setString(9,Email);
            preparedStatement.setInt(10,PhoneNumber);
            preparedStatement.setInt(11,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public ResultSet displayRecords(){
        try {
            String sqlQuery = "SELECT * FROM reservation";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




}
