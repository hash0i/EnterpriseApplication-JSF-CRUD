package managedbean;

import backingbean.reservation;
import db.dbConnection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class reservationBean {

    private reservation Reservation;

    private dbConnection db;

    @PostConstruct
    public void init(){
        Reservation = new reservation();
        db = new dbConnection();
    }

    public reservation getReservation() { return Reservation; }
    public void setReservation(reservation reservation) { Reservation = reservation; }

    public String addReservation()
    {
        db.createRecord(
                Reservation.getArrival_Date(),
                Reservation.getNights(),
                Reservation.getAdults(),
                Reservation.getChildren(),
                Reservation.getRoom_type(),
                Reservation.getBed_type(),
                Reservation.getSmoking(),
                Reservation.getName(),
                Reservation.getEmail(),
                Reservation.getPhoneNumber()
                        );
        return "index";
    }

    public List<reservation> getAllReservation(){
        List<reservation> Resvation = new ArrayList<>();
        ResultSet resultSet = db.displayRecords();
        try {
            while(resultSet.next())
            {
                reservation resv = new reservation();
                resv.setId(resultSet.getInt("id"));
                resv.setArrival_Date(resultSet.getString("Arrival_date"));
                resv.setNights(resultSet.getInt("nights"));
                resv.setAdults(resultSet.getInt("adults"));
                resv.setChildren(resultSet.getInt("Children"));
                resv.setRoom_type(resultSet.getString("Room_type"));
                resv.setBed_type(resultSet.getString("Bed_type"));
                resv.setSmoking(resultSet.getString("Smoking"));
                resv.setName(resultSet.getString("Name"));
                resv.setEmail(resultSet.getString("Email"));
                resv.setPhoneNumber(resultSet.getInt("PhoneNumber"));

                Resvation.add(resv);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Resvation;
    }
    public String deleteReservation(int id){
        db.removeRecord(id);
        return "index";
    }

    public String updateReservation(int reservationID,String Arrival_date, int nights, int adults, int children, String Room_type, String Bed_type, String Smoking, String Name, String Email, int phoneMumber)
    {
        Reservation.setArrival_Date(Arrival_date);
        Reservation.setNights(nights);
        Reservation.setAdults(adults);
        Reservation.setChildren(children);
        Reservation.setRoom_type(Room_type);
        Reservation.setBed_type(Bed_type);
        Reservation.setSmoking(Smoking);
        Reservation.setName(Name);
        Reservation.setEmail(Email);
        Reservation.setPhoneNumber(phoneMumber);

        db.updateRecord(reservationID,Reservation.getArrival_Date(),
                Reservation.getNights(),
                Reservation.getAdults(),
                Reservation.getChildren(),
                Reservation.getRoom_type(),
                Reservation.getBed_type(),
                Reservation.getSmoking(),
                Reservation.getName(),
                Reservation.getEmail(),
                Reservation.getPhoneNumber());

        return "index";
    }


}
