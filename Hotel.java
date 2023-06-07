package hotels;

import java.awt.*;
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hotel {
    Map<String, ReservationInformation> hotelList = new LinkedHashMap<>();
    long asset = 0;

    public void inputReservationInformation(String id, String room, String customerName, String phoneNumber, String appointmentDate, int price, String now) {
        ReservationInformation reservationinformation = new ReservationInformation(room, customerName, phoneNumber, appointmentDate, now);
        hotelList.put(id, reservationinformation);
        asset += price;
    }

    public void printReservationInformation() {
        Set<String> keySet = hotelList.keySet();
        if (keySet.isEmpty()) {
            System.out.println("예약이 없습니다.");
        } else {
            for (String key : keySet) {
                System.out.println("1. " + key + " \n" + hotelList.get(key));
            }
            System.out.println("자산 : " + asset);
        }
    }

    public void searchReservation(String searchId) {
        if (!hotelList.containsKey(searchId)) {
            System.out.println("예약이 없습니다.\n");
        } else {
            System.out.println(hotelList.get(searchId));

            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
            String now = sdf.format(date);
            System.out.println(now);
        }
    }

    public void cancelReservation(String cancelId) {
        if (hotelList.remove(cancelId) == null) {
            System.out.println("예약이 없습니다.\n");
        } else {
            hotelList.remove(cancelId);
            System.out.println("예약을 취소합니다.\n");
        }
    }
}