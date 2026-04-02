package se.su.ovning1;

public abstract class Recording {
    final protected int year;
    final protected String artist;
    final protected double price;
    final private String name;
    protected int condition;

    Recording(String name, String artist, int year, int condition,
            double price) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.condition = condition;
        this.price = price;
    }

    public abstract String getType();

    public double getPrice() {
        final double discountedPrice = condition / 10.0 * price;
        final double minimumPrice = 10.0;
        return Math.max(discountedPrice, minimumPrice);
    }

    public int getCondition() {
        return condition;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s by %s, %d, condition: %d, price: %.2f",
                name, artist, year, condition, price);
    }
}
