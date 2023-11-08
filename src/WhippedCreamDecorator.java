class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream. ";
    }
    public double cost() {
        return coffee.cost() + 400;
    }
}