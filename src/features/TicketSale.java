package features;

import classes.Ticket;
import enums.TicketType;

public class TicketSale  {

  public Ticket createNewTicket(TicketType type, String seat){
    return new Ticket(type, seat);
  }

  public int calcTicketPrice(TicketType type) {
    int basePrice = 500;
    int executivePrice = basePrice + (basePrice * 250) / 100;
    int firstClassPrice = executivePrice + (executivePrice * 150) / 100;

    if (type == TicketType.Executive)
      return executivePrice;
    else if (type == TicketType.First)
      return firstClassPrice;

    return basePrice;
  }


}
