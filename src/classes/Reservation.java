package classes;

import enums.ReservationType;

public class Reservation implements ServiceItem {

  private ReservationType type;

  public Reservation(ReservationType type) {
    this.type = type;
  }
  
  public ReservationType getType() {
    return type;
  }

  public void setType(ReservationType type) {
    this.type = type;
  }

  @Override
  public void showInfo() {
    System.out.println("Reserva: "+ type.name());
  }

}