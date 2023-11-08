import java.util.ArrayList;
import java.util.List;

class OrderManager {
    private static OrderManager instance = new OrderManager();

    private OrderManager() {
    }
    public static OrderManager getInstance() {
        return instance;
    }

    private List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }
    public void placeOrder(Coffee coffee, PaymentStrategy paymentStrategy) {
        double amount = coffee.cost();
        paymentStrategy.pay(amount);
        notifyObservers("confirmed");
    }
    private void notifyObservers(String orderStatus) {
        for (OrderObserver observer:observers) {
            observer.update(orderStatus);
        }
    }
}
