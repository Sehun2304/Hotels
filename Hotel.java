package hotels;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class Hotel {
    Map<String, ReservationInformation> hotelList = new LinkedHashMap<>();
    long asset = 0;

    public void inputReservationInformation(String id, String room, String customerName, String phoneNumber, String appointmentDate, int price) {
        ReservationInformation reservationinformation = new ReservationInformation(room, customerName, phoneNumber, appointmentDate);
        hotelList.put(id, reservationinformation);
        asset += price;
    }

    public void printReservationInformation() {
        Set<String> keySet = hotelList.keySet();
        for (String key : keySet) {
            System.out.println(key + " \n" + hotelList.get(key));
        }
        System.out.println("자산 : " + asset);
    }

    public void searchReservation(String searchId) {
        if (!hotelList.containsKey(searchId)) {
            System.out.println("예약이 없습니다.");
        } else {
            System.out.println(hotelList.get(searchId));
        }
    }

    public void cancelReservation(String cancelId) {
        if (hotelList.remove(cancelId) == null) {
            System.out.println("예약이 없습니다.");
        } else {
            hotelList.remove(cancelId);
            System.out.println("예약을 취소합니다.");
        }
    }
}