import classes.Client;
import classes.Facade;
import enums.CarRentalType;
import enums.PaymentType;
import enums.ReservationType;
import enums.TicketType;
import features.CarRental;
import features.HotelReservation;
import features.PaymentGateway;
import features.TicketSale;

public class Main {
  public static void main(String[] args) {
    Client adriano = new Client("Adriano Costa", "123123123");
    Client brad = new Client("Brad Pitt", "09209320932");

    CarRental carSubSystem = new CarRental();
    HotelReservation hotelSubSystem = new HotelReservation();
    TicketSale ticketSubSystem = new TicketSale();
    PaymentGateway paymentSubSystem = new PaymentGateway();

    Facade facade = new Facade(carSubSystem, hotelSubSystem, ticketSubSystem, paymentSubSystem);

    facade.addNewClientOnTravel(adriano);
    facade.addNewClientOnTravel(brad);

    facade.buyNewTicket(TicketType.Economy, "1A");
    facade.buyNewTicket(TicketType.Economy, "2B");
    facade.createNewCarRental(CarRentalType.Executive);
    facade.createNewReservation(ReservationType.Simple);
    facade.processPayment(PaymentType.Pix);
  }
}