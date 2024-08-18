package classes;

import enums.CarRentalType;

public class Car implements ServiceItem {
  private CarRentalType type;

  public Car(CarRentalType type) {
    this.type = type;
  }

  public CarRentalType getType() {
    return type;
  }

  public void setType(CarRentalType type) {
    this.type = type;
  }

  @Override
  public void showInfo() {
    System.out.println("Carro alugado - tipo: " + type.name());
  }

}
