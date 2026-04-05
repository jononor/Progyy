

public abstract class Recording extends Item implements PriceableWithVAT25 {
    final protected int year;
    final protected String artist;
    final protected double price;
    protected int condition;

    public Recording(String name, String artist, int year, int condition, double price) {
        super(name);
        this.artist = artist;
        this.year = year;
        this.price = price;
        if (condition <= 0) {
            this.condition = 0;
        } else if (condition >= 10) {
            this.condition = 10;
        } else {
            this.condition = condition;
        }
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
        return getType()+":" + "name="+getName()+"," + "artist="+getArtist()+"," + "year="+getYear()+"," + "condition="+getCondition()+"," + "original price="+price+"," + "price="+getPrice()+"," + "price+VAT="+getPriceWithVAT();
    }

}
