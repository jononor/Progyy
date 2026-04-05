

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
        sb.append("Receipt for order #").append(orderNumber).append("\n");
        sb.append("-----------");

        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total excl . VAT : " + getTotalValue() + "\n");
        sb.append("Total incl . VAT : " + getTotalValuePlusVAT() + "\n");
        return sb.toString();
    }

    public Order(Item... items) {
        this.items = List.of(items);
        this.orderNumber = counter++;
    }
}
