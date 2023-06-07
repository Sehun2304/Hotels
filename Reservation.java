package hotels;


import java.util.*;
import java.util.regex.Pattern;

public class Reservation {
    String id;
    Hotel hotel = new Hotel();

    ReservationInformation reservationInformation = new ReservationInformation();

    // 호텔 기능 메서드
    public void hotel() {
        System.out.println("1. 예약확인    2. 취소");
        Scanner sc = new Scanner(System.in);
        String hotels = sc.nextLine();

        if (hotels.equals("1")) {
            hotel.printReservationInformation();

        } else if (hotels.equals("2")) {
            // 메인으로 돌아가기
            System.out.println("메인으로 돌아갑니다.");
        }
    }

    // 고객 기능 메서드
    public void customer() {
        // 고객 기능 (예약, 자신의 예약만 조회, 예약취소)
        System.out.println("1. 예약    2. 조회    3. 예약취소");
        Scanner sc = new Scanner(System.in);
        String customers = sc.nextLine();

        if (customers.equals("1")) {
            reservation();
        } else if (customers.equals("2")) {
            System.out.println("예약번호를 입력하세요.");
            String searchId = sc.nextLine().trim();
            hotel.searchReservation(searchId);

        } else if (customers.equals("3")) {
            System.out.println("예약번호를 입력하세요.");
            String cancelId = sc.nextLine().trim();
            hotel.cancelReservation(cancelId);

        }
    }

    // 예약 메서드
    public void reservation() {
        Scanner sc = new Scanner(System.in);

        System.out.println("예약 하시겠습니까?");
        System.out.println("1. 확인    | 2. 취소");
        System.out.print("입력 : ");
        int confirm = sc.nextInt();
        sc.nextLine();

        if (confirm == 1) {
            Room.RoomList();
            Room.printRoomList();
            System.out.print("\n원하는 객실을 선택해주세요. : ");
            String roomNum = sc.nextLine();

            Room selectedRoom = null;
            for (Room room : Room.getRoomList()) {
                if (room.getRoomNumber().equals(roomNum)) {
                    selectedRoom = room;
                    break;
                }
            }
            if (selectedRoom == null) {
                System.out.println("존재하지 않는 객실입니다.");
                return;
            }

            System.out.print("\n이름을 입력해주세요. : ");
            String customerName = sc.nextLine().trim();

            String phoneNum;

            while (true) {
                System.out.print("\n전화번호를 입력해주세요. : ");
                phoneNum = sc.nextLine().trim();

                String pattern = "^\\d{2,3}-\\d{3,4}-\\d{4}$";

                if (!(Pattern.matches(pattern, phoneNum))) {
                    System.out.println("올바른 휴대전화 형식이 아닙니다. ");
                } else {
                    break;
                }
            }

            while (true) {
                try {
                    System.out.print("\n소지금을 입력해주세요. : ");
                    int money = sc.nextInt();
                    if (money < selectedRoom.getRoomPrice()) {
                        System.out.println("소지금이 부족하여 이용이 불가능합니다.");
                        Main.base();
                        break;
                    }
                    else{
                       break;
                    }
                } catch (InputMismatchException i) {
                    System.out.println("잘못된 입력입니다.");
                    System.out.println("다시 입력해주세요.");
                    sc.nextLine();
                }
            }

            sc.nextLine();
            System.out.print("이용하실 날짜를 입력해주세요 : ");
            String appointmentDate = sc.nextLine();

            System.out.println("\n예약이 완료되었습니다.");
            reservationInformation.makeReservation();
            id = reservationInformation.getMakeId();
            System.out.println("예약번호 : " + id);
            System.out.println();
            hotel.inputReservationInformation(reservationInformation.getMakeId(), roomNum, customerName, phoneNum, appointmentDate, selectedRoom.getRoomPrice());

        } else if (confirm == 2) {
            System.out.println("메인으로 돌아갑니다");
        }
    }
}
