package features;

import enums.PaymentType;

public class PaymentGateway {

  // calcula o valor de todos os serviços da viagem;
  public int calculatesServiceFees(int value, PaymentType type, int parcelas) {
    int total = value;
    int tariffs = 0;

    if (type == PaymentType.Pix) {
      tariffs = (int) (total * 0.10);
      total -= tariffs;
      System.out.println("Desconto com PIX: R$" + tariffs);
    } else if (type == PaymentType.Boleto) {
      tariffs = (int) (total * 0.05);
      total -= tariffs;
      System.out.println("Desconto com Boleto: R$" + tariffs);
    } else if (type == PaymentType.Credit) {
      tariffs = (int) (total * 0.039);
      System.out.println("Juros do Cartão de Credito: R$" + tariffs);
      total += (tariffs * parcelas);
    }

    System.out.println("Total: R$" + total);

    return total;
  }

}
