package backingbean;


import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
public class reservation {
    private int id;
    private String arrival_Date;
    private int nights;
    private int Adults;
    private int Children;

    private String Room_type;
    private String Bed_type;
    private String Smoking;

    private String Name;
    private String Email;
    private int PhoneNumber;

    public reservation() { }

    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getEmail() { return Email; }
    public void setEmail(String Email) { this.Email = Email; }

    public int getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(int PhoneNumber) { this.PhoneNumber = PhoneNumber; }

    public String getRoom_type() { return Room_type; }
    public void setRoom_type(String room_type) { Room_type = room_type; }

    public String getBed_type() { return Bed_type; }
    public void setBed_type(String bed_type) { Bed_type = bed_type; }

    public String getSmoking() { return Smoking; }
    public void setSmoking(String smoking) { Smoking = smoking; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getArrival_Date() { return arrival_Date; }
    public void setArrival_Date(String arrival_Date) { this.arrival_Date = arrival_Date; }

    public int getNights() { return nights; }
    public void setNights(int nights) { this.nights = nights; }

    public int getAdults() { return Adults; }
    public void setAdults(int Adults) { this.Adults = Adults; }

    public int getChildren() { return Children; }
    public void setChildren(int Children) { this.Children = Children; }



}
