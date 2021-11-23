import model.*;
import printer.*;

public class MainBillPrinter {
    public static void main(String[] args) {
        Bill b = new Bill("Tom", "Sarah", 10.0);
        b.getItems().add(new Item("Tea", 3.50, 3));
        b.getItems().add(new Item("Coffee", 5.00, 1));
        b.getItems().add(new Item("Pancake", 7.00, 2));
        b.getItems().add(new Item("Burger", 8.00, 2));

        b.setBillPrinter(new ReceiptPrinter());
        System.out.println(b.toString());

    }
}
