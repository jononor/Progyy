package se.su.ovning1;

import java.util.List;

public class Order {
    static private long counter;
    final private long orderNumber;
    final private List<Item> items;

    public double getTotalValue() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public double getTotalValuePlusVAT() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPriceWithVAT();
        }
        return sum;
    }

    public String getReceipt() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Receipt for order #" + orderNumber + "\n");
        sb.append(" - - - - - - - - - - -\n");

        for (Item item : items) {
            sb.append(item.toString() + "\n");
        }

        sb.append("\n");
        sb.append("Total excl . VAT : " + getTotalValue() + "\n");
        sb.append("Total incl . VAT : " + getTotalValuePlusVAT() + "\n");
        return sb.toString();
    }

    public Order(Item... items) {
        this.orderNumber = counter++;
        this.items = List.of(items);
    }
}
