package hotels;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Reservation {
    String id;
    Hotel hotel = new Hotel();
    CustomerInformation customerInformation = new CustomerInformation();

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
            // 예약 메서드
            reservation();
        } else if (customers.equals("2")) {
            System.out.println("예약번호를 입력하세요.");
            try {
                String id = sc.nextLine().trim();
                customerInformation.searchReservation(id);
            } catch (HotelsBadException h) {
                h.getMessage();
            }


        } else if (customers.equals("3")) {
            System.out.println("예약번호를 입력하세요.");
            try {
                String id = sc.nextLine().trim();
                customerInformation.cancelReservation(id);
                System.out.println("예약이 취소되었습니다.");
            } catch (HotelsBadException h) {
                h.getMessage();
            }
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
            System.out.print("원하는 객실을 선택해주세요.");
            String room = sc.nextLine();

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

            System.out.print("\n소지금을 입력해주세요. : ");
            String money = sc.nextLine().trim();

            System.out.print("이용하실 날짜를 입력해주세요");
            String appointmentDate = sc.nextLine();

            System.out.println("예약이 완료되었습니다.");
            System.out.println();

            hotel.inputReservationInformation(id, room, customerName, phoneNum, appointmentDate);

        } else if (confirm == 2) {
            System.out.println("메인으로 돌아갑니다");
        }
    }
}
