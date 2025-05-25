public class Grape {
    private String variety;
    private String color;
    private String storageDuration;
    private String type;
    private double price;

    public Grape(String variety, String color, String storageDuration, String type, double price) {
        this.variety = variety;
        this.color = color;
        this.storageDuration = storageDuration;
        this.type = type;
        this.price = price;
    }

    public String getVariety() {return variety;}
    public String getColor() { return color; }
    public String getStorageDuration() { return storageDuration; }
    public String getType() { return type; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return variety + " (" + color + ", " + storageDuration + ", " + type + ") - $" + price;
    }
}