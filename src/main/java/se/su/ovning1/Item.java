package se.su.ovning1;

public class Item implements Priceable {
    private final String name;

    protected Item ( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
