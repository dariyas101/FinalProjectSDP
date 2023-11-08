class ChocolateDecorator extends CoffeeDecorator {
    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription(){
        return coffee.getDescription() +", Chocolate. ";
    }
    public double cost() {
        return coffee.cost() + 350;
    }
}