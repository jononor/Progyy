package se.su.ovning1;

public class Book extends Item implements PriceableWithVAT6 {
    private double price;
    private boolean bound;
    private String author;

    public Book(String name, String author, double price, boolean bound) {
        super(name);
        this.author=author;
        this.price=price;
        this.bound=bound;
    }

    public double getOriginalPrice() {
        return price;
    }
    public boolean isBound() {
        return bound;
    }
    public String getAuthor() {
        return author;
    }

    public String getType(){
        return "Book";
    }
    @Override
    public double getPrice(){
        if (bound) {
            return price * 1.3;
        }
        return price;
    }
    @Override
    public String toString(){
        return getType() + " : name = '" + getName() + "' , author ='" + author + "' , bound =" + bound + " , price =" + getPrice() +  " , price + vat =" + getPriceWithVAT();
    }
}
