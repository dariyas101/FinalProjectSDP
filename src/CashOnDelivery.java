class CashOnDelivery implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Cash on Delivery.");
    }
}
