package hotels;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        Hotel hotel = new Hotel();

        boolean start = true;

//        Calendar calendar = Calendar.getInstance();
//        Date date = calendar.getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
//        String text = sdf.format(date);
//        System.out.println(text);

        while (start) {
            Scanner sc = new Scanner(System.in);

            System.out.println("[ 맞왜틀 호텔에 오신것을 환영합니다. ]");
            System.out.println();
            System.out.println("1. 호텔    2. 고객");
            int select = sc.nextInt();

            switch (select) {
                case 1 :
                    reservation.hotel();
                    break;
                case 2 :
                    reservation.customer();
                    break;
            }
        }
    }
}
