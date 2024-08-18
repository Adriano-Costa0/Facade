package classes;

import java.util.ArrayList;

import enums.CarRentalType;
import enums.PaymentType;
import enums.ReservationType;
import enums.TicketType;
import features.CarRental;
import features.HotelReservation;
import features.PaymentGateway;
import features.TicketSale;

public class Facade {
  private CarRental carRentalSubsystem;
  private HotelReservation hotelSubsystem;
  private TicketSale ticketSaleSubsystem;
  private PaymentGateway paymentGatewaySubsystem;

  private ArrayList<Client> clients = new ArrayList<Client>();
  private ArrayList<ServiceItem> services = new ArrayList<ServiceItem>();
  private int total;

  public Facade(CarRental carRentalSubsystem, HotelReservation hotelSubsystem, TicketSale ticketSaleSubsystem,
      PaymentGateway paymentSubsystem) {
    this.carRentalSubsystem = carRentalSubsystem;
    this.hotelSubsystem = hotelSubsystem;
    this.ticketSaleSubsystem = ticketSaleSubsystem;
    this.paymentGatewaySubsystem = paymentSubsystem;
  }

  public void addNewClientOnTravel(Client client) {
    if (client instanceof Client) {
      clients.add(client);
    }

  }

  public void buyNewTicket(TicketType type, String seat) {
    Ticket newTicket = this.ticketSaleSubsystem.createNewTicket(type, seat);
    services.add(newTicket);
    this.total += this.ticketSaleSubsystem.calcTicketPrice(newTicket.getType());
  }

  public void createNewReservation(ReservationType type) {
    Reservation newReservation = this.hotelSubsystem.createNewReservation(type);
    services.add(newReservation);
    this.total += this.hotelSubsystem.calcReservationPrice(newReservation.getType());
  }

  public void createNewCarRental(CarRentalType type) {
    Car newCarRental = this.carRentalSubsystem.createNewCarRental(type);
    services.add(newCarRental);
    this.total += this.carRentalSubsystem.calcTotal(newCarRental.getType());
  }

  public void processPayment(PaymentType type) {

    for (Client client : clients) {
      System.out.println("Cliente: " + client.getName() + " CPF: " + client.getCpf());
    }

    for (ServiceItem item : services) {
      item.showInfo();
    }

    this.paymentGatewaySubsystem.calculatesServiceFees(this.total, type, 0);

    this.total = 0;
    this.services.clear();
    this.clients.clear();

  }

}
