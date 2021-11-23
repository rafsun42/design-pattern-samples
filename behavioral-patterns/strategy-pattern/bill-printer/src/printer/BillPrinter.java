package printer;

import model.*;

/** An interface facilitates printing bills in different format. */
public interface BillPrinter {
    /** Returns summary of bill. */
    String printBill(Bill bill);
}
