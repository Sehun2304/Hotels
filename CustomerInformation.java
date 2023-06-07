package hotels;

public class CustomerInformation {
    Hotel hotel = new Hotel();

    public void searchReservation(String id) throws HotelsBadException {
        for (int i = 0; i < hotel.hotelList.size(); i++) {
            if (hotel.hotelList.get(id).equals(id)) {
                System.out.println(hotel.hotelList.get(i));
            } else throw new HotelsBadException("예약이 없습니다.");
        }

    }

    public void cancelReservation(String id) throws HotelsBadException {
        if (hotel.hotelList.remove(id) == null) {
            throw new HotelsBadException("예약이 없습니다.");
        }
    }
}