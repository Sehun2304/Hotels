package hotels;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
    Room room = new Room();
    Customer customer = new Customer();
    List reservationInformation;
    Map<String, List> reservationList = new LinkedHashMap<>();

    public void hotel() {
        System.out.println("1. 예약확인    2. 취소");
        Scanner sc = new Scanner(System.in);
        String hotels = sc.nextLine();

        if(hotels.equals("1")) {
            // 모든 예약 목록 조회 기능

        } else if(hotels.equals("2")) {
            // 메인으로 돌아가기
            System.out.println("메인으로 돌아갑니다.");
        }
    }

    public void addReservationList(String roomNumber) {
        for (int i = 0; i < Room.getRoomList().size(); i++) {
            if (room.getRoomNumber().equals(roomNumber)) {
                reservationInformation.add(customer.getName());
                reservationInformation.add(customer.getPhoneNum());
                reservationInformation.add(room.getRoomNumber());
                reservationInformation.add(room.getRoomName());
                reservationInformation.add(room.getRoomSize());
            }
        }
    }

    public void checkReservation(String id) {
        reservationList.put(id, reservationInformation);
    }
}
