package hotels;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Reservation {
  
    // 호텔 기능 메서드
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

    // 고객 기능 메서드
    public void customer() {
        // 고객 기능 (예약, 자신의 예약만 조회, 예약취소)
        System.out.println("1. 예약    2. 조회    3. 예약취소");
        Scanner sc = new Scanner(System.in);
        String customers = sc.nextLine();

        if(customers.equals("1")) {
            // 예약 메서드
            reservation();
        } else if(customers.equals("2")) {
            // 고객 자신의 예약목록 조회 메서드
        } else if(customers.equals("3")) {
            // 예약취소 메서드
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
            System.out.print("\n이름을 입력해주세요. : ");
            String name = sc.nextLine().trim();

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

            Customer customer = new Customer(name, phoneNum, money);

        } else if (confirm == 2) {
            System.out.println("메인으로 돌아갑니다");
        }
    }
}
