abstract class Coffee {
    protected String description = "Unknown Coffee. ";

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}