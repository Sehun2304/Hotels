package hotels;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Reservation {
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
                String pattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
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
