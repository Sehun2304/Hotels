package hotels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class Reservation {
    String id;
    String now;
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
                    long money = sc.nextLong();
                    if (money < selectedRoom.getRoomPrice()) {
                        System.out.println("소지금이 부족하여 이용이 불가능합니다.");
                        Main.base();
                        break;
                    } else {
                        break;
                    }
                } catch (InputMismatchException i) {
                    System.out.println("잘못된 입력입니다.");
                    System.out.println("다시 입력해주세요.");
                    sc.nextLine();
                }
            }
            sc.nextLine();
            String appointmentDate;


            while (true) {

                Calendar cal = Calendar.getInstance();
                LocalDate nowYear = LocalDate.now();
                DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");
                int thisYear = Integer.parseInt(nowYear.format(formatterYear));

                LocalDate nowMonth = LocalDate.now();
                DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");
                int thisMonth = Integer.parseInt(nowMonth.format(formatterMonth));

                LocalDate nowDay = LocalDate.now();
                DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd");
                int thisDay = Integer.parseInt(nowDay.format(formatterDay));

                System.out.print("년도를 입력하세요 : ");
                int year = sc.nextInt();

                if(year < thisYear ) {
                    System.out.println("지난 년도입니다.");
                    System.out.println("다시 입력해주세요");
                } else {
                    System.out.print("월을 입력하세요 : ");
                    int month = sc.nextInt();


                    if (year == thisYear && (month < thisMonth || month > 12) || year > thisYear && (month < 0 || month > 12)) {
                        System.out.println("예약이 불가능한 달입니다.");
                        System.out.println("다시 입력해주세요");
                    } else {
                        cal.set(Calendar.YEAR, year); //입력받은 년도로 세팅
                        cal.set(Calendar.MONTH, month); //입력받은 월로 세팅

                        System.out.println("---------[" + year + "년 " + month + "월]---------");
                        System.out.println("  일  월  화   수  목  금  토");
                        cal.set(year, month - 1, 1); //입력받은 월의 1일로 세팅

                        int end = cal.getActualMaximum(Calendar.DATE); //해당 월 마지막 날짜
                        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //해당 날짜의 요일(1:일요일 … 7:토요일)

                        for (int i = 1; i <= end; i++) {
                            if (i == 1) {
                                for (int j = 1; j < dayOfWeek; j++) {
                                    System.out.print("    ");
                                }
                            }
                            if (i < 10) { //한자릿수일 경우 공백을 추가해서 줄맞추기
                                System.out.print(" ");
                            }
                            System.out.print(" " + i + " ");
                            if (dayOfWeek % 7 == 0) { //한줄에 7일씩 출력
                                System.out.println();
                            }
                            dayOfWeek++;
                        }
                        System.out.println();
                        System.out.println("-----------------------------");

                        System.out.print("예약하실 날짜를 입력해주세요. : ");
                        int day = sc.nextInt();

                        if ((year == thisYear && month == thisMonth && thisDay > day) ||
                                year == thisYear && month > thisMonth && (day < 0 || day > end) ||
                        year > thisYear && (day < 0 || day > end )) {
                            System.out.println("잘못된 입력입니다.");
                        } else {
                            appointmentDate = year + "-" + month + "-" + day;

                            LocalDate today = LocalDate.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

                            int result = (appointmentDate).compareTo(String.valueOf(today));

                            if (result < 0) {
                                System.out.println("예약이 불가능한 날짜입니다.");
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            reservationInformation.makeReservation();
            id = reservationInformation.getMakeId();
            System.out.println();
            hotel.inputReservationInformation(reservationInformation.getMakeId(), roomNum, customerName, phoneNum, appointmentDate, selectedRoom.getRoomPrice());

        } else if (confirm == 2) {
            System.out.println("메인으로 돌아갑니다");
        }
    }
}