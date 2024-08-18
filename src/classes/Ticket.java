package classes;

import enums.TicketType;

public class Ticket implements ServiceItem {
  private TicketType type;
  private String seat;

  public Ticket(TicketType type, String seat){
      this.type = type;
      this.seat = seat;
  }

  public TicketType getType() {
    return type;
  }

  public void setType(TicketType type) {
    this.type = type;
  }

  public String getSeat() {
    return seat;
  }

  public void setSeat(String seat) {
    this.seat = seat;
  }

  @Override
  public void showInfo() {
    System.out.println("Passagem - Assento: "+seat + " tipo: "+type.name() );
  }
}
