package printer;

import model.*;

/** A class facilitates producing model.Bill in receipt format. */
public class ReceiptPrinter implements BillPrinter {
    @Override
    public String printBill(Bill bill) {
        // Prints names
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------\n");
        sb.append("Customer: " + bill.getCustomerName() + "\n");
        sb.append("Server: " + bill.getServerName() + "\n");
        sb.append("-------------------------------\n");

        // Prints items
        sb.append("Items\n");

        Double totalWithoutTip = 0.0;

        for (Item i: bill.getItems()) {
            Double totalItemPrice = i.getUnitPrice() * i.getQuantity();
            sb.append(i.getName());
            sb.append("\t" + i.getQuantity() + "x");
            sb.append("\t$" + totalItemPrice);
            sb.append("\n");

            totalWithoutTip += totalItemPrice;
        }

        // Prints amount
        sb.append("-------------------------------\n");
        sb.append("Total: \t$" +  totalWithoutTip + "\n");
        sb.append("Tip: \t$" + bill.getTip() + "\n");
        sb.append("-------------------------------\n");
        sb.append("Payable: \t$" + (bill.getTip() + totalWithoutTip) + "\n");

        return sb.toString();
    }
}
