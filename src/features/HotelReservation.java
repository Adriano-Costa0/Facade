package features;

import classes.Reservation;
import enums.ReservationType;

public class HotelReservation {

  public Reservation createNewReservation(ReservationType type) {
    return new Reservation(type);
  }

  public int calcReservationPrice(ReservationType type) {
    int basePrice = 200;
    int executivePrice = basePrice + (basePrice * 150) / 100;
    int presidentialPrice = executivePrice + (executivePrice * 300) / 100;

    if (type == ReservationType.Executive)
      return executivePrice;
    else if (type == ReservationType.Presidential)
      return presidentialPrice;

    return basePrice;
  }

}
