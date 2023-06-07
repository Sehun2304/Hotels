package hotels;

public class CustomerInformation {
    Hotel hotel = new Hotel();
    ReservationInformation reservationInformation = new ReservationInformation();

    public void searchReservation(String searchId) {
        System.out.println(hotel.hotelList.get(searchId));
//
//        if (hotel.hotelList.containsKey(searchId)) {
//            System.out.println(hotel.hotelList.get(searchId));
//        } else {
//            System.out.println("예약이 없습니다.");
//        }
    }
}
//
//    public void cancelReservation(String id) throws HotelsBadException {
//        if (hotel.hotelList.remove(id) == null) {
//            throw new HotelsBadException("예약이 없습니다.");
//        }
//    }
