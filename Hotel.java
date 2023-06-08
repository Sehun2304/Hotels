package hotels;

import java.awt.*;
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hotel {
    Map<String, ReservationInformation> hotelList = new LinkedHashMap<>();
    long asset = 0;

    public void inputReservationInformation(String id, String room, String customerName, String phoneNumber, String appointmentDate, int price, String now) {
        if (reservationAvailable(room, appointmentDate)) {
            ReservationInformation reservationInformation = new ReservationInformation(room, customerName, phoneNumber, appointmentDate, now);
            hotelList.put(id, reservationInformation);
            asset += price;
            System.out.println("예약이 완료되었습니다.\n");
        } else {
            System.out.println("해당 객실은 이미 예약된 날짜입니다. 다른 날짜나 다른 객실을 선택해주세요.\n");
        }
    }
    public boolean reservationAvailable(String room, String appointmentDate) {
        for (ReservationInformation reservation : hotelList.values()) {
            if (reservation.getRoom().equals(room) && reservation.getAppointmentDate().equals(appointmentDate)) {
                return false; // 이미 예약된 날짜와 객실이 존재하면 예약 불가능
            }
        }
        return true; // 예약 가능
    } // 이부분입니다


    public void printReservationInformation() {
        Set<String> keySet = hotelList.keySet();
        if (keySet.isEmpty()) {
            System.out.println("예약이 없습니다.");
            System.out.println("자산 : " + asset);
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
        ReservationInformation canceledReservation = hotelList.remove(cancelId);
        if (canceledReservation == null) {
            System.out.println("예약이 없습니다.\n");
        } else {
            Room canceledRoom = null;
            for (Room room : Room.getRoomList()) {
                if (room.getRoomNumber().equals(canceledReservation.getRoom())) {
                    canceledRoom = room;
                    break;
                }
            }
            int canceledPrice = 0;
            if (canceledRoom != null) {
                canceledPrice = canceledRoom.getRoomPrice();
            }
            asset -= canceledPrice;
            System.out.println("예약을 취소합니다.\n");
        }
    }
}