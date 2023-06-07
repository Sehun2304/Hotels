package hotels;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class Hotel {
    Map<String, ReservationInformation> hotelList = new LinkedHashMap<>();

    public void hotel() {
        System.out.println("1. 예약확인    2. 취소");
        Scanner sc = new Scanner(System.in);
        String hotels = sc.nextLine();

        if (hotels.equals("1")) {
            // 모든 예약 목록 조회 기능

        } else if (hotels.equals("2")) {
            // 메인으로 돌아가기
            System.out.println("메인으로 돌아갑니다.");
        }
    }

    public void inputReservationInformation(String id, String room, String customerName, String phoneNumber, String appointmentDate) {
        ReservationInformation reservationinformation = new ReservationInformation(room, customerName, phoneNumber, appointmentDate);
        hotelList.put(id, reservationinformation);
    }

    public void printReservationInformation() {
        Set<String> keySet = hotelList.keySet();
        for (String key : keySet) {
            System.out.println(key + " \n" + hotelList.get(key));
        }
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