

import java.util.List;

public class Order {
    private static long counter;
    private final long orderNumber;
    private final List<Item> items;

    public Order(Item... items) {
        this.items = List.of(items);
        this.orderNumber = counter++;
    }

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


}
