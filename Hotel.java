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

        if (hotels.equals("1")) {
            // 모든 예약 목록 조회 기능

        } else if (hotels.equals("2")) {
            // 메인으로 돌아가기
            System.out.println("메인으로 돌아갑니다.");
        }
    }

    /**
     * 전체 예약 목록 Map에 담을 value List 생성하는 메서드
     *
     * @param roomNumber : 예약할 방 번호
     */
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


    /**
     * 예약에 추가하는 메서드, 룸 넘버로 날짜 비교하여 겹치면 저장 안 되게 하는 기능 추가해야 함
     *
     * @param id : 유저 고유 uuid
     */
    public void checkReservation(String id) {
        reservationList.put(id, reservationInformation);
    }


    /** 호출한 쪽에서 try-catch 해줘야 할듯
     * @param id : 취소할 예약 번호
     */
    public void cancelReservation(String id) throws HotelsBadException {
        if (reservationList.remove(id) == null) { // 문법적으로 괜찮은지 모르겠네요
            throw new HotelsBadException("예약이 없습니다.");
        } else {
            System.out.println("예약이 취소되었습니다.");
        }
    }
}