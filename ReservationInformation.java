package hotels;

import java.util.UUID;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class ReservationInformation {

DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");

private String makeId;
private String makeDate;

private String roomNumber;

private String reservationDate;
private Customer customer;

    public void makeReservation(){
    this.makeId = UUID.randomUUID().toString();
    this.makeDate = dateTimeFormatter.format(LocalDateTime.now());
    }


    public void makeCustomer(String name, String phoneNum, String money){
        this.customer = new Customer(name,phoneNum,money);
    }


    public void makeRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }

    public void makeReservationDate(String reservationDate){
        this.reservationDate = reservationDate;
    }


    public String getMakeId(){
        return makeId;
    }

    public String getMakeDate(){
        return makeDate;
    }

    public String getName(){
        return customer.name;
    }

    public String getPhoneNum(){
        return customer.phoneNum;
    }
    public String getMoney(){
        return customer.money;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public String getReservationDate(){
        return reservationDate;
    }

}
