class CreditCardPPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $: " + amount + "via credit card. ");
    }
}
