package model;

import printer.*;
import java.util.*;

/** A bill for a customer on a restaurant. */
public class Bill {
    private String customerName;
    private String serverName;
    List<Item> items = new ArrayList<>();
    private Double tip;
    private BillPrinter billPrinter;

    public Bill(String customerName, String serverName, Double tip) {
        this.customerName = customerName;
        this.serverName = serverName;
        this.tip = tip;
    }

    public BillPrinter getBillPrinter() {
        return billPrinter;
    }

    public void setBillPrinter(BillPrinter billPrinter) {
        this.billPrinter = billPrinter;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    /**
     * If billPrinter is set then, returned string is formatted by
     * the provided billPrinter. Otherwise, default toString is called.
     */
    @Override
    public String toString() {
        if (billPrinter == null)
            return super.toString();
        else
            return this.billPrinter.printBill(this);
    }
}
