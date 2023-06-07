package hotels;


import java.util.UUID;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ReservationInformation {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");

    String makeId;
    String makeDate;
    String room;
    String customerName;
    String phoneNumber;
    String appointmentDate;

    public ReservationInformation(String room, String customerName, String phoneNumber, String appointmentDate) {
        this.room = room;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
    }
    public void makeReservation(){
        this.makeId = UUID.randomUUID().toString();
        this.makeDate = dateTimeFormatter.format(LocalDateTime.now());
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getMakeId(){
        return makeId;
    }

    public String getMakeDate(){
        return makeDate;
    }
    public  String toString(){
        return "객실 : " + room + "\n예약자 이름 : " + customerName + "\n전화번호 : " + phoneNumber + "\n예약날짜 : " + appointmentDate;
    }
}