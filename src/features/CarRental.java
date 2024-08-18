package features;

import classes.Car;
import enums.CarRentalType;

public class CarRental {

  public Car createNewCarRental(CarRentalType type) {
    return new Car(type);
  }

  public int calcTotal(CarRentalType type) {
    int basePrice = 150;
    int executivePrice = basePrice + (basePrice * 100) / 100;
    int luxPrice = executivePrice + (executivePrice * 100) / 100;

    if (type == CarRentalType.Executive)
      return executivePrice;
    else if (type == CarRentalType.Lux)
      return luxPrice;

    return basePrice;
  }

}
