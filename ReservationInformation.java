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
    String now;

    ReservationInformation() {}

    public ReservationInformation(String room, String customerName, String phoneNumber, String appointmentDate, String now) {
        this.room = room;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.now = now;
    }
    public void makeReservation() {
        this.makeId = UUID.randomUUID().toString();
        this.makeDate = dateTimeFormatter.format(LocalDateTime.now());
    }
    public String getRoom() {
        return room;
    }
    public String getAppointmentDate() {
        return appointmentDate;
    }
    public String getMakeId() {
        return makeId;
    }
    public String toString() {
        return "객실 : " + room + "\n예약자 이름 : " + customerName + "\n전화번호 : " + phoneNumber + "\n예약날짜 : " + appointmentDate + "\n예약시간 : " + now;
    }
}