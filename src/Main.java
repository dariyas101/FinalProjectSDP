import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = OrderManager.getInstance();
        orderManager.addObserver(new Customer("Dariya"));

        while (true) {
            System.out.println("==== Coffee Shop Menu ====");
            System.out.println("1. Espresso");
            System.out.println("2. Espresso with Chocolate");
            System.out.println("3. Espresso with Whipped Cream");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            Coffee coffee = null;

            switch (choice) {
                case 1:
                    CoffeeFactory coffeeFactory = new EspressoFactory();
                    coffee = coffeeFactory.createCoffee();
                    break;
                case 2:
                    coffee = new Espresso();
                    coffee = new ChocolateDecorator(coffee);
                    break;
                case 3:
                    coffee = new Espresso();
                    coffee = new WhippedCreamDecorator(coffee);
                    break;
                case 4:
                    System.out.println("Exiting Coffee Shop. Have a great day!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            System.out.println("Total Amount: $" + coffee.cost());
            System.out.println("Choose a payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Cash on Delivery");
            int paymentChoice = scanner.nextInt();

            PaymentStrategy paymentStrategy = null;
            switch (paymentChoice) {
                case 1:
                    paymentStrategy = new CreditCardPPayment();
                    break;
                case 2:
                    paymentStrategy = new PayPalPayment();
                    break;
                case 3:
                    paymentStrategy = new CashOnDelivery();
                    break;
                default:
                    System.out.println("Invalid payment method. Please try again.");
                    continue;
            }

            orderManager.placeOrder(coffee, paymentStrategy);
        }
    }
}